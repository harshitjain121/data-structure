package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SumTheDifference {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                5, 3, 10
        ));
        // output - 21
        System.out.println(findTheDiffBtwMIN_MAXOfEverySubsequence(A));
    }

    private static int findTheDiffBtwMIN_MAXOfEverySubsequence(ArrayList<Integer> A) {
        long MOD = 1000000007;
        long minVal = 0L;
        long maxVal = 0L;
        int N = A.size();
        long minPower = 1L; // 2^0
        long maxPower = (long) Math.pow(2,N-1); // 2^(n-1)

        Collections.sort(A);

        // USING THE CONTRIBUTION TECHNIQUE ------------------
        for(int i=0; i<N; i++){
            maxVal = (maxVal + A.get(i) * (minPower<<i) ) % MOD; // 2^0 -> 2^1 -> 2^2
            minVal = (minVal + A.get(i) * (maxPower>>i) ) % MOD; // 2^n-1 -> 2^n-2 -> 2^n-3
//            System.out.println("minVal : " + minVal + " , minPow : " + (maxPower>>i) + " || maxVal : " + maxVal + " , maxPow : " + (minPower<<i));
        }

        return (int)((maxVal - minVal + MOD) % MOD);
    }

//    minVal : 12 , minPow : 4 || maxVal : 3 , maxPow : 1
//    minVal : 22 , minPow : 2 || maxVal : 13 , maxPow : 2
//    minVal : 32 , minPow : 1 || maxVal : 53 , maxPow : 4
//            21
}
