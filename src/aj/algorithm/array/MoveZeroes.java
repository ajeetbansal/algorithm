package aj.algorithm.array;

import java.util.Arrays;

/**
 * Created by ajeet on 3/27/2019.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr1 = {0,1,0,2,3};
        moveZeroes(arr1);
        Arrays.stream(arr1).forEach(System.out::println);
        System.out.println("");
        int[] arr2 = {0,0,0,0,1};
        moveZeroes(arr2);
        Arrays.stream(arr2).forEach(System.out::println);
        System.out.println("");
    }

    public static void moveZeroes(int[] nums) {
        int temp;
        int zp = 0, np=0;
        while(np < nums.length) {
            if(nums[np] != 0){
                temp = nums[zp];
                nums[zp] = nums[np];
                nums[np] = temp;
                zp++;
            }
            np++;
        }
    }
}
