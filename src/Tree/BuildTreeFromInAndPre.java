package Tree;

/**
 * Created by NISHANT on 10/5/17.
 */
public class BuildTreeFromInAndPre {

    private static int pIndex = 0;
    public static void main(String[] args) {

        int in[] = {1,5,7,8,10,12};
        int pre[] =  {8,5,1,7,10,12};
        BuildTreeFromInAndPre buildBST = new BuildTreeFromInAndPre();
        Node node = buildBST.buildTree(in, pre, 0, in.length - 1);
        buildBST.printInOrder(node);
        System.out.println();
        buildBST.printPostOrder(node);
    }

    private Node buildTree(int[] in, int[] pre, int iStart, int iEnd) {

        if (iStart > iEnd){
            return null;
        }
        Node root = new Node(pre[pIndex]);
        pIndex++;
//        if (iStart == iEnd){
//            return root;
//        }
        int inArrayIndex = getArrayIndex(in, root.data);
        root.left = buildTree(in, pre, iStart, inArrayIndex-1);
        root.right = buildTree(in, pre, inArrayIndex+1, iEnd);

        return root;
    }

    public static int getArrayIndex(int[] arr, int value) {
        for(int i=0;i<=arr.length;i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }

    public void printInOrder(Node root){
        if(root!=null){
            printInOrder(root.left);
            System.out.print("  " + root.data);
            printInOrder(root.right);
        }
    }

    public void printPostOrder(Node root){
        if(root!=null){
            System.out.print("  " + root.data);
            printPostOrder(root.left);
            printPostOrder(root.right);
        }
    }

}
