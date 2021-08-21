//Find the second largest number from an array by user input using function

package array_java;

import java.util.Scanner;
public class Prob_2 {
    public static int findSecondLarge(int[] arr) {
        int firstM = 0;
        int secondM = 0;
        firstM = arr[0];
        secondM = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (firstM < arr[i]) {
                secondM = firstM;
                firstM = arr[i];
            } else if(secondM < arr[i]) {
                secondM = arr[i];
            }
        }

        return secondM;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = 0;
        int numbers[] = null;

        System.out.print("Enter the length of array: ");
        length = scan.nextInt();

        numbers = new int[length];

        System.out.println("Enter elements: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }

        System.out.println("Second largest element  of the array is = "
                + findSecondLarge(numbers));

        scan.close();
    }



}

