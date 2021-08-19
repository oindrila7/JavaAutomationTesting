//Write a program to take 3 inputs from user and do sum and average

package basic_java;

import java.util.Scanner;

public class Prob_3 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner (System.in);
        System.out.print("Input first number: ");
        int num1 = in.nextInt ();
        System.out.print("Input second number: ");
        int num2= in.nextInt ();
        System.out.print("Input third number:");
        int num3 = in.nextInt ();
        System.out.println("Sum of three number is=" +(num1 + num2 + num3));
        System.out.println("Average of three number is="+(num1 + num2 + num3) / 3);
    }
}
