package Tree;

public class ConvertBSTtoGreaterTree {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(13);
        Node node = convertBST(root);
        System.out.println(node.val);
        System.out.println(node.right.val);
        System.out.println(node.left.val);
    }
    static int sum = 0;
    public static Node convertBST(Node root) {

        if (root == null){
            return null;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}
