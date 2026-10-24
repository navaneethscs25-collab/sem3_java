/*
Java 24/10/2026
Interfaces 

interface - interface = extends 
clas - class = extends 
class interface = implements 

Default methods in interface (Java8)
For interfaces u can use default methods also not only abstract method 
u can always redfine the default method too (overwrite)

Static methods in interface (Java8 )
it belongs to interface itself 
call it by interfaceName.methodName()
Cant be overidden like an instance method 

Private methods in interface (Java9)
The can only be used inside that interface 
they cant be called or overiddent by implementing class

static private helper 
eg private static void f_name() 

A class can extend an abstract class and implement an interface at the same time 
class car extends vechile implements insurable 


Packages :
java.lang (implicitly called)
java.util - utility classes (date time scanner)
java.io - (input/output) classes
java.net - Networking
java.swing - GUI programming 
java.sql - Database Acess 


*/

interface Notification {
    void sendMessages();
    
    default void sendSafety() {
        validate();
        sendMessages();
    }

    private void validate () {
        System.out.println("Validating notifciation");
    }

    static void showinfo() {
        System.out.println("Notficiation service");
    }
}

class EmailNotifciation implements Notification {
    public void sendMessages() {
        System.out.println("Sending Email");
    }
}

public class day9 {
    public static void main(String[] args) {
        Notification.showinfo();

        Notification n = new EmailNotifciation();
        n.sendSafety();
    }
}
