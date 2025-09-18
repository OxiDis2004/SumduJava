package com.smart;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private static int nextID = 1;
    private int ID;
    private int managerID;
    private String name;
    private String departmentName;
    private double salary;

    private final List<Employee> subordinates;

    public Employee(int managerID, String name, String departmentName, double salary) {
        this.ID = nextID++;
        this.managerID = managerID;
        this.name = name;
        this.departmentName = departmentName;
        this.salary = salary;

        this.subordinates = new ArrayList<>();
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

    public void add(Employee emp) {
        subordinates.add(emp);
    }

    public void remove(Employee emp) {
        subordinates.remove(emp);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{")
                .append("ID=").append(ID)
                .append(", managerID=").append(managerID)
                .append(", name='").append(name).append('\'')
                .append(", departmentName='").append(departmentName).append('\'')
                .append(", salary=").append(salary);

        // Only show subordinate IDs to avoid recursion
        sb.append(", subordinates=[");
        for (Employee e : subordinates) {
            sb.append(e.getID()).append(" ");
        }
        sb.append("]}");

        return sb.toString();
    }
}