package com.smart;

public class Employee {

    private static int nextID = 1;
    private int ID;
    private int managerID;
    private String name;
    private String departmentName;
    private double salary;

    public Employee(int managerID, String name, String departmentName, double salary) {
        this.ID = nextID++;
        this.managerID = managerID;
        this.name = name;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public int getManagerID() {
        return managerID;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getSalary() {
        return salary;
    }
}