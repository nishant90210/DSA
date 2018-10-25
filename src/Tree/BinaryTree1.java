package Tree;


public class BinaryTree1 {

	// Node -> key(data)
	//		-> children (left and right child)

	Node root;

	public void add(int data) {
		Node nodeToAdd = new Node(data);

		if (root == null) {
			root = nodeToAdd;
			System.out.println("Root " + root.data);
		}

		traverseAndAddNode(root, nodeToAdd);
	}

	public void traverseAndAddNode(Node node, Node nodeToAdd) {

		if (nodeToAdd.data > node.data) {
			if (node.right == null) {
				node.right = nodeToAdd;
				System.out.println("Right Child" + nodeToAdd.data);
			} else {
				traverseAndAddNode(node.right, nodeToAdd);
			}

		} else if (nodeToAdd.data < node.data) {
			if (node.left == null) {
				node.left = nodeToAdd;
				System.out.println("Left Child" + nodeToAdd.data);
			} else {
				traverseAndAddNode(node.left, nodeToAdd);
			}
		}

	}

	public Node find(int val) {

		if (root != null) {
			return findNode(root, val);
		}
		return null;

	}

	private Node findNode(Node search, int val) {

		if (search == null) {
			return null;
		}
		if (search.data == val) {
			System.out.println();
			System.out.println(search.data);
			return search;
		} else if (search.data > val) {
			Node findNode = findNode(search.left, val);
			return findNode;
		} else if (search.data < val) {
			Node findNode = findNode(search.right, val);
			return findNode;
		}

		return null;
	}

	public void traverse(Node root) {
		// IN, PRE, POST Order traversal
		System.out.println();
		System.out.print("Inorder Traversal : -> ");
		if (root != null) {
			Node nodeToTraverse = root;

			if (nodeToTraverse.left == null && nodeToTraverse.right == null) {
				System.out.println("Only Root Element Exist " + nodeToTraverse.data);
			}
			inOrderTraversal(nodeToTraverse);
		} else {
			System.out.println("Empty Tree");
		}
	}

	private void inOrderTraversal(Node node) {

		if (node.left != null) {
			inOrderTraversal(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inOrderTraversal(node.right);
		}
	}

	public Node traverseAndAddNodeIterative(Node nodeToAdd) {

		if (root == null) {
			root = nodeToAdd;
			return root;
		}
		Node node = root;
		while (true) {
			if (node.data > nodeToAdd.data) {
				if (node.left != null) {
					node = node.left;
				} else {
					node.left = nodeToAdd;
					break;
				}
			}
			if (node.data < nodeToAdd.data) {
				if (node.right != null) {
					node = node.right;
				} else {
					node.right = nodeToAdd;
					break;
				}
			}
		}
		return node;
	}

	private Node deleteKey(Node root, int key) {
		// case 1: Node has no children
		// case 2: Node has one child
		// case 3: Node has two children --> Find minimum value in right sub-tree OR maximum in left sub-tree ,copy the value in place of
		//									 deleted node value and delete duplicate from right subtree

		if (root == null) {
			return null;
		}
		if (root.data > key) {
			root.left = deleteKey(root.left, key);
		} else if (root.data < key) {
			root.right = deleteKey(root.right, key);
		} else {
			// if nodeToBeDeleted have both children
			if (root.left != null && root.right != null) {
				//finding the min value in right subtree
				root.data = minVal(root.right);
				// Deleting minimum node from right and attaching it as right sub tree
				root.right = deleteKey(root.right, root.data);

			} else if (root.left != null) {
				// if nodeToBeDeleted has only left child
				root = root.left;

			} else if (root.right != null) {
				// if nodeToBeDeleted has only right child
				root = root.right;
			} else {
				// if nodeToBeDeleted do not have child (Leaf node)
				root = null;
			}
		}
		return root;
	}

	public static void main(String[] args) {

		BinaryTree1 tree = new BinaryTree1();
//		binaryTree.traverseAndAddNodeIterative(new Node(4));
//        binaryTree.traverseAndAddNodeIterative(new Node(3));
//        binaryTree.traverseAndAddNodeIterative(new Node(5));
//        binaryTree.traverseAndAddNodeIterative(new Node(9));
//        binaryTree.traverseAndAddNodeIterative(new Node(7));
//        binaryTree.traverseAndAddNodeIterative(new Node(2));
//        binaryTree.traverseAndAddNodeIterative(new Node(1));

//        binaryTree.traverse();


		tree.add(50);
		tree.add(30);
		tree.add(20);
		tree.add(40);
		tree.add(70);
		tree.add(60);
		tree.add(80);
		tree.traverse(tree.root);

		System.out.println("\nDelete 30");
		Node node = tree.deleteKey(tree.root, 70);

		tree.traverse(node);
//		binaryTree.find(9);

	}

	private int minVal(Node root) {

		int minVal = root.data;
		while (root.left != null) {
			minVal = root.left.data;
			root = root.left;
		}
		return minVal;
	}
}