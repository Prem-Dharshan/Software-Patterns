package CodeAnalysis;

import java.util.ArrayList;
import java.util.List;

class CCEmployee {
    private String name;
    private int age;
    private double salary;
    private String department;

    public CCEmployee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public double calculateBonus(int yearsOfService, boolean isManager) {
        double bonus = 0.0;

        if (yearsOfService > 10) {
            bonus += salary * 0.15;
            if (isManager) {
                bonus += 5000;
            }
        } else if (yearsOfService > 5) {
            bonus += salary * 0.10;
            if (isManager && department.equalsIgnoreCase("Sales")) {
                bonus += 3000;
            }
        } else {
            bonus += salary * 0.05;
        }

        if (department.equalsIgnoreCase("HR")) {
            bonus += 1000;
        } else if (department.equalsIgnoreCase("IT")) {
            bonus += 2000;
            if (salary > 100000) {
                bonus += 1000;
            }
        }

        return bonus;
    }

    public boolean isEligibleForPromotion(int completedProjects, int teamSize) {
        if (completedProjects > 20) {
            return true;
        } else if (completedProjects > 10) {
            if (teamSize > 5) {
                return true;
            }
        }
        return false;
    }
}

class CCEmployeeManager {
    private List<CCEmployee> employees = new ArrayList<>();

    public void addEmployee(CCEmployee e) {
        employees.add(e);
    }

    public void evaluateEmployees() {
        for (CCEmployee e : employees) {
            boolean promotion = e.isEligibleForPromotion(15, 7);
            if (promotion) {
                System.out.println("Employee eligible for promotion: " + e);
            }
        }
    }
}

public class CC {
    public static void main(String[] args) {
        CCEmployeeManager manager = new CCEmployeeManager();

        CCEmployee e1 = new CCEmployee("Alice", 35, 120000, "IT");
        CCEmployee e2 = new CCEmployee("Bob", 45, 90000, "Sales");

        manager.addEmployee(e1);
        manager.addEmployee(e2);

        manager.evaluateEmployees();

        System.out.println("Bonus for Alice: " + e1.calculateBonus(12, true));
        System.out.println("Bonus for Bob: " + e2.calculateBonus(8, false));
    }
}
