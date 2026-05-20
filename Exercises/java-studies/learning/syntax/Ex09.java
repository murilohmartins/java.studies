package learning.syntax;

import java.util.Scanner;
public class Ex09 { public static void main(String[]args ){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Choose a number to see odd and even numbers till it: ");
    double num = scanner.nextDouble();
    for (int i = 0; i<= num; i++){
        if (i % 2 == 0){
            System.out.println(i+" is a even number");
        } else {
            System.out.println(i+" is a odd number");
        }
        }
    }

}