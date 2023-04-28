package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add( new ArrayList<Integer>(Arrays.asList(3, -8)));
        A.add( new ArrayList<Integer>(Arrays.asList(-15, 2)));
        A.add( new ArrayList<Integer>(Arrays.asList(25, 25)));
        A.add( new ArrayList<Integer>(Arrays.asList(20, -5)));

        System.out.println(solve(A));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int[][] pf = new int[A.size()][A.get(0).size()];
        // pf - prefix sum  matrix - row wise
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (i == 0)
                    pf[i][j] = A.get(i).get(j);
                else
                    pf[i][j] = A.get(i).get(j) + pf[i - 1][j];
            }
        }

        int max = Integer.MIN_VALUE;


        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                //  i  -   j
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int k = 0; k < A.get(0).size(); k++) {
                    if (i == 0)
                        temp.add(pf[j][k]);
                    else
                        temp.add(pf[j][k] - pf[i - 1][k]);
                }
                max = Math.max(max, kadanes(temp));
            }
            System.out.println("================= " + i + " end ==================");
        }
        return max;
    }


    //kadanes also
    public static int kadanes(ArrayList<Integer> list) {
        System.out.println("Arr : " + list);
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            curSum += list.get(i);

            maxSum = Math.max(curSum, maxSum);

            if (curSum < 0) curSum = 0;
        }
        return maxSum;
    }
}
