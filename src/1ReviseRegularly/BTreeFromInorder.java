package Tree;

/**
 * Created by NISHANT on 11/3/17.
 */
public class BTreeFromInorder {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode = buildTree(inorder, 0, len - 1);
        inOrderTraversal(mynode);
    }

    private static Node buildTree(int[] inorder, int start, int end) {

        if (start > end){
            return null;
        }
        int max = findMax(inorder, start, end);
        Node root = new Node(max);
        int indexOfMax = findIndexOfMax(inorder, max);
        root.left = buildTree(inorder, start, indexOfMax-1);
        root.right = buildTree(inorder, indexOfMax+1, end);
        return root;
    }

    private static int findMax(int[] inorder, int start, int end) {

        int max = 0;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, inorder[i]);
        }
        return max;
    }

    private static int findIndexOfMax(int[] inorder, int max) {

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == max){
                index = i;
                break;
            }
        }
        return index;
    }

    private static void inOrderTraversal(Node node) {

        if(node.left != null){
            inOrderTraversal(node.left);
        }
        System.out.print(node.val + " ");
        if(node.right != null){
            inOrderTraversal(node.right);
        }
    }
}
