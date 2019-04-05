/**
 * Given an array of integers, find and print contiguous subarray with maximum sum in it.
 * <strong>Input: </strong> {-2, 1, -3, 4, -1, 2, 1, -5, 4}</p>
 <p><strong>Output:</strong> The contiguous subarray with the largest sum is {4, -1, 2, 1}<br />
 */
package aj.algorithm.array;

/**
 * Created by ajeet on 3/26/2019.
 */
public class SubArrayMaxSum {
    public static void main(String[] args) {
//        int[] a = {-2, -1, -3, -4, -1, -2, -1, -5, -4}; // does not work
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        kadane(a);
    }
    public static void kadane(int[] A)
    {
        // stores maximum sum sub-array found so far
        int maxSoFar = 0;

        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;

        // stores end-points of maximum sum sub-array found so far
        int start = 0, end = 0;

        // stores starting index of a positive sum sequence
        int beg = 0;

        // traverse the given array
        for (int i = 0; i < A.length; i++)
        {
            // update maximum sum of sub-array "ending" at index i
            maxEndingHere = maxEndingHere + A[i];

            // if maximum sum is negative, set it to 0
            if (maxEndingHere < 0)
            {
                maxEndingHere = 0;	// empty sub-array
                beg = i + 1;
            }

            // update result if current sub-array sum is found to be greater
            if (maxSoFar < maxEndingHere)
            {
                maxSoFar = maxEndingHere;
                start = beg;
                end = i;
            }
        }

        System.out.println("The sum of contiguous sub-array with the " +
                "largest sum is " +	maxSoFar);

        System.out.print("The contiguous sub-array with the largest sum is ");
        for (int i = start; i <= end; i++) {
            System.out.print(A[i] + " ");
        }
    }
//    private static void kadane(int[] a) {
//        int currBeg = 0;
//        int maxBeg = 0, maxEnd = 0;
//        int currSum = a[0], maxSum = a[0];
//        int i = 1;
//        while(i < a.length) {
//            currSum += a[i];
//            if(currSum > maxSum){
//                maxSum = currSum;
//                maxBeg= currBeg;
//                maxEnd = i;
//                i++;
//            } else {
//                currBeg++;
//                i= currBeg;
//                currSum = 0;
//            }
//        }
//        System.out.println("maxSum = " + maxSum);
//        System.out.println("maxBeg = " + maxBeg);
//        System.out.println("maxEnd = " + maxEnd);
//        for(i=maxBeg; i< maxEnd; i++) {
//            System.out.println(a[i]);
//        }
//    }
}
