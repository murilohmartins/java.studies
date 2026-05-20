package learning.syntax;

import java.util.Scanner;
public class Ex07{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a number to see the odds till it: ");
        int num = scanner.nextInt();
        for (int i = 0; i<= num; i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}