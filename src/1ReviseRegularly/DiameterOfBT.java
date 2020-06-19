package Tree;

//https://www.youtube.com/watch?v=ey7DYc9OANo
//Number of nodes on the longest path of a BT is called the DIAMETER OF A BINARY TREE
public class DiameterOfBT {

    Node root;
    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        DiameterOfBT diameterOfBT = new DiameterOfBT();
        diameterOfBT.addNodeToBST(2);
        diameterOfBT.addNodeToBST(1);
        diameterOfBT.addNodeToBST(4);
        diameterOfBT.addNodeToBST(3);
        diameterOfBT.addNodeToBST(5);

        diameterOfBT.printInOrder(diameterOfBT.root);
        int maxHeight = diameterOfBT.calculateHeight(diameterOfBT.root);
        System.out.println("Height of BT : " + maxHeight);
        int diameter = diameterOfBT.calculateDiameter(diameterOfBT.root);
        System.out.println("Diameter of a BT : " + diameter);
    }

    private int calculateDiameter(Node root) {

        if (root == null){
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        int leftDiameter = calculateDiameter(root.left);
        int rightDiameter = calculateDiameter(root.right);
        int diameter = Math.max((leftHeight+rightHeight), Math.max(leftDiameter, rightDiameter));
        return diameter;
    }

    private int calculateHeight(Node root) {

        if (root == null){
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }


    private void printInOrder(Node root) {

        if (root == null){
            return;
        }else {
            printInOrder(root.left);
            System.out.println(" " + root.data);
            printInOrder(root.right);
        }
    }

    public void addNodeToBST(int data) {

        if (root == null){
            root = new Node(data);
        }else {
            traverseAndAdd(root, data);
        }
    }

    private void traverseAndAdd(Node root, int data) {

        if (root.data > data) {
            if (root.left != null){
                traverseAndAdd(root.left, data);
            }else {
                root.left = new Node(data);
            }
        }else {
            if (root.right != null){
                traverseAndAdd(root.right, data);
            }else {
                root.right = new Node(data);
            }
        }
    }
}
