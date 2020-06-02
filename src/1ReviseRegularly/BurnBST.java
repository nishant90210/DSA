package TopInterviewQuestions;

import java.util.*;
//https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
public class BurnBST {

    public static class Node {
        int data;
        public Node left;
        public Node right;

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
        Node target = root.left; // 8
        printBurntNodes(root, target);
    }

    private static void printBurntNodes(Node root, Node target) {

        Map<Node, Node> nodeToParentMap = new HashMap();
        Queue<Node> queue = new LinkedList<>();
        populateNodeToParentMap(nodeToParentMap, root, null);
        queue.offer(target);
        Set<Node> seen = new HashSet();
        seen.add(target);
        System.out.println(target.data);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                Node currentNode = queue.poll();

                if (currentNode.left != null && !seen.contains(currentNode.left)) {
                    seen.add(currentNode.left);
                    queue.offer(currentNode.left);
                    System.out.print(currentNode.left.data + ", ");
                }

                if (currentNode.right != null && !seen.contains(currentNode.right)) {
                    seen.add(currentNode.right);
                    queue.offer(currentNode.right);
                    System.out.print(currentNode.right.data+ ", ");
                }

                Node parentOfCurrentNode = nodeToParentMap.get(currentNode);
                if (parentOfCurrentNode != null && !seen.contains(parentOfCurrentNode)) {
                    seen.add(parentOfCurrentNode);
                    queue.offer(parentOfCurrentNode);
                    System.out.println(parentOfCurrentNode.data+ ", ");
                }
            }
        }
    }

    private static void populateNodeToParentMap(Map<Node, Node> nodeToParentMap, Node root, Node parent) {

        if (root == null){
            return;
        }
        nodeToParentMap.put(root, parent);
        populateNodeToParentMap(nodeToParentMap, root.left, root);
        populateNodeToParentMap(nodeToParentMap, root.right, root);
    }
}
