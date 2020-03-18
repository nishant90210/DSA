package Tree;

import java.util.HashSet;
import java.util.Set;

public class FindPairGivenSumBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 15);
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 8);
        root = insert(root, 12);
        root = insert(root, 16);
        root = insert(root, 25);

        int sum = 28;
        Set<Integer> set = new HashSet<>();

        if (!findPair(root, sum, set)) {
            System.out.print("Pair do not exists");
        }
    }

    private static Node insert(Node root, int val) {

        if (root == null) {
            root = new Node(val);
        } else {
            if (val < root.data) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
        }
        return root;
    }

    private static boolean findPair(Node root, int sum, Set<Integer> set) {

        if (root == null){
            return false;
        }
        if (findPair(root.left, sum , set)){
            return true;
        }
        if (set.contains(sum - root.data)){
            System.out.println(root.data + " " + (sum - root.data));
            return true;
        }else {
            set.add(root.data);
        }
        return findPair(root.right, sum , set);
    }
}
