//Day 1: 24-09-2026
// Customer purchases 3 items each cost 250.99 calculate the total amount billing amount 
// import java.util.Scanner;

class day1 {
    public static void main(String[] var0) {
        double amt = 127.87;
        System.out.println("Amount : " + (amt-(int)amt) );

        int arr[] = {1000, 787, 856, 999, 1721, 1876, 1729, 666, 777, 787};
        int total=0;
        for(int i=0; i<10; i++) {
            total += arr[i];
        }
        double avg = total/10;
        System.out.println("Average : "+ avg);

        int count =0;
        for(int i=0; i<10; i++) {
            if(i<10) count++;
        }
        System.out.println(count);

        // int items=3;
        // int price= (int)250.99;
        // double bill = price * items;
        // System.out.println("Bill Amount : " + bill);

        // int ch='A';
        // int code=ch;
        // System.out.println(code); //Its uses UNICODE not ASCII 

        // int code=66;
        // char ch = (char) code;
        // System.out.println(ch);

        // int[] marks = new int[5];
        // marks[0] = 91;
        // int[] marks1 = {91, 85, 66, 78, 89};
        // System.out.println(marks1 [marks1.length-1]);
        
        // A school teacher wants to store the marks of 6 students Calculate total and average marks of these students. 
        // int [] marks = new int[5];
        // System.out.println("Enter array elemets");
        // for(int i=0; i<5; i++) {
        //     marks[i] = sc.nextInt();
        // }
        // System.out.println();

        // int Sum=0;
        // float avg=0f;
        // for(int i=0; i<5; i++) {
        //     Sum += marks[i];
        //     System.out.print(marks[i] + ", ");
        // }
        // avg = Sum/marks.length;
        // System.out.println();
        // System.out.println("Sum : "+ Sum);
        // System.out.println("Average :" + avg);

        // sc.close();

    }
}

 