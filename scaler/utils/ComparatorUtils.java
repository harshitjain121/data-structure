package utils;

import java.util.ArrayList;

public class ComparatorUtils {

    public static void Sort_InReverse_ByAdding_2_digitAsString(ArrayList<Integer> list){
        list.sort((x,y) -> {
            if(x == y)  return 0;
            String first = String.valueOf(x);
            String second = String.valueOf(y);
            return (second+first).compareTo((first+second));
        });
    }
}
