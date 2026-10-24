package DemoPackage;

/*
Java 15/10/2026

Package and Interfaces :
To manage class in 1 file is difficult 
so we subdivide them in seperate packages 

import eventmanagement.events.Event (Event is specific class)
import eventmanagement.*

Without import also u can created objects but its unnecesarly lengthy
event management.events.Event e = new management.events

Advantages of Package :
1. Prevent name conflict
2. Acess protection 
3. Modularity 
4. Maintainance


To run this and understand Packages 
go to sem3_java file in terminal (cd ..)
then compile the of the required 
then call them and exectue 
Eg: java package_name.file_name 


*/
class Balance {
    String name;
    double bal;

    Balance (String n, double b) {
        name = n;
        bal = b;
    }

    void show() {
        System.out.print("--> ");
        System.out.println(name + ": $" + bal);
    }

}

public class day8 {
    public static void main(String[] args) {
        Balance[] current = new Balance[3];
        current[0] = new Balance("K. J. Feilding", 123.23);
        current[1] = new Balance("Will Tell", 157.02);
        current[2] = new Balance("Tom Jackson", -12.33);

        for(int i=0; i<3; i++) current[i].show();
    }    
}
