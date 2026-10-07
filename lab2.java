/*
Java 7/10/2026

Develop a Java program to create a class Book with members Book ID, Title, Author, and Price. 
Use a constructor to initialize the details. 
Include methods to display book information, overload search() to search by Book ID and Title, and 
create a method that accepts another Book object and returns the costlier book. 
Use a static member to maintain the total number of books created. 
In the main class, create multiple book objects and demonstrate all the operations. 

*/


class Book {
    static int count = 0;

    int  BookID;
    String Title;
    String Author;
    double price;

    Book (int BookID, String Title, String Author, double price) {
        this.BookID = BookID;
        this.Title = Title;
        this.Author = Author;
        this.price = price;
        count++;
    }

    void display() {
        System.out.println("BookID :" + BookID);
        System.out.println("Title  :" + Title);
        System.out.println("Author :" + Author);
        System.out.println("Price  :" + price);

        System.out.println("---------------------------");
    }

    void search(int BookID) {
        if(BookID == this.BookID) {
            System.out.println(" Book is present !!");
        } else {
            System.out.println("Book is not found ");
            System.out.println("Recheck the BookID ");
        }
    } 

    void search(String Title) {
        if(Title == this.Title) {
            System.out.println("Book is present !!");
        } else {
            System.out.println("Book is not found ");
            System.out.println("Recheck the Book Title");
        }

    }

    Book compare (Book b1, Book b2) {
        if(b1.price > b2.price) {
            return b1;    
        } else {
            return b2;
        }
    }

}

class lab2 {
    public static void main(String[] args) {
        Book B1 = new Book(101, "Java - The complete Reference", "Father of Java", 1200);
        Book B2 = new Book(102, "C++ - The complete Reference", "Father of C++", 7000 );
        
        B1.display();
        B2.display();

        B1.search(101);
        B2.search("Java - The complete Reference");

        Book Costlier = B1.compare(B1, B2);
        Costlier.display();
   
        System.out.println("The Total Books created is : " + Book.count);

    }
}