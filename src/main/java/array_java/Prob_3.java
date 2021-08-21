//Write a program to show the duplicates values . Given array is: {10,5,2,3,2,7,7,15,10}
//Output: 2, 7, 10


package array_java;

public class Prob_3 {
    public static void main(String[] args) {
        int [] array = new int [] {10, 5, 2, 3, 2, 7, 7, 15, 10};
        for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] == array[j])
                    System.out.println(array[j]);
            }
        }
    }
}

