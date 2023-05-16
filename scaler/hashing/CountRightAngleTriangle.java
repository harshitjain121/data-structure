package hashing;

import java.util.HashMap;

public class CountRightAngleTriangle {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 3};
        int[] b = new int[]{1, 2, 1, 2, 1};
        System.out.println("Total Num of Right Triangle : " + solve(a,b));
    }

    public static int solve(int[] a, int[] b) {
        int n = a.length;
        // stores the frequency of each x coordinate
        HashMap < Integer, Integer > mpx = new HashMap <> ();
        // stores the frequency of each y coordinate
        HashMap < Integer, Integer > mpy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mpx.get(a[i]) == null) {
                mpx.put(a[i], 1);
            } else
                mpx.put(a[i], mpx.get(a[i]) + 1);

            if (mpy.get(b[i]) == null) {
                mpy.put(b[i], 1);
            } else
                mpy.put(b[i], mpy.get(b[i]) + 1);
        }
        long ans = 0, mod = 1000 * 1000 * 1000 + 7;
        for (int i = 0; i < n; i++) {
            // counts the no of triangles that forms a right angle at the i-th point
            ans = (ans + (mpx.get(a[i]) - 1)% mod * (mpy.get(b[i]) - 1)% mod) % mod;
        }
        return (int) ans;
    }
}