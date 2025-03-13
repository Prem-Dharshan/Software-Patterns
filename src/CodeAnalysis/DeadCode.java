package CodeAnalysis;

import java.util.ArrayList;
import java.util.List;

class DeadEmployee {
    private String name;
    private int age;
    private double salary;
    private String department;
    private boolean isActive; // (???)

    public DeadEmployee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.isActive = true; // (???)
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

    public void deactivateEmployee() {
        this.isActive = false; // (???)
    }

    public boolean isActive() {
        return isActive;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Active: " + isActive);
    }
}

class DeadEmployeeManager {
    private List<DeadEmployee> deadEmployees = new ArrayList<>();

    public void addEmployee(DeadEmployee e) {
        deadEmployees.add(e);
    }

    public void removeEmployee(DeadEmployee e) { // (???)
        deadEmployees.remove(e);
    }

    public void processSalaries() {
        for (DeadEmployee e : deadEmployees) {
            double newSalary = e.calculateBonus() + e.calculateBonus(); // (!!!)
            System.out.println("Processed Salary: " + newSalary);
        }
    }

    public List<DeadEmployee> getActiveEmployees() {
        List<DeadEmployee> activeDeadEmployees = new ArrayList<>();
        for (DeadEmployee e : deadEmployees) {
            if (e.isActive()) {
                activeDeadEmployees.add(e);
            }
        }
        return activeDeadEmployees; // (???)
    }
}

public class DeadCode {
    public static void main(String[] args) {
        DeadEmployeeManager manager = new DeadEmployeeManager();

        DeadEmployee e1 = new DeadEmployee("Alice", 30, 50000, "IT");
        DeadEmployee e2 = new DeadEmployee("Bob", 40, 60000, "HR");

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        e1.deactivateEmployee(); // (???)

        manager.processSalaries();

        for (DeadEmployee e : manager.getActiveEmployees()) {
            e.printDetails();
        }
    }
}
