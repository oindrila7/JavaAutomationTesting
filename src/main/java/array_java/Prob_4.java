//Write a program to find the position of a matched value from an array. If not matched, return -1 using function.
//Given array is: {10,5,2,3,2,7,7,15,10}
//Input: User inputs 7
//Output: Position: 5

package array_java;

import java.util.Scanner;
public class Prob_4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = {10, 5, 2, 3, 2, 7, 7, 15, 10};

        int value = 0;
        int resulted_index = -1;

        System.out.print("Enter the value to find the position : ");
        value = scan.nextInt();

        int i = 0;
        while(i < array.length) {
            if(array[i] == value) {
                resulted_index = i;
                break;
            }
            i++;
        }


        System.out.println("Position : "+resulted_index);
    }
}





