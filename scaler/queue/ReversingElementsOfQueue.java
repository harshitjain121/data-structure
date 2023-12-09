package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ReversingElementsOfQueue {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2, 3, 1, 5, 4
        ));
        System.out.println(reverseQueue(A));
    }

    private static ArrayList<Integer> reverseQueue(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> st = new Stack<>();

        //insert to the stack
        for (Integer i : A) {
            st.push(i);
        }

        //remove from the stack
        for(int i=0; i<n; i++){
            A.set(i, st.pop());
        }
        return A;
    }
}
