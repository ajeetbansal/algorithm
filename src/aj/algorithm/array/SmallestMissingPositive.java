package aj.algorithm.array;

import java.util.Arrays;

/**
 * Created by ajeet on 4/4/2019.
 */
public class SmallestMissingPositive {

    public static void main(String[] args) {
        int a1[] = {2, 3, 7, 6, 8, -1, -10, 15};
        System.out.println("smallestMissingPositive(a1) = " + smallestMissingPositive(a1));
        int a2[] = {2, 3, -7, 6, 8, 1, -10, 15};
        System.out.println("smallestMissingPositive(a2) = " + smallestMissingPositive(a2));
        int a3[] = {1, 1, 0, -1, -2};
        System.out.println("smallestMissingPositive(a3) = " + smallestMissingPositive(a3));
    }

    public static int smallestMissingPositive(int a[]) {
        int b[] = new int[positiveCount(a)];
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] > 0)
                b[j++] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b.length && a[i] > 0) {
                b[a[i] - 1] = -1;
            }
        }
        int i = 0;
        for (; i < b.length; i++) {
            if (b[i] > 0)
                break;
        }
        return i + 1;
    }

    private static int positiveCount(int[] a) {
        return (int) Arrays.stream(a).filter(e -> e > 0).count();
    }
}
