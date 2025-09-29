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
    private final static List<String> menu = List.of(
            "Create new character",
            "Show current character",
            "Save current character in json file",
            "Exit"
    );

    private final View view;
    private final CareTaker careTaker;
    private final SaveVisitor saveVisitor;

    private Character character;

    public Controller(View view, CareTaker careTaker, SaveVisitor saveVisitor) {
        this.view = view;
        this.careTaker = careTaker;
        this.saveVisitor = saveVisitor;
    }

    public int menu() {
        view.printMenu(menu);
        int choice = view.getInputFromConsoleInt(
                "Enter your choice: ",
                "You didn't enter choice."
        );

        if (choice < 0 || choice > menu.size()) {
            view.printError("Invalid choice.");
            return -1;
        }
        else if (choice == menu.size() - 1) {
            return 0;
        }
        else {
            updateView(choice);
            return 1;
        }
    }

    public void updateView(int choice) {
        switch (choice) {
            case 0:
                createCharacter();
                break;
            case 1:
                if (character == null) {
                    view.printErrorCharacter();
                    break;
                }
                view.printCharacter(character);
                break;
            case 2:
                if (character == null) {
                    view.printErrorCharacter();
                    break;
                }
                String savedCharacterPath = saveJson();
                if (savedCharacterPath == null) {
                    view.printError("Save failed.");
                    break;
                }
                view.printPathToSavedJson(savedCharacterPath);
                break;
        }
    }

    public void createCharacter() {
        System.out.println("Creating character...");
        character = null;
        String characterName = null;
        CharacterRace race = null;
        CharacterClass cClass = null;
        Stats stats = null;

        while (character == null) {
            if (characterName == null) {
                characterName = view.getInputFromConsole(
                        "Enter character name: ",
                        "Character name is empty."
                );
                if (characterName == null) {
                    continue;
                }
            }

            if (race == null) {
                race = getCharacterRace();
                if (race == null)
                    continue;
            }

            if (cClass == null) {
                cClass = getCharacterClass();
                if (cClass == null)
                    continue;
            }

            if (stats == null) {
                System.out.println("Generating stats...");
                stats = new Stats().generate();
            }

            Stats update = getNewStats(stats);
            if (update == null || !update.equals(stats)) {
                stats = update;
                continue;
            }

            System.out.println("Creating character...");
            character = new Character(characterName, race, cClass, stats);
            addBonusesFromRace();
            System.out.println("Character created");
        }
    }

    private CharacterRace getCharacterRace() {
        List<RaceAbstractFactory> factories = List.of(
                new HalfingFactory(),
                new HobgoblinFactory()
        );

        view.printCharacterRaces(factories);
        int choice = view.getInputFromConsoleInt(
                "Enter number of race from the list: ",
                "Input number of race is empty."
        );

        if (choice < 0 || choice >= factories.size()) {
            view.printError("Invalid choice.");
            return null;
        }

        return factories.get(choice).create();
    }

    private CharacterClass getCharacterClass() {
        List<String> classes = List.of(
                CharacterClassFactory.BARD,
                CharacterClassFactory.RANGER
        );

        view.printCharacterClasses(classes);
        int choice = view.getInputFromConsoleInt(
                "Enter number of classes from the list: ",
                "Input number of class is empty."
        );

        if (choice < 0 || choice >= classes.size()) {
            view.printError("Invalid choice.");
            return null;
        }

        return CharacterClassFactory.getClass(classes.get(choice));
    }

    private Stats getNewStats(Stats stats) {
        view.printStats(stats);
        int choice = view.getInputFromConsoleInt(
                "Are u want to save this stats or rerole or get prev? (0 - 'no, save' / 1 - 'yes, rerole' / 2 - 'get prev'): ",
                "Invalid input"
        ) + 1;

        if (choice == 2) {
            List<Stats> prevStats = careTaker.getList().stream().map(item -> {
                Stats prevStat = new Stats();
                prevStat.state = item.state();
                return prevStat;
            }).toList();

            do {
                view.printPrevStats(prevStats);
                choice = view.getInputFromConsoleInt(
                        "Enter your choice: ",
                        "Invalid input."
                );

            } while (choice < 0 || choice >= prevStats.size());

            careTaker.add(new Memento(stats.state));
            stats = prevStats.get(choice);
            careTaker.remove(choice);
        }
        else if (choice == 1) {
            careTaker.add(new Memento(stats.state));
            stats = null;
        }
        else if (choice != 0) {
            stats = null;
            view.printError("Invalid choice.");
        }

        return stats;
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

    public String saveJson() {
        character.accept(saveVisitor, dataUnit);
        String path = character.getName() + ".json";
        File file = new File(path);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(new JSONObject(dataUnit).toJSONString());
            writer.flush();
            return file.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Error writing json file.");
        }
        return "";
    }
}
