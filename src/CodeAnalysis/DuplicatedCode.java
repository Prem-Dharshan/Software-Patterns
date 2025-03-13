package CodeAnalysis;

import java.util.ArrayList;
import java.util.List;

class DuplicatedCodeEmployee {
    private String name;
    private int age;
    private double salary;
    private String department;

    public DuplicatedCodeEmployee(String name, int age, double salary, String department) {
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

    public double calculateBonusWithDifferentLogic() {
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

    public void printDetailsWithAdditionalInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Bonus: " + calculateBonusWithDifferentLogic());
    }

    public void saveToDatabase() {
        System.out.println("Saving employee data to database...");
        // Simulated DB write logic
    }
}

class DCEmployeeManager {
    private List<DuplicatedCodeEmployee> employees = new ArrayList<>();

    public void addEmployee(DuplicatedCodeEmployee e) {
        employees.add(e);
    }

    public void processSalaries() {
        for (DuplicatedCodeEmployee e : employees) {
            double newSalary = e.calculateBonus() + e.calculateBonus();  // 🤨 Bonus applied twice?
            System.out.println("Processed Salary: " + newSalary);
        }
    }

    public List<DuplicatedCodeEmployee> getEmployees() {
        return employees;
    }
}

public class DuplicatedCode {
    public static void main(String[] args) {
        DCEmployeeManager manager = new DCEmployeeManager();

        DuplicatedCodeEmployee e1 = new DuplicatedCodeEmployee("Alice", 30, 50000, "IT");
        DuplicatedCodeEmployee e2 = new DuplicatedCodeEmployee("Bob", 40, 60000, "HR");

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        manager.processSalaries();

        for (DuplicatedCodeEmployee e : manager.getEmployees()) {
            e.printDetails();
            e.printDetailsWithAdditionalInfo();
        }
    }
}
