import java.util.*;
import java.lang.*;

public class BSTtest
{
	public static void main(String args[]){

		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(50); 
	    tree.insert(30); 
	    tree.insert(20); 
	    tree.insert(40); 
	    tree.insert(70); 
	    tree.insert(60); 
	    tree.insert(80); 
	  
	     // print inorder traversal of the BST 
	    tree.printDesc();

	    //deletes specific node in tree
	    tree.delete(40);

	    //prints current tree without deleted node
	    tree.printDesc();


	    //prints sum of all nodes between two numbers starting from the root node
	    System.out.println(tree.rangeSum(tree.root, 10, 65));
	};
}