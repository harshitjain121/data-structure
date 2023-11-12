package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersInWindow {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 1, 3, 4, 3
        ));
        int k = 3;
        System.out.println(findDistinctElementsInAWindowOfSizeK(A, k));
    }

    private static ArrayList<Integer> findDistinctElementsInAWindowOfSizeK(ArrayList<Integer> A, int B) {
        int n = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();

        if (B > n) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();

        //Insert first subarray
        for (int i = 0; i < B; i++) {
            int temp = A.get(i);
            if(hm.containsKey(temp))
                hm.put(temp, hm.get(temp)+1);
            else
                hm.put(temp, 1);
        }

        // Create the first element in the resultant array
        ans.add(hm.size());

        // Sliding window protocol

        for(int i=B; i<n; i++){
            // Remove the first element from the HM or reduce its frequency
            int tempStartElement = A.get(i-B);
            hm.put(tempStartElement, hm.get(tempStartElement)-1);
            if (hm.get(tempStartElement) == 0) {
                hm.remove(tempStartElement);
            }

            int tempEnd = A.get(i);
            if (hm.containsKey(tempEnd)) {
                hm.put(tempEnd, hm.get(tempEnd)+1);
            }
            else
                hm.put(tempEnd, 1);

            ans.add(hm.size());
        }

        return ans;
    }
}
