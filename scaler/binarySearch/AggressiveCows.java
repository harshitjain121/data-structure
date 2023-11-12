package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AggressiveCows {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                82,61,38,88,12,7,6,12,48,8,31,90,35,5,88,2,66,19,5,96,84,95
        ));
        int B = 8;
        System.out.println(solveAggressiveCows(A, B));
    }

    private static int solveAggressiveCows(ArrayList<Integer> A, int B){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer i : A){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
//         Collections.sort(A); ------
        int n = A.size();
        int s = 1;
//         int e = A.get(n-1) - A.get(0); -----
        int e = max - min;
        int ans = 0;

        while(s <= e){
            int mid = s + (e-s)/2;

            if(isCowHappy(A, mid, B)){
                ans = mid;
                s = mid + 1;
            }
            else{
                // not happy
                e = mid -1;
            }
        }
        return ans;
    }

    private static boolean isCowHappy(ArrayList<Integer> A, int mid, int B){
        int lastPlaced = A.get(0);
        int cow = 1;

        for(int i=1; i<A.size(); i++){
            if((A.get(i) - lastPlaced) >= mid){
                lastPlaced = A.get(i);
                cow++;
                if(cow == B){
                    return true;
                }
            }
        }
        return false;
    }
}
