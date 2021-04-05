package Test;

public class DiameterBSt {

    Node root;
    static class Node {

        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

//        DiameterBSt diameterBSt = new DiameterBSt();
//        diameterBSt.addNodeToBST(1);
//        diameterBSt.addNodeToBST(2);
//        diameterBSt.addNodeToBST(4);
//        diameterBSt.addNodeToBST(3);
//        diameterBSt.addNodeToBST(5);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        calulateHeight(root);
        int dia = dia(root);
        System.out.println(dia);
    }

    private static int dia(Node root) {

        if (root == null){
            return 0;
        }
        int left = calulateHeight(root.left);
        int right = calulateHeight(root.right);
        int diaLeft = dia(root.left);
        int diaRight = dia(root.right);
        return Math.max((left+right+1), Math.max(diaLeft, diaRight));
    }

    private static int calulateHeight(Node root) {

        if (root == null){
            return 0;
        }
        int left = calulateHeight(root.left);
        int right = calulateHeight(root.right);
        return 1 + Math.max(left, right);
    }


    private void addNodeToBST(int val) {

        if (root == null){
            root = new Node(val);
        }else {
            traverseNAdd(root, val);
        }
    }

    private void traverseNAdd(Node root, int val) {

        if (root.val > val) {
            if (root.left == null){
                root.left = new Node(val);
            }else {
                traverseNAdd(root.left, val);
            }
        }else {
            if (root.right == null){
                root.right = new Node(val);
            }else {
                traverseNAdd(root.right, val);
            }
        }
    }
}