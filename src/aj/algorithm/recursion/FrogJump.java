package aj.algorithm.recursion;

/**
 * There is a stair with n levels. A frog can jump up one level or two levels at one time on the stair. How many ways are there for the frog to jump from the bottom of the stairs to the top?
 *
 * For example, there are three choices for the frog to jump up a stair with three levels: (1) it jumps in three steps, one level for each jump; (2) it jumps in two steps, one level for the first jump and two levels for the second jump; or (3) it jumps with two steps, two levels for the first step and one level for the last jump
 * the solution is actually generation of fibonacci sequence
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int numWays = frogJump.frogJump(5);
        System.out.println("numWays = " + numWays);
    }

    private int frogJump(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        return frogJump(n-1) + frogJump(n-2);
    }
}
