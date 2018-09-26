package aj.algorithm.recursion;

public class SumArray {

    public static void main(String[] args) {
        SumArray sumArray = new SumArray();
        int[] a = {1,2,3,4,5};
        int sum = sumArray.sumArray(a, a.length -1 );
        System.out.println("sum = " + sum);

    }

    private int sumArray(int[] a, int n) {
        if(n==0)
            return a[0];
        return a[n] + sumArray(a, n-1);
    }
}
