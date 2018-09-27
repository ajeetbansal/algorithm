package aj.algorithm.recursion;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinChange {

    private TreeSet<Integer> denominations;

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange(1,3,9,10);
        System.out.println("coinChange.calculateChange(15) = " + coinChange.calculateChange(15));
    }

    public CoinChange(int... denominations) {
        this.denominations = new TreeSet<Integer>();
        for(int i=0; i< denominations.length; i++)
            this.denominations.add(denominations[i]);
    }

    public Integer calculateChange(int total) {
        if(total == 0)
            return 0;
        return denominations.stream()
                .filter(denomination -> denomination <= total)
                .map(denomination -> calculateChange(total - denomination))
                .reduce((d1,d2)->Math.min(d1,d2)).get() + 1;
    }
}
