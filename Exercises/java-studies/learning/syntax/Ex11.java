package learning.syntax;

import java.util.Scanner;
public class Ex11{

    public static void main(String[]args ){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a number to start: ");
        Double start = scanner.nextDouble();
        System.out.print("Choose a number to end: ");
        Double end = scanner.nextDouble();
        System.out.print("Choose the pacing: ");
        Double pacing = scanner.nextDouble();
        int i = 0;
        while (true){
            if (start+(i*pacing)<=end){
                System.out.println(start+(i*pacing));
                i++;
            } else {
                break;
            }
        }

    }
}
