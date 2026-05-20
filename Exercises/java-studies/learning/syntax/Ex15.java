package learning.syntax;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class Ex15{ public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    while(true) {
        System.out.print("What you desire? 1 for list of participants, 2 for registration, 3 for verify login or anything else to exit: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            try {
                new FileWriter("info.csv", true).close();
                BufferedReader reader = new BufferedReader(new FileReader("info.csv"));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e){
                e.printStackTrace();
                continue;
            };
        } else if (choice.equals("2")){
            System.out.print("Choose an email to register: ");
            String email = scanner.nextLine();
            System.out.print("Choose your password: ");
            String password = scanner.nextLine();
            Boolean exists = false;
            try {
                new FileWriter("info.csv", true).close();
                BufferedReader reader = new BufferedReader(new FileReader("info.csv"));
                String line;

                while ((line = reader.readLine())!=null){
                    String[]parts= line.split(";");
                    if (parts[0].equals(email)) {
                        exists = true;
                        break;
                    }
                } reader.close();
                if(exists){
                    System.out.println("Email already registered! ");
                } else{
                    FileWriter writer = new FileWriter("info.csv", true);
                    writer.write(email + ";" + password + "\n");
                    writer.close();
                }
            } catch ( IOException e){
                e.printStackTrace();
                continue;

        }


        }else if(choice.equals("3")){
            System.out.print("Choose an email to login: ");
            String email = scanner.nextLine();
            System.out.print("Choose your password: ");
            String password = scanner.nextLine();
            try {
                new FileWriter("info.csv", true).close();
                BufferedReader reader = new BufferedReader(new FileReader("info.csv"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts[0].equals(email) && parts[1].equals(password)){
                        System.out.println("indeed that emaild and passwords belongs for an user registred");
                    } else{
                        System.out.println("None users found with those expecifications");
                    }
                }

            } catch (IOException e){
                e.printStackTrace();
                continue;
            };

        }
        else{
            System.out.println("Seeya");
            break;
        }
    }}}