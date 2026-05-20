package learning.syntax;

import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;


public class Ex16{
    public void printAllLines(){
        try{ new FileWriter("test.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
            String line;
            while((line = reader.readLine())!=null){
                String[] parts= line.split(";");
                System.out.println(parts[0]);
            } reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void register(String email, String password){
        try{ new FileWriter("test.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
            String line;
            boolean exists = false;
            while ((line = reader.readLine())!=null){
                String[] parts = line.split(";");
                if (parts[0].equals(email)){
                    exists= true;
                    break;
                }
            } if (exists){
                System.out.println("This email is already registered");
            } else{
                FileWriter writer = new FileWriter("test.csv", true);
                writer.write(email+";"+password+"\n");
                writer.close();
                System.out.println("Sucefully registered! ");
            } reader.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void login(String email, String password){
        try{ new FileWriter("test.csv", true).close();
            BufferedReader reader = new BufferedReader(new FileReader("test.csv"));
            String line;
            boolean exists = false;
            while ((line = reader.readLine())!=null){
                String[] parts = line.split(";");
                if (parts[0].equals(email) && parts[1].equals(password)) {
                    exists = true;
                    break;
                }
            }
            if (exists){
                System.out.println("Logged in sucessfully");
            } else {
                System.out.println("Unfortenely we couldnt find an email that matches that password");
            } reader.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }




    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Ex16 system = new Ex16();
    while(true){
        System.out.print("Choose what you want to do 1 for list of all emails, 2 to register yourself, 3 to verify login and anything else to exit: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")){
            new Ex16().printAllLines();
        } else if (choice.equals("2")){
            System.out.print("Choose your email: ");
            String email = scanner.nextLine();
            System.out.print("Choose your password: ");
            String password = scanner.nextLine();
            system.register(email,password);
        } else if(choice.equals("3")){
            System.out.print("Choose your email: ");
            String email = scanner.nextLine();
            System.out.print("Choose your password: ");
            String password = scanner.nextLine();
            system.login(email,password);
        }else{
            System.out.println("Seeya");
            break;
        }

}
}
}