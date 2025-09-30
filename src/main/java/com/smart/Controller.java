package com.smart;

import com.smart.models.Character;
import com.smart.models.abstractfactory.HalfingFactory;
import com.smart.models.abstractfactory.HobgoblinFactory;
import com.smart.models.abstractfactory.RaceAbstractFactory;
import com.smart.models.classes.CharacterClass;
import com.smart.models.classes.CharacterClassFactory;
import com.smart.memento.CareTaker;
import com.smart.memento.Memento;
import com.smart.models.races.CharacterRace;
import com.smart.models.stats.Stats;
import com.smart.models.stats.StatsName;
import com.smart.visitor.SaveVisitor;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

public class Controller {

    private final static TreeMap<String, Object> dataUnit = new TreeMap<>();
    private final static List<RaceAbstractFactory> factories = new ArrayList<>();
    private final static List<String> classes = new ArrayList<>();

    private final GraphicView view;
    private final CareTaker careTaker;
    private final SaveVisitor saveVisitor;

    private Character character;
    private Stats stats;
    private int currentStatsIndex = -1;

    public Controller(GraphicView view, CareTaker careTaker, SaveVisitor saveVisitor) {
        this.view = view;
        this.careTaker = careTaker;
        this.saveVisitor = saveVisitor;

        factories.addAll(List.of(
            new HalfingFactory(),
            new HobgoblinFactory()
        ));

        classes.addAll(List.of(
            CharacterClassFactory.BARD,
            CharacterClassFactory.RANGER
        ));

        view.setRaceLoader(this::characterRaces);
        view.setCharacterClassLoader(this::characterClasses);
        view.setStatsArea(this::getStats);
        view.setGenerateHandler(this::generateStats);
        view.setRestorePrevStateHandler(() -> restoreStats(true));
        view.setRestoreNextStateHandler(() -> restoreStats(false));
        view.setAddCharacterHandler(this::createCharacter);
        view.setSaveJsonHandler(this::saveJson);
    }

    private String createCharacter() {
        Character tmp;

        try {
            String characterName = view.getCharacterName();
            if (characterName == null || characterName.isEmpty())
                throw new Exception("Name didn't define");

            CharacterRace race = getCharacterRace();
            if (race == null)
                throw new Exception("Race didn't select");

            CharacterClass cClass = getCharacterClass();
            if (cClass == null)
                throw new Exception("Class didn't select");

            if (stats == null)
                throw new Exception("Stats didn't generate");

            tmp = new Character(characterName, race, cClass, stats);
            addBonusesFromRace();
            this.character = tmp;
            return this.character.info();
        } catch (Exception e) {
            return "{error} " + e.getMessage();
        }
    }

    private List<String> characterRaces() {
        return factories.stream().map(RaceAbstractFactory::name).toList();
    }

    private CharacterRace getCharacterRace() {
        int selectedRace = view.getRace();
        if (selectedRace < 0 || selectedRace >= factories.size())
            return null;

        return factories.get(selectedRace).create();
    }

    private List<String> characterClasses() {
        return classes;
    }

    private CharacterClass getCharacterClass() {
        String selectedClass = view.getCharacterClass();
        if (selectedClass == null || selectedClass.isEmpty()) {
            return null;
        }

        return CharacterClassFactory.getClass(selectedClass);
    }

    private String getStats() {
        if (stats == null) {
            return "No stats";
        }
        return stats.toString();
    }

    private void generateStats() {
        if (stats == null) {
            stats = new Stats();
        }
        stats = stats.generate();
        careTaker.add(new Memento(stats.state));
        currentStatsIndex++;
        view.refreshStatsArea();
    }

    private void restoreStats(boolean prev) {
        currentStatsIndex = prev ? currentStatsIndex - 1 : currentStatsIndex + 1;
        if (currentStatsIndex < 0 || currentStatsIndex >= careTaker.getList().size()) {
            return;
        }
        stats.state = careTaker.get(currentStatsIndex).state();
        view.refreshStatsArea();
    }

    private void addBonusesFromRace() {
        Map<StatsName, Integer> updated = new HashMap<>();

        character.getAttributes()
                .state
                .forEach((statsName, value) -> {
                    int bonus = character.getRace()
                            .getRaceBonuses()
                            .state
                            .getOrDefault(statsName, 0);
                    updated.put(statsName, value + bonus);
                });

        character.getAttributes().state.putAll(updated);

        int newHP = (int) (character.getCharacterClass().getHP()
                + (double) (character.getAttributes().state.get(StatsName.CONSTITUTION) / 2) - 5);
        character.setHp(newHP);
    }

    private String saveJson() {
        if (character == null) {
            return "{error} Character is not created";
        }
        character.accept(saveVisitor, dataUnit);
        String path = character.getName() + ".json";
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(new JSONObject(dataUnit).toJSONString());
            writer.flush();
            return file.getAbsolutePath();
        } catch (Exception e) {
            return "{error} " + e;
        }
    }
}
