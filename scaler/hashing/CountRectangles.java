package hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CountRectangles {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 3, 3};
        int[] b = new int[]{1, 2, 1, 2, 1, 2};
        System.out.println("Total Num of Rectangles : " + solve(a,b));
    }
    public static int solve(int[] a, int[] b) {
        int n = a.length;
        HashMap<Integer, HashSet<Integer>> mpx = new HashMap<>();
        HashSet<Integer> h;
        // stores all the points
        for (int i = 0; i < n; i++) {
            if (mpx.containsKey(a[i]))
                h = mpx.get(a[i]);
            else
                h = new HashSet<>();
            h.add(b[i]);
            mpx.put(a[i], h);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // checks if there exists a rectange such that the i-th and
                // j-th points are the ends of a diagonal
                if (a[i] == a[j] || b[i] == b[j])
                    continue;
                if (mpx.get(a[i]).contains(b[j]) && mpx.get(a[j]).contains(b[i])){
                    System.out.println("POINTS : "+
                            "(" + a[i] +","+ b[i]+")" + " " +
                            "(" + a[j] +","+ b[j]+")" + " " +
                            "(" + a[i] +","+ b[j]+")" + " " +
                            "(" + a[j] +","+ b[i]+")" );
                    ans++;
                }
            }
        }
        return ans >> 1;
    }
}