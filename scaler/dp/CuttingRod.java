package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class CuttingRod {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(1,5,6,9,11,12,14,16)
        );
        System.out.println(solve(list));
    }

    public static int solve(ArrayList<Integer> A) {
        int[] dp = new int[A.size() + 1];
        for (int i = 1; i <= A.size(); i++) {
            for (int len=1; len<=i; len++) {
                dp[i] = Math.max(dp[i], dp[i-len] + A.get(len-1));
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[A.size()];
    }
}
