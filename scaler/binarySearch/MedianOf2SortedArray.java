package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MedianOf2SortedArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 4, 5
        ));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(
                2,3
        ));
//      output - 3.0
        System.out.println(medianOfTwoSortedArray(A, B));
    }

    private static double medianOfTwoSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int m = B.size();
        int total = n+m;

        //first array size should be small - as calculating the CUTS on smaller array
        if(n>m)
            return medianOfTwoSortedArray(B,A);

        int s = 0;
        int e = n;
//        L1 <= R2 && L2 <= R1
//                        cut1
//        arr1 ->  .....L1 | R1 .......
//                        cut2
//        arr2 ->  .....L2 | R2 .......
//        [.....L1  |  R2 .....]
//        [.....L2  |  R1 .....]

        while(s <= e){
            int cut1 = (s+e)/2;     // mid
            int cut2 = (total +1)/2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A.get(cut1 -1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B.get(cut2 -1);
            int r1 = (cut1 == n) ? Integer.MAX_VALUE : A.get(cut1);
            int r2 = (cut2 == m) ? Integer.MAX_VALUE : B.get(cut2);

            if(l1 <= r2 && l2 <= r1) {
                // median logic
                if((total % 2) == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else
                    return Math.max(l1,l2);
            }
            else if (l1 > r2)
                e = cut1-1;
            else
                s = cut1+1;
        }
        return 0.0;
    }
}
