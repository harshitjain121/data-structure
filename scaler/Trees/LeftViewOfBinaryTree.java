package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 12, -1, -1, 8, -1, -1, -1, 10, -1, -1, -1, -1, 11, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(LeftViewOfBinaryTreeHelper(root));
    }

    private static ArrayList<Integer> LeftViewOfBinaryTreeHelper(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(A == null)   return list;
        q.add(A);
        q.add(null);
        TreeNode prev_node = null;

        while(q.size() > 1){
            TreeNode temp = q.poll();

            if(temp != null){
                //add the child
                if(temp.left != null)   q.add(temp.left);
                if(temp.right != null)   q.add(temp.right);

                //is next to the null ??? - check this
                if(prev_node == null)
                    list.add(temp.val);
            }
            else{
                q.add(null);
            }
            prev_node = temp;
        }
        return list;
    }
}
