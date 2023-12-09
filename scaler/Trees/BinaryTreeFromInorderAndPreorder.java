package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPreorder {

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>(
                Arrays.asList(8,6,5,15,19,9,18,25,4,7,41,30,39,48)
        );
        ArrayList<Integer> inOrder = new ArrayList<>(
                Arrays.asList(15,5,19,6,18,9,25,8,7,41,4,39,30,48)
        );

        System.out.println(buildTree(preOrder, inOrder).toString());
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i=0; i<B.size(); i++){
            hash.put(B.get(i), i);
        }

        return makeTree(A, B, 0, A.size()-1, 0, B.size()-1, hash);
    }

    public static TreeNode makeTree(ArrayList<Integer> pre, ArrayList<Integer> inOrder, int pStart, int pEnd, int inStart, int inEnd,
                                HashMap<Integer, Integer> hash){
        //base case
        if(pStart > pEnd)   return null;

        int rootVal = pre.get(pStart);
        TreeNode root = new TreeNode(rootVal);

        int index = hash.get(rootVal);

        int lenLST = index - inStart;

        root.left = makeTree(pre, inOrder, pStart+1, pStart+lenLST, inStart, index-1, hash);

        root.right = makeTree(pre, inOrder, pStart + lenLST+1, pEnd, index+1, inEnd, hash);

        return root;
    }
}
