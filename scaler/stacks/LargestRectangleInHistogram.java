package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2, 1, 5, 6, 2, 3
        ));
        System.out.println(largestHistogramArea(A));
    }

    private static int largestHistogramArea(ArrayList<Integer> A) {
        ArrayList<Integer> leftSmallerHeight;
        ArrayList<Integer> rightSmallerHeight;

        int maxArea = 0;
        leftSmallerHeight = leftSmaller(A);
        rightSmallerHeight  = rightSmaller(A);

        for(int i=0; i<A.size(); i++){
            maxArea = Math.max(maxArea, A.get(i) * ( rightSmallerHeight.get(i) - leftSmallerHeight.get(i) -1) );
        }
        return maxArea;
    }

    // previous question code - but here we are taking indexes instead of values
    public static ArrayList<Integer> leftSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<A.size(); i++){
            while(!stack.empty() && A.get(stack.peek()) >= A.get(i)){
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

    // if no nearest smaller element on right then it will go till the right end --> n
    //and store the index of right element on right side --- not to add to arraylist -- as it is adding on the left side
    public static ArrayList<Integer> rightSmaller(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, n));

        for (int i = A.size() - 1; i >= 0; i--) {
            while (stack.size() > 0 && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
                //by default, it is A.size()
                // if(stack.empty()){
                //     ans.set(i, A.size());
                // }
            if (stack.size() > 0) {
                ans.set(i, stack.peek());
            }

            stack.push(i);
        }
        return ans;
    }
}
