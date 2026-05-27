package PersistenceAndOOP.ImprovedLibrary;

public class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author, boolean available) {
        if (!title.isBlank() && !author.isBlank()) {
            this.title = title;
            this.author = author;
            this.available = available;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setTitle(String title){
        if (!title.isBlank()) {
            this.title = title;
        }else {
            throw new IllegalArgumentException("Invalid title");
        }
    }

    public void setAuthor(String author){
        if (!author.isBlank()){
            this.author= author;
        }else {
            throw new IllegalArgumentException("Invalid author");
        }
    }

    public void activate(){
        if (this.available){
            throw new IllegalArgumentException("Book is already available");
        }else {
            available = true;
        }
    }

    public void deactivate(){
        if (this.available){
            available= false;
        } else {
            throw new IllegalArgumentException(", Book is already unavailable");
        }
    }

    public String exportBookData(){
        return title + ";" + author + ";" + available;
    }

}