package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NISHANT on 11/1/17.
 */
//LCA in BINARY TREE
public class LowestCommonAncestorBT {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(40);
        binaryTree.add(20);
        binaryTree.add(60);
        binaryTree.add(10);
        binaryTree.add(30);
        binaryTree.add(50);
        binaryTree.add(70);
        binaryTree.add(5);
        binaryTree.add(55);

        System.out.println(findLCA(binaryTree.root, 5, 30).data);
    }

    private static Node findLCA(Node root, int phal, int phool) {

        if (root == null){
            return null;
        }
        if (root.data == phal || root.data == phool){
            return root;
        }
        Node left = findLCA(root.left, phal, phool);
        Node right = findLCA(root.right, phal, phool);
        if(left == null){
            return right;
        } else if(right == null){
            return left;
        }else{
            return root;
        }
    }
}
