/*
Java 9/10/2026 

When a child constructor is blank then parent constructor [super()] is called implicitly 
if called child constuctor call super(attribute) explicitly
if no paramterised constructor then no need of calling super() explicitly

if the parent has only a parameterized cconstructor then the child constructir must call the apporp tiate super(attribute)

Irrespective of anything always Parent constructor 1st then child constructor 

ABSTRACT CLASS
class which has atleast one abstract method is abstract class
Cannot create object of abstract class
Every subclass (child class) must implement the abstract method 

Final variable : cannot change 
Final method   : cant overide 
Final class    : cant inherit 



extends : 
super : 
constructor : 
overriding :
abstract :
dynamic dispatch :
final :

*/

abstract class Vehicle {
    String brand;

    Vehicle (String brand) {
        this.brand = brand;
    }

    void displayBrand() {
        System.out.println("Brand :"+brand);
    }

    abstract void start();//Abstract method

    final void safetyRule() {
        System.out.println("Follow safety rules");
    }
}

class Car extends Vehicle {

    Car (String brand) {
        super(brand);
    }

    void start() {
        System.out.println("Car starts with the key");
    }
}

class Bike extends Vehicle {

    Bike (String brand) {
        super(brand);
    }
    
    void start() {
        System.out.println("Bike starts with self start");
    }
}

abstract class Employee {
    String eid;
    String name;
    int basic_sal;

    abstract void calculateSalary();
} 

class Faculty extends Employee {
    void calculateSalary() {
        //Diff implementation for each 
    }

}

class LabAssistant extends Employee{
    void calculateSalary () {

    }
}

class day7 {
    public static void main(String[] args) {
        Vehicle v;

        v =new Car("Honda");
        v.displayBrand();
        v.start();
        v.safetyRule();

        System.out.println();


    }
}