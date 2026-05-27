package PersistenceAndOOP.ImprovedLibrary;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class BookSystem {
    private ArrayList<Book> books = new ArrayList<>();

    public void saveBooks(){
        try {
            FileWriter writer = new FileWriter("Books.csv");
            for (Book book: books){
                writer.write(book.exportBookData()+"\n");
            }
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void loadBooks(){
        try {
            Scanner scanner = new Scanner(new File("Books.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length < 3) continue;
                String title = parts[0];
                String author = parts[1];
                boolean active = Boolean.parseBoolean(parts[2]);
                books.add(new Book(title, author, active));
            }
            scanner.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void errorMessage() {
        System.out.println("Be sure to fulfill each blank properly");
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public void addBook(String title, String author) {
        if (title.isBlank() || author.isBlank()) {
            errorMessage();
            return;
        }
        books.add(new Book(title, author,true));
        saveBooks();
    }

    public void borrowBook(User user, String title){
        if(user == null || title.isBlank()){
            errorMessage();
            return;
        }
        Book book = findBook(title);
        if(book == null){
            System.out.println("Book not found");
            return;
        }
        if(!book.isAvailable()){
            System.out.println("Book unavailable");
            return;
        }
        user.addBorrowedBook(book);
        book.deactivate();
        System.out.println("Successfully borrowed");
        saveBooks();
    }

    public void returnBook(User user,String title) {
        if (user == null || title.isBlank()){
            errorMessage();
            return;
        }
        Book book = findBook(title);
        if (book==null){
            errorMessage();
            return;
        }
        if (book.isAvailable()){
            System.out.println("Book available");
            return;

        }
        if(!user.hasBook(book)){
            System.out.println("It seems other person has this book");
            return;
        }
        user.removeBorrowedBook(book);
        book.activate();
        System.out.println("Sucessfully returned");
        saveBooks();
    }

    public void listAllBooks(){
        for (Book book: books){
            System.out.println(book.getTitle()+", written by the author "+book.getAuthor());
        }

    }

}