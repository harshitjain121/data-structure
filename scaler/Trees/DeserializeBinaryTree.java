package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBinaryTree {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1
        ));
        PrintTreeNode.printNode(buildTreeFromArrayList(A));
    }

    public static TreeNode buildTreeFromArrayList(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int i=1;

        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            if(A.get(i) != -1){
                parent.left = new TreeNode(A.get(i));
                q.add(parent.left);
            }
            i++;
            if(A.get(i) != -1){
                parent.right = new TreeNode(A.get(i));
                q.add(parent.right);
            }
            i++;
        }
        return root;
    }
}
