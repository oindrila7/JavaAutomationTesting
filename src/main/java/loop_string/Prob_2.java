//Write a program to show range of prime numbers from 2 to n using while loop [n is the number by user input]

package loop_string;

import java.util.Scanner;
public class Prob_2 {

    public static void main(String[] args) {

        int start = 2;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the highest range of prime numbers : ");
        int high=scan.nextInt();

        while (start < high) {
            boolean flag = false;
            for(int i = 2; i <= start/2; ++i) {
                if(start % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag && start != 0 && start != 1)
                System.out.print(start + " ");

            ++start;
        }
    }
}

