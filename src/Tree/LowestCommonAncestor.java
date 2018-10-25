package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NISHANT on 11/1/17.
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(1);
        binaryTree.add(8);
        binaryTree.add(9);
        binaryTree.add(7);

        Integer lca1 = isExist(7, binaryTree.root, l1);
        Integer lca2 = isExist(9, binaryTree.root, l2);
        printList(l1);
        printList(l2);

        System.out.println(findLCA(l1, l2, binaryTree.root));
    }

    private static String findLCA(List<Integer> list1, List<Integer> list2, Node root) {

        if (!list1.isEmpty() && !list2.isEmpty()){
            for (int i = list1.size()-1; i > 0; i--){
                for (int j = list2.size()-1; j > 0; j--){
                    if (list1.get(i) == list2.get(j)){
                        return list1.get(i).toString();
                    }
                }
            }
        }
        return "Not Found";
    }

    private static void printList(List<Integer> list) {
        if (list.size() > 0){
            for (int i  = 0 ; i < list.size(); i++){
                System.out.println("List is := " + list.get(i));
            }
        }
        else {
            System.out.println("List is Empty ");
        }
    }

    private static Integer isExist(int elementToBeSearched, Node root, List<Integer> list) {

        int element = 0;
        if (root == null){
            return null;
        }
        list.add(root.data);
        if (root.data == elementToBeSearched){
            System.out.println("Element Found " + root.data);
            return root.data;
        } else if (root.data > elementToBeSearched){
            element = isExist(elementToBeSearched, root.left, list);
        } else if (root.data < elementToBeSearched){
            element = isExist(elementToBeSearched, root.right, list);
        } else {
            list.clear();
        }
        return element;
    }
}
