package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidBinarySearchTree {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(isBinarySearchTreeValid(root));
    }

    private static int isBinarySearchTreeValid(TreeNode A) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        if(checkBST(A, min, max))
            return 1;
        return 0;
    }

    private static boolean checkBST(TreeNode A, int min, int max) {
        //base case
        if(A == null)   return true;

        //processing - check the range of the node
        if(A.val < min || A.val > max)  return false;

        return checkBST(A.left, min, A.val -1) && checkBST(A.right, A.val+1, max);
    }
}
