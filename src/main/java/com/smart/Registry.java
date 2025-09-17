package com.smart;

import java.util.ArrayList;
import java.util.List;

public final class Registry {

    private static Registry WorkersRegistry = null;
    private final List<Employee> employees;

    private Registry() {
        employees = new ArrayList<>();
    }

    public static Registry getRegistry() {
        if  (WorkersRegistry == null) {
            WorkersRegistry = new Registry();
        }

        return WorkersRegistry;
    }

    public void addEmployee(Employee employee) throws EmployeeInRegistryException {
        if (employees.stream().anyMatch(e -> e.getID() == employee.getID())) {
            throw new EmployeeInRegistryException("Employee with ID " + employee.getID() + " already exists");
        }

        employees.add(employee);
    }

    public void printList(){
        for (Employee e : employees){
            if (e instanceof Manager m){
                System.out.println("Manager " + m.getID() + " " + m.getName() + " " + m.getDepartmentName() +
                        " " + m.getManagerID() + " " + m.getSalary() + " " + m.getBonus());
            } else {
                System.out.println("Employee " + e.getID() + " " + e.getName() + " " + e.getDepartmentName() +
                        " " + e.getManagerID() + " " + e.getSalary());
            }
        }
    }
}
