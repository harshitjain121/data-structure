package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                4,5,6,7,0,1,2,3
        ));
        int B = 6;
        System.out.println(rotatedSortedArray(A, B));
    }

    //without finding the pivot element
    private static int rotatedSortedArray(ArrayList<Integer> A, int B) {
        int s = 0;
        int e = A.size()-1;
        int mid = s + (e-s)/2;

        while(s<e){
            if(A.get(mid) == B) return mid;

            // upper line
            if(A.get(mid) >= A.get(0)){
                if(A.get(mid) > B && B >= A.get(s)) e = mid;
                else s = mid +1;
            }
            else{
                if(A.get(mid) < B && B <= A.get(e)) s = mid+1;
                else e = mid;
            }
            mid = s + (e-s)/2;
        }
        return -1;
    }
}
