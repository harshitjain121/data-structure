package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 3, 5)));
        A.add(new ArrayList<>(Arrays.asList(2, 6, 9)));
        A.add(new ArrayList<>(Arrays.asList(3, 6, 9)));

        System.out.println(findMatrixMedian(A));
    }

    private static int findMatrixMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int s = 1;
        int e = A.get(n-1).get(m-1);
        final int MEDIAN_ELEMENT_COUNT = n*m/2 +1;

        while(s <= e){
            int mid = s + (e-s)/2;
            int count = 0;

            // count number of elements <= mid for each row . . . . .
            for(int i=0; i<n; i++){
                count += countSmallerNumber(A.get(i), mid, m);
            }
            // count should be greater than N*M/2 + 1
            if(count < MEDIAN_ELEMENT_COUNT)
                s = mid +1;
            else
                e = mid -1;
        }
        return s;
    }

    private static int countSmallerNumber(ArrayList<Integer> A, int mid, int m) {
        int s = 0;
        int e = m-1;

        while(s <= e){
            int midPos = s + (e-s)/2;

            if(A.get(midPos) <= mid){
                s = midPos +1;
            }
            else{
                e = midPos -1;
            }
        }
        return s;
    }
}
