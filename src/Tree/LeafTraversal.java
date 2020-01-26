package Tree;

import java.util.Stack;

/**
 * Created by NISHANT on 10/13/17.
 */
public class LeafTraversal {

    public static void main(String[] args)
    {
        Node root1 = new Node(0);
        root1.left = new Node(1);
        root1.right = new Node(2);
        root1.left.left = new Node(8);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println("Leaf Traversal");
        Node root2 = new Node(0);
        root2.left = new Node(1);
        root2.right = new Node(5);
        root2.left.right = new Node(4);
        root2.right.left = new Node(6);
        root2.right.right = new Node(7);

        if (isSame(root1, root2))
            System.out.println("Same");
        else
            System.out.println("Not Same");
    }

    private static boolean isSame(Node root1, Node root2) {

        boolean flag = false;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack stackRoot1 = leafTraversal(root1, stack1);
        Stack stackRoot2 = leafTraversal(root2, stack2);
        if (stackRoot1.size() == stackRoot2.size()){
            while (!stackRoot1.isEmpty() && !stackRoot2.isEmpty()){
                if (stackRoot1.pop() != stackRoot2.pop()){
                    flag = false;
                }
                else {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static Stack leafTraversal(Node root, Stack stack) {

        if (root == null){
            return stack;
        }
        if (root.left == null && root.right == null){
            System.out.println(root.data);
            stack.push(root.data);
        }
        leafTraversal(root.left, stack);
        leafTraversal(root.right, stack);
        return stack;
    }
}
