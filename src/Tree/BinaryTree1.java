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


	/* For the deletion of a node in BST, three cases should be considered:

			1. Node to be deleted is leaf:
			- Simply remove from the tree.

                 40                           	     	  40
			   /    \         deleteNode(10)            /    \
			 20      60      --------------->   	 20      60
			/  \    /  \                     	      \     /  \
		   10  30  50  70                             30  50  70

			2. Node to be deleted has only one child:
			- Copy the child to the node and delete the child

              40                            	 		40
			/    \         deleteNode(20)    		   /    \
			20    60      --------------->   		 30     60
			\    /  \                     	       		   /  \
			30  50  70                            		  50  70

			3. Node to be deleted has two children:
			- Find inorder successor of the node.
			- Copy contents of the inorder successor to the node and delete the inorder successor.
			- Note that inorder predecessor can also be used.

				40                                 50
			  /    \         deleteNode(40)      /    \
			30      60      --------------->   30      60
				    /  \                                  \
				   50  70                                 70

			- In this particular case, inorder successor can be obtained by finding the minimum value in right subtree of the node.
	 */
	private Node deleteNode(Node root, int key) {
		// case 1: Node has no children
		// case 2: Node has one child
		// case 3: Node has two children --> Find minimum value in right sub-tree OR maximum in left sub-tree ,copy the value in place of
		//									 deleted node value and delete duplicate from right subtree

		if(root == null) {
			return null;
		}

		if(key < root.data) {
			root.left = deleteNode(root.left, key);
		}
		else if(key > root.data) {
			root.right = deleteNode(root.right, key);
		}
		else {
			if(root.left == null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			root.data = minVal(root.right);
			root.right = deleteNode(root.right, root.data);
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

		System.out.println("\nDelete 70");
		Node node = tree.deleteNode(tree.root, 70);

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