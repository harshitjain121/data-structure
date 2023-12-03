package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//star
public class AllSubarrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2, 3, 1, 4
        ));
//        Subarray            XOR of maximum and 2nd maximum no.
//        1. [2, 3]           1
//        2. [2, 3, 1]        1
//        3. [2, 3, 1, 4]     7
//        4. [3, 1]           2
//        5. [3, 1, 4]        7
//        6. [1, 4]           5
//        So maximum value of Xor among all subarrays is 7
        System.out.println(allSubarrayMaxAndSecondMax(A));  //TODO - Approach 1
        //Approach 2 : monotonic Decreasing Stack
    }

    // stack - |6 5 3 2 <- entry|  - 4(current element)
    private static int allSubarrayMaxAndSecondMax(ArrayList<Integer> A) {
        Stack<Integer> monotonicDecsSt = new Stack<>();
        int ans = 0;

        for(int i=0; i<A.size(); i++){
            while(!monotonicDecsSt.isEmpty()){
                int xor = A.get(monotonicDecsSt.peek()) ^ A.get(i);
                ans = Math.max(ans, xor);

                if(A.get(monotonicDecsSt.peek()) > A.get(i))
                    break;
                monotonicDecsSt.pop();
            }
            monotonicDecsSt.push(i);
        }
        return ans;
    }
}
