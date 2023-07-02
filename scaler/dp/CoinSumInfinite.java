package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinSumInfinite {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        System.out.println(coinChange(list,4));
    }

    public static int coinChange(ArrayList<Integer> A, int B) {

        int[] dp = new int[B + 1];
        int MOD = 1000000 + 7;
        dp[0]  = 1;
        System.out.println(Arrays.toString(dp));

        for (int i = 0; i < A.size(); i++) {
            for (int w = 1; w <= B; w++) {

                if (A.get(i) <= w)
                    //dp[w - C.get(i)] - this index should be positive
                    // Finding the maximum value  -> XXX
                    //Finding total number of ways -> i.e. TAKE + DONT TAKE
                    dp[w] = (dp[w] + dp[w - A.get(i)]) % MOD;
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[B];

    }
}
//for (j = A[i]; j <= B; j++) {