/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 */
package aj.algorithm.array;

/**
 * Created by ajeet on 3/27/2019.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int a[] = {9,6,4,2,3,5,7,0,1};
        System.out.println("missingNumber(a) = " + missingNumber(a));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int total = (n)*(n+1)/2;
        for(int i=0;i<n;i++){
            total -= nums[i];
        }
        return total;
    }
}
