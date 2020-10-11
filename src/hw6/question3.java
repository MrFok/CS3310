package hw6;
// Implement both algorithms for the Binomial Coefficient problem (Algorithms 3.1 and 3.2)
// on your system and study their performances using different problem instances
public class question3
{
	private static long timeForOp;	//operation counter
	
	public static void main (String[] args)
	{
		calculateDC(10,3);
		calculateDC(100,3);
		calculateDC(1000,3);
		calculateDC(2000,3);
		System.out.println();
		calculateDP(10,3);
		calculateDP(100,3);
		calculateDP(1000,3);
		calculateDP(2000,3);
		calculateDP(100000,3);
		calculateDP(1000000,3);
	}
	
	public static void calculateDC(int a, int b)
	{
		timeForOp = 0;
		long startTime = System.currentTimeMillis();
		binDC(a, b);
		long stopTime = System.currentTimeMillis();
		System.out.printf("Divide & Conquer: %d choose %d took %d milliseconds.\n", a, b, (stopTime - startTime));
	}
	
	public static void calculateDP(int a, int b)
	{
		timeForOp = 0;
		long startTime = System.currentTimeMillis();
		binDP(a, b);
		long stopTime = System.currentTimeMillis();
		System.out.printf("Dynamic Programming: %d choose %d took %d milliseconds.\n", a, b, (stopTime - startTime));
	}
	
	public static int binDC(int n, int k)
	{
		if(k == 0 || n == k)
		{
			return 1;
		}
		else
			return binDC(n - 1, k - 1) + binDC(n - 1, k);
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
