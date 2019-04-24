/**
 * Search an element in a sorted and rotated array
 * An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 */
package aj.algorithm.array;

public class SearchRotated {

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 1, 2};
        System.out.println("pivotedBinarySearch(arr, 1) = " + pivotedBinarySearch(arr, 1));
    }
    static int pivotedBinarySearch(int arr[], int key) {
        int low =0, high = arr.length -1;
        int pivot = findPivot(arr, low, high);
        System.out.println("pivot = " + pivot);
        if(key > arr[low])
            return binarySearch(arr, low, pivot -1, key);
        else
            return binarySearch(arr, pivot, high, key);
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        while(low<=high){
            int mid = (low + high) /2;
            if(arr[mid] == key)
                return mid;
            if(arr[mid] < key)
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }

    private static int findPivot(int[] arr, int low, int high) {
        int mid = (low + high) /2;
        if(mid < high && arr[mid] > arr[mid+1])
            return mid+1;
        if(mid > low && arr[mid] < arr[mid-1])
            return mid;
        if(arr[mid] > arr[low])
            return findPivot(arr, low, mid-1);
        else
            return findPivot(arr,mid +1, high);
    }
}
