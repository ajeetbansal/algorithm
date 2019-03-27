/**
 * Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. Print the decimal value of each fraction on a new line.

 Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.

 For example, given the array  there are  elements, two positive, two negative and one zero. Their ratios should be printed as
 0.400000
 0.400000
 0.200000
 */
package aj.algorithm.array;

/**
 * Created by ajeet on 3/26/2019.
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Fraction {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int total = arr.length;
        float pos=0, neg=0, zero = 0;
        for(int i=0; i< total; i++) {
            if(arr[i] < 0)
                neg ++;
            else if(arr[i] > 0)
                pos ++;
            else
                zero++;
        }
        System.out.printf("%.6f\n", pos/total);
        System.out.printf("%.6f\n", neg/total);
        System.out.printf("%.6f", zero/total);


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
