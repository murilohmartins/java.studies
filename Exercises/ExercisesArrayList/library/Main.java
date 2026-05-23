package ExercisesArrayList.library;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Library system = new Library();
        while(true) {
            System.out.println("--------Library--------");
            System.out.println("Type the following number to execute the action, or anything else to exit");
            System.out.println("1- To add a book to the list");
            System.out.println("2- To see all books on the list");
            System.out.println("3- To see all books available");
            System.out.println("4- To find an specific book by title  ");
            System.out.println("5- To borrow a book");
            System.out.println("6- To return a book");
            System.out.println("7- To delete a book");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                System.out.print("What is the title of the book you want to add? ");
                String title = scanner.nextLine().trim();
                System.out.print("What is the author? ");
                String author = scanner.nextLine().trim();
                system.addBook(title,author);
                System.out.println("Book successfully registered!");
            } else if (choice.equals("2")){
                system.listAllBooks();
            } else if (choice.equals("3")) {
                system.listAllBooksAvailable();
            } else if (choice.equals("4")){
                System.out.print("What is the name of the book you wanna find? ");
                String name= scanner.nextLine();
                system.findByTitle(name);
            } else if(choice.equals("5")){
                System.out.print("What is the name of the book you wanna borrow? ");
                String name = scanner.nextLine();
                system.borrowBook(name);
            } else if (choice.equals("6")) {
                System.out.print("What is the name of the book you want to return? ");
                String name = scanner.nextLine();
                system.returnBook(name);
            } else if(choice.equals("7")){
                System.out.print("What is the name of the book you want to remove? ");
                String name= scanner.nextLine().trim();
                system.deleteBook(name);
            }else {
                System.out.print("Seeya");
                scanner.close();
                break;
            }
        }

    }
}
