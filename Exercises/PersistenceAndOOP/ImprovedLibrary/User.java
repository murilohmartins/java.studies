package PersistenceAndOOP.ImprovedLibrary;

import java.util.ArrayList;

public class User {
    private String idNumber;
    private String password;
    private boolean active;
    private boolean admin;
    private ArrayList <Book> borrowedBooks = new ArrayList<>();


    public User(String idNumber, String password, boolean admin, boolean active) {
            if (!idNumber.isBlank() && !password.isBlank()) {
                this.idNumber = idNumber;
                this.password = password;
                this.active = active;
                this.admin = admin;
                this.borrowedBooks = new ArrayList<>();
            } else {
                throw new IllegalArgumentException("Invalid ");
            }
        }


        public String getIdNumber(){
            return idNumber;
        }



        public void addBorrowedBook(Book book){
            if(book == null){
                throw new IllegalArgumentException("Invalid book");
            }
            borrowedBooks.add(book);
        }

        public void removeBorrowedBook(Book book){

            if(book == null){
                throw new IllegalArgumentException("Invalid book");
            }

            borrowedBooks.remove(book);
        }


        public void printAllBorrowedBooks(){
            for (Book book: borrowedBooks){
                System.out.println(book.getTitle()+" written by "+book.getAuthor());
            }
        }

        public void changePassword(String newPassword){

        if (newPassword.isBlank()){
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = newPassword;
        }

        public void deactivate(){
            if (this.active){
                this.active= false;
            }else {
                throw new IllegalArgumentException("This account is already activate");
            }
        }

        public void activate(){
            if (!this.active){
                this.active= true;
            } else {
                throw new IllegalArgumentException("This account is already deactivate");
            }
        }

        public boolean isActive(){
            return active;
        }

        public boolean isAdmin(){
            return admin;
        }

        public boolean hasBook(Book book){
            return borrowedBooks.contains(book);
        }

        public boolean passwordMatch(String password){
            return this.password.equals(password);
        }

        public String exportUserData(){
            return idNumber + ";" + password + ";" + active + ";" + admin;
        }

}
