package Programs;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {

    public static void main(String[] args) {

        ValidateBST.Node node = new ValidateBST.Node(3);
        node.left = new ValidateBST.Node(1);
        node.left.right = new ValidateBST.Node(2);
        node.right = new ValidateBST.Node(4);

        List<Integer> list = kthSmallest(node);
        Integer integer = list.get(2);
        System.out.println(integer);
    }

    public static List<Integer> kthSmallest(ValidateBST.Node root) {

        List<Integer> res = new ArrayList();
        return getInOrder(root, res);
    }

    public static List<Integer> getInOrder(ValidateBST.Node root, List<Integer> res) {

        if(root == null){
            return null;
        }
        getInOrder(root.left, res);
        res.add(root.data);
        getInOrder(root.right, res);
        return res;
    }
}
