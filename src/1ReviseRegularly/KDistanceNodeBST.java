package TopInterviewQuestions;

import java.util.*;
//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
public class KDistanceNodeBST {

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
        Node target = root.left.right; // 12
        List<Integer> integers = printkdistanceNode(root, target, 1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    private static List<Integer> printkdistanceNode(Node treeRoot, Node startNode, int targetDistance) {

        Map<Node, Node> nodeToParentMap = new HashMap();
        populateNodeToParentMap(nodeToParentMap, treeRoot, null);

        Queue<Node> queue = new LinkedList();
        queue.add(startNode);

    /*
      This is an undirected graph now that we can go to and from nodes. Before we could only go down the tree.
      Therefore, we need a hashtable to keep track of nodes we have visited so that we do not go back and revisit what has already
      been processed and cause an infinite cycle
    */
        Set<Node> seen = new HashSet();
        seen.add(startNode);

        int currentLayer = 0;
        while (!queue.isEmpty()) {
            if (currentLayer == targetDistance) {
                return extractLayerFromQueue(queue);
            }

      /*
        How large is this layer? Let's process all node in the layer. This is Breadth First Search.
      */
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
        /*
          Pull a node from the search queue, we are going to basically use our current layer to populate the next layer of nodes
          that we need to search in the next while loop iteration
        */
                Node currentNode = queue.poll();

                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                }

                Node parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                }
            }

            currentLayer++;
        }
        return new ArrayList<>();
    }

    private static List<Integer> extractLayerFromQueue(Queue<Node> queue) {

        List<Integer> extractedList = new ArrayList();
        for (Node node: queue) {
            extractedList.add(node.data);
        }
        return extractedList;
    }

    private static void populateNodeToParentMap(Map<Node, Node> nodeToParentMap, Node root, Node parent) {

        /*
            When this recursion is done we will know all nodes' parents. The tree then
            can be treated and searched like any other graph
        */
        if (root == null){
            return;
        }
        nodeToParentMap.put(root, parent);
        /*
          Go left and after that go right. The call that we make next will have what we call 'root' now as the 'parent' value so
          we can do the mapping in THAT call stack frame...and so on and so on...
        */
        populateNodeToParentMap(nodeToParentMap, root.left, root);
        populateNodeToParentMap(nodeToParentMap, root.right, root);
    }
}
