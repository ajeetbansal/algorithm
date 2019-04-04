package aj.algorithm.sort;

import java.util.Arrays;

/**
 * Created by ajeet on 4/4/2019.
 */
public class HeapSort {

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
    }
    public void heapSort(int[] a) {
        int n = a.length;

        for(int i= n/2 - 1; i>=0; i--) {
            heapify(a, i, n);
        }
        System.out.println("Max Heap");
        Arrays.stream(a).forEach( e -> System.out.print(e+" "));

        for(int i=n-1; i> 0; i--) {
            swap(a, 0, i);
            heapify(a, 0, i);
        }

        System.out.println("\nSorted Array");
        Arrays.stream(a).forEach( e -> System.out.print(e+" "));
    }

    private void heapify(int[] a, int i, int n) {
        int left = 2*i + 1, right = 2*i + 2;
        int max = i;
        if(left < n && a[left] > a[max])
            max = left;
        if(right < n && a[right] > a[max])
            max = right;
        if(max != i) {
            swap(a, i , max);
            heapify(a, max, n);
        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
