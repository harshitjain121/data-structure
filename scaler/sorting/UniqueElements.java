package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueElements {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 1, 3, 1, 2, 3
        ));

        System.out.println(uniqueElements(A));
    }

    private static int uniqueElements(ArrayList<Integer> A) {
        Collections.sort(A);
        int count = 0;
        for(int i=1; i<A.size(); i++){
            if(A.get(i-1) >= A.get(i)){
                int temp = A.get(i);
                A.set(i, A.get(i-1) + 1);
                count += A.get(i) - temp;
            }
        }
        return count;
    }
}
