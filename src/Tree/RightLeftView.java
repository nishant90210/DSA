package Tree;

import java.util.Stack;

/**
 * Created by NISHANT on 11/2/17.
 */
public class RightLeftView {

    public static void main(String[] args) {

        /*
        Use STACK for right view and QUEUE for left view
         */
        Stack<Integer> stack = new Stack<>();
        HeightBST heightBST = new HeightBST();
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        int level = heightBST.maxHeight(root);

        for (int i = 1; i <= level; i++) {
            printGivenLevel(root, i, stack);
            System.out.println(stack.peek());
            stack.clear();
        }
    }

    private static void printGivenLevel(Node root, int level, Stack<Integer> stack) {

        if (root == null){
            return;
        }
        else if (level == 1){
            stack.add(root.data);
        }
        else {
            printGivenLevel(root.left, level-1, stack);
            printGivenLevel(root.right, level-1, stack);
        }
    }
}
