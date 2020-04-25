package Programs;

import java.util.*;

public class BurnBSTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        int target = 14;
        printBurnBSTNodes(root, root.right.left);
    }

    private static void printBurnBSTNodes(Node root, Node nodeTarget) {

        HashMap<Integer, Node> nodeToParentMap = new HashMap();
        fillParentMap(nodeToParentMap, root, null);
        Set<Node> seen = new HashSet();
        Queue<Node> queue = new LinkedList();
        queue.add(nodeTarget);
        seen.add(nodeTarget);
        System.out.println(nodeTarget.data);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                if (node.left != null && !seen.contains(node.left)){
                    System.out.print(node.left.data + ", ");
                    queue.add(node.left);
                    seen.add(node.left);
                }
                if (node.right != null && !seen.contains(node.right)){
                    System.out.print(node.right.data + ", ");
                    queue.add(node.right);
                    seen.add(node.right);
                }
                Node parentNode = nodeToParentMap.get(node.data);
                if (parentNode != null && !seen.contains(parentNode)){
                    System.out.println(parentNode.data);
                    queue.add(parentNode);
                    seen.add(parentNode);
                }
            }
        }
    }

    private static void fillParentMap(HashMap nodeToParentMap, Node root, Node parent) {

        if (root == null){
            return;
        }
        nodeToParentMap.put(root.data, parent);
        fillParentMap(nodeToParentMap, root.left, root);
        fillParentMap(nodeToParentMap, root.right, root);
    }

    private static Node searchNodeBT(Node root, int target) {

        if (root == null || root.data == target){
            return root;
        }
        searchNodeBT(root.left, target);
        searchNodeBT(root.right, target);
        return root;
    }

    public static Node insertIntoBST(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
            root.left = insertIntoBST(root.left, val);
        }else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    private static Node searchNodeBST(Node root, int target) {

        if (root == null || root.data == target){
            return root;
        }
        if (root.data > target){
            return searchNodeBST(root.left, target);
        }else {
            return searchNodeBST(root.right, target);
        }
    }
}
