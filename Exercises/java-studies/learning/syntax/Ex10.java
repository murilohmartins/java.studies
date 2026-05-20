package learning.syntax;

import java.util.Scanner;
public class Ex10 {
    public static void main(String[] args)    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a number to be done the multiplication table: ");
        double num = scanner.nextDouble();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i*num);
        }
    }
}