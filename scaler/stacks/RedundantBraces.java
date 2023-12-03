package stacks;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        String A = "(a+(a+b))";

        System.out.println(checkRedundantBraces(A));
    }

    private static int checkRedundantBraces(String A) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else if(isOperator(ch)){
                stack.push(ch);
            }
            else if(ch == ')'){
                //stack.peek() is operator
                if(!isOperator(stack.peek())){
                    return 1; // redundant
                }
                while(isOperator(stack.peek())){
                    stack.pop();
                }
                stack.pop();
            }
        }
        return 0;
    }

    public static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
