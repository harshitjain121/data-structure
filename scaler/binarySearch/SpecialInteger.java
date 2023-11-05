package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialInteger {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2,24,38,25,35,33,43,12,49,35,45,47,5,33
//                1,1000000000
        ));
        int B = 249; //1000000000
        //OPTIMAL SOLUTION - 2 POINTER - T.C - O(n) - DRY RUN ON NOTES
        //Binary Search  - T.C- O(n lon n)
        System.out.println(findTheMaxLengthSubArrayWithSumLessThanEqualTo_B(A,B));
    }

    // TWO Pointer approach
    private static int findTheMaxLengthSubArrayWithSumLessThanEqualTo_B(ArrayList<Integer> A, int B) {
        //base case
        if(B == 0)  return 0;

        int i=0;
        int j=0;
        long sum = 0;
        int window = 0;

        while(j < A.size()){
            sum += A.get(j++);
            if(sum > B){
                while(sum > B){
                    sum -= A.get(i++);
                    window = j-i;
                }
                break;
            }
        }

        while(j<A.size()){
            sum = sum + A.get(j++) - A.get(i++);
            if(sum > B){
                while(sum > B){
                    sum -= A.get(i++);
                    window = j-i;
                }
            }
        }
        return window;
    }
}
