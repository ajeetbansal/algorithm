package aj.algorithm.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//sorted list, 1,1,2,2,3 -> 3
public class FindNonRepeating {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int a[] = {1,1,2,2,3,3,4};
        FindNonRepeating solution = new FindNonRepeating();
        Integer answer = solution.findNonRepeatedNumber1(a,0, a.length-1);
        if(answer != null)
            System.out.println(answer);
        else
            System.out.println("Could not find a non repeating number");
    }

    Integer findNonRepeatedNumber(int[] a) {
        if(a == null)
            throw new IllegalArgumentException("Input can not be null");
        int n = a.length;
        if(n % 2 == 0)
            return null;
        for(int i=0; i<n; i=i+2) {
            if(i< n-1 && a[i] != a[i+1])
                return a[i];
        }
        return a[n-1];

    }

    Integer findNonRepeatedNumber1(int[] a, int start, int end) {
        System.out.println("start =" + start + " end=" + end);
        if(start >= end)
            return a[start];

        int mid = (start + end)/2;
        System.out.println("mid = " + mid);
        int mid1, mid2;
        if (mid % 2 == 0 ){
            mid1 = mid;
            mid2 = mid+1;
        }
        else{
            mid1= mid-1; mid2 = mid;
        }
        System.out.println("mid1 =" + mid1 + " mid2=" + mid2);

        if(a[mid1] == a[mid2]) {
            return findNonRepeatedNumber1(a,mid2+1, end);
        }
        else {
            return findNonRepeatedNumber1(a, start, mid1-1);
        }

    }


}