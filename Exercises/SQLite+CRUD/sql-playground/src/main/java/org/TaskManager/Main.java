// NOTE:
// Connection is opened per method for simplicity.
// Future improvement: use connection pool or singleton connection.


package org.TaskManager;

import java.util.Scanner;

public class Main {

    private static void errorMessage(){
        System.out.println("Be sure to fulfill all blanks properly!");
    }

    private static void successfullyMessage(){
        System.out.println("Action successfully done");
    }

    private static boolean checkIfBlank(String name){
        if(name.isBlank()){
            return true;
        }else {
            return false;
        }
    }

    public static void menuCRUD(){
        System.out.println("Type one of those to perform an action, or anything else to exit");
        System.out.println("1 - To create a task");
        System.out.println("2 - To read a task");
        System.out.println("3 - To update a task");
        System.out.println("4 - To delete a task");
        System.out.println("5 - To see all tasks on db");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskSystem system = new TaskSystem();

        system.databank.connect();
        System.out.println("----Welcome to our humble task manage----");
        menuCRUD();

        while (true){
            System.out.println("6 - To see all options again");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice){
                case "1":
                    System.out.print("Which task you want to create? ");
                    String title = scanner.nextLine().trim();
                    if (checkIfBlank(title)){
                        break;
                    }
                    system.createTask(title);
                    successfullyMessage();
                    break;
                case "2":
                    System.out.print("Which task you want to find? ");
                    String find = scanner.nextLine().trim();
                    if (checkIfBlank(find)){
                        errorMessage();
                        break;
                    }
                    system.findTask(find);
                    successfullyMessage();
                    break;
                case "3":
                    System.out.print("Which task you wanna set done? ");
                    String update = scanner.nextLine().trim();
                    if (checkIfBlank(update)){
                        errorMessage();
                        break;
                    }
                    system.updateToDone(update);
                    successfullyMessage();
                    break;
                case "4":
                    System.out.print("Which task you want to delete? ");
                    String delete = scanner.nextLine().trim();
                    if (checkIfBlank(delete)){
                        errorMessage();
                        break;
                    }
                    system.deleteTask(delete);
                    successfullyMessage();
                    break;
                case "5":
                    system.getAllTasks();
                    break;
                case "6":
                    menuCRUD();
                    break;
                default:
                    System.out.println("Seeya");
                    return;
            }
        }

    }
}