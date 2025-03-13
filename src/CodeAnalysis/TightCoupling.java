package CodeAnalysis;

import java.util.ArrayList;
import java.util.List;

class Worker {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Worker(String name, int age, double salary, String department) {
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
        System.out.println("Saving worker data to database...");
        // Simulated DB write logic
    }
}

class WorkerManager {
    private List<Worker> workers = new ArrayList<>();
    private DatabaseManager dbManager;

    public WorkerManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addWorker(Worker w) {
        workers.add(w);
    }

    public void processSalaries() {
        for (Worker w : workers) {
            double newSalary = w.calculateBonus();
            System.out.println("Processed Salary: " + newSalary);
            dbManager.saveToDatabase(w);  // Tight coupling with DatabaseManager
        }
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}

class DatabaseManager {
    public void saveToDatabase(Worker worker) {
        System.out.println("Saving worker " + worker + " data to database...");
    }
}

public class TightCoupling {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        WorkerManager manager = new WorkerManager(dbManager);

        Worker w1 = new Worker("Alice", 30, 50000, "IT");
        Worker w2 = new Worker("Bob", 40, 60000, "HR");

        manager.addWorker(w1);
        manager.addWorker(w2);

        manager.processSalaries();

        for (Worker w : manager.getWorkers()) {
            w.printDetails();
        }
    }
}
