package Midterm2;

import java.util.concurrent.ThreadLocalRandom;

abstract class solution 
{
	protected int[] values;
	protected int answer;
	protected long time;
	protected int length;
	
	protected long returnTime()	//returns how much time it took to execute
	{
		return time;
	}
	
	protected void setUnSortArray(int[] arr)	//reads in values
	{
		values = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			values[i] = ThreadLocalRandom.current().nextInt(-100, 101);
		}
	}
	
	protected void setSortedArray(int[] arr)	//this method 
	{
		setUnSortArray(arr);
		quickSort(arr, 0, length - 1);
	}
	
	protected void quickSort(int[] arr, int low, int high)	//Implementation from Baeldung 
	{														//https://www.baeldung.com/java-quicksort
		int index = 0;
		
		if(low < high)
		{
			index = partition(arr, low, high);
			
			quickSort(arr, low, index - 1);
			quickSort(arr, index + 1, high);
		}
	}
	
	protected int partition(int arr[], int first, int last)
	{
		int piv = arr[last];
		int i = (first - 1);
		int swapNum = 0;
		
		for(int j = first; j < last; j++)
		{
			if(arr[j] <= piv)
			{
				i++;
				swapNum = arr[i];
				arr[i] = arr[j];
				arr[j] = swapNum;	
			}
		}
		
		swapNum = arr[i + 1];
		arr[i + 1] = arr[last];
		arr[last] = swapNum;
		
		return i + 1;
	}
	
	
	protected void readSum(int ans)		//reads in the sum
	{
		answer = ans;
	}
	
	public int[] getValues() {
		return values;
	}
	
	public int getValue(int index) {
		return values[index];
	}

	public void setValues(int[] values) {
		this.values = values;
	}
	
	public int getLength()
	{
		return length;
	}
	
}
