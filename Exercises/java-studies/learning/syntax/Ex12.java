package learning.syntax;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Ex12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("What is your name: ");
            String name = scanner.nextLine();
            if (name.isEmpty()){
                System.out.println("Seeya");
                break;
            }
            System.out.print("And which is your number for contact: ");
            String number = scanner.nextLine();
            try {
                FileWriter writer = new FileWriter("Contatos.csv", true);
                writer.write(name + "," + number+ "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}