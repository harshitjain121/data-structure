package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class PostorderTraversal {
    
    static ArrayList<Integer> POSTORDER_LIST=new ArrayList<>();
    
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(treePostorderTraversal(root));
    }

    private static ArrayList<Integer> treePostorderTraversal(TreeNode A) {
        if(A==null){
            return null;
        }
        //LRN
        treePostorderTraversal(A.left);
        treePostorderTraversal(A.right);
        POSTORDER_LIST.add(A.val);
        
        return POSTORDER_LIST;
    }
}
