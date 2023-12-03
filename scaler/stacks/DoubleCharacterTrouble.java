package stacks;

import java.util.Stack;

public class DoubleCharacterTrouble {

    public static void main(String[] args) {
        // remove consecutive elements
        //String = abccbc
        //Stack :: a -> ab -> abc -> ab -> a -> ac

        String A = "abccbc";
        System.out.println(removeConsecutiveElements(A));
    }

    private static String removeConsecutiveElements(String A) {
        Stack<Character> st = new Stack<>();
        int len = A.length()-1;
        for(int i=len; i>=0; i--){
            if(!st.empty() && A.charAt(i) == st.peek()){
                st.pop();
            }else{
                st.push(A.charAt(i));
            }
        }
        StringBuilder s = new StringBuilder();
        while(!st.empty()){
            s.append(st.pop());
        }

        return s.toString();
    }
}
