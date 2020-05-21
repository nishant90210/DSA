package Programs;

import TopInterviewQuestions.MaxPathSumBinaryTree;

import java.util.HashMap;

public class CousinsinBinaryTree {

    public static void main(String[] args) {

        int x = 5;
        int y = 4;
        MaxPathSumBinaryTree.Node root = new MaxPathSumBinaryTree.Node(1);
        root.left = new MaxPathSumBinaryTree.Node(2);
        root.right = new MaxPathSumBinaryTree.Node(3);
        root.left.right = new MaxPathSumBinaryTree.Node(4);
        root.right.right = new MaxPathSumBinaryTree.Node(5);
        boolean cousin = isCousin(root, x, y);
        System.out.println(cousin);
    }

    private static boolean isCousin(MaxPathSumBinaryTree.Node root, int x, int y) {

        int depth = 0;
        HashMap map = new HashMap();
        nodeToParentMap(root, null, map);
        int xDepth = checkDepth(root, x, depth);
        int yDepth = checkDepth(root, y, depth);
        if (xDepth == yDepth && map.get(x) != map.get(y)){
            return true;
        }
        return false;
    }

    private static int checkDepth(MaxPathSumBinaryTree.Node root, int x, int depth) {

        if (root == null){
            return 0;
        }
        if (root.data == x){
            return depth;
        }
        int leftDepth = checkDepth(root.left, x, depth+1);
        if(leftDepth != 0) {
            return leftDepth;
        }
        return checkDepth(root.right, x, depth+1);
    }

    private static void nodeToParentMap(MaxPathSumBinaryTree.Node root, MaxPathSumBinaryTree.Node parent, HashMap map) {

        if (root == null){
            return;
        }
        map.put(root.data, parent);
        nodeToParentMap(root.left, root, map);
        nodeToParentMap(root.right, root, map);
    }
}
