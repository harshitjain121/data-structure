package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPostorder {

    public static void main(String[] args) {
        ArrayList<Integer> postOrder = new ArrayList<>(
                Arrays.asList(6, 3, 2, 1)
        );
        ArrayList<Integer> inOrder = new ArrayList<>(
                Arrays.asList(6, 1, 3, 2)
        );

        System.out.println(buildTree(postOrder, inOrder));
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i=0; i<A.size(); i++){
            hash.put(A.get(i), i);
        }

        //B - postorder
        //A - Inorder
        return makeTree(B, A, 0, B.size()-1, 0, A.size()-1, hash);
    }

    public static TreeNode makeTree(ArrayList<Integer> post, ArrayList<Integer> inOrder, int pStart, int pEnd, int inStart, int inEnd,
                                HashMap<Integer, Integer> hash){
        //base case
        if(pStart > pEnd)   return null;

        int rootVal = post.get(pEnd);
        TreeNode root = new TreeNode(rootVal);

        int index = hash.get(rootVal);

        int lenLST = index - inStart;

        root.left = makeTree(post, inOrder, pStart, pStart+lenLST-1, inStart, index-1, hash);

        root.right = makeTree(post, inOrder, pStart + lenLST, pEnd-1, index+1, inEnd, hash);

        return root;
    }
}