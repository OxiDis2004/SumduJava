package com.smart;

public class Main {
    public static void main(String[] args) {
        Employee emp = null;

        try {
            emp = new Employee("Denys", "Ponomarenko", 1500.0);
            emp.setName("");
        } catch (IncorrectSalaryException | FieldLengthLimitException e) {
            System.err.println(e.getMessage());
        }

        assert emp != null;

        try {
            emp.setSurname("");
        } catch (FieldLengthLimitException e) {
            System.err.println(e.getMessage());
        }

        try {
            emp.setSalary(-1000);
        } catch (IncorrectSalaryException e) {
            System.err.println(e.getMessage());
        }

        System.out.printf("Id: %s\n", emp.getId());
        System.out.printf("Name: %s\n", emp.getName());
        System.out.printf("Surname: %s\n", emp.getSurname());
        System.out.printf("Salary: %.2f%n\n", emp.getSalary());
    }
}