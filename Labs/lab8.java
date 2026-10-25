/*
Java 25/10/2026

Develop a Java program to accept a student's email address and perform the following string operations:
1. Determine and display the length of the email address.
2. Extract and display the username (the part of the email address before the @ symbol).
3. Extract and display the domain name (the part of the email address after the @ symbol) and compare it with the valid domain "bmsce.ac.in" to verify whether the email belongs to the institution.
4. Convert the complete email address to lowercase and display the modified string.
5. Check whether the email address starts with a given prefix (such as a student registration number) and display an appropriate message.
6. Check whether the email address ends with the valid domain "bmsce.ac.in" and display the result.
7. Replace the domain "bmsce.ac.in" with "cse.bmsce.ac.in" and display the updated email address.
8. Check whether the email address contains a specific character or sequence (such as "cse" or "2025") and display the result.
9. Remove any leading or trailing spaces in the entered email address and display the trimmed email using an appropriate string method.
10. Compare two email addresses entered by the user and display whether they are identical, ignoring case differences.
*/

import java.util.Scanner;

class StudentEmail {
    private String rawEmail;
    private String email;

    StudentEmail(String rawEmail) {
        this.rawEmail = rawEmail;
        // 9. Remove any leading or trailing spaces
        this.email = rawEmail.trim();
    }

    void performAllOperations(String prefixToCheck, String sequenceToCheck, String secondEmail) {
        System.out.println("\n=======================================================");
        System.out.println("            STUDENT EMAIL ANALYSIS REPORT             ");
        System.out.println("=======================================================");

        // Operation 9: Trimmed output
        System.out.println("09. Trimmed Email Address                  : \"" + email + "\"");

        // Operation 1: Length of the email address
        System.out.println("01. Length of Email Address                : " + email.length());

        // Extracting Username and Domain
        int atIndex = email.indexOf('@');
        if (atIndex != -1) {
            // Operation 2: Username (before @)
            String username = email.substring(0, atIndex);
            System.out.println("02. Username (before '@')                  : " + username);

            // Operation 3: Domain name (after @) and institution verification
            String domain = email.substring(atIndex + 1);
            System.out.println("03. Domain Name (after '@')                : " + domain);
            if (domain.equalsIgnoreCase("bmsce.ac.in")) {
                System.out.println("    -> Verification                        : Belongs to BMSCE institution.");
            } else {
                System.out.println("    -> Verification                        : Does NOT belong to BMSCE institution.");
            }
        } else {
            System.out.println("02/03. Invalid Email Format (No '@' symbol found).");
        }

        // Operation 4: Convert to lowercase
        String lowerEmail = email.toLowerCase();
        System.out.println("04. Email in Lowercase                     : " + lowerEmail);

        // Operation 5: Check if starts with a given prefix
        boolean startsWithPrefix = email.startsWith(prefixToCheck);
        System.out.println("05. Starts with prefix \"" + prefixToCheck + "\"             : " + 
            (startsWithPrefix ? "YES, matches registration number" : "NO, does not match"));

        // Operation 6: Check whether email ends with valid domain "bmsce.ac.in"
        boolean endsWithValidDomain = email.endsWith("bmsce.ac.in");
        System.out.println("06. Ends with valid domain \"bmsce.ac.in\"   : " + endsWithValidDomain);

        // Operation 7: Replace domain "bmsce.ac.in" with "cse.bmsce.ac.in"
        String updatedEmail = email.replace("bmsce.ac.in", "cse.bmsce.ac.in");
        System.out.println("07. Updated Email with \"cse.bmsce.ac.in\"   : " + updatedEmail);

        // Operation 8: Check if email contains specific sequence
        boolean containsSequence = email.contains(sequenceToCheck);
        System.out.println("08. Contains sequence \"" + sequenceToCheck + "\"               : " + containsSequence);

        // Operation 10: Compare two email addresses ignoring case differences
        boolean isIdentical = email.equalsIgnoreCase(secondEmail.trim());
        System.out.println("10. Comparison with second email (ignore case): " + 
            (isIdentical ? "Identical email addresses" : "Different email addresses"));
        System.out.println("=======================================================");
    }
}

class lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Email Address (with spaces if any): ");
        String emailInput = sc.nextLine();

        System.out.print("Enter Prefix to check (e.g., USN/Reg No like 1BM23CS): ");
        String prefix = sc.nextLine();

        System.out.print("Enter Sequence to check (e.g., cse or 2025): ");
        String sequence = sc.nextLine();

        System.out.print("Enter a Second Email Address for comparison: ");
        String secondEmailInput = sc.nextLine();

        StudentEmail studentEmail = new StudentEmail(emailInput);
        studentEmail.performAllOperations(prefix, sequence, secondEmailInput);

        sc.close();
    }
}

