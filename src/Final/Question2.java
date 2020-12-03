package Final;
public class Question2 
{
	public static void main(String[] args)
	{
		int testArr[] = {-1, 100, -200, -200, -200, -200};
		int results[] = contigSeqMax(testArr);
		
		String seq = "";
		for(int i = results[0]; i <= results[1]; i++)
		{
			if(i == results[0])
			{
				seq = "[" + testArr[i];
			}
			else
			{
				seq = seq + ", " + testArr[i];
			}
		}
		seq = seq + "]";
		
		String arrStr = "";
		for(int i = 0; i < testArr.length; i++)
		{
			if(i == 0)
			{
				arrStr = "[" + testArr[i];
			}
			else
			{
				arrStr = arrStr + ", " + testArr[i];
			}
		}
		
		arrStr = arrStr + "]";
		
		System.out.println(arrStr);
		System.out.println("Output: " + results[2] + " where the sequence would be " + seq);
	}
	
	public static int[] contigSeqMax(int[] arr)
	{
		int[] values = new int[3]; //start index, end index, sum
		int knownMax = Integer.MIN_VALUE;
		int maxHere = 0;
		int start = 0;
		int end = 0;
		int temp = 0;
		
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
		
		values[0] = start;
		values[1] = end;
		values[2] = knownMax;
		
		return values;
	}
}
