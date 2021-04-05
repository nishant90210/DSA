package Test;

import Tree.Node;

public class InvertTree {

    static class TreeNode {

        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);

        int height = getHeight(root);
        for (int level = 1; level <= height; level++) {
            levelOrder(level, root);
        }
        System.out.println();
        System.out.println();
        TreeNode treeNode = invertTree(root);
        for (int level = 1; level <= height; level++) {
            levelOrder(level, treeNode);
        }
    }

    private static void levelOrder(int level, TreeNode root) {

        if (root == null) {
            return;
        }
        else if (level == 1) {
            System.out.print(root.data + " ");
        } else {
            levelOrder(level -1, root.left);
            levelOrder(level -1, root.right);
        }
    }

    private static int getHeight(TreeNode treeNode) {

        if (treeNode == null){
            return 0;
        }
        int left = getHeight(treeNode.left);
        int right = getHeight(treeNode.right);
        return 1 + Math.max(left, right);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.left = invertTree(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.right = invertTree(root.right);
        return root;
    }
}
