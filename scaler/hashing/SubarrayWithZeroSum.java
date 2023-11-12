package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubarrayWithZeroSum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                4, -1, 1
        ));

        System.out.println(checkForSubarrayWithZeroSum(A));
    }

    private static int checkForSubarrayWithZeroSum(ArrayList<Integer> A) {
        int n = A.size();
        int[] pfSum = new int[n];
        pfSum[0] = A.get(0);

        for (int i = 1; i < n; i++) {
            pfSum[i] = A.get(i) + pfSum[i-1];
        }
        System.out.println(Arrays.toString(pfSum));

        //check using the hashset
        HashSet<Integer> set = new HashSet<>();

        for(Integer i : pfSum){
            if(set.contains(i)){
                return 1;
            }
            set.add(i);
        }
        return 0;
    }
}
