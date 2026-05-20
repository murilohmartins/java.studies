package learning.syntax;

import java.util.Scanner;
public class Ex03{
    public static double calculateBMI(double weight, double height){
        return weight/(height*height);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.print("What is your weight? ");
        double weight = scanner.nextDouble();
        System.out.print("And what about your height? ");
        double height = scanner.nextDouble();
        double bmi = calculateBMI(weight,height);
        if (bmi <=18.2) {
            System.out.println("since your bmi is" + bmi + ", youre currently underweight");
        } else if (bmi <= 24.1){
            System.out.println("since your bmi is "+ bmi + ", youre currently in a normal weight");
        } else if (bmi <= 29.9){
            System.out.println("since your bmi is "+ bmi + ", youre currently overweight");
        } else {
            System.out.println("You are currently in the obese range");
        }
        scanner.close();
        }
    }
