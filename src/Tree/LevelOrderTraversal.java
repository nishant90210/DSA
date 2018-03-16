package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by NISHANT on 9/27/17.
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {

        HeightBST heightBST = new HeightBST();
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(3);
        binaryTree.add(5);

        int level = heightBST.maxHeight(binaryTree.root);

        //Stop the loop and enter the value of i for printing all nodes at distance k from a given node and perform a check if i == 0.
        for (int i = 1; i <= level; i++) {
//            printGivenLevel(binaryTree.root, i);
//            System.out.println("");
        }
        System.out.println();
        levelOrder1Queues(binaryTree.root);
    }

    private static void printGivenLevel(Node root, int level) {

        if (root == null){
            return;
        }
        else if (level == 1){
            System.out.print(" " + root.data);
        }
        else {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    private static void levelOrder2Queues(Node root) {

        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        if (root == null){
            return;
        }
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            while (!queue1.isEmpty()){
                if (queue1.peek().left != null){
                    queue2.add(queue1.peek().left);
                }
                if (queue1.peek().right != null){
                    queue2.add(queue1.peek().right);
                }
                System.out.print(" " + queue1.peek().data);
                queue1.remove();
            }
            System.out.println();
            while (!queue2.isEmpty()){
                System.out.print(" " + queue2.peek().data);
                if (queue2.peek().left != null){
                    queue1.add(queue2.peek().left);
                }
                if (queue2.peek().right != null){
                    queue1.add(queue2.peek().right);
                }
                queue2.remove();
            }
            System.out.println();
        }
    }

    private static void levelOrder1Queues(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        if (root == null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            if (tempNode != null){
                System.out.print(tempNode.data + " ");
            }

            /*Enqueue left child */
            if (tempNode != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode != null) {
                queue.add(tempNode.right);
            }
        }
    }

}
