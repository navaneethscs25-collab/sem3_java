/*
Java 25/10/2026

Lab 7: CIE Lab Test-1
Problem Statement:
Develop a Java program to model a Corporate Employee and Manager System.
1. Create a class Employee with members empId, name, basicSalary, and a static member totalEmployees.
   - Include constructors (default and parameterized).
   - Include a method calculateSalary() that returns the net salary (basic + 20% HRA + 10% DA).
   - Include a method displayDetails() to display employee information.
2. Derive a class Manager from Employee with additional member bonus.
   - Use super to initialize base class attributes.
   - Override calculateSalary() to include bonus (net salary + bonus).
   - Override displayDetails() to display manager information.
3. In the main class lab7:
   - Create multiple Employee and Manager objects.
   - Demonstrate dynamic method dispatch and display total employees created using static count.
*/

class Employee {
    int empId;
    String name;
    double basicSalary;
    static int totalEmployees = 0;

    Employee() {
        this.empId = 0;
        this.name = "Unknown";
        this.basicSalary = 0.0;
        totalEmployees++;
    }

    Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
        totalEmployees++;
    }

    double calculateSalary() {
        double hra = 0.20 * basicSalary;
        double da = 0.10 * basicSalary;
        return basicSalary + hra + da;
    }

    void displayDetails() {
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.printf("Basic Salary  : Rs. %.2f\n", basicSalary);
        System.out.printf("Net Salary    : Rs. %.2f\n", calculateSalary());
        System.out.println("----------------------------------------");
    }
}

class Manager extends Employee {
    double bonus;

    Manager(int empId, String name, double basicSalary, double bonus) {
        super(empId, name, basicSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return super.calculateSalary() + bonus;
    }

    @Override
    void displayDetails() {
        System.out.println("Manager ID    : " + empId);
        System.out.println("Manager Name  : " + name);
        System.out.printf("Basic Salary  : Rs. %.2f\n", basicSalary);
        System.out.printf("Bonus         : Rs. %.2f\n", bonus);
        System.out.printf("Total Salary  : Rs. %.2f\n", calculateSalary());
        System.out.println("----------------------------------------");
    }
}

class lab7 {
    public static void main(String[] args) {
        System.out.println("=== CIE Lab Test - 1 Evaluation ===");

        Employee emp1 = new Employee(101, "Rahul Sharma", 45000.0);
        Manager mgr1 = new Manager(201, "Priya Nair", 85000.0, 15000.0);

        System.out.println("\nEmployee Details:");
        emp1.displayDetails();

        System.out.println("Manager Details:");
        mgr1.displayDetails();

        System.out.println("Dynamic Method Dispatch Demonstration:");
        Employee polyRef;
        polyRef = mgr1; // Base reference holding subclass object
        polyRef.displayDetails();

        System.out.println("Total Employees Created: " + Employee.totalEmployees);
    }
}

