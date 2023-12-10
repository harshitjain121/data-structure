package Trees;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1
        ));
        TreeNode root = DeserializeBinaryTree.buildTreeFromArrayList(A);
        PrintTreeNode.printNode(root);
        System.out.println(verticalViewOfBinaryTree(root));
    }

    private static ArrayList<ArrayList<Integer>> verticalViewOfBinaryTree(TreeNode A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<Pair> q = new LinkedList<Pair>();

        int maxLevel = 0;
        int minLevel = 0;

        q.add(new Pair(A, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.treeNode;
            int level = p.level;

            //insert into HashMap
            if(map.containsKey(level)){
                ArrayList<Integer> curList = map.get(level);
                curList.add(node.val);
                map.put(level, curList);
            }
            else{
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(node.val);
                map.put(level, newList);
            }

            //update minLevel and maxLevel
            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            //insertion to the Queue
            if(node.left != null)  q.add(new Pair(node.left, level-1));
            if(node.right != null)  q.add(new Pair(node.right, level+1));
        }

        //Iterate map starting from minLevel -->maxLevel and add to response list
        ArrayList<ArrayList<Integer>> responseList = new ArrayList();
        for (int i= minLevel; i<=maxLevel; i++){
            responseList.add(map.get(i));
        }

        return responseList;
    }
}


class Pair{
    public TreeNode treeNode;
    public Integer level;

    //constructor
    public Pair(TreeNode treeNode, Integer level){
        this.treeNode = treeNode;
        this.level = level;
    }
}