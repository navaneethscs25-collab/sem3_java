/*
Java 1/10/2026

Pass by value: pass it by address (it always changes the original / create a new one)
Pass by reference: pass it by pointer 

Java : always passes by value

Objects as parameters is possible
Acess control :
1. public  (acessible whereever required)
2. private (same class)
3. protected (same package + subclass in other pacakage)
4. default (same package)

private is most restricted 
public is most acessible

Setter :
Getter : 

Driver class: which has methods to do work
static : You could create objects directly in class without creating it explicitly 

instance variable : Every object has unique var

**IMP 1Q**
Static variable aka class variable shared by all objects with the class
used for less memory usage like a company name for all the objects kinda like global var 
No copy 

Static method : class_name.method_name() can use only static var no this or super 
Static Object :
Static block  : At the begin static block is excuted first 
Eg: static {}

*/

class StaticDemo {
    static int a=42;
    static int b=99;
    static void callme() {
        System.out.println("a = " + a);
    }

    public static void main(String[] args) {
        callme();
        System.out.println("b");
    }
}

class Product {
    String name;
    double price;

    Product (String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ProductService {
    Product applyDiscount (Product p) {
        double newPrice = p.price * 0.90;
        return new Product(p.name, newPrice);
    }
}
