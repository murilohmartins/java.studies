package learning.syntax;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex17 {
    public void countUsers(){
        try{new FileWriter("Project.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("Project.csv"));
            String line;
            int counter = 0;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(";");
                if (parts.length >=2){
                    counter++;
                }
            } System.out.println(counter);
            reader.close();

        } catch ( IOException e){
            e.printStackTrace();
        }
    }


    public void printAllEmails() {
        try {
            new FileWriter("Project.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("Project.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    System.out.println("Email: " + parts[0] + " & password: " + parts[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void findUser(String email) {
        try {
            new FileWriter("Project.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("Project.csv"));
            String line;
            boolean exists = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equals(email)) {
                    exists = true;
                    break;
                }
            } reader.close();
            if (exists) {
                System.out.println("user found sucefully");
            } else {
                System.out.println("user not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void register(String email, String password){
        try{ new FileWriter("Project.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("Project.csv"));
            String line;
            boolean exists = false;
            while ((line= reader.readLine())!=null){
                String[] parts = line.split(";");
                if (parts[0].equals(email)){
                    exists = true;
                    break;
                }
            } if (exists){
                System.out.println("This email is already registered");
            } else{
                FileWriter writer = new FileWriter("Project.csv", true);
                writer.write(email+";"+password+"\n");
                writer.close();
                System.out.println("User sucefully registered");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex17 system = new Ex17();
        while (true) {
            System.out.print("What is your choice? 1- for see all emails, 2- for check an email in specific, 3- to count how many user do exists, 4- to register a new user or anything else to exit: ");
            String choice= scanner.nextLine().trim();
            if (choice.equals("1")){
                system.printAllEmails();
            } else if(choice.equals("2")){
                System.out.print("Which user you want to find? type the email to find it: ");
                String email = scanner.nextLine().trim();
                system.findUser(email);
            } else if(choice.equals("3")) {
                system.countUsers();
            } else if(choice.equals("4")){
                System.out.print("Choose the email to register: ");
                String email = scanner.nextLine().trim();
                System.out.print("Choose your password: ");
                String password = scanner.nextLine().trim();
                system.register(email,password);
            } else{
                System.out.println("Seeya");
                break;
            }

        }
    }
}