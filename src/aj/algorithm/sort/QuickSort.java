package aj.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int a1[] = {5,4,3,2,1};
        quickSort.quickSort(a1);

        int a2[] = {1,2,3,4,5};
        quickSort.quickSort(a2);

        int a3[] = {};
        quickSort.quickSort(a3);
    }

    private void quickSort(int[] a) {
        System.out.println("Input:" );
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("" );
        System.out.println("Output:" );
        quickSort(a, 0, a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("" );
    }

    private void quickSort(int[] a, int low, int high) {
        int mid = low+high /2;
        while(low<high) {
            while (a[low] < a[mid] && low < mid) {
                low++;
            }
            if (low < mid) {
                swap(a, low, mid);
                mid = low;
            }
            while (a[high] > a[mid] && high > mid) {
                high--;
            }
            if (high > mid) {
                swap(a, mid, high);
                mid = high;
            }
        }
        if(low < mid-1 )
            quickSort(a, low, mid -1);
        if(high > mid+1)
            quickSort(a, mid+1, high);
    }

    private void swap(int[] a, int low, int mid) {
        int temp = a[low];
        a[low] = a[mid];
        a[mid] = temp;
    }
}
