package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ShaggyAndDistances {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                7, 1, 3, 4, 1, 7
        ));

        System.out.println(minimumDistanceBtwEqualPairs(A));
    }

    private static int minimumDistanceBtwEqualPairs(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // value, index
        int diff = Integer.MAX_VALUE;

        for(int i=0; i<A.size(); i++){
            if(map.containsKey(A.get(i))){
                diff = Math.min(diff, i - map.get(A.get(i)));
                // update the map
                map.put(A.get(i), i);
            }
            else{
                //insert into map
                map.put(A.get(i), i);
            }
        }
        return diff;
    }
}
