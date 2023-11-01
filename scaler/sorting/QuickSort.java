package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 4, 10, 2, 1, 5
        ));
        quickSort(A, 0, A.size()-1);
        System.out.println(A);
    }

    private static void quickSort(ArrayList<Integer> A, int s, int e) {
        if(s >= e)  return;
        int idx = rearrange(A, s, e);

        quickSort(A, s, idx-1);
        quickSort(A, idx+1, e);
    }

    private static int rearrange(ArrayList<Integer> A, int s, int e) {
        //selecting the random index from the array
        int randomPivot = (int)(Math.random()*(e-s+1)+s);

        //swap the starting element and the randomPivot element
        swap(A, s, randomPivot);

        int i = s+1;
        int j = e;

        // sending A[s] to its right position
        while(i <= j){
            if(A.get(i) <= A.get(s)) // i -> is happy
                i++;
            else if(A.get(j) > A.get(s)) // j -> is happy
                j--;
            else{
                // both are unhappy
                swap(A, i, j);
                i++;
                j--;
            }
        }
        // swap A[s] and A[i--]
        swap(A, s, --i);
        return i;
    }

    private static void swap(ArrayList<Integer> A, int a, int b) {
        int temp = A.get(a);
        A.set(a, A.get(b));
        A.set(b, temp);
    }

}
