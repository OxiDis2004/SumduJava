package com.smart;

public class Manager extends Employee {

    private final double bonus;

    public Manager(int managerID, String name, String departmentName, double salary, double bonus) {
        super(managerID, name, departmentName, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
