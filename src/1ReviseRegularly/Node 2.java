package Tree;

/**
 Unlike Array and Linked List, which are linear data structures, tree is hierarchical (or non-linear) data structure.

 1) The maximum number of nodes at level ‘l’ of a binary tree is 2l-1.
 2) Maximum number of nodes in a binary tree of height ‘h’ is 2h – 1.
 3) In a Binary Tree with N nodes, minimum possible height or minimum number of levels is  [Log2(N+1)].
 4) A Binary Tree with L leaves has at least   [ Log2L ] + 1  levels.
 5) In Binary tree, number of leaf nodes is always one more than nodes with two children.
 6) In a Full Binary, number of leaf nodes is number of internal nodes plus 1
        L = I + 1
        Where L = Number of leaf nodes, I = Number of internal nodes
 7) A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2h – 1 node.
 8) A binary tree is balanced if height of the tree is O(Log n) where n is number of nodes.
*/


public class Node {
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
