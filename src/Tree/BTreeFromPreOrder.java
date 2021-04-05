package Tree;

public class BTreeFromPreOrder {

    static int index = 0;
    static class Node {

        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        int[] preorder = {8,5,1,7,10,12};
        Node node = generateBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        inOrder(node);
//        constructBSTinO2(preorder, 0, preorder.length-1);
    }

    private static void inOrder(Node node) {

        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    private static Node generateBST(int[] preorder, int currMin, int currMax) {

        if (index >= preorder.length){
            return null;
        }
        int currentNum = preorder[index];
        while (currentNum > currMin && currentNum < currMax){
            Node root = new Node(currentNum);
            index++;
            root.left = generateBST(preorder, currMin, currentNum);
            root.right = generateBST(preorder, currentNum, currMax);
            return root;
        }
        return null;
    }

    //O(n^2)
    public static Node constructBSTinO2(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(preorder[start]);
        int i = getIndex(preorder, start, end, node);
        node.left = constructBSTinO2(preorder, start + 1, i - 1);
        node.right = constructBSTinO2(preorder, i, end);
        return node;
    }

    private static int getIndex(int[] preorder, int start, int end, Node node) {
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.data) {
                break;
            }
        }
        return i;
    }
}
