package sorting;

import utils.ComparatorUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                3, 30, 34, 5, 9
        ));

        // approach 1 - merge sort with - custom merge logic - this will be a lengthy code
        // approach 2 - use custom logic to compare and try Comparators
        System.out.println(largestNumber(A));
    }

    private static String largestNumber(ArrayList<Integer> A) {
        StringBuilder sb = new StringBuilder();
        ComparatorUtils.sort_InReverse_ByAdding_2_digitAsString(A);

        for (int i : A){
            if(i == 0 && sb.length() == 0)  continue;
            sb.append(i);
        }
        return sb.toString();
    }
}