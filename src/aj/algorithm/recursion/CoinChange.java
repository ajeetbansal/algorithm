/* Coin change-making problem (unlimited supply of coins) */
package aj.algorithm.recursion;

import java.util.Arrays;
import java.util.TreeSet;

public class CoinChange {

    private TreeSet<Integer> denominations;
    int[] changeCount;

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange(1,3,9,10);
        System.out.println("coinChange.calculateChange(15) = " + coinChange.calculateChange(15));
    }

    public CoinChange(int... denominations) {
        this.denominations = new TreeSet<Integer>();
        for(int i=0; i< denominations.length; i++)
            this.denominations.add(denominations[i]);
    }

    public int calculateChange(int total) {
        changeCount = new int[total];
        int minNumCoins = calculateChangeInternal(total);
        System.out.println("Arrays.toString(changeCount) = " + Arrays.toString(changeCount));
        return minNumCoins;
    }
    private int calculateChangeInternal(int total) {
        if(total == 0)
            return 0;
        if(changeCount[total-1] != 0)
        {
            System.out.println("Memoization kicked in");
            return changeCount[total-1];
        }
        int minNumCoins= denominations.stream()
                .filter(denomination -> denomination <= total)
                .map(denomination -> calculateChangeInternal(total - denomination))
                .reduce((d1,d2)->Math.min(d1,d2)).get() + 1;
        changeCount[total-1] = minNumCoins;
        return minNumCoins;
    }
}
