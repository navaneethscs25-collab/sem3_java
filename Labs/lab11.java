/*
Java 25/10/2026

Develop a Java program to simulate a Hospital Patient Record System using Generics. 
Create a generic class PatientRecord<T1, T2> where T1 represents the Patient ID 
and T2 represents the Doctor Assigned. Include methods addRecord(T1 patientID, T2 doctorAssigned) 
to store patient details and displayRecord() to display the stored records. 
In the main method, use BufferedReader to accept input from the user. 
Demonstrate the generic class by creating a PatientRecord<String, String> object to store 
an alphanumeric Patient ID and Doctor Name, and a PatientRecord<String, String> object to store 
a numeric Patient ID entered as a string and Doctor Name. Store the entered details using 
the generic methods and display all patient records.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// Generic Class with two type parameters
class PatientRecord<T1, T2> {
    private T1 patientID;
    private T2 doctorAssigned;

    // Method to store patient details
    public void addRecord(T1 patientID, T2 doctorAssigned) {
        this.patientID = patientID;
        this.doctorAssigned = doctorAssigned;
    }

    // Method to display stored records
    public void displayRecord() {
        System.out.println("Patient ID      (Type: " + patientID.getClass().getSimpleName() + ") : " + patientID);
        System.out.println("Doctor Assigned (Type: " + doctorAssigned.getClass().getSimpleName() + ") : " + doctorAssigned);
        System.out.println("-----------------------------------------------------------------");
    }
}

class lab11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("=== Hospital Patient Record System (Generics Demo) ===");

        // Record 1: Alphanumeric Patient ID and Doctor Name using PatientRecord<String, String>
        System.out.println("\n--- Enter Details for Record 1 (Alphanumeric ID) ---");
        System.out.print("Enter Alphanumeric Patient ID (e.g., PAT-BLR-101): ");
        String alphaId = reader.readLine();
        System.out.print("Enter Doctor Assigned Name: ");
        String doc1 = reader.readLine();

        PatientRecord<String, String> record1 = new PatientRecord<>();
        record1.addRecord(alphaId, doc1);

        // Record 2: Numeric Patient ID entered as a String and Doctor Name
        System.out.println("\n--- Enter Details for Record 2 (Numeric ID as String) ---");
        System.out.print("Enter Numeric Patient ID (e.g., 9081234): ");
        String numericStringId = reader.readLine();
        System.out.print("Enter Doctor Assigned Name: ");
        String doc2 = reader.readLine();

        PatientRecord<String, String> record2 = new PatientRecord<>();
        record2.addRecord(numericStringId, doc2);

        // Record 3: Numeric Patient ID using Integer type to further demonstrate generic flexibility
        System.out.println("\n--- Enter Details for Record 3 (Numeric ID as Integer Object) ---");
        System.out.print("Enter Integer Patient ID (e.g., 5001): ");
        int integerId = Integer.parseInt(reader.readLine());
        System.out.print("Enter Doctor Assigned Name: ");
        String doc3 = reader.readLine();

        PatientRecord<Integer, String> record3 = new PatientRecord<>();
        record3.addRecord(integerId, doc3);

        // Displaying all patient records
        System.out.println("\n=================================================================");
        System.out.println("                   ALL STORED PATIENT RECORDS                    ");
        System.out.println("=================================================================");
        System.out.println("Record 1:");
        record1.displayRecord();

        System.out.println("Record 2:");
        record2.displayRecord();

        System.out.println("Record 3:");
        record3.displayRecord();
    }
}

