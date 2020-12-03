package MidtermPt3;

//Java program to implement optimized matrix chain multiplication problem. 
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.*; 
import java.io.*; 


class GFG
{ 
	//Matrix Mi has dimension p[i-1] x p[i] for i = 1..n 
	static int MatrixChainOrder(int p[], int n) 
	{ 
	
		/* For simplicity of the program, one extra row and one extra column are 
		allocated in dp[][]. 0th row and 0th column of dp[][] are not used */
		int [][]dp=new int[n][n]; 
	
		/* dp[i, j] = Minimum number of scalar multiplications needed to compute the matrix M[i]M[i+1]...M[j] 
					= M[i..j] where dimension of M[i] is p[i-1] x p[i] */
					
		// cost is zero when multiplying one matrix. 
		
		for (int i=1; i<n; i++) 
			dp[i][i] = 0; 
	
		// Simply following above recursive formula. 
		for (int L=1; L<n-1; L++) 
		for (int i=1; i<n-L; i++)	 
			dp[i][i+L] = Math.min(dp[i+1][i+L] + p[i-1]*p[i]*p[i+L], 
						dp[i][i+L-1] + p[i-1]*p[i+L-1]*p[i+L]);	 
		
		
		return dp[1][n-1]; 
		
	} 

	static int MatrixChainOrderG(int p[], int i, int j)
    {
        if (i == j)
            return 0;
 
        int min = Integer.MAX_VALUE;
 
        // place parenthesis at different places between
        // first and last matrix, recursively calculate
        // count of multiplications for each parenthesis
        // placement and return the minimum count
        for (int k = i; k < j; k++) 
        {
            int count = MatrixChainOrderG(p, i, k)
                        + MatrixChainOrderG(p, k + 1, j)
                        + p[i - 1] * p[k] * p[j];
 
            if (count < min)
                min = count;
        }
 
        // Return minimum count
        return min;
    }
	
	//Driver code 
	public static void main(String args[]) 
	{ 
		Scanner scnr = new Scanner(System.in);
		System.out.printf("Enter Number of Matrices:");
		int length = scnr.nextInt();
		System.out.printf("Enter Range of Values:");
		int btm = scnr.nextInt();
		int top = scnr.nextInt();
		
		int[] arr = new int[length];
		int[] values = new int[top - btm + 1];
		long time = 4000;
		
		int temp = 0;
		for(int i = 0; i < length; i++)
		{
			temp = ThreadLocalRandom.current().nextInt(btm, top + 1);
			for(;values[temp - btm] != 0; values[temp - btm]++)
			{
				temp = ThreadLocalRandom.current().nextInt(btm, top + 1);
			}
			arr[i] = temp;
		}
		
		System.out.printf("Print Matrix Dimensions?  Y or N?");
		String mdInput = scnr.next();
		System.out.printf("Answer: %s\n", mdInput);
		if(mdInput.contains("Y"))
		{
			System.out.printf("Matrix Dimensions: ");
			for(int i = 0; i < length; i++)
				System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		
		// Yaos
		long startTime = System.currentTimeMillis();
		int numOfMulY = MatrixChainOrder(arr, length);	//for n^2
		long stopTime = System.currentTimeMillis();
		time = stopTime - startTime;
		
		System.out.printf("YAO: Min Number of Operations: %d\nTime in Milliseconds: %d\n", numOfMulY, time);
		
		//Godboles
		startTime = System.currentTimeMillis();
		int numOfMulG = MatrixChainOrderG(arr, 1, length - 1);	//for n^3
		stopTime = System.currentTimeMillis();
		time = stopTime - startTime;

		System.out.printf("GODBOLE: Min Number of Operations: %d\nTime in Milliseconds: %d", numOfMulG, time);
						 
	} 
} 
