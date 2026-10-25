/*
Java 25/10/2026

Develop a Java program to create a class Student with members USN and Name. 
Include methods to accept and display student details. 
Create multiple student objects and display their information.
*/

import java.util.Scanner;

class Student {
    String usn;
    String name;

    void accept(Scanner sc) {
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
    }

    void accept(String usn, String name) {
        this.usn = usn;
        this.name = name;
    }

    void display() {
        System.out.println("USN  : " + usn);
        System.out.println("Name : " + name);
        System.out.println("---------------------------");
    }
}

class lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Student Details Demo ---");

        // Creating multiple student objects
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        // Initializing details
        System.out.println("Entering details for Student 1:");
        s1.accept("1BM23CS001", "Alice");

        System.out.println("Entering details for Student 2:");
        s2.accept("1BM23CS002", "Bob");

        System.out.println("Entering details for Student 3:");
        s3.accept("1BM23CS003", "Charlie");

        // Displaying student information
        System.out.println("\n--- Displaying Student Information ---");
        s1.display();
        s2.display();
        s3.display();

        sc.close();
    }
}

