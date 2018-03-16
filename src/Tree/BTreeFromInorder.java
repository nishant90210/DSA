package Tree;

/**
 * Created by NISHANT on 11/3/17.
 */
public class BTreeFromInorder {

    public static void main(String[] args) {

        Node root = null;
        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode = buildTree(inorder, 0, len - 1, root);
        inOrderTraversal(mynode);
    }

    private static Node buildTree(int[] inorder, int start, int end, Node root) {

        if (start > end){
            return null;
        }
        int max = findMax(inorder, start, end);
        root = new Node(inorder[max]);
//        int index = calculateIndex(inorder, max);
        if (start == end){
            return root;
        }
        root.left = buildTree(inorder, start, max-1, root);
        root.right = buildTree(inorder, max+1, end, root);
        return root;
    }

    private static int calculateIndex(int[] inorder, int max) {

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == max){
                index = i;
                break;
            }
        }
        return index;
    }

    private static int findMax(int arr[], int strt, int end)
    {
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }

    private static void inOrderTraversal(Node node) {

        if(node.left != null){
            inOrderTraversal(node.left);
        }
        System.out.print(node.data + " ");
        if(node.right != null){
            inOrderTraversal(node.right);
        }
    }
}
