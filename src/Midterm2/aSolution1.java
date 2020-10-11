/***************************************************************
* file: aSolution1
* author: Ricky Fok
* class: CS 3310
*
* assignment: Midterm
* date last modified: 10/9/2020
*
* purpose: brute force solution for sorted array. O(n^2)
****************************************************************/
package Midterm2;

public class aSolution1 extends solution
{
//	int[] values;
//	int answer;
//	int time;
//	int length;
	private int[] answers;	//4 items, 2 pairs of index and value.
	private boolean found;
	
	public aSolution1(int[] arr, int answer)
	{
		setSortedArray(arr);
		readSum(answer);
		this.length = arr.length;
		time = 0;
		answers = new int[2];
		found = false;
	}
	
	public void findAns()
	{
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < length - 1; i++)
		{
			for(int j = i + 1; j < length; j++)
			{
				if(values[i] + values[j] == answer)
				{
					slotAns(i,j);
					found = true;
				}
			}
		}
		long stopTime = System.currentTimeMillis();
		time = stopTime - startTime;
	}
	
	public void slotAns(int a, int b)	//places answers into answers array
	{
		answers[0] = a;	//index of first answer value	
		answers[1] = b;	//index of second answer value	

	}
	
	public void printAns()	//prints out array
	{
		if(found == false)
			System.out.printf("AS1: Array Length %d: No results", length);
		else
		{
			System.out.printf("AS1:Array Length %d: %d and %d make up %d.", length, answers[0], answers[1], answer);
			System.out.printf("\nTook %d milliseconds\n", time);
		}
		
		if(length <= 100)
			printArray();
		
	}
}
