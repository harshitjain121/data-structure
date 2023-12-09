package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                3, 9, 20, -1, -1, 15, 7, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(levelOrderTraversal(root));
    }

    private static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode A) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);
        q.add(null);
        // QUEUE - 3 null 9 20 null 15 7 null

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();

        while(q.size() > 1){
            TreeNode temp = q.poll();

            if(temp != null){
                level.add(temp.val);
                if(temp.left != null)   q.add(temp.left);
                if(temp.right != null)   q.add(temp.right);
            }
            else{
                //that means we have completed one level
                q.add(null);
                mainList.add(level);
                level = new ArrayList();
            }
        }
        mainList.add(level);
        return mainList;
    }
}
