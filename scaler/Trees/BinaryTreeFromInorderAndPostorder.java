package Trees;

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

    public static Tree buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i=0; i<A.size(); i++){
            hash.put(A.get(i), i);
        }

        //B - postorder
        //A - Inorder
        return makeTree(B, A, 0, B.size()-1, 0, A.size()-1, hash);
    }

    public static Tree makeTree(ArrayList<Integer> post, ArrayList<Integer> inOrder, int pStart, int pEnd, int inStart, int inEnd,
                                HashMap<Integer, Integer> hash){
        //base case
        if(pStart > pEnd)   return null;

        int rootVal = post.get(pEnd);
        Tree root = new Tree(rootVal);

        int index = hash.get(rootVal);

        int lenLST = index - inStart;

        root.left = makeTree(post, inOrder, pStart, pStart+lenLST-1, inStart, index-1, hash);

        root.right = makeTree(post, inOrder, pStart + lenLST, pEnd-1, index+1, inEnd, hash);

        return root;
    }
}

class Tree {
    int val;
    Tree left;
    Tree right;
    Tree(int x) {
     val = x;
     left=null;
     right=null;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';

    }
}