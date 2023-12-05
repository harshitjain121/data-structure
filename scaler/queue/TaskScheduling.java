package queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class TaskScheduling {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                2, 3, 1, 5, 4
        ));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(
                1, 3, 5, 4, 2
        ));
//        Explanation
//        According to the order array B task 1 has to be performed first, so the CPU will move tasks 2 and 3 to the end of the queue (in 2 clock cycles).
//        Total clock cycles till now = 2
//        Now CPU will perform task 1.
//        Total clock cycles till now = 3
//        Now, queue becomes [5, 4, 2, 3]
//        Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to the back one-by-one.
//                Total clock cycles till now = 6
//        Now all the tasks in the queue are as in the required order so the CPU will perform them one-by-one.
//                Total clock cycles = 10

        System.out.println(scheduleTaskInAOrderOfB(A,B));
    }

    private static int scheduleTaskInAOrderOfB(ArrayList<Integer> A, ArrayList<Integer> B) {
        //Logic of the problem we need to do Task as per Scheduled in B Array with A and find the minimum number of operations done to complete all the Task

        //First we have to take Deque for doing both operations insert in FIFO & LIFO
        Deque<Integer> deque = new ArrayDeque<Integer>();
        //First we need to add A to deque
        for ( int i = 0; i < A.size(); i++ ) {
            deque.add(A.get(i));
        }
        // we need to keep Track the count so we have initazile count
        int count = 0 ;
        int i = 0;
        while(i<B.size()){
            //if B th Element and deque First Element is same count it and remove.
            if(B.get(i) == deque.peekFirst()) {
                count++;
                deque.removeFirst();
                i++;
            }else{
                //if B th Element is not same as deque First Element remove from the front and add it at the end deque and do count it
                deque.add(deque.removeFirst());
                count++;
            }
        }
        return count;
    }
}
