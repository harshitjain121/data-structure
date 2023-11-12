package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                100, 4, 200, 1, 3, 2
        ));
        // output - 4 (1,2,3,4 - consecutive)

        System.out.println(findLongestConsecutiveSequence(A));
    }

    private static int findLongestConsecutiveSequence(ArrayList<Integer> A) {
        //step 1 : insert all the elements to the Hashset
        HashSet<Integer> set = new HashSet<>(A);

        int ans = Integer.MIN_VALUE;
        int chain = 1;

        //step 2 : iterate over the HashSet

        for (int x : set) {
            // if it is parent
            if (!set.contains(x - 1)) {
                chain = 1;
                while (set.contains(x + 1)) {
                    x++;
                    chain++;
                }
            }
            ans = Math.max(ans, chain);
        }
        return ans;
    }
}
