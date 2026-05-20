package classes;

import java.util.Scanner;

public class Books {

    String title;
    String author;
    boolean borrowable = true;

    int id = 0;
    Books[] books = new Books[100];

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowable = true;
    }

    public void addBook(String title, String author) {
        books[id] = new Books(title, author);
        id++;
        System.out.println("Book successfully added!");
    }

    public void printAllBooks() {
        if (id == 0) {
            System.out.println("There are no books registered yet.");
            return;
        }

        for (int i = 0; i < id; i++) {
            System.out.println(
                    books[i].title +
                            " - " +
                            books[i].author +
                            " | Available: " +
                            books[i].borrowable
            );
        }
    }

    public void findBookByTitle(String title) {
        boolean exists = false;
        for (int i = 0; i < id; i++) {
            if (books[i].title.equals(title)) {
                exists = true;
                System.out.println(
                        "Book found: " +
                                books[i].title +
                                " by " +
                                books[i].author +
                                " | Available: " +
                                books[i].borrowable
                );
                break;
            }
        }
        if (!exists) {
            System.out.println("We couldn't find this book.");
        }
    }

    public void borrowBook(String title) {
        boolean exists = false;

        for (int i = 0; i < id; i++) {
            if (books[i].title.equals(title)) {
                exists = true;
                if (books[i].borrowable) {
                    books[i].borrowable = false;
                    System.out.println("Book successfully borrowed!");
                } else {
                    System.out.println("This book is already borrowed.");
                }
                break;
            }
        }
        if (!exists) {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title) {
        boolean exists = false;
        for (int i = 0; i < id; i++) {
            if (books[i].title.equals(title)) {
                exists = true;
                if (!books[i].borrowable) {
                    books[i].borrowable = true;
                    System.out.println("Book successfully returned!");
                } else {
                    System.out.println("This book was already available.");
                }
                break;
            }
        }
        if (!exists) {
            System.out.println("Book not found.");
        }
    }

    public void countBooks() {
        System.out.println("There are currently " + id + " books registered.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Books system = new Books("", "");
        while (true) {
            System.out.println("\n===== LIBRARY =====");
            System.out.println("1 - Add book");
            System.out.println("2 - Show all books");
            System.out.println("3 - Find book by title");
            System.out.println("4 - Borrow book");
            System.out.println("5 - Return book");
            System.out.println("6 - Count books");
            System.out.println("Anything else - Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                System.out.print("Book title: ");
                String title = scanner.nextLine().trim();
                System.out.print("Author: ");
                String author = scanner.nextLine().trim();
                system.addBook(title, author);
            } else if (choice.equals("2")) {
                system.printAllBooks();
            } else if (choice.equals("3")) {
                System.out.print("Which book do you want to find? ");
                String title = scanner.nextLine().trim();
                system.findBookByTitle(title);
            } else if (choice.equals("4")) {
                System.out.print("Which book do you want to borrow? ");
                String title = scanner.nextLine().trim();
                system.borrowBook(title);
            } else if (choice.equals("5")) {
                System.out.print("Which book do you want to return? ");
                String title = scanner.nextLine().trim();
                system.returnBook(title);
            } else if (choice.equals("6")) {
                system.countBooks();
            } else {
                System.out.println("Seeya!");
                break;
            }
        }
    }
}