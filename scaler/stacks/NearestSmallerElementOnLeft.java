package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementOnLeft {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                4, 6, 10, 11, 7, 6, 3, 5
                ));
        System.out.println(findNearestSmallerOnLeft(A));
    }

    private static ArrayList<Integer> findNearestSmallerOnLeft(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i : A){
            while(!stack.empty() && stack.peek() >= i){
                stack.pop();
            }
            if(stack.empty()){
                result.add(-1);
            }
            else{
                result.add(stack.peek());
            }
            stack.push(i);
        }
        return result;
    }
}
