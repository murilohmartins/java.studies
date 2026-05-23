package ExercisesArrayList.Profiles;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserSystem system = new UserSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----User Interface-----");
        System.out.println("Welcome! Type the number of the following action you wanna perform, or anything else to exit");
        System.out.println("1- List all users");
        System.out.println("2- Register an user");
        System.out.println("3- Find an user");
        System.out.println("4- Print infos of an user");
        System.out.println("5- Try to perform login");
        System.out.println("6- Delete an user");
        while (true) {
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                system.listUsers();
            } else if (choice.equals("2")) {
                System.out.print("What is the email to be registered: ");
                String email = scanner.nextLine().trim();
                System.out.print("What is the username to be registered: ");
                String username = scanner.nextLine().trim();
                System.out.print("What is the password to be registered: ");
                String password = scanner.nextLine().trim();
                System.out.print("Well lastly what is your age? be sure to put an number: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                system.registerUser(username, email, password, age);
            } else if (choice.equals("3")) {
                System.out.print("What is the email of the user you wanna find? ");
                String email = scanner.nextLine().trim();
                system.findUser(email);
            } else if (choice.equals("4")) {
                System.out.print("What is the email of the user you wanna find? ");
                String email = scanner.nextLine().trim();
                system.printInfoOfUser(email);
            } else if (choice.equals("5")) {
                System.out.print("Type username or email to perform login: " );
                String emailOrEmail = scanner.nextLine().trim();
                System.out.print("Inform your password: ");
                String password = scanner.nextLine().trim();
                system.login(emailOrEmail, password);
            } else if (choice.equals("6")) {
                System.out.print("What is the email of the user you wanna delete? ");
                String email = scanner.nextLine().trim();
                system.deleteUser(email);
            } else {
                System.out.print("Seeya");
                scanner.close();
                break;
            }

        }
    }
}