//Write a program to generate random numbers from minimum range to maximum range by user input

package basic_java;

import java.util.Scanner;
public class Prob_4 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner (System. in);
        System.out.println("Input minimum number: ");
        int minimum = in.nextInt();

        System.out.println("Input maximum number: ");
        int maximum = in.nextInt();

        System.out.println("Random value of type int between"+minimum+" to "+maximum+":");
        int a = (int)(Math.random()*(maximum-minimum+1)+minimum);
        System.out.println(a);
    }
}
