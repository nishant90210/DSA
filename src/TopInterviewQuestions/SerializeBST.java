package TopInterviewQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {

    private static final String NULL_SYMBOL = "X";
    private static final String DELIMITER = ",";

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        String serialize = serialize(root);
        System.out.println(serialize);
        Node deserialize = deserialize(serialize);
        System.out.println(deserialize.data);
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        // If we have a null symbol...we encode a null symbol
        if (root == null) {
            return NULL_SYMBOL + DELIMITER;
        }
        /*
         * The key to tree problems is TO HAND OFF RESPONSIBILITY. Here we are saying...
         *
         * "hey, I know what root's value is...ummmm...hey serialize()... can you encode
         * my left and right subtrees?...Get back to me because ONLY THEN will I append
         * myself"
         */
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        // Here we append the node we hold ('root') to the other serializations
        return root.data + DELIMITER + leftSerialized + rightSerialized;
    }

    /*
     * Here we take the string and simply split it on the delimiter. We then have a
     * list of values we can materialize into nodes
     */
    public static Node deserialize(String data) {
        Queue<String> nodesLeftToMaterialize = new LinkedList<>();
        nodesLeftToMaterialize.addAll(Arrays.asList(data.split(DELIMITER)));
        return deserializeHelper(nodesLeftToMaterialize);
    }

    /*
     * We use a queue here so we don't have to keep overarching state (since the
     * question description bars us from doing so)
     *
     * At any point in time when this function is called we will know the next node
     * to materialize
     *
     * We materialize a node, set its left and right subtrees respectively, and then
     * return the node itself
     */
    private static Node deserializeHelper(Queue<String> nodesLeftToMaterialize) {

        String valueForNode = nodesLeftToMaterialize.poll();

        if (valueForNode.equals(NULL_SYMBOL)) {
            return null;
        }

        Node newNode = new Node(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeftToMaterialize);
        newNode.right = deserializeHelper(nodesLeftToMaterialize);

        /*
         * How does the call to 'right' know where to pick up where the 'left' call
         * left off?
         *
         * Well, the queue ensures that whatever is at the front is the next node to
         * process, we don't need to carry state between calls because the queue
         * enforces that ordering itself
         */

        return newNode;
    }
}
