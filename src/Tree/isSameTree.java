package Tree;

public class isSameTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root1 = new Node(1);
        root1.left = new Node(2);
//        root1.right = new Node(3);

        Node root2 = new Node(1);
//        root2.left = new Node(2);
        root2.right = new Node(2);

        boolean sameTree = isSameTree(root1, root2);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(Node p, Node q) {

        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.data == q.data){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
