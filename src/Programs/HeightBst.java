package Programs;

import TopInterviewQuestions.BurnBST;

public class HeightBst {

    public static void main(String[] args) {

        BurnBST.Node root = new BurnBST.Node(3);
        root.left = new BurnBST.Node(9);
        root.right = new BurnBST.Node(20);
        root.right.left = new BurnBST.Node(15);
        root.right.right = new BurnBST.Node(7);

        System.out.println(calcHeight(root));
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        int i = leftHeight - rightHeight;
        if (Math.abs(i) <= 1){
            System.out.println("balanced");
        }else {
            System.out.println("not");
        }
    }

    private static int calcHeight(BurnBST.Node root) {

        if (root == null){
            return 0;
        }
        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = 1 + Math.max(left, right);
        return height;
    }
}
