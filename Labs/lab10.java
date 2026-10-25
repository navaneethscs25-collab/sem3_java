/*
Java 25/10/2026

Develop a Java program to simulate an Online Examination Result System using 
Enumerations and Autoboxing. Create an enumeration Result with values PASS, FAIL, 
and ABSENT. Create a class Student with members USN, Name, Marks, and Result Status. 
Accept the marks from the user and determine the result status based on the following 
criteria: Marks >= 40 – PASS, Marks < 40 – FAIL, and Marks = -1 – ABSENT. 
Store marks using wrapper objects and demonstrate autoboxing and unboxing while 
calculating and displaying the result.
*/

import java.util.Scanner;

// Enumeration for Result status
enum Result {
    PASS,
    FAIL,
    ABSENT
}

class Student {
    String usn;
    String name;
    Double marks;       // Storing marks using Wrapper class Double
    Result resultStatus; // Enumeration member

    Student(String usn, String name, double marksInput) {
        this.usn = usn;
        this.name = name;
        // Autoboxing: primitive double is automatically converted to Double wrapper object
        this.marks = marksInput; 
        determineResult();
    }

    void determineResult() {
        // Unboxing: wrapper object Double is automatically unboxed to primitive double
        double unboxedMarks = this.marks; 

        if (unboxedMarks == -1.0) {
            this.resultStatus = Result.ABSENT;
        } else if (unboxedMarks >= 40.0) {
            this.resultStatus = Result.PASS;
        } else {
            this.resultStatus = Result.FAIL;
        }
    }

    void display() {
        System.out.println("USN           : " + usn);
        System.out.println("Name          : " + name);
        if (resultStatus == Result.ABSENT) {
            System.out.println("Marks         : N/A (Candidate was Absent)");
        } else {
            System.out.println("Marks (Double): " + marks); // Implicit unboxing/toString
        }
        System.out.println("Result Status : " + resultStatus);
        System.out.println("----------------------------------------------");
    }
}

class lab10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Online Examination Result System ===");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Enter USN: ");
            String usn = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks (or -1 if Absent): ");
            double marksInput = sc.nextDouble();
            sc.nextLine(); // Consume newline

            // Creating Student object (demonstrates autoboxing internally)
            students[i] = new Student(usn, name, marksInput);
        }

        System.out.println("\n==============================================");
        System.out.println("             EXAMINATION RESULTS              ");
        System.out.println("==============================================");
        for (Student s : students) {
            s.display();
        }

        sc.close();
    }
}

