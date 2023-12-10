package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OddAndEvenLevels {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 12, -1, -1, 8, -1, -1, -1, 10, -1, -1, -1, -1, 11, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(oddAndEvenLevelsSumDifference(root));
    }

    private static int oddAndEvenLevelsSumDifference(TreeNode A) {
        Queue< TreeNode > q = new LinkedList<>();

        if (A == null)  return 0;

        int oddsum = 0;
        int evensum = 0;
        int level = 0;
        q.add(A);

        while (q.size() > 0) {
            int n = q.size();
            level ^= 1;
            while (n--> 0) {
                TreeNode temp = q.peek();
                q.remove();
                if (temp.left != null)  q.add(temp.left);
                if (temp.right != null) q.add(temp.right);

                if (level != 0)
                    oddsum += temp.val;
                else
                    evensum += temp.val;
            }
        }
        return (oddsum - evensum);
    }
}
