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
		//Testing Tree Sort
//		int[] valueArr = {8, 3, 5, 7, 11, 14, 13, 2};
//
//		TreeSort tree = new TreeSort(valueArr);
//		tree.createBTree();
//		tree.print();
		
		int[] arr1 = new int[16];
		int[] arr2 = new int[(int)Math.floor(1 + Math.random() * 1000)];
		int[] arr3 = new int[(int)Math.floor(1 + Math.random() * 1000)];
		
		for(int i = 0; i < arr1.length; i++)
		{
			arr1[i] = (int)Math.floor(1 + Math.random() * 20);
		}
		
		for(int i = 0; i < arr2.length; i++)
		{
			arr2[i] = (int)Math.floor(1 + Math.random() * 20);
		}
		
		for(int i = 0; i < arr3.length; i++)
		{
			arr3[i] = (int)Math.floor(1 + Math.random() * 20);
		}
		
		TreeSort t1 = new TreeSort(arr1);
		TreeSort t2 = new TreeSort(arr2);
		TreeSort t3 = new TreeSort(arr3);
		
		t1.createBTree();
		t2.createBTree();
		t3.createBTree();
	
		System.out.println("Array 1 (" + t1.getLength() + "): Basic Operations = " + t1.getNumOfOps());
		System.out.println("Array 2 (" + t2.getLength() + "): Basic Operations = " + t2.getNumOfOps());
		System.out.println("Array 3 (" + t3.getLength() + "): Basic Operations = " + t3.getNumOfOps());
	}
}