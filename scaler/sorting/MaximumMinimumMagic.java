package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumMinimumMagic {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                3, 11, -1, 5
        ));
        // Output - [14, 10]
        System.out.println(minAndMaxMagicCombination(A));
    }

    private static ArrayList<Integer> minAndMaxMagicCombination(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        Collections.sort(A);

        // MINIMUM value
        int min = 0;
        int max = 0;
        int N = A.size();

        for (int i = 0; i < N; i+=2) {
            min = (min + Math.abs(A.get(i) - A.get(i+1))) % MOD;
        }

        // MAXIMUM value
        for (int i = 0; i < N/2; i++) {
            max = (max + Math.abs(A.get(i) - A.get(N-i-1))) % MOD;
        }

        result.add(max);
        result.add(min);

        return result;
    }
}
