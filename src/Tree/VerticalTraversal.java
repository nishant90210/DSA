package Tree;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by NISHANT on 11/1/17.
 *
 * For Printing Vertical Order Traversal just Loop through the Map's value i.e. entry.getValue during the for loop;
 *
 * For Printing Top View of Tree just Loop through the Map's first value i.e.
 * Vector value = (Vector)  entry.getValue();
 * value.get(0)
 *
 * For Printing Bottom View of Tree just Loop through the Map's last value i.e.
 * Vector value = (Vector)  entry.getValue();
 * value.get(value.size()-1)
 */
public class VerticalTraversal {

    public static void main(String args[])
    {
        /* Let us construct the tree shown in above diagram */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
//        root.right.left.right = new Node(8);
//        root.right.right.right = new Node(9);

        TreeMap<Integer, Vector<Integer>> valueMap = new TreeMap<>();
        System.out.println("vertical order traversal is :");
        verticalOrder(0, root, valueMap);
        for (Map.Entry entry : valueMap.entrySet()){
            //This step is for top view of a Tree else just loop through entry.getValue();
            Vector value = (Vector)  entry.getValue();
            System.out.println("key -> " + entry.getKey() + " value -> " + value.get(value.size()-1));
        }
    }

    private static void verticalOrder(int d, Node root, Map<Integer, Vector<Integer>> valueMap) {

        if (root == null){
            return;
        }
        Vector<Integer> keyValue = valueMap.get(d);
        if (keyValue == null){
            keyValue = new Vector<Integer>();
            keyValue.add(root.data);
        }else {
            keyValue.add(root.data);
        }
        valueMap.put(d, keyValue);
        verticalOrder(d-1, root.left, valueMap);
        verticalOrder(d+1, root.right, valueMap);
    }
}
