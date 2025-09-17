package com.smart;

public class Employee {
    private long id;
    private static long nextId = 1;
    private String name;
    private String surname;
    private double salary;

    public Employee(String name, String surname, double salary) throws FieldLengthLimitException, IncorrectSalaryException {
        this.id = nextId++;

        checkStringValue(name, "name");
        this.name = name;

        checkStringValue(surname, "surname");
        this.surname = surname;

        if (salary < 0)
            throw new IncorrectSalaryException("Salary cannot be negative");

        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws FieldLengthLimitException {
        checkStringValue(name, "name");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws FieldLengthLimitException {
        checkStringValue(surname, "surname");
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws IncorrectSalaryException {
        if (salary < 0)
            throw new IncorrectSalaryException("Salary cannot be negative");

        this.salary = salary;
    }

    private void checkStringValue(String value, String nameOfValue) throws FieldLengthLimitException {
        if (value == null || value.isEmpty() || value.length() > 256)
            throw new FieldLengthLimitException(String.format("Property '%s' cannot be empty", nameOfValue));
    }
}
