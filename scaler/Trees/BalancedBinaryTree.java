package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class BalancedBinaryTree {
    public static int isBalancedTree = 1;
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        isBinaryTreeBalanced(root);
        //1 - yes
        System.out.println("Is Binary Tree Balanced : " + isBalancedTree);

    }

    public static int isBinaryTreeBalanced(TreeNode A) {
        //base case
        if(A == null)   return 0;

        int leftHeight = isBinaryTreeBalanced(A.left);
        int rightHeight = isBinaryTreeBalanced(A.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalancedTree = 0;
            return 0;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
