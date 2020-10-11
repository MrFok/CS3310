/***************************************************************
* file: aSolution2
* author: Ricky Fok
* class: CS 3310
*
* assignment: Midterm
* date last modified: 10/9/2020
*
* purpose: implementation of boolean array solution with sorted array, O(n)
****************************************************************/

package Midterm2;

public class aSolution2 extends solution
{
//	int[] values;
//	int answer;
//	int time;
//	int length;
	private int[] valueArr;
	private int[] answers;	//4 items, 2 pairs of index and value.
	private boolean found;
	
	public aSolution2(int[] arr, int answer)
	{
		setSortedArray(arr);
		readSum(answer);
		this.length = arr.length;
		time = 0;
		valueArr = new int[201];
		answers = new int[2];
		found = false;
	}
	
	public void setvaluesArr()
	{
		int temp = 0;
		for(int i = 0; i < length; i++)
		{
			temp = values[i];
			valueArr[temp + 100]++;
		}
	}
	
	public void findAns()
	{
		long startTime = System.currentTimeMillis();
		setvaluesArr();
		
		int maxIndex = 0;
		int minValue = 0;
		int x = 0;
		
		for(int index = 0;found != true && index <= 200; index++)
		{
			minValue = index - 100; 
			x = answer - (minValue);	// value to add to minIndex number to get sum
			maxIndex = 100 + x;

			if(x <= 100)
			{
				if(index == maxIndex)	//if odd and adds up same nums for ans, need 2 instances
				{
					if(valueArr[index] >= 2)
					{
						found = true;
						slotAns(minValue, x);
					}
				}
				else if(valueArr[index] >= 1 && valueArr[maxIndex] >= 1)
				{
					found = true;
					slotAns(minValue, x);
				}
			}
			
			
		}
		long stopTime = System.currentTimeMillis();
		time = stopTime - startTime;

	}
	
	public void printAns()
	{
		if(found == false)
			System.out.printf("AS2: Array Length %d: No results", length);
		else
		{
			System.out.printf("AS2:Array Length %d: %d and %d make up %d.", length, answers[0], answers[1], answer);
			System.out.printf("\nTook %d milliseconds\n\n", time);
		}

		printArray();
	}
	
	public void slotAns(int a, int b)	//indexes
	{
		answers[0] = a;	//first answer value
		answers[1] = b;	//2nd answer value
	}
}
