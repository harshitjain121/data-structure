package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextRightGreater {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                4, 5, 2, 10
        ));
        System.out.println(nextGreater(A));
    }

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1)); // set -1 according to the question

        for (int i = A.size() - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= A.get(i)) {
                stack.pop();
            }
            //by default it is A.size()
            // if(stack.empty()){
            //     ans.set(i, A.size());
            // }
            if (stack.size() > 0) {
                ans.set(i, stack.peek());
            }

            stack.push(A.get(i));
        }
        return ans;
    }
}
