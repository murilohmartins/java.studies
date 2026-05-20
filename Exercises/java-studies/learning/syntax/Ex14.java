package learning.syntax;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ex14 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.print("Which email you desire to register? ");
            String email = scanner.nextLine();

            if (email.isEmpty()) {
                System.out.println("Bye!");
                break;
            }

            System.out.print("Choose your password: ");
            String password = scanner.nextLine();

            boolean exists = false;

            try {
                new FileWriter("Project.csv", true).close();
                BufferedReader reader = new BufferedReader(new FileReader("Project.csv"));
                String line;

                while ((line = reader.readLine()) != null){
                    String[] parts = line.split(";");
                    if (parts[0].equals(email)){
                        exists = true;
                        break;
                    }
                }
                reader.close();
                if (exists){
                    System.out.println("This email is already registered!");
                } else{
                    FileWriter writer = new FileWriter("Project.csv", true);
                    writer.write(email + ";" + password + "\n");
                    writer.close();
                    System.out.println("User registered successfully!");
                }

            } catch (IOException e){
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}