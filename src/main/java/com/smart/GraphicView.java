package com.smart;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;


public class GraphicView extends Application {

    private final TextField nameField;
    private final ComboBox<String> raceBox;
    private final ComboBox<String> classBox;
    private final TextArea stats;
    private final Button generateBtn;
    private final Button restorePrevBtn;
    private final Button restoreNextBtn;
    private final Button addBtn;
    private final Button saveJsonBtn;
    private final TextArea infoArea;

    private Supplier<String> supplierStats;

    public GraphicView() {
        nameField = new TextField();
        nameField.setPromptText("Enter character name");

        raceBox = new ComboBox<>();
        classBox = new ComboBox<>();
        stats = new TextArea();
        stats.setEditable(false);
        infoArea = new TextArea();
        infoArea.setEditable(false);

        generateBtn = new Button("Generate Stats");
        restorePrevBtn = new Button("Restore Prev State");
        restoreNextBtn = new Button("Restore Next State");
        addBtn = new Button("Add Character");
        saveJsonBtn = new Button("Save JSON");
    }

    public String getCharacterName() {
        return nameField.getText();
    }

    public void setRaceLoader(Supplier<List<String>> raceLoader) {
        raceBox.setOnMouseClicked(mouseEvent -> {
            if (raceBox.getItems().isEmpty()) {
                raceBox.getItems().addAll(raceLoader.get());
            }
        });
    }

    public int getRace() {
        return raceBox.getSelectionModel().getSelectedIndex();
    }

    public void setCharacterClassLoader(Supplier<List<String>> classLoader) {
        classBox.setOnMouseClicked(mouseEvent -> {
            if (classBox.getItems().isEmpty()) {
                classBox.getItems().addAll(classLoader.get());
            }
        });
    }

    public String getCharacterClass() {
        return classBox.getSelectionModel().getSelectedItem();
    }

    public void setStatsArea(Supplier<String> stats) {
        this.supplierStats = stats;
        this.stats.setText(stats.get());
    }

    public void refreshStatsArea() {
        if (supplierStats != null) {
            stats.setText(supplierStats.get());
        }
    }

    public void setInfoArea(Supplier<String> info) {
        this.infoArea.setText(info.get());
    }

    public void setGenerateHandler(Runnable r) {
        generateBtn.setOnAction(e -> r.run());
    }

    public void setRestorePrevStateHandler(Runnable r) {
        restorePrevBtn.setOnAction(e -> r.run());
    }

    public void setRestoreNextStateHandler(Runnable r) {
        restoreNextBtn.setOnAction(e -> r.run());
    }

    public void setAddCharacterHandler(Supplier<String> onCreate) {
        addBtn.setOnAction(e -> {
            String charachterInfo = onCreate.get();
            Alert.AlertType type;
            String title;
            String context;

            if (charachterInfo.contains("{error}")) {
                charachterInfo = charachterInfo.replace("{error}", "");
                type = Alert.AlertType.ERROR;
                title = "Create failed";
                context = "By creating occurred problem. Error: " + charachterInfo;
            } else {
                type = Alert.AlertType.INFORMATION;
                title = "Create successful";
                context = "Character created.";
                setInfoArea(onCreate);
            }


            Alert alert = new Alert(type);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(context);
            alert.showAndWait();
        });
    }

    public void setSaveJsonHandler(Supplier<String> onSaved) {
        saveJsonBtn.setOnAction(e -> {
            String path = onSaved.get();
            Alert.AlertType type;
            String title;
            String context;

            if (path.contains("{error}")) {
                path = path.replace("{error}", "");
                type = Alert.AlertType.ERROR;
                title = "Save failed";
                context = "By saving occurred problem. Error: " + path;
            } else {
                type = Alert.AlertType.INFORMATION;
                title = "Save successful";
                context = "File saved to: " + path;
            }

            Alert alert = new Alert(type);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(context);
            alert.showAndWait();
        });
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox(10, nameField, raceBox, classBox, generateBtn,
                stats, restorePrevBtn, restoreNextBtn, addBtn, saveJsonBtn);

        stage.setScene(new Scene(root, 400, 500));
        stage.setTitle("DnD Character Generator");
        stage.show();
    }
}
