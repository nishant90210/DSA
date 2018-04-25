package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by NISHANT on 10/30/17.
 */
public class DiagonalTraversal {

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        Map<Integer, Vector<Integer>> valueMap = new HashMap<>();
        Node node = root;
        diagonalTraversal(0, valueMap, node);
        for (Map.Entry entry : valueMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private static void diagonalTraversal(int d, Map<Integer, Vector<Integer>> valueMap, Node root) {

        if (root == null){
            return;
        }
        Vector<Integer> keyVal = valueMap.get(d);
        if (keyVal == null){
            keyVal = new Vector<Integer>();
            keyVal.add(root.data);
        } else {
            keyVal.add(root.data);
        }
        valueMap.put(d, keyVal);

        /* d will increment by 1 i.e. d = d + 1, only for the left child
        * and will remain same as of the parent i.e. d = d of parent for every right child
        * SO the same value of d will correspond to the same diagonal*/
        diagonalTraversal(d+1, valueMap, root.left);
        diagonalTraversal(d, valueMap, root.right);
    }






















    /*    BAKWASSS HAI YEEEE     */


//    private static void diagonalPrint(Node root) {
//
//        Queue<Node> q1 = new LinkedList();
//        Queue<Node> q2 = new LinkedList();
//        Queue<Node> q3 = new LinkedList();
//        Node node = root;
//
//        addToQueue(q1, node);
//        printQueue(q1);
//        System.out.println();
//        while (!q1.isEmpty()){
//            Node leftNode = q1.peek().left;
//            addToQueue(q2, leftNode);
//            q1.remove();
//        }
//        printQueue(q2);
//        System.out.println();
//        while (!q2.isEmpty()){
//            Node leftNode = q2.peek().left;
//            addToQueue(q3, leftNode);
//            q2.remove();
//        }
//        printQueue(q3);
//    }
//
//    private static void addToQueue(Queue<Node> queue, Node node) {
//        while (node != null){
//            queue.add(node);
//            node = node.right;
//        }
//    }
//
//    private static void printQueue(Queue<Node> queue) {
//
//        for (Node s : queue) {
//            System.out.print(" " + s.data);
//        }
//    }
}
