package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class PreorderTraversal {
    
    static ArrayList<Integer> PREORDER_LIST=new ArrayList<>();
    
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(treePreorderTraversal(root));
    }

    private static ArrayList<Integer> treePreorderTraversal(TreeNode A) {
        if(A==null){
            return null;
        }
        //NLR
        PREORDER_LIST.add(A.val);
        treePreorderTraversal(A.left);
        treePreorderTraversal(A.right);

        return PREORDER_LIST;
    }
}
