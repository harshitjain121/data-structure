package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        ArrayList<Integer>  A = new ArrayList<>(Arrays.asList(
                1, 3, 2, 3, 1
        ));
        //Output - 2
        // REFER MERGE SORT CODE ***********************
        System.out.println(countInvertedPairs( A, 0,  A.size()-1));
    }

    private static int countInvertedPairs(ArrayList<Integer>  A, int l, int r) {
        // base case
        if(r == l)  return 0;
        int mid = l + (r-l)/2;

        int a = countInvertedPairs( A, l, mid) ;
        int b = countInvertedPairs( A, mid+1, r) ;
        int a_with_b = merge( A, l, mid, r) ;

        return (a + b + a_with_b) ;
    }

    private static int merge(ArrayList<Integer>  A, int l, int mid, int r) {
        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        int i = l;
        int j = mid+1;

        while(i <= mid && j<= r){
            if( A.get(i) <=  A.get(j)){
                result.add( A.get(i));
                i++;
            }
            else{
                // invert pair exists ~~~~~~~~~~~~~~~~~~~~~ TODO
                if( A.get(i) > 2*  A.get(j)){
                    count += mid-i+1;
                }
                result.add( A.get(j));
                j++;
            }
        }

        while(i <= mid){
            result.add( A.get(i));
            i++;
        }
        while(j <= r){
            result.add( A.get(j));
            j++;
        }

        //copy the sorted array back the original arraylist
        for(int k=l; k<=r; k++){
             A.set(k, result.get(k-l));
        }

        return count ;
    }
}
