package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 12, -1, -1, 8, -1, -1, -1, 10, -1, -1, -1, -1, 11, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(ZigZagLevelOrderOfBinaryTree(root));
    }

    public static ArrayList<ArrayList<Integer>> ZigZagLevelOrderOfBinaryTree(TreeNode A) {
        Stack<TreeNode> s1_L2R = new Stack<>();
        Stack<TreeNode> s2_R2L = new Stack<>();

        ArrayList<ArrayList<Integer>> zigzag = new ArrayList <> ();
        ArrayList<Integer> level = new ArrayList<>();
        if (A == null)  return null;

        s1_L2R.push(A);
        while (!s1_L2R.isEmpty() || !s2_R2L.isEmpty()) {

            while(!s1_L2R.isEmpty()){
                TreeNode temp = s1_L2R.pop();
                level.add(temp.val);

                if(temp.left != null)   s2_R2L.push(temp.left);
                if(temp.right != null)   s2_R2L.push(temp.right);
            }
            if (level.size() != 0)  zigzag.add(level);
            level = new ArrayList<>();

            while(!s2_R2L.isEmpty()){
                TreeNode temp = s2_R2L.pop();
                level.add(temp.val);

                if(temp.right != null)   s1_L2R.push(temp.right);
                if(temp.left != null)   s1_L2R.push(temp.left);
            }
            if (level.size() != 0)  zigzag.add(level);
            level = new ArrayList<>();
        }
        return zigzag;
    }
}
