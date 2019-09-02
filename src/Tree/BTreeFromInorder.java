package Tree;

/**
 * Created by NISHANT on 11/3/17.
 */
public class BTreeFromInorder {

    public static void main(String[] args) {

        int inorder[] = new int[]{5, 10, 40, 30, 28};
        int len = inorder.length;
        Node mynode = buildTree(inorder, 0, len - 1);
        inOrderTraversal(mynode);
    }

    private static Node buildTree(int[] inorder, int start, int end) {

        if (start > end){
            return null;
        }
        int max = findMax(inorder, start, end);
        Node root = new Node(inorder[max]);
//        int index = calculateIndex(inorder, max);
        if (start == end){
            return root;
        }
        root.left = buildTree(inorder, start, max-1);
        root.right = buildTree(inorder, max+1, end);
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

    private static int findMax(int arr[], int start, int end)
    {
        int i, max = arr[start], maxInd = start;
        for (i = start + 1; i <= end; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                maxInd = i;
            }
        }
        return maxInd;
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
