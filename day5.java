/*
Java
5/10/2026

final keyword is like const in cpp
final variable cant change
final method cant be overide by subclass
final class cant be inherited 

static final 
Comman to all class and cant be changed 

Syntax: java file_name args 

INHERITANCE
child class : Subclass, child, derivedclass
parent class :Super class, Parent , Base class

class child_name extends parent_name {
}
            
private : only same class
default : only same class package subclass
protected : only same class package subclass
public : acessible same class package subclass and everywhere

Types of inheritance
One class cant inherit from two classes simultaneously like CPP
Singlelevel :
MultiLevel  :
Hierachy    :

*/


class day1 {
    public static void main(String[] args) {

        //For each loop 
        for(String val : args) {
            System.out.println(val);
        }

        int units = Integer.parseInt(args[0]);
        double rate = Double.parseDouble(args[1]);

        double bill = units * rate;

        System.out.println("Units :" + units);
        System.out.println("Rate  :" + rate);
        System.out.println("Bill  :" + bill);

    }

}

