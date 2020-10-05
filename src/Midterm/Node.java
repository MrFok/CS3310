/***************************************************************
* file: Node
* author: Ricky Fok
* class: CS 3310
*
* assignment: Midterm
* date last modified: 10/9/2020
*
* purpose: Implementation of a Node for the setup for trees
****************************************************************/
package Midterm;

public class Node
{
	private int data;	//data in node
	private Node left, right;	//left and right nodes

	public Node(int dataPortion)	//default constructor
	{
		this(dataPortion, null, null);
	}

	public Node(int dataPortion, Node leftNode, Node rightNode)	//constructor
	{
		data = dataPortion;
		leftNode = null;
		rightNode = null;
	}

	public int getData()	//returns data
	{
		return data;
	}

	public void setData(int newData)	//sets data
	{
		data = newData;
	}

	public void setLftNode(Node nextNode)	//sets left node
	{
		left = nextNode;
	} 

	public void setRgtNode(Node nextNode)	//set right node
	{
		right = nextNode;
	}

	public Node getLftNode()	//gets left node
	{
		return left;
	} 

	public Node getRgtNode()	//gets right node
	{
		return right;
	}
}