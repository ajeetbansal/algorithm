/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 */
package aj.algorithm.array;

import java.util.Arrays;

/**
 * Created by ajeet on 3/27/2019.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int a[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("removeDuplicates(a) = " + removeDuplicates(a));
        int b[] = {1,1,2};
        System.out.println("removeDuplicates(b) = " + removeDuplicates(b));;

        Arrays.stream(b).forEach(System.out::println);


    }
    public static  int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;

        int sp=1, fp=1;
        while(fp<nums.length) {
            if(nums[fp] != nums[fp-1]) {
                nums[sp] = nums[fp];
                sp++;
            }
            fp++;
        }
        return sp+1;
    }
}
