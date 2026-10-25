/*
Java 25/10/2026

Lab 6: Open-ended Exercise
Title: Library Membership and Book Borrowing Management System

Problem Statement:
Design and implement a Library Management System using Object-Oriented Principles.
1. Create an interface Borrowable with methods borrowBook(String title) and returnBook(String title, int daysBorrowed).
2. Create an abstract class LibraryUser with members User ID, Name, and Maximum Allowed Books.
3. Derive two classes StudentMember and FacultyMember from LibraryUser:
   - StudentMember: Max 3 books. Overdue fine of Rs. 5 per day if returned after 14 days.
   - FacultyMember: Max 6 books. Overdue fine of Rs. 2 per day if returned after 30 days.
4. Demonstrate inheritance, interface implementation, encapsulation, and polymorphism.
*/

interface Borrowable {
    void borrowBook(String title);
    void returnBook(String title, int daysBorrowed);
}

abstract class LibraryUser {
    private String userId;
    private String name;
    protected int maxBooks;
    protected int borrowedCount;

    LibraryUser(String userId, String name, int maxBooks) {
        this.userId = userId;
        this.name = name;
        this.maxBooks = maxBooks;
        this.borrowedCount = 0;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public int getMaxBooks() { return maxBooks; }
    public int getBorrowedCount() { return borrowedCount; }

    abstract void displayUserDetails();
}

class StudentMember extends LibraryUser implements Borrowable {
    private static final int DUE_DAYS = 14;
    private static final double FINE_PER_DAY = 5.0;

    StudentMember(String userId, String name) {
        super(userId, name, 3);
    }

    @Override
    public void borrowBook(String title) {
        if (borrowedCount < maxBooks) {
            borrowedCount++;
            System.out.println("Student " + getName() + " successfully borrowed: \"" + title + "\"");
        } else {
            System.out.println("Borrowing failed: Student " + getName() + " reached the limit of " + maxBooks + " books.");
        }
    }

    @Override
    public void returnBook(String title, int daysBorrowed) {
        if (borrowedCount > 0) {
            borrowedCount--;
            double fine = 0.0;
            if (daysBorrowed > DUE_DAYS) {
                fine = (daysBorrowed - DUE_DAYS) * FINE_PER_DAY;
            }
            System.out.println("Student " + getName() + " returned: \"" + title + "\"");
            System.out.println("Days Borrowed: " + daysBorrowed + " | Overdue Fine: Rs. " + fine);
        } else {
            System.out.println("No books to return.");
        }
    }

    @Override
    void displayUserDetails() {
        System.out.println("Role: Student | ID: " + getUserId() + " | Name: " + getName() + 
            " | Borrowed: " + getBorrowedCount() + "/" + getMaxBooks());
    }
}

class FacultyMember extends LibraryUser implements Borrowable {
    private static final int DUE_DAYS = 30;
    private static final double FINE_PER_DAY = 2.0;

    FacultyMember(String userId, String name) {
        super(userId, name, 6);
    }

    @Override
    public void borrowBook(String title) {
        if (borrowedCount < maxBooks) {
            borrowedCount++;
            System.out.println("Faculty " + getName() + " successfully borrowed: \"" + title + "\"");
        } else {
            System.out.println("Borrowing failed: Faculty " + getName() + " reached the limit of " + maxBooks + " books.");
        }
    }

    @Override
    public void returnBook(String title, int daysBorrowed) {
        if (borrowedCount > 0) {
            borrowedCount--;
            double fine = 0.0;
            if (daysBorrowed > DUE_DAYS) {
                fine = (daysBorrowed - DUE_DAYS) * FINE_PER_DAY;
            }
            System.out.println("Faculty " + getName() + " returned: \"" + title + "\"");
            System.out.println("Days Borrowed: " + daysBorrowed + " | Overdue Fine: Rs. " + fine);
        } else {
            System.out.println("No books to return.");
        }
    }

    @Override
    void displayUserDetails() {
        System.out.println("Role: Faculty | ID: " + getUserId() + " | Name: " + getName() + 
            " | Borrowed: " + getBorrowedCount() + "/" + getMaxBooks());
    }
}

class lab6 {
    public static void main(String[] args) {
        System.out.println("=== Library Membership & Borrowing System (Open-Ended Exercise 1) ===");

        StudentMember student = new StudentMember("1BM23CS101", "Kavya");
        FacultyMember faculty = new FacultyMember("FAC-CS-042", "Dr. Ramesh");

        System.out.println("\n--- Initial Member Details ---");
        student.displayUserDetails();
        faculty.displayUserDetails();

        System.out.println("\n--- Borrowing Books ---");
        student.borrowBook("Core Java Volume 1");
        student.borrowBook("Design Patterns");
        faculty.borrowBook("Artificial Intelligence: A Modern Approach");

        System.out.println("\n--- Returning Books & Fine Calculation ---");
        // Student returned after 18 days (4 days late -> 4 * 5 = Rs. 20 fine)
        student.returnBook("Core Java Volume 1", 18);

        // Faculty returned after 35 days (5 days late -> 5 * 2 = Rs. 10 fine)
        faculty.returnBook("Artificial Intelligence: A Modern Approach", 35);

        System.out.println("\n--- Final Member Details ---");
        student.displayUserDetails();
        faculty.displayUserDetails();
    }
}

