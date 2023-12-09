package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(serializeBinaryTreeToList(root));
    }

    private static ArrayList<Integer> serializeBinaryTreeToList(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);

        while(!q.isEmpty()){
            TreeNode temp = q.poll();

            if(temp != null){
                list.add(temp.val);
                q.add(temp.left);
                q.add(temp.right);
            }
            else{
                list.add(-1);
            }
        }
        return list;
    }
}
