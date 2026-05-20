package learning.syntax;

import java.util.Scanner;
public class Ex02{ public static void main (String[] args){
    Scanner scanner = new Scanner (System.in);
    System.out.print("What is your name? ");
    String name = scanner.nextLine();
    System.out.print("And how old are you? ");
    int age = scanner.nextInt();
    System.out.println("Good afternoon "+name+",By my counts you have "+age+ " years");
}
}