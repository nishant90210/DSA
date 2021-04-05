package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by NISHANT on 10/30/17.
 */
public class DiagonalTraversal {

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        Map<Integer, ArrayList<Integer>> valueMap = new HashMap<>();
        diagonalTraversal(0, valueMap, root);
        for (Map.Entry entry : valueMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private static void diagonalTraversal(int d, Map<Integer, ArrayList<Integer>> valueMap, Node root) {

        if (root == null){
            return;
        }
        //mapKey is the level with which we will put the values
        //like with 0 --> 8 , 10 , 14
        // with 1 --> 3, 6, 7, 13 ,etc
        ArrayList<Integer> mapKey = valueMap.get(d);
        if (mapKey == null){
            mapKey = new ArrayList<>();
        }
        mapKey.add(root.data);
        valueMap.put(d, mapKey);
        /* d will increment by 1 i.e. d = d + 1, only for the left child
         * and will remain same as of the parent i.e. d = d of parent for every right child
         * SO the same value of d will correspond to the same diagonal
         */
        diagonalTraversal(d + 1, valueMap, root.left);
        diagonalTraversal(d, valueMap, root.right);
        return;
    }
}