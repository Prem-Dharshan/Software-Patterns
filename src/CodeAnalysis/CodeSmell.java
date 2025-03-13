package CodeAnalysis;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public double calculateBonus() {
        if (department.equalsIgnoreCase("HR")) {
            return salary * 0.10;
        } else if (department.equalsIgnoreCase("IT")) {
            return salary * 0.15;
        } else if (department.equalsIgnoreCase("Sales")) {
            return salary * 0.20;
        }
        return 0;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Bonus: " + calculateBonus());
    }

    public void saveToDatabase() {
        System.out.println("Saving employee data to database...");
        // Simulated DB write logic
    }
}

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void processSalaries() {
        for (Employee e : employees) {
            double newSalary = e.calculateBonus() + e.calculateBonus();  // 🤨 Bonus applied twice?
            System.out.println("Processed Salary: " + newSalary);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

public class CodeSmell {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        Employee e1 = new Employee("Alice", 30, 50000, "IT");
        Employee e2 = new Employee("Bob", 40, 60000, "HR");

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        manager.processSalaries();

        for (Employee e : manager.getEmployees()) {
            e.printDetails();
        }
    }
}
