package stacks;

import java.util.Stack;

public class Check2BracketExpression {

    private static final int MAX_CHAR = 26;
    public static void main(String[] args) {
        String A = "-(a+b+c)";
        String B = "-a-b-c";

        // +,- -> continue
        // (   -> check the prev sign and push to the stack
        // )   -> pop
        System.out.println(checkTroBracketExpressionValue(A, B));
    }

    private static int checkTroBracketExpressionValue(String A, String B) {
        // comparison can be done in 2 ways
        // 1.comparing both String - StringBuilder
        // 2.creating int array - doing +1,-1  - this will be optimal in this case
        if (areSame(A, B))
            return 1;
        return 0;
    }

    //using approach 2 : array - final array should be zero completely
    static Boolean areSame(String expr1, String expr2) {
        int[] v = new int[MAX_CHAR];
        eval(expr1, v, true);
        eval(expr2, v, false);
        for (int i = 0; i < MAX_CHAR; i++)
            if (v[i] != 0)
                return false;

        return true;
    }

    //flag for the array to add or sub 1 -> to get the final array as ZERO
    public static void eval(String A, int[] v, Boolean flag){
        Stack<Boolean> stack = new Stack<>();

        stack.push(true); // global sign stack
        int i = 0;

        while(i<A.length()){
            char ch = A.charAt(i);

            //case : +,-
            if(ch == '+' || ch == '-'){
                i++;
                continue;
            }
            //case : (
            if(ch == '('){
                //check the previous sign
                if(checkSign(A, i)){
                    stack.push(stack.peek());
                }
                else stack.push(!stack.peek());
            }
            else if(ch == ')'){
                stack.pop();
            }
            else {
                if (stack.peek())
                    v[ch - 'a'] += (checkSign(A, i) ? flag ? 1 : -1 : flag ? -1 : 1);
                else
                    v[ch - 'a'] += (checkSign(A, i) ? flag ? -1 : 1 : flag ? 1 : -1);
            }
            i++;
        }
    }

    public static Boolean checkSign(String A, int i){
        if(i == 0)  return true;
        // true -> +
        // false -> -
        return A.charAt(i - 1) != '-';
    }
}
