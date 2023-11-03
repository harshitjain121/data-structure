package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class PeakElement {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 3, 5, 6
        ));

        System.out.println(findThePeakElement(A));
    }

    private static int findThePeakElement(ArrayList<Integer> A) {
        int s = 0;
        int e = A.size()-1;

        // NOTE: s<= e  --> we'll get ArrayOutOfBound
        while(s<e){
            int mid = s + (e-s)/2;

            //target is in the decreasing path
            if(A.get(mid) > A.get(mid+1)){
                e = mid;
            }
            else{
                s = mid+1;
            }
        }
        // we have answer at e
        return A.get(e);
    }
}
