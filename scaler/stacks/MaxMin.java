package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MaxMin {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                4, 7, 3, 8
        ));
//        value ( [4] ) = 4 - 4 = 0
//        value ( [7] ) = 7 - 7 = 0
//        value ( [3] ) = 3 - 3 = 0
//        value ( [8] ) = 8 - 8 = 0
//        value ( [4, 7] ) = 7 - 4 = 3
//        value ( [7, 3] ) = 7 - 3 = 4
//        value ( [3, 8] ) = 8 - 3 = 5
//        value ( [4, 7, 3] ) = 7 - 3 = 4
//        value ( [7, 3, 8] ) = 8 - 3 = 5
//        value ( [4, 7, 3, 8] ) = 8 - 3 = 5
//        sum of values % 10^9+7 = 26
        System.out.println(findMaxAndMinOfSubarray(A));
    }

    private static int findMaxAndMinOfSubarray(ArrayList<Integer> A) {
        int MOD = 1000 * 1000 * 1000 + 7;
        //edge case
        // if(A.size() == 1)   return 0;

        ArrayList<Integer> leftSmallerElements = leftSmaller(A);
        ArrayList<Integer> rightSmallerElements  = rightSmaller(A);
        ArrayList<Integer> leftGreaterElements = leftGreater(A);
        ArrayList<Integer> rightGreaterElements  = rightGreater(A);

        long ans = 0;
        long sumOfMax = 0;
        long sumOfMin = 0;

        for(int i=0; i<A.size(); i++){
            long p1 = leftSmallerElements.get(i);
            long p2 = rightSmallerElements.get(i);
            long p3 = leftGreaterElements.get(i);
            long p4 = rightGreaterElements.get(i);

            sumOfMin = (sumOfMin) + ((A.get(i) ) * ((i-p1)) * ((p2 - i))) % MOD;
            sumOfMax = (sumOfMax) + ((A.get(i)) * ((i-p3)) * ((p4 - i))) % MOD;
            // sumOfMin += ((A.get(i) % MOD) * ((i-leftSmallerElements.get(i)) % MOD) * ((rightSmallerElements.get(i) - i) % MOD)) % MOD;
            // sumOfMax += ((A.get(i) % MOD) * ((i-leftGreaterElements.get(i)) % MOD) * ((rightGreaterElements.get(i) - i) % MOD)) % MOD;
        }
        ans = (sumOfMax-sumOfMin) % MOD;

        if (ans < 0) {
            ans = (ans + MOD) % MOD;
        }
        return (int)ans;
    }

    public static ArrayList<Integer> leftSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

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
            while (stack.size() > 0 && A.get(stack.peek()) >= A.get(i) ) {
                stack.pop();
            }
            //by default it is A.size()
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

    public static ArrayList<Integer> leftGreater(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<A.size(); i++){
            while(!stack.empty() && A.get(stack.peek()) <= A.get(i)){
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
    public static ArrayList<Integer> rightGreater(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, n));

        for (int i = A.size() - 1; i >= 0; i--) {
            while (stack.size() > 0 &&  A.get(stack.peek()) <= A.get(i) ) {
                stack.pop();
            }
            //by default it is A.size()
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
