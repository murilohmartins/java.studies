package PersistenceAndOOP.ImprovedLibrary;

import java.util.Scanner;

public class CLI {

    private static void menuNotLogged(){
        System.out.println("Type one of the following to perform an action, or anything else to exit");
        System.out.println("1- To perform login");
        System.out.println("2- To create an account");
    }

    private static void menuLogged(){
        System.out.println("Type one of the following to perform an action. or anything else to exit");
        System.out.println("1- To see all books");
        System.out.println("2- To borrow a book");
        System.out.println("3- To return a book");
        System.out.println("4- To logout");
        System.out.println("5- To change password");
        System.out.println("6- To deactivate account");
        System.out.println("7- To see my books borrowed");


    }

    private static void errorMessage(){
        System.out.println("Be sure to fulfill the blanks properly");

    }

    public static void main(String[] args){
        UserSystem usersystem = new UserSystem();
        BookSystem bookSystem = new BookSystem();
        Scanner scanner = new Scanner(System.in);
        usersystem.loadUsers();
        bookSystem.loadBooks();

        System.out.println("----Library System----");
        System.out.println("Welcome!");
        while (true){
            User userInSession = usersystem.getActualUser();

            if (userInSession == null){
                menuNotLogged();
                System.out.println("0- To see all options again");
                System.out.print("Choice: ");
                String choice = scanner.nextLine().trim();
                switch (choice){
                    case "1":
                        System.out.print("What is your name? ");
                        String name = scanner.nextLine().trim();
                        System.out.print("What is your password? ");
                        String password = scanner.nextLine().trim();
                        if (name.isBlank() || password.isBlank()){
                            errorMessage();
                            break;
                        }
                        usersystem.logIn(name,password);
                        break;
                    case "2":
                        System.out.print("What is your name? ");
                        String newName = scanner.nextLine().trim();
                        System.out.print("What is your password? ");
                        String newPassword = scanner.nextLine().trim();
                        System.out.print("Admin password (leave empty if not admin): ");
                        String adminPassword = scanner.nextLine();
                        if (newName.isBlank() || newPassword.isBlank()){
                            errorMessage();
                            break;
                        }
                        boolean isAdmin = adminPassword.equals("1234");
                        usersystem.createUser(newName,newPassword,isAdmin, true);
                        break;
                    case "0":
                        menuNotLogged();
                        break;
                    default:
                        System.out.print("Seeya");
                        return;
                }
            }else {
                menuLogged();
                if(userInSession.isAdmin()){
                    System.out.println("8- Add books");
                }
                System.out.println("0- To see all option again");
                System.out.print("Choice: ");
                String choice = scanner.nextLine().trim();
                switch (choice){
                    case "1":
                        System.out.println("There is the books we currently have: ");
                        bookSystem.listAllBooks();
                        break;
                    case "2":
                        System.out.print("What is the name of the book you want to borrow? ");
                        String bookBorrow = scanner.nextLine().trim();
                        if (bookBorrow.isBlank()){
                            errorMessage();
                            break;
                        }
                        bookSystem.borrowBook(userInSession,bookBorrow);
                        break;
                    case "3":
                        System.out.print("What is the name of the book you want to return? ");
                        String bookReturn = scanner.nextLine().trim();
                        if (bookReturn.isBlank()){
                            errorMessage();
                            break;
                        }
                        bookSystem.returnBook(userInSession,bookReturn);
                        break;
                    case "4":
                        usersystem.logOut();
                        break;
                    case "5":
                        System.out.print("What will be your new password? ");
                        String newPassword = scanner.nextLine();
                        if (newPassword.isBlank()){
                            errorMessage();
                            break;
                        }
                        usersystem.changeActualUserPassword(newPassword);
                        System.out.println("Password successfully changed!");
                        System.out.println("For safety reasons, we ask you to perform login again");
                        usersystem.logOut();
                        break;
                    case "6":
                        usersystem.deactivateAccount();
                        System.out.println("Successfully deactivate");
                        usersystem.logOut();
                        break;
                    case "7":
                        userInSession.printAllBorrowedBooks();
                        break;
                    case "8":
                        if(userInSession.isAdmin()){
                            System.out.print("What is the name of the book you want to add? ");
                            String newBook = scanner.nextLine().trim();
                            System.out.print("Who is the author of this book? ");
                            String newAuthor= scanner.nextLine().trim();
                            if (newBook.isBlank() || newAuthor.isBlank()){
                                errorMessage();
                                break;
                            }
                            bookSystem.addBook(newBook,newAuthor);
                            System.out.println("Book successfully added!");
                            break;
                        }
                        else {
                            System.out.println("Seeya! ");
                            scanner.close();
                            return;
                        }
                    case "0":
                        menuLogged();
                        break;
                    default:
                        usersystem.logOut();
                        System.out.println("Seeya");
                        scanner.close();
                        return;

                }
            }
        }
    }
}
