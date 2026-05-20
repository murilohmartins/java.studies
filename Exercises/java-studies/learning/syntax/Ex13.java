package learning.syntax;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Ex13{ public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your email: ");
        String email = scanner.nextLine();
        System.out.print("What will be your password: ");
        String password = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter ("Dados.csv", true);
            writer.write(email+";"+password+"\n");
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        scanner.close();
}}