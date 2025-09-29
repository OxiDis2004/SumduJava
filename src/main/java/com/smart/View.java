package com.smart;

import com.smart.models.Character;
import com.smart.models.abstractfactory.RaceAbstractFactory;
import com.smart.models.classes.CharacterClass;
import com.smart.models.classes.CharacterClassFactory;
import com.smart.models.races.CharacterRace;
import com.smart.models.stats.Stats;
import com.smart.visitor.ElementVisitor;

import java.util.List;
import java.util.Scanner;

public class View {

    private final ElementVisitor elementVisitor;

    public View(ElementVisitor elementVisitor) {
        this.elementVisitor = elementVisitor;
    }

    public void printMenu(List<String> menu) {
        System.out.println("Select one function from menu:");
        for (int i = 1; i <= menu.size(); i++) {
            System.out.println(i + ". " + menu.get(i - 1));
        }
    }

    public void printError(String error) {
        System.out.println("Error: " + error);
    }

    public void printCharacter(Character character) {
        character.accept(elementVisitor, null);
    }

    public void printErrorCharacter() {
        printError("Character isn't created or loaded.");
    }

    public void printPathToSavedJson(String path) {
        System.out.println("Saved character path: " + path);
    }

    public void printCharacterRaces(List<RaceAbstractFactory> factories) {
        System.out.println("Choose a race of character: ");
        for (int i = 0; i < factories.size(); i++) {
            CharacterRace race = factories.get(i).create();
            System.out.print(i + 1 + ". ");
            race.accept(elementVisitor, null);
        }
    }

    public void printCharacterClasses(List<String> classes) {
        System.out.println("Choose a class for character: ");
        for (int i = 1; i <= classes.size(); i++) {
            CharacterClass characterClass = CharacterClassFactory.getClass(classes.get(i - 1));
            assert characterClass != null;
            System.out.print(i + ". ");
            characterClass.accept(elementVisitor, null);
        }
    }

    public void printStats(Stats stats) {
        System.out.println("Currently stats: ");
        stats.accept(elementVisitor, null);
    }

    public void printPrevStats(List<Stats> prevStats) {
        System.out.println("Previous stats: ");
        for (int i = 0; i < prevStats.size(); i++) {
            System.out.println(i + 1 + ". ");
            printStats(prevStats.get(i));
        }
    }

    public String getInputFromConsole(String infoMessage, String errorMessage) {
        System.out.print(infoMessage);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {
            System.out.println(errorMessage);
            return null;
        }
        return input;
    }

    public int getInputFromConsoleInt(String infoMessage, String errorMessage) {
        String input = getInputFromConsole(infoMessage, errorMessage);
        if (input == null) return -1000;
        return Integer.parseInt(input) - 1;
    }
}

