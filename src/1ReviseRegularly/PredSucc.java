package Tree;

import java.util.ArrayList;

/**
 * Created by NISHANT on 4/7/18.
 */
public class PredSucc {

    static ArrayList arrayList = new ArrayList();

    public static void main(String[] args) {

        Node root = null;
        int[] inOrder = {11, 5, 8, 6, 17, 9, 14, 10, 12, 7};
        Node node = buildTree(inOrder);
        inOrderTraversal(node);
        predSucc(10);
    }

    private static void predSucc(Integer predSucc) {

        int pred = 0;
        int succ = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == predSucc){
                if (i < 0){
                    pred = 0;
                    succ = (int) arrayList.get(i+1);
                }else if (i >= arrayList.size()-1){
                    pred = (int) arrayList.get(i-1);
                    succ = 0;
                }else {
                    pred = (int) arrayList.get(i-1);
                    succ = (int) arrayList.get(i+1);
                }
            }
        }
        System.out.println();
        System.out.println(pred +  "  " + succ);
    }

    private static Node buildTree(int[] inOrder) {

        Node root = null;
        for (int i = 0; i < inOrder.length; i++) {
            Node nodeToAdd = new Node(inOrder[i]);
            if (root == null){
                root = new Node(inOrder[i]);
            } else {
                root = traverseAndAdd(root, nodeToAdd);
            }

        }
        return root;
    }

    private static Node traverseAndAdd(Node root, Node nodeToAdd) {

        if (nodeToAdd.data < root.data){
            if (root.left == null){
                root.left = nodeToAdd;
            }else {
                traverseAndAdd(root.left, nodeToAdd);
            }
        } else {
            if (root.right == null){
                root.right = nodeToAdd;
            }else {
                traverseAndAdd(root.right, nodeToAdd);
            }
        }
        return root;
    }

    private static void inOrderTraversal(Node node) {

        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        System.out.print(node.data + " ");
        arrayList.add(node.data);
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

}
