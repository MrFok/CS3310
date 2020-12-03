package Final;
public class Question4 
{
	public static void main(String[] args)
	{
		int testArr[][] = {{ 2,  1, -3, -4,  -7},
			               { -1,  4,  2,  4,  1},
			               { 2, -2, -1,  9, -8},
			               {-3,  3,  -2,  4,  -4}};

		Question4 test = new Question4();
		SubArrResult ans = test.getMaxSubArr(testArr);
		System.out.println(ans.toString(testArr));
	}
	
	SubArrResult getMaxSubArr(int input[][])
	{
		int rows = input.length;
		int cols = input[0].length;
		int[] testingArr = new int[rows];
		SubArrResult results = new SubArrResult();
		
		for(int l = 0; l < cols; l++)
		{
			for(int tmp = 0; tmp < rows; tmp++)
			{
				testingArr[tmp] = 0;
			}
			
			for(int r = l; r < cols; r++)
			{
				for(int tmp2 = 0; tmp2 < rows; tmp2++)	//filling testingArr
				{
					testingArr[tmp2] += input[tmp2][r];
				}
				KadaneResult contigResult = contigSeqMax(testingArr);
				
				if(contigResult.sum > results.maxSum)
				{
					results.maxSum = contigResult.sum;
					results.maxLeft = l;
					results.maxRight = r;
					results.maxDown = contigResult.end;
					results.maxUp = contigResult.start;
				}
			}
		}
		
		return results;
	}
	
	KadaneResult contigSeqMax(int[] arr)
	{
		int knownMax = Integer.MIN_VALUE;
		int maxHere = 0;
		int start = 0;
		int end = 0;
		int temp = 0;
		KadaneResult result;
		
		for(int i = 0; i < arr.length; i++)
		{
			maxHere += arr[i];
			
			if(knownMax < maxHere)
			{
				knownMax = maxHere;
				start = temp;
				end = i;
			}
			
			if(maxHere < 0)
			{
				maxHere = 0;
				temp = i + 1;
			}
		}
		
		result = new KadaneResult(knownMax, start, end);
		
		return result;
	}
}

class SubArrResult	//stores values for getMaxSubArr
{
	int maxSum;
    int maxLeft;
    int maxRight;
    int maxUp;
    int maxDown;
    
    public String toString(int[][] arr) 
    {
    	String temp = "";
    	
    	for(int i = maxUp; i <= maxDown; i++)
    	{
    		temp = temp + "[";
    		for(int j = maxLeft; j < maxRight; j++)
    		{
    			temp = temp + arr[i][j] + ", ";
    		}
    		temp = temp + arr[i][maxRight] + "]\n";
    	}
    	
    	temp = temp + "\nMax Sum = " + maxSum;
    	return temp; 
    }
}

class KadaneResult	//stores values for contigSeqMax
{
	int sum;
    int start;
    int end;
    public KadaneResult(int sum, int start, int end) 
    {
        this.sum = sum;
        this.start = start;
        this.end = end;
    }
}