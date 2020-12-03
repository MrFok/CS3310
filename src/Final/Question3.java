package Final;
public class Question3
{
	Node tree, subTree, failSubTree;
	boolean isSame(Node root1, Node root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		
		if(root1 == null || root2 == null)
		{
			return false;
		}
		
		return (root1.data == root2.data && isSame(root1.left, root2.left) && isSame(root1.right, root2.right));
	}
	
	boolean inTree(Node theTree, Node theSubTree)
	{
		if(theSubTree == null)
		{
			return false;
		}
		
		if(theTree == null)
		{
			return false;
		}
		
		if(isSame(theTree, theSubTree))
		{
			return true;
		}
		
		return inTree(theTree.left, theSubTree) || inTree(theTree.right, theSubTree);
	}
	
	public static void main(String[] args)
	{
		Question3 test = new Question3();
		
		/* 
			        10 
			       /   \ 
			      17      5
			     /    \     \ 
			    4      8     3 
			     \ 
			      11  
		 */
		test.tree = new Node(10);
		test.tree.right = new Node(5); 
		test.tree.right.right = new Node(3); 
		test.tree.left = new Node(17); 
		test.tree.left.left = new Node(4); 
		test.tree.left.left.right = new Node(11); 
		test.tree.left.right = new Node(8); 
		
		/*
					   17 
			         /    \ 
			         4     8 
			          \ 
			          11  
        */
		
		test.subTree = new Node(17); 
		test.subTree.right = new Node(8); 
		test.subTree.left = new Node(4); 
		test.subTree.left.right = new Node(11); 
		
		/*
					   10 
			         /    \ 
			        17     4 
			          \ 
			           3 
		*/
		
		test.failSubTree = new Node(10); 
		test.failSubTree.right = new Node(4); 
		test.failSubTree.left = new Node(17); 
		test.failSubTree.left.right = new Node(3); 		
		
		if(test.inTree(test.tree, test.subTree))
		{
			System.out.println("Tree contains Subtree");
		}
		else
		{
			System.out.println("Tree does not contain Subtree");
		}
		
		if(test.inTree(test.tree, test.failSubTree))
		{
			System.out.println("Tree contains failSubTree");
		}
		else
		{
			System.out.println("Tree does not contain failSubTree");
		}
	}
}

class Node
{
	int data;
	Node left, right;
	
	Node(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
}