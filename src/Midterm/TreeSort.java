/***************************************************************
* file: Tree Sort
* author: Ricky Fok
* class: CS 3310
*
* assignment: Midterm
* date last modified: 10/9/2020
*
* purpose: Implementation of an integer Tree Sort
* 		 1. tree sort take elements into an array
* 		 2. creates binary tree from array values
* 		 3. Perform in-order traversal on tree to return values in sorted order
****************************************************************/
package Midterm;

public class TreeSort
{
	private Node root;
	private int[] array;
	private int length;

	public TreeSort(int[] arr)
	{
		root = null;
		length = arr.length;
		array = new int[this.length];
		readArr(arr);
	}

	public void createBTree()	//sets up Binary Tree
	{
		int i;
		for(i = 0; i < length; i++)	
		{
			root = slot(root, array[i]);
		}
		System.out.println("Slotted " + i + " times");
	}


	public Node slot(Node root, int value)	//recursive function to insert new value
	{
		if(root == null)	//if tree is empty, then you return a new Node
		{
			root = new Node(value);
			return root;
		}

		if(value < root.getData())		//if value is less than root value
			root.setLftNode(slot(root.getLftNode(), value));
		else if(value > root.getData())	//if value is greater than root value
			root.setRgtNode(slot(root.getRgtNode(), value));

		return root;
	}

	private void printSubTree(Node root)	//In-Order Tree Print
	{
		if(root != null)
		{
			printSubTree(root.getLftNode());
			System.out.print(root.getData() + " ");
			printSubTree(root.getRgtNode());
		}
	}

	public void readArr(int[] arr)
	{
		for(int i = 0; i < length; i++)	
		{
			array[i] = arr[i];
		}
	}

	public void print()
	{
		printSubTree(root);
	}

	public Node getRoot()
	{
		return root;
	}

	public void setRoot(Node r)
	{
		root = r;
	}

}
