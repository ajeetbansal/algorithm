package aj.algorithm.recursion;

public class Fibonacci {

    int[] fibNumbers = new int[10];

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.fibonacci(10);
        System.out.println("result = " + result);
    }

    public Fibonacci() {
        fibNumbers[0] = 0;
        fibNumbers[1] = 1;
        for(int i=2;i<10; i++)
            fibNumbers[i] = -1;
    }

    private int fibonacci(int n) {
        if(fibNumbers[n-1] != -1)
            return fibNumbers[n-1]; //Memoization
        int fibN = fibonacci(n-1) + fibonacci(n-2);
        fibNumbers[n-1] = fibN;
        return fibN;
    }
}
