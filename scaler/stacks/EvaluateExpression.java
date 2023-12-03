package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression {
//    Evaluate the value of an arithmetic expression in Reverse Polish Notation

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList(
                "2", "1", "+", "3", "*"
        ));
        System.out.println(evaluateReversePolishNotation(A));
    }

    private static int evaluateReversePolishNotation(ArrayList<String> A) {
        Stack<Integer> st = new Stack<Integer>();
        int v1;
        int v2;

        for(String s : A){
            if(s.equals("+")){
                v2 = st.pop();
                v1 = st.pop();
                st.push(v1 + v2);
            }
            else if(s.equals("*")){
                v2 = st.pop();
                v1 = st.pop();
                st.push(v1 * v2);
            }
            else if(s.equals("/")){
                v2 = st.pop();
                v1 = st.pop();
                st.push(v1 / v2);
            }
            else if(s.equals("-")){
                v2 = st.pop();
                v1 = st.pop();
                st.push(v1 - v2);
            }
            else{
                v1 = Integer.parseInt(s);
                st.push(v1);
            }
        }
        return st.peek();
    }
}
