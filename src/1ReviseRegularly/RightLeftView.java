package Tree;

import java.util.ArrayList;
import java.util.List;
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
//        Node root = new Node(12);
//        root.left = new Node(10);
//        root.right = new Node(30);
//        root.right.left = new Node(25);
//        root.right.right = new Node(40);

        Node root = new Node(1);
        root.right = new Node(2);

//        List<Integer> list = new ArrayList();
//        List<Integer> res = printRightView(root, list);
//        for (Integer re : res) {
//            System.out.println(re);
//        }

        int level = heightBST.maxHeight(root);

        for (int i = 1; i <= level; i++) {
            printGivenLevel(root, i, stack);
            System.out.println(stack.peek());
            stack.clear();
        }
    }

    private static List<Integer> printRightView(Node root, List<Integer> list) {

        if (root == null){
            return list;
        }
        list.add(root.data);
        printRightView(root.right, list);
        return list;
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
