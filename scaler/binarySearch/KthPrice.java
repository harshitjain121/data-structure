package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class KthPrice {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2, 1, 4, 3, 2
        ));
        int B = 3;

        System.out.println(find_Kth_Number(A, B));

    }

    private static int find_Kth_Number(ArrayList<Integer> A, int B) {
        int min = 0;
        int max = 0;
        for (Integer i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int s = min;
        int e = max;
        int ans = 0;

        //binary search -------------------------------------------
        while(s <= e){
            int mid = s + (e-s)/2;
            int smallerThanK = elementsSmallerThanK(A, mid);

            if(smallerThanK >= B){
                //move to left
                ans = mid;
                e = mid -1;
            }
            else{
                s = mid +1;
            }
        }
        return ans;
    }

    private static int elementsSmallerThanK(ArrayList<Integer> A, int mid) {
        int smallerThanK = 0;
        for(int i : A){
            if(i <= mid)
                smallerThanK++;
        }
        return smallerThanK;
    }
}
