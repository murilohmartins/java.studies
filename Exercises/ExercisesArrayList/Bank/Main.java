package ExercisesArrayList.Bank;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankSystem system = new BankSystem();
        while (true) {
            if (system.actualAccount == null) {
                System.out.println("----Welcome----");
                System.out.println("Type the folowing number to perform an action, or type anything else to exit");
                System.out.println("1- To perform login");
                System.out.println("2- To create an account");
                System.out.print("Choice: ");
                String choice = scanner.nextLine();
                if (choice.equals("1")){
                    System.out.print("What is your name? ");
                    String name = scanner.nextLine().trim();
                    System.out.print("What is your account number? ");
                    String accountnumber = scanner.nextLine().trim();
                    System.out.print("What is your password? ");
                    String password= scanner.nextLine();
                    system.login(name,accountnumber,password);
                } else if(choice.equals("2")){
                    System.out.print("What is your name? ");
                    String name = scanner.nextLine().trim();
                    System.out.print("What will be your account number? ");
                    String accNumber = scanner.nextLine().trim();
                    System.out.print("What will be your password? ");
                    String password = scanner.nextLine().trim();
                    System.out.print("How much you plan to deposit first? ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    system.addAccount(name,accNumber,password,amount);
                } else{
                    System.out.print("Seeya!");
                }

            }else{
                System.out.println("----Welcome "+system.actualAccount.name+"----");
                System.out.println("Type the folowing number to perform an action, or type anything else to exit");
                System.out.println("1- To see your current balance");
                System.out.println("2- To deposit money");
                System.out.println("3- To make a transference of money");
                System.out.println("4- To withdraw money from your current balance");
                System.out.println("5- To try find an user");
                System.out.println("6- To see all user registered");
                System.out.println("7- To see all user registered who maintain an active account");
                System.out.println("8- To deactivate your account");
                System.out.println("9- To logout");
                System.out.print("Choice:  ");
                String choice = scanner.nextLine();
                if (choice.equals("1")){
                    system.currentBalance();
                } else if (choice.equals("2")){
                    System.out.print("How much you wanna deposit? ");
                    double amount = scanner.nextDouble();
                    system.deposit(amount);
                    scanner.nextLine();
                } else if (choice.equals("3")){
                    System.out.print("What is the account number of the person you want to transfer? ");
                    String accNumber= scanner.nextLine();
                    System.out.print("How much you want to transfer? ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    if (amount>0){
                        system.transfer(accNumber,amount);
                    } else{
                        System.out.println("Be sure to try a positive amount!");
                    }
                } else if (choice.equals("4")){
                    System.out.print("How much you want to withdraw? ");
                    double amount= scanner.nextDouble();
                    scanner.nextLine();
                    if (amount>0){
                        system.withdraw(amount);
                    } else {
                        System.out.println("Be sure to try a positive amount! ");
                    }
                } else if (choice.equals("5")){
                    System.out.print("Who you want to try find? ");
                    String person = scanner.nextLine();
                    system.findUser(person);
                } else if (choice.equals("6")){
                    system.printAllUsers();
                } else if (choice.equals("7")){
                    system.printAllUsersActive();
                } else if (choice.equals("8")){
                    system.deactivateAccount();
                } else if (choice.equals("9")){
                    system.logout();
                } else {
                    System.out.print("Seeya");
                    break;
                }
            }

        }
    }
}