/*
Java 28/9/26

If there are no refernce to obj then elligible for garbage allocation 
System.gc() calls garbage collection (only requests it)

Compile Time polymorphism (decide at compile time only) 
Method Overloading (Same method name) 
happens within the same class
only Number of parameters, type of parameters, order of parameters;
not change in return type 



*/

//Example of overloding no of parameters
class BillingService {
    double calculatebill (double price) {
        return price;
    }

    double calculatebill (double price, int qty) {
        return price*qty;
    }

    double calculatebill (double price, int qty, double discount) {
        return price * qty * (discount/100);
    }
}
 
class Stack {
    int[] data;
    int top;

    Stack(int size) {
        data = new int[size];
        top = -1;
    }

    void push (int val) {
        if (top == data.length-1) {
            System.out.println("Stack Overflow");
            return;
        }
        top ++;
        data[top] = val;
    }

    int pop () {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return data[top--]; 
    }

    void display () {
        for(int i=top; i>=0; i--) {
            System.out.print(data[i] + ", ");
        }
        System.out.println();
    }

}

class day3 {
    public static void main(String[] args) {
        Stack s1 = new Stack(10) ;

        s1.push(10);
        s1.push(20);
        s1.push(30);

        s1.display();

        System.out.println("Popped element :" + s1.pop());
    }
}