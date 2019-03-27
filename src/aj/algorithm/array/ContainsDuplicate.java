/**
 * Given an array of integers, find if the array contains any duplicates.
 */
package aj.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ajeet on 3/26/2019.
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int a[] = {1,2,3,1};
        System.out.println("containsDuplicate(a) = " + containsDuplicate(a));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for(int i=0; i< nums.length;i++){
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}