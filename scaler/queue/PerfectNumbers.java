package queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        int A = 8;
        //     Explanation 1: Notes

        // First 8 perfect numbers are:
        // 1. 1 1
        // 2. 2 2
        // 3. 11 11
        // 4. 12 21
        // 5. 21 12
        // 6. 22 22
        // 7. 111 111
        // 8. 112 211
        System.out.println(findAthPerfectNumber(A));
    }

    private static String findAthPerfectNumber(int A) {
        Queue<StringBuilder> q = new LinkedList<>();

        StringBuilder str = new StringBuilder("1");
        q.add(str);

        str = new StringBuilder("2");
        q.add(str);

        for (int i = 1; i < A; i++) {
            StringBuilder temp1 = new StringBuilder(q.peek());
            StringBuilder temp2 = new StringBuilder(q.peek());
            q.poll();
            temp1.append('1');
            q.add(temp1);
            temp2.append('2');
            q.add(temp2);
        }
        str = q.peek();
        int n = str.length();
        StringBuilder revStr = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            revStr.append(ch);
        }
        str.append(revStr);
        return str.toString();
    }
}
