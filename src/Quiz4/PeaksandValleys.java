package Quiz4;

import java.util.concurrent.ThreadLocalRandom;

public class PeaksandValleys 
{
	private int[] arr;
	private int length;
	private int[] pvArr;
	
	public PeaksandValleys()	//constructor
	{
		length = ThreadLocalRandom.current().nextInt(5, 21);
		arr = new int[length];
		pvArr = new int[length];
		
		fillArray();
	}
	
	public void findPV()
	{
		sort(arr, 0, (arr.length - 1));
		
		int max = length - 1;
		int min = 0;

		for(int i = 0;(max >= min) && (i < length);i++)	//while max is not less than min
		{
			if(max == min)
			{
				pvArr[i] = arr[min];
			}
			else
			{
				pvArr[i] = arr[min];
				i++;
				pvArr[i] = arr[max];	
				max--;
				min++;
			}
		}
	}
	
	
	//Implementation from GeeksForGeeks
	// MergeSort: Every-Case Time Complexity: O(n*logn)
	public void merge(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;
		
	
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        int i = 0, j = 0; 

        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            {
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
	}
	public void sort(int arr[], int l, int r) 
    { 
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr, m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
	
	public void fillArray()
	{
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = ThreadLocalRandom.current().nextInt(-20, 21);
		}
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void printArr(int[] arr)
	{
		int numPrinted = 0;
		for(int i = 0; i < length; i++)
		{
			if(numPrinted == 10)
			{
				System.out.printf("}\n{ %d", arr[i]);
				numPrinted = 1;
			}
			else if (numPrinted == 0)
			{
				numPrinted++;
				System.out.printf("{ %d ", arr[i]);
			}
			else
			{
				numPrinted++;
				System.out.printf("%d ", arr[i]);
			}
			
		}
		System.out.printf("}\n");
	}
	
	public void printAnswer()
	{
		System.out.printf("Generated Array\n");
		printArr(arr);
		System.out.printf("\nPeaks and Valleys Array:\n");
		printArr(pvArr);
	}
	
}
