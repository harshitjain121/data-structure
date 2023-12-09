package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderTraversal {
    static ArrayList<Integer> INORDER_LIST=new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(treeInorderTraversal(root));
    }

    private static ArrayList<Integer> treeInorderTraversal(TreeNode A) {
        if(A==null){
            return null;
        }
        //LNR
        treeInorderTraversal(A.left);
        INORDER_LIST.add(A.val);
        treeInorderTraversal(A.right);
        return INORDER_LIST;
    }
}
