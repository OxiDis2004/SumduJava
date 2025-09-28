package com.smart;

import com.smart.abstractfactory.HalfingFactory;
import com.smart.abstractfactory.HobgoblinFactory;
import com.smart.classes.ClassFactory;
import com.smart.stats.Stats;
import com.smart.visitor.ElementVisitor;
import com.smart.visitor.SaveVisitor;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class Main {
    private final static ElementVisitor elementVisitor = new ElementVisitor();
    private final static SaveVisitor saveVisitor = new SaveVisitor();

    private final static TreeMap<String, Object> dataUnit1 = new TreeMap<>();
    private final static TreeMap<String, Object> dataUnit2 = new TreeMap<>();

    public static void main(String[] args) {
        Character unit1 = new Character(
                "Abrams",
                new HalfingFactory().create(),
                new ClassFactory().getClass("Bard"),
                new Stats().generate()
        );
        unit1.accept(elementVisitor, dataUnit1);
        saveJson(unit1, dataUnit1);
        System.out.println();
        Character unit2 = new Character(
                "Barbus",
                new HobgoblinFactory().create(),
                new ClassFactory().getClass("Ranger"),
                new Stats().generate()
        );
        unit2.accept(elementVisitor, dataUnit2);
        saveJson(unit2, dataUnit2);
    }

    public static void saveJson(Character character, TreeMap<String, Object> map) {
        character.accept(saveVisitor, map);
        try (FileWriter writer = new FileWriter(character.getName() + ".json")) {
            writer.write(new JSONObject(map).toJSONString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}