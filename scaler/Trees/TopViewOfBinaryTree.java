package Trees;

import java.util.*;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(TopViewOfTheBinaryTree(root));
    }

    private static ArrayList<Integer> TopViewOfTheBinaryTree(TreeNode A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<Pair>();

        int maxLevel = 0;
        int minLevel = 0;

        q.add(new Pair(A, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.treeNode;
            int level = p.level;

            //insert into HashMap
            if(!map.containsKey(level)){
                map.put(level, node.val);
            }

            //update minLevel and maxLevel
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            //insertion to the Queue
            if(node.left != null)  q.add(new Pair(node.left, level-1));
            if(node.right != null)  q.add(new Pair(node.right, level+1));
        }

        //Iterate map starting from minLevel -->maxLevel and add to response list
        ArrayList<Integer> responseList = new ArrayList<Integer>();
        for (int i= minLevel ;i<=maxLevel;i++){
            //2nd approach ----
            responseList.add(map.get(i));
        }

        return responseList;
    }
}


//class Pair{
//    public TreeNode treeNode;
//    public Integer level;
//
//    //constructor
//    public Pair(TreeNode treeNode, Integer level){
//        this.treeNode = treeNode;
//        this.level = level;
//    }
//}
