/*
Java 25/10/2026

Develop a Java program to create a class Reservation in Railway Reservation 
Management System with methods to reserve seats. The application should:
- Handle invalid seat numbers.
- Handle incorrect user input.
- Throw a custom exception SeatAlreadyBookedException.
- Use multiple catch clauses.
- Use finally to display transaction completion status.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

// Custom Exception for already booked seat
class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}

class Reservation {
    private static final int TOTAL_SEATS = 10;
    private boolean[] seats = new boolean[TOTAL_SEATS + 1]; // 1-indexed seats

    public void reserveSeat(int seatNumber) throws SeatAlreadyBookedException, IllegalArgumentException {
        // Handle invalid seat numbers
        if (seatNumber < 1 || seatNumber > TOTAL_SEATS) {
            throw new IllegalArgumentException("Invalid seat number " + seatNumber + 
                "! Valid seat numbers are from 1 to " + TOTAL_SEATS + ".");
        }

        // Throw custom exception if seat is already booked
        if (seats[seatNumber]) {
            throw new SeatAlreadyBookedException("Seat " + seatNumber + " is already booked! Please choose another seat.");
        }

        // Reserve the seat
        seats[seatNumber] = true;
        System.out.println("Success: Seat " + seatNumber + " booked successfully!");
    }

    public void displaySeatStatus() {
        System.out.print("Current Seat Status [X: Booked, O: Available]:\n");
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            System.out.print("Seat " + i + ": " + (seats[i] ? "[X] " : "[O] "));
            if (i % 5 == 0) System.out.println();
        }
    }
}

class lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reservation railway = new Reservation();

        System.out.println("=== Railway Reservation System ===");
        railway.displaySeatStatus();

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.println("\n------------------------------------------------");
            try {
                System.out.print("Enter seat number to reserve (1 - 10): ");
                int seatNo = sc.nextInt(); // May throw InputMismatchException

                railway.reserveSeat(seatNo); // May throw IllegalArgumentException or SeatAlreadyBookedException

            } catch (InputMismatchException ime) {
                // Handling incorrect user input (e.g., non-integer input)
                System.out.println("Error: Incorrect input! Seat number must be a valid integer.");
                sc.nextLine(); // Clear the bad token from scanner buffer
            } catch (SeatAlreadyBookedException sabe) {
                // Handling custom exception
                System.out.println("Booking Error: " + sabe.getMessage());
            } catch (IllegalArgumentException iae) {
                // Handling invalid seat number
                System.out.println("Validation Error: " + iae.getMessage());
            } catch (Exception e) {
                // Catch-all for any other unanticipated exception
                System.out.println("General Error: " + e.getMessage());
            } finally {
                // Finally block to always display transaction completion status
                System.out.println("[Status: Seat reservation transaction attempt completed.]");
            }

            System.out.print("\nDo you want to book another seat? (y/n): ");
            choice = sc.next();
        }

        System.out.println("\nFinal Booking Chart:");
        railway.displaySeatStatus();
        System.out.println("Thank you for using Railway Reservation System!");
        sc.close();
    }
}

