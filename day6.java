/*

Java 8/10/2026
Super v/s this
Overloading v/s Overriding 

Overloading - Complie time polymorphism
Overriding - Runtime Polymorphism

super function : 
It is used to call the method of the  immediate parent
parent class memeber 
super.method_name()
super(..) calls the constructor of the immediate parent 

this function :
Current class object
current class memeber
this.method_name() //Not always explicitly
this(..) calls the constructor of the same class 

While calling a child constructor first parent constructor runs first 
for child to exist parent must be alive 

During no parameter constructor there is no need of calling super()


At runtime the overidden method is selected according to the actual object not merely the reference type.
Acessible methods -> based on referenc class
Overriden methods -> based on inherited class

The method use for selecting the overidden method is called Dynamic memory dispatch 
*/
class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
        // System.out.println("Vechile declared ");
    }

    void start() {
        System.out.println("Vechile starts");
    }

    void stop() {
        System.out.println("Vechile stop");
    }
}

class Car extends Vehicle {

    Car(String brand) {
        super(brand); //
        // System.out.println("Car Created ");

    }

    @Override //Used like comments
    void start() {
        System.out.println("Car starts ");
        // super.start();//To call parents method
    }

    void openBoot () {
        System.out.println("Car Bootup");
    }


}


class day6 {
    public static void main(String[] args) {
        Vehicle v = new Car("Audi");

        v.start(); //Calls the overidden method in Car
        v.stop();  //Calls the only method present in Vechile (as Referenced by Vechile v)

        // v.openBoot(); //OpenBoot is acessible for Car reference 

        // Car c1 = new Car("Audi");
        // c1.start();
    }

}
