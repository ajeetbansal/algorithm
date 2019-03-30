/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,-7, 5,3,6,7], and k = 3
 Output: [3,3,-1,5,5,6,7]

 Refer: https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 */
package aj.algorithm.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ajeet on 3/29/2019.
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,-7, 5,3,6,7};
        int[] ret = maxSlidingWindow(nums, 3);
        Arrays.stream(ret).forEach(System.out::println);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<Integer>();
        int[] ret = new int[nums.length-k+1];
        for(int i=0; i< nums.length; i++) {
            while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]){
                dq.removeLast();
            }
            while(!dq.isEmpty() && dq.getFirst() <= i-k)
                dq.removeFirst();
            dq.addLast(i);
            if(i >= k-1) {
                ret[i-k+1] = nums[dq.getFirst()];
            }
        }

        return ret;
    }
}
