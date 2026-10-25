/*
Java 25/10/2026

Lab 12:
a) Develop a Java program to simulate a Bus Route Management System using a LinkedList. 
Use the LinkedList collection to maintain the sequence of bus stops in a route. 
Implement operations to add new bus stops at the beginning, end, or a specified position 
in the route, remove a bus stop based on the stop name or position, search for a particular 
bus stop, and display the complete list of bus stops in the order of the route. 
Display appropriate messages for successful addition, deletion, or when a specified 
bus stop is not found.

b) Develop a Java program to simulate a College Placement Registration System. 
Create a class Student with members USN, Name, Branch, and CGPA. 
Store all student records in an ArrayList and maintain a HashMap with USN as the 
key and the corresponding Student object as the value. 
Implement operations to register students, search by USN, remove records, 
and display all registered students using an Iterator.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

// ==================== Part (a): Bus Route Management (LinkedList) ====================
class BusRoute {
    private LinkedList<String> route = new LinkedList<>();

    // Add stop at beginning
    public void addAtBeginning(String stop) {
        route.addFirst(stop);
        System.out.println("Success: Stop \"" + stop + "\" added at the beginning of the route.");
    }

    // Add stop at end
    public void addAtEnd(String stop) {
        route.addLast(stop);
        System.out.println("Success: Stop \"" + stop + "\" added at the end of the route.");
    }

    // Add stop at specified position (1-based index)
    public void addAtPosition(int position, String stop) {
        if (position >= 1 && position <= route.size() + 1) {
            route.add(position - 1, stop);
            System.out.println("Success: Stop \"" + stop + "\" inserted at position " + position + ".");
        } else {
            System.out.println("Error: Invalid position! Valid positions are between 1 and " + (route.size() + 1) + ".");
        }
    }

    // Remove stop by name
    public void removeByName(String stop) {
        if (route.remove(stop)) {
            System.out.println("Success: Stop \"" + stop + "\" removed from the route.");
        } else {
            System.out.println("Error: Bus stop \"" + stop + "\" not found in the route.");
        }
    }

    // Remove stop by position (1-based index)
    public void removeByPosition(int position) {
        if (position >= 1 && position <= route.size()) {
            String removedStop = route.remove(position - 1);
            System.out.println("Success: Stop \"" + removedStop + "\" at position " + position + " removed.");
        } else {
            System.out.println("Error: Invalid position! No stop found at position " + position + ".");
        }
    }

    // Search for a stop
    public void searchStop(String stop) {
        int index = route.indexOf(stop);
        if (index != -1) {
            System.out.println("Found: Bus stop \"" + stop + "\" is at stop number " + (index + 1) + " in the route.");
        } else {
            System.out.println("Not Found: Bus stop \"" + stop + "\" is not present in this route.");
        }
    }

    // Display the complete route
    public void displayRoute() {
        if (route.isEmpty()) {
            System.out.println("The bus route is currently empty.");
            return;
        }
        System.out.println("\n--- Current Bus Route (" + route.size() + " stops) ---");
        for (int i = 0; i < route.size(); i++) {
            System.out.print((i + 1) + ". " + route.get(i));
            if (i < route.size() - 1) System.out.print(" -> ");
        }
        System.out.println("\n--------------------------------------------");
    }
}

// ==================== Part (b): College Placement Registration ====================
class Student {
    String usn;
    String name;
    String branch;
    double cgpa;

    Student(String usn, String name, String branch, double cgpa) {
        this.usn = usn;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    void display() {
        System.out.printf("USN: %-12s | Name: %-15s | Branch: %-8s | CGPA: %.2f\n", 
            usn, name, branch, cgpa);
    }
}

class PlacementSystem {
    private ArrayList<Student> studentList = new ArrayList<>();
    private HashMap<String, Student> studentMap = new HashMap<>();

    // Register Student
    public void registerStudent(String usn, String name, String branch, double cgpa) {
        if (studentMap.containsKey(usn)) {
            System.out.println("Registration Failed: Student with USN " + usn + " is already registered.");
            return;
        }
        Student student = new Student(usn, name, branch, cgpa);
        studentList.add(student);
        studentMap.put(usn, student);
        System.out.println("Success: Student " + name + " (USN: " + usn + ") registered for placement.");
    }

    // Search by USN using HashMap (O(1) lookup)
    public void searchByUSN(String usn) {
        if (studentMap.containsKey(usn)) {
            System.out.println("Student Found in Placement Portal:");
            studentMap.get(usn).display();
        } else {
            System.out.println("Search Result: No student found with USN " + usn);
        }
    }

    // Remove Student record by USN
    public void removeStudent(String usn) {
        if (!studentMap.containsKey(usn)) {
            System.out.println("Delete Failed: Student with USN " + usn + " not found.");
            return;
        }

        // Remove from HashMap
        studentMap.remove(usn);

        // Remove from ArrayList using an Iterator safely
        Iterator<Student> it = studentList.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.usn.equalsIgnoreCase(usn)) {
                it.remove();
                break;
            }
        }
        System.out.println("Success: Student record for USN " + usn + " removed successfully.");
    }

    // Display all registered students using an Iterator
    public void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No registered students found.");
            return;
        }

        System.out.println("\n==========================================================================");
        System.out.println("                   REGISTERED PLACEMENT STUDENTS                          ");
        System.out.println("==========================================================================");

        Iterator<Student> iterator = studentList.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.print(count++ + ". ");
            iterator.next().display();
        }
        System.out.println("==========================================================================");
    }
}

// ==================== Main Driver Class ====================
class lab12 {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" Part 12(a): Bus Route Management (LinkedList)   ");
        System.out.println("=================================================");
        BusRoute route = new BusRoute();

        // Adding stops
        route.addAtEnd("Majestic");
        route.addAtEnd("Corporation");
        route.addAtEnd("National College");
        route.addAtEnd("BMSCE Bull Temple");
        route.displayRoute();

        // Adding at beginning and specified position
        route.addAtBeginning("Yeshwanthpur");
        route.addAtPosition(3, "City Market");
        route.displayRoute();

        // Searching stops
        System.out.println("\n--- Search Operations ---");
        route.searchStop("BMSCE Bull Temple");
        route.searchStop("Whitefield");

        // Removing stops
        System.out.println("\n--- Remove Operations ---");
        route.removeByName("City Market");
        route.removeByPosition(1);
        route.displayRoute();

        System.out.println("\n=================================================");
        System.out.println(" Part 12(b): Placement System (ArrayList/HashMap)");
        System.out.println("=================================================");
        PlacementSystem ps = new PlacementSystem();

        // Registering students
        ps.registerStudent("1BM23CS001", "Aakash Gupta", "CSE", 8.92);
        ps.registerStudent("1BM23CS045", "Bhavana Rao", "ISE", 9.15);
        ps.registerStudent("1BM23CS089", "Chirag Hegde", "AIML", 8.45);
        ps.registerStudent("1BM23CS120", "Divya Suresh", "ECE", 7.85);

        // Display all using Iterator
        ps.displayAllStudents();

        // Searching by USN
        System.out.println("\n--- Searching by USN ---");
        ps.searchByUSN("1BM23CS045");
        ps.searchByUSN("1BM23CS999"); // Non-existent

        // Removing record
        System.out.println("\n--- Removing Record ---");
        ps.removeStudent("1BM23CS089");
        ps.removeStudent("1BM23CS999"); // Non-existent

        // Updated display using Iterator
        System.out.println("\n--- Updated Placement List ---");
        ps.displayAllStudents();
    }
}
