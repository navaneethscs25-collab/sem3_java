class Box {
    int width ;
    int breadth ;
    int height ;

    Box (int width, int breadth, int height) {
        this.width = width;
        this.breadth = breadth;
        this.height = height;
    }

    Box () {
        System.out.println("Default constructor ");
    }

    double volume() {
        return width * height * breadth; 
    }
}

class BoxWeight extends Box {
    double weight;

    BoxWeight (int width, int breadth, int height, double weight) {
        // super(width, breadth, height);
        //Java calss super() (default constructor)
        this.weight = weight;
    } 

    double weight () {
        return weight;
    }
}

class Product {
    String name; 
    double price;
    int qty;

    double cost () {
        double cost = price * qty;
        return cost;
    }

    void display() {
        double cost = cost();
        if(cost > 10000) {
            System.out.println("Product :" + name);
        }
    }
  
}

class Bill {
    void calculateBill (int units) {
        System.out.println("Bill :" + units);
    } 

    void calculateBill (int units, double rate) {
        System.out.println("Bill :" + units*rate);
    }

    void calculateBill (int units, double rate, double fixedCharge) {
        System.out.println("Bill :" + (fixedCharge + rate*units));
    }
}

class Result {
    int m1;
    int m2; 
    int m3;
    int total; 
    double percentage;

    Result (int m1, int m2, int m3) {
        this.m1 = m1;
        this.m2 = m2;
        this.m2 = m3;
    }

    Result(int total, double percentage) {
        this.total = total;
        this.percentage = percentage;
    }

    Result calcTotal (Result r1) {
        int total = r1.m1 + r1.m2 + r1.m3;
        double percentage = (total/300) * 100;
        System.out.println("Total :" + total);
        System.out.println("Precentage :" + percentage + "%");

        return new Result(total, percentage);
    }
}

class PatientRecord {
    private int id;
    String name;
    int age;

    PatientRecord (String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }
}

class Ticket {
    int id;
    double amount;
    static int count =0;

    Ticket(int id, double amount) {
        this.id =id;
        this.amount = amount;
        count++;
    }

    //To call count 
    //Ticket.count 
}




class cie1 {
    public static void main(String[] args) {
        Ticket[] tcks = new Ticket[12];
        int[] arr = new int[15];

        // double dist = Double.parseDouble(args[0]);
        // float perKm = Float.parseFloat(args[1]);
        // System.out.println("Cost :" + (dist*perKm));


        // BoxWeight b1 = new  BoxWeight(0,20,30, 9.8);
        // System.out.println(b1.weight());

        
        // BoxWeight weightbox = new BoxWeight(10,20, 30, 8.7);
        // Box plainbox = weightbox;

        // double vol = plainbox.volume();
        // double weight = plainbox.weight();//ERROR


        //Type Conversion & Type Cast
        // float f1 = 236;
        // int i1 = 27;
        // double d1 = 7.64;
        // System.out.println(f1 + d1 + i1);

        // Box b1 = new Box();
        // Box b2 = b1;

        // b1 = null;

        // System.out.println(b2.width);

        




        // System.out.println("Size of byte   : " + Byte.BYTES + " bytes.");        
        // System.out.println("Size of short  : " + Short.BYTES + " bytes.");        
        // System.out.println("Size of int    : " + Integer.BYTES + " bytes.");        
        // System.out.println("Size of long   : " + Long.BYTES + " bytes.");        
        // System.out.println("Size of char   : " + Character.BYTES + " bytes.");        
        // System.out.println("Size of float  : " + Float.BYTES + " bytes.");        
        // System.out.println("Size of double : " + Double.BYTES + " bytes."); 
    }
}
