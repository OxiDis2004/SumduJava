package com.smart;

public class Main {

    private final static Registry registry = Registry.getRegistry();

    public static void main(String[] args) {
        Manager man = new Manager(0, "Denys", "Sales", 2500, 500);
        man.add(man);
        Employee emp1 = new Employee(man.getID(), "Elia", "Sales", 1500);
        man.add(emp1);
        Employee emp2 = new Employee(man.getID(), "Oter", "Sales", 1200);
        man.add(emp2);
        Manager man2 = new Manager(0, "Oter", "Sales", 1200, 500);
        man.add(man2);

        System.out.println(man);
    }
}