package hw6;

//Modify Algorithm 3.2 (Binomial Coefficient Using Dynamic Programming)
//so that it uses only a one-dimensional array indexed from 0 to k.

public class question4
{
	private static long timeForOp = 0;
	
	public static void main (String[] args)
	{
		calculateDP(10,3);
		calculateDP(100,3);
		calculateDP(1000,3);
		calculateDP(2000,3);
		calculateDP(100000,3);
		calculateDP(1000000,3);
		System.out.println();
		calculateDP_OP(10,3);
		calculateDP_OP(100,3);
		calculateDP_OP(1000,3);
		calculateDP_OP(2000,3);
		calculateDP_OP(100000,3);
		calculateDP_OP(1000000,3);
	}
	
	public static void calculateDP(int a, int b)
	{
		timeForOp = 0;
		long startTime = System.currentTimeMillis();
		binDP(a, b);
		long stopTime = System.currentTimeMillis();
		System.out.printf("Dynamic Programming: %d choose %d took %d milliseconds.\n", a, b, (stopTime - startTime));
	}
	
	public static void calculateDP_OP(int a, int b)
	{
		timeForOp = 0;
		long startTime = System.currentTimeMillis();
		binDP_Optimized(a, b);
		long stopTime = System.currentTimeMillis();
		System.out.printf("Dynamic Programming: %d choose %d took %d milliseconds.\n", a, b, (stopTime - startTime));
	}
	
	public static int binDP_Optimized(int n, int k)
	{
		int[] B = new int[k+1];
		
		B[0] = 1;
		for(int i = 1; i <= n; i++)
		{
			for(int j = minimum(i,k); j > 0 ; j--)
			{
				B[j] = B[j] + B[j-1];
			}
		}
		return B[k];
	}
	
	public static int binDP(int n, int k)
	{
		int[][] B = new int[n+1][k+1];
		
		for(int i = 0; i <= n; i++)
		{
			for(int j = 0; j <= minimum(i,k); j++)
			{
				if(j == 0 || j == i)
					B[i][j] = 1;
				else
					B[i][j] = B[i-1][j-1] + B[i-1][j];
			}
		}
		return B[n][k];
	}
	
	private static int minimum(int a, int b)
	{
		if(a < b)
			return a;
		else if (b < a)
			return b;
		else
			return a;
	}
}
