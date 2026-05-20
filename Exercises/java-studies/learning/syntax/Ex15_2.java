package learning.syntax;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ex15_2 { public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    while(true) {
        System.out.print("What you want to do? 1-see all emails, 2- register yourself,3- verify login or anything else to exit: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")){
            try{ new FileWriter("register.csv", true);
                 BufferedReader reader = new BufferedReader(new FileReader("register.csv"));
                 String line;
                 while ((line=reader.readLine())!=null){
                     System.out.println(line);
                }reader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        } else if(choice.equals("2")){
            try{
                FileWriter writer = new FileWriter("register.csv", true);
                BufferedReader reader = new BufferedReader(new FileReader("register.csv"));
                String line;
                Boolean exists = false;

                System.out.print("Choose an email to register: ");
                String email = scanner.nextLine();
                System.out.print("Choose your password: ");
                String password = scanner.nextLine();
                while ((line= reader.readLine())!=null){
                    String[] parts = line.split(";");
                    if (parts[0].equals(email)){
                        exists=true;
                    }
                } if (exists){
                    System.out.println("This email is already registered");
                } else{
                    writer.write(email+";"+password+"\n");
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();

            }

        } else if(choice.equals("3")){
            System.out.print("Please inform your email to login: ");
            String email = scanner.nextLine();
            System.out.print("Please infor the password to finish login: ");
            String password = scanner.nextLine();
            try {
                new FileWriter("register.csv", true).close();
                BufferedReader reader = new BufferedReader(new FileReader("register.csv"));
                String line;
                Boolean exists= false;
                while ((line = reader.readLine())!=null){
                    String[] parts = line.split(";");
                    if (parts[0].equals(email) && parts[1].equals(password)){
                        exists= true;
                    }
                } if (exists){
                    System.out.println("Welcome back "+email+"!");
                } else{
                    System.out.println("Unfortanely we couldnt find an email that matchs that password");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.print("Goodbye!");
            break;
        }

    }
}}