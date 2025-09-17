package com.smart;

public class Main {

    private final static Registry registry = Registry.getRegistry();

    public static void main(String[] args) {
        Manager man = new Manager(0, "Denys", "Sales", 2500, 500);
        Employee emp = new Employee(man.getID(), "Elia", "Sales", 1500);

        try {
            // first add
            registry.addEmployee(emp);
            registry.addEmployee(man);

            // add already exists
            registry.addEmployee(emp);
        } catch(EmployeeInRegistryException e) {
            System.err.println(e.getMessage());
        }

        registry.printList();
    }
}