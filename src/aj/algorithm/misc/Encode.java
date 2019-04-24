/**
 * Complete the function that takes an integer as its argument and returns the encoded string in base 7 using the following encoding rule:
 * base 10 0 1 2 3 4 5 6
 * base 7 0 a t l s i N
 *
 * Sample Input 1
 * 7
 *
 * Sample Output 1
 * a0
 */
package aj.algorithm.misc;

public class Encode {
    private final char[] digits;
    private final int base;

    public Encode(char[] digits, int base) {
        this.digits = digits;
        this.base = base;
    }

    public static void main(String[] args) {
        char[] digits = {'0', 'a', 't', 'l', 's', 'i', 'N'};
        Encode encode = new Encode(digits, 7);
        System.out.println("encode.encode(1) = " + encode.encode(1));
        System.out.println("encode.encode(7) = " + encode.encode(7));
    }

    public String encode( int number) {
        StringBuilder encoded = new StringBuilder();
        while(number != 0) {
            int remainder = number % base;
            encoded.append(digits[remainder]);
            number /=  base;
        }
        return encoded.reverse().toString();
    }
}
