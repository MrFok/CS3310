package main;

public class Q35 
{
	public static void main(String[] args)
	{
		//RANDOM MODIFIER
		int randomLimit = 3;		//default randomLimit value
//		randomLimit = YOUR NUMBER	//change this to change the max power of 2 that the matrix length can randomize to
		int randomizer = (int)(Math.floor(1 + Math.random() * randomLimit));
		int length = (int)Math.pow(2, randomizer);
		length = 8;		//change length of matrices here

		//creating random arrays
		int numLimit = 10;			//default numLimit value
		int[][] a = new int[length][length];
		int[][] b = new int[length][length];
//		numLimit = YOUR NUMBER; 	// change this to increase or decrease the range of numbers put into "a" and "b"

		for(int w = 0; w < length; w++)
		{
			for(int h = 0; h < length; h++)
			{
				a[w][h] = (int)(Math.floor(1 + Math.random() * 10));
				b[w][h] = (int)(Math.floor(1 + Math.random() * 10));
			}
		}

		Matrix matrix = new Matrix(length, a, b);
		matrix.printMatrix('a');

		matrix.printMatrix('b');

		matrix.calculate();

		matrix.printMatrix('c');  //result

	}



}