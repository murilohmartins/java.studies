package learning.syntax;

import java.util.Scanner;
public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a number ");
        int num1= scanner.nextInt();
        for (int i = 0; i<num1;i++){
            System.out.println(i);
        }
    }
}