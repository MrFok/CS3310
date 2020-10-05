/***************************************************************
* file: TS_Tree
* author: Ricky Fok
* class: CS 3310
*
* assignment: Midterm
* date last modified: 10/9/2020
*
* purpose: main method for testing tree sort
****************************************************************/
package Midterm;

public class TS_Test 
{
	public static void main(String[] args)
	{
		int[] valueArr = {8, 3, 5, 7, 11, 14, 13, 2};

		TreeSort tree = new TreeSort(valueArr);
		tree.createBTree();
		Node temp = tree.getRoot();
		tree.print();
	}
}