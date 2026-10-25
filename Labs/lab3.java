/*
Java 25/10/2026

Lab 3:
a) Develop a Java program to create an abstract class EnergySource with members 
Source ID, Source Name, and Energy Generated (in kWh). Include an abstract method 
calculateEfficiency(). Derive the classes SolarEnergy and WindEnergy from 
EnergySource and implement the method based on the following criteria: 
For SolarEnergy, efficiency is calculated as (Energy Generated / 5000) × 100. 
For WindEnergy, efficiency is calculated as (Energy Generated / 8000) × 100. 
Display source details and efficiency percentage. 
Demonstrate dynamic method dispatch using an EnergySource reference.

b) Develop a Java program to create an interface ParkingCharge containing the 
methods calculateCharge() and displayParkingDetails(). Create a class 
VehicleParking with members Vehicle Number, Vehicle Type, and Parking Hours. 
Derive the classes TwoWheeler and FourWheeler from VehicleParking and implement 
the interface. Calculate the parking charge as follows: 
For TwoWheeler, charge Rs. 20 per hour for the first two hours and Rs. 10 per hour 
for each additional hour. 
For FourWheeler, charge Rs. 50 per hour for the first two hours and Rs. 30 per hour 
for each additional hour. 
Display vehicle details and total parking charge. 
Demonstrate runtime polymorphism using a ParkingCharge reference.
*/

// ==================== Part (a): EnergySource Hierarchy ====================
abstract class EnergySource {
    int sourceId;
    String sourceName;
    double energyGenerated; // in kWh

    EnergySource(int sourceId, String sourceName, double energyGenerated) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.energyGenerated = energyGenerated;
    }

    abstract double calculateEfficiency();

    void displayDetails() {
        System.out.println("Source ID        : " + sourceId);
        System.out.println("Source Name      : " + sourceName);
        System.out.println("Energy Generated : " + energyGenerated + " kWh");
        System.out.printf("Efficiency       : %.2f%%\n", calculateEfficiency());
        System.out.println("----------------------------------------");
    }
}

class SolarEnergy extends EnergySource {
    SolarEnergy(int sourceId, String sourceName, double energyGenerated) {
        super(sourceId, sourceName, energyGenerated);
    }

    @Override
    double calculateEfficiency() {
        return (energyGenerated / 5000.0) * 100.0;
    }
}

class WindEnergy extends EnergySource {
    WindEnergy(int sourceId, String sourceName, double energyGenerated) {
        super(sourceId, sourceName, energyGenerated);
    }

    @Override
    double calculateEfficiency() {
        return (energyGenerated / 8000.0) * 100.0;
    }
}

// ==================== Part (b): ParkingCharge Interface ====================
interface ParkingCharge {
    double calculateCharge();
    void displayParkingDetails();
}

class VehicleParking {
    String vehicleNumber;
    String vehicleType;
    double parkingHours;

    VehicleParking(String vehicleNumber, String vehicleType, double parkingHours) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingHours = parkingHours;
    }
}

class TwoWheeler extends VehicleParking implements ParkingCharge {
    TwoWheeler(String vehicleNumber, double parkingHours) {
        super(vehicleNumber, "Two Wheeler", parkingHours);
    }

    @Override
    public double calculateCharge() {
        if (parkingHours <= 2) {
            return parkingHours * 20.0;
        } else {
            return (2 * 20.0) + ((parkingHours - 2) * 10.0);
        }
    }

    @Override
    public void displayParkingDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Parking Hours  : " + parkingHours + " hrs");
        System.out.printf("Total Charge   : Rs. %.2f\n", calculateCharge());
        System.out.println("----------------------------------------");
    }
}

class FourWheeler extends VehicleParking implements ParkingCharge {
    FourWheeler(String vehicleNumber, double parkingHours) {
        super(vehicleNumber, "Four Wheeler", parkingHours);
    }

    @Override
    public double calculateCharge() {
        if (parkingHours <= 2) {
            return parkingHours * 50.0;
        } else {
            return (2 * 50.0) + ((parkingHours - 2) * 30.0);
        }
    }

    @Override
    public void displayParkingDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Parking Hours  : " + parkingHours + " hrs");
        System.out.printf("Total Charge   : Rs. %.2f\n", calculateCharge());
        System.out.println("----------------------------------------");
    }
}

// ==================== Main Driver Class ====================
class lab3 {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Lab 3(a): Dynamic Method Dispatch (EnergySource) ");
        System.out.println("==================================================");
        
        // Demonstrating dynamic method dispatch using EnergySource reference
        EnergySource eRef;

        eRef = new SolarEnergy(101, "Pavagada Solar Park", 4200.0);
        System.out.println("Solar Energy Source Details:");
        eRef.displayDetails();

        eRef = new WindEnergy(202, "Muppandal Wind Farm", 6400.0);
        System.out.println("Wind Energy Source Details:");
        eRef.displayDetails();

        System.out.println("\n==================================================");
        System.out.println("  Lab 3(b): Runtime Polymorphism (ParkingCharge)   ");
        System.out.println("==================================================");
        
        // Demonstrating runtime polymorphism using ParkingCharge interface reference
        ParkingCharge pRef;

        pRef = new TwoWheeler("KA-01-AB-1234", 5);
        pRef.displayParkingDetails();

        pRef = new FourWheeler("KA-05-XY-9876", 4);
        pRef.displayParkingDetails();
    }
}
