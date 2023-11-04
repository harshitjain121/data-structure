package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,   3,  5,  7)));
        A.add(new ArrayList<>(Arrays.asList(10, 11, 16, 20)));
        A.add(new ArrayList<>(Arrays.asList(23, 30, 34, 50)));
        int B = 3;

        System.out.println(sortedMatrixSearch(A, B));
    }

    private static int sortedMatrixSearch(ArrayList<ArrayList<Integer>> A, int B) {
//        matrix - n X m
        int n = A.size();
        int m = A.get(0).size();
        int s = 0;
        int e = n*m -1;
        int mid = s + (e-s)/2;

        while(s<=e){
            int i = mid/m;  //divide by column
            int j = mid%m;  //mod by column
            int midElement = A.get(i).get(j);

            if(midElement == B)    return 1;
            if(midElement > B)
                e = mid-1;
            else
                s = mid+1;
            mid = s + (e-s)/2;
        }
        return 0;
    }
}
