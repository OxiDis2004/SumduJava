package com.smart;

import com.smart.memento.CareTaker;
import com.smart.visitor.ElementVisitor;
import com.smart.visitor.SaveVisitor;

public class Main {

    public static void main(String[] args) {
        ElementVisitor elementVisitor = new ElementVisitor();
        View view = new View(elementVisitor);

        CareTaker careTaker = new CareTaker();
        SaveVisitor saveVisitor = new SaveVisitor();
        Controller controller = new Controller(view, careTaker, saveVisitor);

        System.out.println("Program Started");
        while (true) {
            int result = controller.menu();
            if (result == 0)
                break;
        }
    }
}