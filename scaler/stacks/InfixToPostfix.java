package stacks;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String A = "a+b*(c^d-e)^(f+g*h)-i";

        // if operand -> don't push to stack
        // if operator
        //      if the stack is empty or contains low precedence operator or contains '(' -> push
        //      otherwise if it contains higher precedence -> pop that higher or equal precedence operator and then push
        // if ')' -> pop till '('

        System.out.println(doInfixToPostfix(A));
    }

    private static String doInfixToPostfix(String A) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);

            if(ch >='a' && ch <='z'){
                sb.append(ch);
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(isOperator(ch)){
                if(stack.isEmpty() || stack.peek() == '(' || (checkPriority(stack.peek()) < checkPriority(ch))){
                    stack.push(ch);
                }
                else{
                    while(!stack.isEmpty() && stack.peek()!='(' && checkPriority(stack.peek()) >= checkPriority(ch)){
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();

    }

    public static boolean isOperator(char ch){
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    public static int checkPriority(char op){

        if(op == '^')
            return 3;
        else if(op == '/' || op == '*')
            return 2;
        return 1;
    }
}
