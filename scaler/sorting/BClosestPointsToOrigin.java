package sorting;

import utils.ComparatorUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class BClosestPointsToOrigin {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1,3)));
        A.add(new ArrayList<>(Arrays.asList(-2,2)));

        int B = 1;
        // output - [[-2, 2]]
        System.out.println(findBClosestPointsFromOrigin(A, B));
    }

    private static ArrayList<ArrayList<Integer>> findBClosestPointsFromOrigin(ArrayList<ArrayList<Integer>> A, int B) {
//        sorting the points based on the distance
        ComparatorUtils.sortListOf_2_Points_List(A);

        ArrayList<ArrayList<Integer>> res = new  ArrayList<>();
        for(int i=0;i<B;i++){
            res.add(A.get(i));
        }
        return res;
    }
}
