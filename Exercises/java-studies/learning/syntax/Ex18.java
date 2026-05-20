package learning.syntax;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
public class Ex18 {
    public void deleteContact(String number){
        try{
            new FileWriter("contacts.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            String newFile= "";
            boolean exists = false;
            while ((line= reader.readLine())!=null) {
                String[] parts = line.split(";");
                if (!parts[1].equals(number)){
                    newFile += line+"\n";
                }else {
                    exists= true;
                }
            }if (exists){
                FileWriter writer = new FileWriter("contacts.csv", false);
                writer.write(newFile);
                writer.close();
                System.out.println("Contact sucefully erased from the entire existence! ");
                }else{
                System.out.println("We couldnt find a contact that corresponds to this number");
            } reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void registerContact(String name, String number) {
        try {
            new FileWriter("contacts.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            boolean exists = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[1].equals(number)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                System.out.println("This number is already in use");
            } else {
                FileWriter writer = new FileWriter("contacts.csv", true);
                writer.write(name + ";" + number + "\n");
                writer.close();
                System.out.println("User sucefully registered!");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findContact(String number){
        try{ new FileWriter("contacts.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            boolean exists = false;
            String name = "";
            while ((line = reader.readLine())!=null){
                String[] parts = line.split(";");
                if (parts[1].equals(number)) {
                    name = parts[0];
                    exists = true;
                    break;
                }
                }if (exists){
                    System.out.println("User "+name+" was sucefully found");
                } else{
                    System.out.println("Unfornetelly we couldnt find a user with this number");
                }
             reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printAllContacts(){
        try{ new FileWriter("contacts.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            while((line = reader.readLine())!=null){
                String[] parts = line.split(";");
                System.out.println("User: "+parts[0]+"| Phone: "+parts[1]);
            } reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void countContacts(){
        try{ new FileWriter("contacts.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("contacts.csv"));
            String line;
            int countup = 0;
            while ((line = reader.readLine())!=null){
                countup++;
            } System.out.println("Total contacts registered: "+countup);
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex18 system = new Ex18();
        while (true) {
            System.out.print("Choose 1 to register a new contact, 2 to find a contact by number, 3 to see all contacts, 4 to see how many contacts already registered, 5 to delete a contact based on the number and anything else to exit: ");
            String choice = scanner.nextLine().trim();
            if (choice.equals("1")) {
                System.out.print("Which name for the contact? ");
                String name = scanner.nextLine().trim();
                System.out.print("Which number will be saved? ");
                String number = scanner.nextLine().trim();
                if (name.length()<= 1||number.length()<=1){
                    System.out.println("To register a new contact, be sure the name and password has more than 1 character");
                } else{
                    system.registerContact(name, number);
                }
            } else if(choice.equals("2")){
                System.out.print("Which number you want to try to find a contact related to? ");
                String number = scanner.nextLine().trim();
                system.findContact(number);
            } else if(choice.equals("3")){
                system.printAllContacts();
            } else if(choice.equals("4")){
                system.countContacts();
            } else if(choice.equals("5")){
                System.out.print("Which number you do want to delete? ");
                String number = scanner.nextLine().trim();
                system.deleteContact(number);
            }
            else {
                System.out.print("Seeya");
                break;
            }
        }
    }
}