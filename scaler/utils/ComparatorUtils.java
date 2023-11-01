package utils;

import java.util.ArrayList;

public class ComparatorUtils {

    public static void sort_InReverse_ByAdding_2_digitAsString(ArrayList<Integer> list){
        list.sort((x,y) -> {
            if(x == y)  return 0;
            String first = String.valueOf(x);
            String second = String.valueOf(y);
            return (second+first).compareTo((first+second));
        });
    }

    public static void sortListOf_2_Points_List(ArrayList<ArrayList<Integer>> A){
        A.sort((a, b) -> {
            int OriginToCord1 = a.get(0) * a.get(0) + a.get(1) * a.get(1);
            int OriginToCord2 = b.get(0) * b.get(0) + b.get(1) * b.get(1);

            if(OriginToCord1 == OriginToCord2)  return 0;
            return OriginToCord1 > OriginToCord2 ? 1 : -1;
        });
    }
}
