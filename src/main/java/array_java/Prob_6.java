//Write a program that will show minimum number of currency notes to sum of given amount. For example: You input an amount 1400. The output will be:
//1000 1
//200 2
//Or you input the amount 165. The output will be:
//100 1
//50 1
//10 1
//5 1

package array_java;
import java.util.Scanner;
public class Prob_6 {
    public static void main(String[] args) {
        countNote();
    }

    public static void countNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the amount to be calculated: ");
        int amount = scanner.nextInt();
        int[] notes = {1000, 500, 200, 100, 50, 20, 10, 5, 2};
        int[] noteCounter = new int[notes.length];

        for (int i = 0; i < notes.length; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount - (notes[i] * noteCounter[i]);
            }
        }
        for (int i = 0; i < notes.length; i++) {
            if (noteCounter[i] != 0) {
                System.out.println(notes[i] + " " + noteCounter[i]);
            }
        }
    }
}