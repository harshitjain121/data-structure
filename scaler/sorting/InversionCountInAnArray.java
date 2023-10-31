package sorting;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionCountInAnArray {
    private static final int MOD = 1000000000 + 7;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(
                3, 4, 1, 2
        ));
        // REFER MERGE SORT CODE ***********************
        System.out.println(countInvertedPairs(list, 0, list.size()-1));
    }

    private static int countInvertedPairs(ArrayList<Integer> list, int l, int r) {
        // base case
        if(r == l)  return 0;
        int mid = l + (r-l)/2;

        int a = countInvertedPairs(list, l, mid) % MOD;
        int b = countInvertedPairs(list, mid+1, r) % MOD;
        int a_with_b = merge(list, l, mid, r) % MOD;

        return (a + b + a_with_b) % MOD;
    }

    private static int merge(ArrayList<Integer> list, int l, int mid, int r) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = 0;
        int i = l;
        int j = mid+1;

        while(i <= mid && j<= r){
            if(list.get(i) <= list.get(j)){
                result.add(list.get(i));
                i++;
            }
            else{
                //inverted pair exists ----------------
//              (----i--------mid) (-----j---------)
                count = (count + mid - i +1) % MOD;
                result.add(list.get(i));
                j++;
            }
        }

        while(i <= mid){
            result.add(list.get(i));
            i++;
        }
        while(j <= r){
            result.add(list.get(j));
            j++;
        }

        //copy the sorted array back the original arraylist
        for(int k=l; k<=r; k++){
            list.set(k, result.get(k-l));
        }

        return count % MOD;
    }
}
