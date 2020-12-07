import java.util.*;
import java.lang.*;

public class BinarySearchTree{

	public class Node {
		int data;
		Node left;
		Node right;

		public Node(int val){
			this.data = val;
			this.left = null;
			this.right = null;
		}

	}

	public static Node root;

	public BinarySearchTree(){
		root = null;
	}

	public boolean find(int key){
		return find(root,key);
	}

	protected boolean find(Node node, int key){
		if (node == null)
			return false;
		if (key == node.data)
			return true;
		else if (key < node.data)
			return find(node.left, key);
		else
			return find(node.right, key);
	}

	public void insert(int data){
		root = insert(root, data);
		// if(root == null){
		// 	root = new Node(data);
		// } else{
		// 	if(root.data > data){
		// 		root.right = new Node(data);
		// 	} else{
		// 		root.left = new Node(data);
		// 	}
		// }
	}

	protected Node insert(Node node, int key){
		if (node == null)
			return new Node(key);
		if (key < node.data)
			node.left = insert(node.left, key);
		else
			node.right = insert(node.right, key);
		return node;
	}

	public void delete(int data){
		root = delete(root, data); //start with root
	}

	public int removeSmallest(Node node){ //helper funtion for other delete function below
		if (node.left.left == null){
			int smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		} else {
			return removeSmallest(node.left);
		}
	}

	protected Node delete(Node node, int key){ //delets specific root and promotes children as next root
		if (node == null) //base case if the key is not found
			return null;
		if (node.data < key){ //deletes left/right depending on key/node.data
			node.right = delete(node.right, key);
			return node;
		} else if (node.data > key){
			node.left = delete(node.left, key);
			return node;
		} else{ //key equals to the current node data
			if (node.left == null) //if node has one child, promotes that child as parent
				return node.right;
			else if (node.right == null)
				return node.left;
			else { //promote in-order successor
				if (node.right.left == null){
					node.data = node.right.data;
					node.right = node.right.right;
				} else{
					node.data = removeSmallest(node.right);
				}
				return node;
			}
		}
	}

	public int rangeSum(Node root, int left, int right){
		int ans = 0;

		Stack<Node> stack = new Stack();
		stack.push(root);

		while(!stack.isEmpty()){

			Node node = stack.pop();

			if(node != null) {

				if (left <= node.data && node.data <= right)
					ans += node.data;

				if (left < node.data)
					stack.push(node.left);

				if (node.data < right)
					stack.push(node.right);	
			}
		}

		return ans;
	}

	public void printDesc(){
		printDesc(root);
	}

	public void printDesc(Node root){
		if (root != null){
			printDesc(root.left);
			System.out.println(root.data);
			printDesc(root.right);
		}
	}
	
	
}