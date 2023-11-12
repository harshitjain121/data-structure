package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1,2,-2,4,-4
        ));

        System.out.println(checkForLargestSubarrayWithZeroSum(A));
    }

    private static ArrayList<Integer> checkForLargestSubarrayWithZeroSum(ArrayList<Integer> A) {
        int n = A.size();
        int[] pfSum = new int[n];
        pfSum[0] = A.get(0);

        for (int i = 1; i < n; i++) {
            pfSum[i] = A.get(i) + pfSum[i-1];
        }
        // A = [1,2,-2,4,-4]
        // pf = [1,3,1,5,1]

        //check using the hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = -1;
        int end = -1;
        int length = 0;
        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            if(map.containsKey(pfSum[i])){
                length = i - map.get(pfSum[i]);
                if(length > maxLen){
                    maxLen = Math.max(maxLen, length);
                    start = pfSum[i];
                    end  = i;
                }
            }
            else {
                map.put(pfSum[i], i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(A.get(i));
        }
        return result;
    }
}
