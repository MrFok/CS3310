package main;

public class Matrix
{
	private int threshold;
	private int[][] a, b;
	private int [][] result;
	private int n;

	public Matrix(int n, int[][] aIn, int[][] bIn)
	{
		a = new int[n][n];
		b = new int[n][n];
		result = new int[n][n];
		threshold = 2;
		this.n  = n;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++) 
			{
				this.a[i][j] = aIn[i][j];
				this.b[i][j] = bIn[i][j];
			}		
		}	

	}

	public int[][] stdCalculate(int[][] a, int[][] b, int d)
	{
		int[][] result = new int[d][d];
		for(int i = 0; i < d; i++)
		{
			for(int j = 0; j < d; j++)
			{
				result[i][j] = 0;
				for(int k = 0; k < d; k++)
				{
					result[i][j] = result[i][j] + a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

	public void calculate()
	{
		if(n <= threshold)
			result = stdCalculate(a, b, n);
		else
			result = strassenCall(a, b);
	}

	private int[][] strassenCall(int[][] a, int[][] b)
	{
		int l = a.length;
		int[][] out = new int[l][l];	//output matrix

		if(l == 2)
			return stdCalculate(a, b, l);

		int[][] a11 = new int[l / 2][l / 2];	//first matrix (a)
		int[][] a12 = new int[l / 2][l / 2];
		int[][] a21 = new int[l / 2][l / 2];
		int[][] a22 = new int[l / 2][l / 2];

		int[][] b11 = new int[l / 2][l / 2];	//second matrix (b)
		int[][] b12 = new int[l / 2][l / 2];
		int[][] b21 = new int[l / 2][l / 2];
		int[][] b22 = new int[l / 2][l / 2];

		split(a, a11, 0, 0);				//creates sub-arrays of a
		split(a, a12, 0, l/2);
		split(a, a21, l/2, 0);
		split(a, a22, l/2, l/2);	

		split(b, b11, 0, 0);				//creates sub-arrays of b
		split(b, b12, 0, l/2);
		split(b, b21, l/2, 0);
		split(b, b22, l/2, l/2);	

		int[][] m1 = strassenCall(add(a11, a22), add(b11, b22));
		int[][] m2 = strassenCall(add(a21, a22), b11);
		int[][] m3 = strassenCall(a11, subtract(b12, b22));
		int[][] m4 = strassenCall(a22, subtract(b21, b11));
		int[][] m5 = strassenCall(add(a11, a12), b22);
		int[][] m6 = strassenCall(subtract(a21, a11), add(b11, b12));
		int[][] m7 = strassenCall(subtract(a12, a22), add(b21, b22));

		int[][] c11 = add(subtract(add(m1, m4), m5), m7);
		int[][] c12 = add(m3, m5);
		int[][] c21 = add(m2, m4);
		int[][] c22 = add(subtract(add(m1, m3), m2), m6);


		join(c11, out, 0, 0);
		join(c12, out, 0, l / 2);
		join(c21, out, l / 2, 0);
		join(c22, out, l / 2, l / 2);

		return out;
	}

    public void split(int[][]ref, int[][] subA, int st, int end) 
    {
        for(int i1 = 0, i2 = st; i1 < subA.length; i1++, i2++)
            for(int j1 = 0, j2 = end; j1 < subA.length; j1++, j2++)
                subA[i1][j1] = ref[i2][j2];    
    }

    public void join(int[][] subA, int[][] finalA, int e1, int e2) 
    {
        for(int i1 = 0, i2 = e1; i1 < subA.length; i1++, i2++)
            for(int j1 = 0, j2 = e2; j1 < subA.length; j1++, j2++)
                finalA[i2][j2] = subA[i1][j1];
    }  

	public int[][] add(int[][] a, int[][] b)
	{
		int[][] temp = new int[a.length][a.length];
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a.length; j++)
			{
				temp[i][j] = a[i][j] + b[i][j];
			}
		}

		return temp;
	}

	public int[][] subtract(int[][] a, int[][] b)
	{
		int[][] temp = new int[a.length][a.length];
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a.length; j++)
			{
				temp[i][j] = a[i][j] - b[i][j];
			}
		}

		return temp;
	}

	public void print(int[][] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print("[ ");
			for(int j = 0; j < a.length; j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println("]");
		}
	}
	public void printMatrix(char input)
	{
		if(input == 'a')
		{
			System.out.println("Size of A is: " + result.length);
			print(a);
			System.out.println();
		}

		else if(input == 'b')
		{
			System.out.println("Size of B is: " + result.length);
			print(b);
			System.out.println();
		}
		else
		{
			System.out.println("Size of Resultant Matrix is: " + result.length);
			print(result);
			System.out.println();
		}
	}


	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
}
