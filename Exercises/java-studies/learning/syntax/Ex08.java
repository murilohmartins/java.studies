package learning.syntax;

import java.util.Scanner;
public class Ex08 {
    public static double plus(double a, double b) {
        return a + b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double minus(double a, double b){
        return a - b;
    }

    public static double division(double a, double b){
        return a/b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose an operation or type 0 to close the app(plus,minus,times,division: ");
            String option = scanner.nextLine();
            if (option.equals("0")){
                System.out.print("Have a good day!");
                break;}
            if (!option.equals("plus") &&
                    !option.equals("minus") &&
                    !option.equals("times") &&
                    !option.equals("division")) {

                System.out.println("Invalid option");
                continue;}

            System.out.print("Choose a: ");
            if (!scanner.hasNextDouble()){
                System.out.println("Invalid number!");
                continue;
            }
            double a = scanner.nextDouble();

            System.out.print("Choose b: ");
            if (!scanner.hasNextDouble()){
                System.out.println("Invalid number!");
                continue;
            }
            double b = scanner.nextDouble();

            scanner.nextLine();
            if (option.equals("plus")){
                System.out.println(plus(a,b));
            } else if (option.equals("minus")){
                System.out.println(minus(a,b));
            } else if (option.equals("times")){
                System.out.println(multiplication(a,b));
            } else if (option.equals("division")){
                System.out.println(division(a,b));
                }
            }
        }
    }
