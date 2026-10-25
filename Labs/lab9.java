/*
Java 25/10/2026

Develop a Java program to simulate a Bus Reservation System where multiple 
customers attempt to book the same seat simultaneously. Create a class 
BusReservation to maintain seat details and demonstrate the occurrence of a race 
condition when synchronization is not used and how synchronization ensures 
safe access to the shared resource.
*/

class BusReservation {
    int availableSeats;

    BusReservation(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // UNSYNCHRONIZED METHOD: Susceptible to race conditions
    public void bookSeatUnsafe(String passengerName, int seatsRequested) {
        System.out.println(passengerName + " is checking seat availability (Available: " + availableSeats + ")...");

        if (availableSeats >= seatsRequested) {
            System.out.println("-> Seats found available for " + passengerName + ". Processing booking...");
            try {
                // Simulate processing delay so other thread interleaves
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            availableSeats -= seatsRequested;
            System.out.println("   [CONFIRMED] " + seatsRequested + " seat(s) booked for " + passengerName + 
                " | Remaining Seats: " + availableSeats);
        } else {
            System.out.println("   [FAILED] Sorry " + passengerName + ", not enough seats available.");
        }
    }

    // SYNCHRONIZED METHOD: Ensures mutual exclusion and thread-safety
    public synchronized void bookSeatSafe(String passengerName, int seatsRequested) {
        System.out.println(passengerName + " is checking seat availability (Available: " + availableSeats + ")...");

        if (availableSeats >= seatsRequested) {
            System.out.println("-> Seats found available for " + passengerName + ". Processing booking...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            availableSeats -= seatsRequested;
            System.out.println("   [CONFIRMED] " + seatsRequested + " seat(s) booked for " + passengerName + 
                " | Remaining Seats: " + availableSeats);
        } else {
            System.out.println("   [FAILED] Sorry " + passengerName + ", not enough seats available.");
        }
    }
}

class CustomerUnsafe extends Thread {
    BusReservation bus;
    String passengerName;
    int seatsRequested;

    CustomerUnsafe(BusReservation bus, String passengerName, int seatsRequested) {
        this.bus = bus;
        this.passengerName = passengerName;
        this.seatsRequested = seatsRequested;
    }

    @Override
    public void run() {
        bus.bookSeatUnsafe(passengerName, seatsRequested);
    }
}

class CustomerSafe extends Thread {
    BusReservation bus;
    String passengerName;
    int seatsRequested;

    CustomerSafe(BusReservation bus, String passengerName, int seatsRequested) {
        this.bus = bus;
        this.passengerName = passengerName;
        this.seatsRequested = seatsRequested;
    }

    @Override
    public void run() {
        bus.bookSeatSafe(passengerName, seatsRequested);
    }
}

class lab9 {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" PART 1: DEMONSTRATING RACE CONDITION (WITHOUT SYNCHRONIZATION)  ");
        System.out.println("==================================================================");

        // Only 1 seat available, but two customers attempt to book simultaneously
        BusReservation unsafeBus = new BusReservation(1);

        CustomerUnsafe c1 = new CustomerUnsafe(unsafeBus, "Customer-1 (Rahul)", 1);
        CustomerUnsafe c2 = new CustomerUnsafe(unsafeBus, "Customer-2 (Sneha)", 1);

        c1.start();
        c2.start();

        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final seats after unsynchronized bookings: " + unsafeBus.availableSeats);
        System.out.println("Notice: Both customers got confirmed or seats went negative (Race Condition occurred!).");

        System.out.println("\n==================================================================");
        System.out.println(" PART 2: SAFE BOOKING WITH SYNCHRONIZATION                        ");
        System.out.println("==================================================================");

        // Only 1 seat available
        BusReservation safeBus = new BusReservation(1);

        CustomerSafe s1 = new CustomerSafe(safeBus, "Customer-1 (Rahul)", 1);
        CustomerSafe s2 = new CustomerSafe(safeBus, "Customer-2 (Sneha)", 1);

        s1.start();
        s2.start();

        try {
            s1.join();
            s2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final seats after synchronized bookings: " + safeBus.availableSeats);
        System.out.println("Notice: Only one customer booked the seat; the other was safely denied.");
    }
}

