package ExercisesArrayList.library;

import java.util.ArrayList;

public class Library{
    ArrayList<Books> books = new ArrayList<>();

    public void addBook(String name, String author){
        books.add(new Books(name,author,true));
    }

    public void listAllBooks(){
        for (Books book : books){
            System.out.println(book.title+", made by the author "+book.author);
        }
    }

    public void listAllBooksAvailable(){
        for (Books book : books){
            if(book.available){
                System.out.println(book.title+", made by the author "+book.author);
            }
        }
    }

    public void findByTitle(String name){
        boolean found = false;
        for (Books book : books){
            if (book.title.equals(name)){
                found = true;
                System.out.println("Book found: " + book.title+", made by the author "+book.author);
                if (book.available) {
                    System.out.println("He is available");
                } else {
                    System.out.println("He is currently taken");
                }
            }
        } if (!found){
            System.out.println("Unfortunately we couldnt find this book");
        }
    }

    public void borrowBook(String title){
        boolean found = false;
        for (Books book : books){
            if (book.title.equals(title)){
                found = true;
                System.out.println("Book found: " + book.title);
                if (book.available) {
                    System.out.println("Done! remind the date due");
                    book.available = false;
                } else {
                    System.out.println("He is currently taken");
                }
                break;
            }
        } if (!found){
            System.out.println("Unfortunately we couldnt find this book");
        }
    }

    public void returnBook(String title){
        boolean found = false;
        for (Books book : books){
            if (book.title.equals(title)){
                found = true;
                System.out.println("Book found: " + book.title);
                if (book.available) {
                    System.out.println("This book is not taken yet!");
                } else {
                    System.out.println("Thanks for returning the book");
                    book.available = true;
                }
                break;
            }
        } if (!found){
            System.out.println("Unfortunately we couldnt find this book");
        }
    }

    public void deleteBook(String title){
        boolean found = false;

        for (Books book : books){
            if (book.title.equals(title)){
                found = true;

                if (book.available){
                    books.remove(book);
                    System.out.println("Book successfully deleted");
                } else {
                    System.out.println("This book is currently borrowed.");
                }

                break;
            }
        }

        if (!found){
            System.out.println("Book not found.");
        }
    }

}