package binarySearch;

import java.util.ArrayList;

public class SquareRoot {

    public static void main(String[] args) {
        int A = 11;

        System.out.println(findSquareRoot(A));
    }

    private static int findSquareRoot(int A) {
        // edge case for A = 0;
        if(A == 0)  return 0;

        int s = 1;
        int e = A;
        int mid = s + (e-s)/2;
        int ans = 1;

        // for optimal power function - use our power function
        //to save from overflow  -->  mid == A/mid

        while(s <= e){
            if(mid <= A/mid){
                ans = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
}
