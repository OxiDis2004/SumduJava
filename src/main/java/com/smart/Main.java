package com.smart;

import com.smart.memento.CareTaker;
import com.smart.visitor.SaveVisitor;
import javafx.application.Platform;

public class Main {

    public static void main(String[] args) {
        Platform.startup(() -> {
            CareTaker careTaker = new CareTaker();
            SaveVisitor saveVisitor = new SaveVisitor();
            GraphicView view = new GraphicView();
            new Controller(view, careTaker, saveVisitor);
            try {
                view.start(new javafx.stage.Stage());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        });
    }
}