package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContainingOnly_1_2_3 {
    public static void main(String[] args) {
        int A = 7;
        //[1, 2, 3, 11, 12, 13, 21] - output
        System.out.println(printListOf_1_2_3(A));
    }

    private static ArrayList<Integer> printListOf_1_2_3(int A) {
        Queue< Integer > q = new LinkedList<>();
        ArrayList < Integer > ans = new ArrayList < > ();
        q.add(1);
        q.add(2);
        q.add(3);
        int cnt = 3;
        while (ans.size() < A) {
            int x = q.peek();
            ans.add(x);
            q.remove();
            if(cnt >= A)continue;
            // append 1, 2 and 3 to the current number
            q.add(10 * x + 1);
            q.add(10 * x + 2);
            q.add(10 * x + 3);
            cnt += 3;
        }
        return ans;
    }
}
