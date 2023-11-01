package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {
    // find the maximum length UnSorted subarray in a sorted array

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 3, 2, 4, 5
        ));

        System.out.println(subArrayUnsorted(A));
    }

    private static ArrayList<Integer> subArrayUnsorted(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int i = 0;
        int j = n-1;

        while (i < n - 1 && A.get(i) <= A.get(i+1)) {
            i++;
        }

        while(j>0 && A.get(j-1) <= A.get(j)){
            j--;
        }
        // EDGE CASE | if the array is already sorted, output is -1
        if(i == n-1){
            ans.add(-1);
            return ans;
        }

        // find the maximum and minimum element of the subarray -> A.get(i) ... A.get(j)
        int mn = A.get(i);
        int mx = A.get(i);

        for (int k = i; k <= j ; k++) {
            mx = Math.max(mx, A.get(k));
            mn = Math.min(mn, A.get(k));
        }

        int l = 0, r = n-1;

        while(A.get(l) <= mn && l <= i)
            l++;

        while(A.get(r) >= mx && r >= j)
            r--;

        ans.add(l);
        ans.add(r);

        return ans;
    }
}








