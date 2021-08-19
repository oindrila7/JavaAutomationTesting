//Write a program to sum of digits of a number by taking from user input

package loop_string;

import java.util.Scanner;
public class Prob_1 {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number to sum : ");
        int n=scan.nextInt();
        System.out.println(sumOfNumber(n));
    }

    static int sumOfNumber(int number)
    {
        int total = 0;
        while (number != 0)
        {
            total = total + number % 10;
            number = number/10;
        }
        return total;
    }
}

