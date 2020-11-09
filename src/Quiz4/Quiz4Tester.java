package Quiz4;

import java.util.Scanner;

public class Quiz4Tester 
{
	public static void main(String[] args)
	{
			testPV();		
	}
	public static void testPV()
	{
		PeaksandValleys pV = new PeaksandValleys();
		
		pV.findPV();
		pV.printAnswer();
	}
	
//	public static void testTopo()
//	{
//		readTopo();
//	}
//	
//	public static void readTopo()
//	{
//		print("Example Projects: a, b, c, d, e, f\n");
//
//		Scanner sc = new Scanner(System.in);
//		sc.useDelimiter("\n");
//		print("Projects: ");
//		// EXAMPLE INPUT: a, b, c, d, e, f
//		String Projs = sc.next();
//		// use default by just pressing enter
//		if (Projs.length() == 1) {
//			Projs = "a, b, c, d, e, f";
//		}
//		char[] projs = new char[(Projs.length() + 2) / 3];
//		for (int i = 0; i < projs.length; i++) {
//			projs[i] = Projs.charAt(i * 3);
//		}
//
//		print("Example Dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)\n");
//		print("Dependencies: ");
//		// EXAMPLE INPUT: (a, d), (f, b), (b, d), (f, a), (d, c)
//		String Deps = sc.next();
//		// use default by just pressing enter
//		if (Deps.length() == 1) {
//			Deps = "(a, d), (f, b), (b, d), (f, a), (d, c)";
//		}
//		char[] deps = new char[(Deps.length() + 2) / 7 * 2];
//		int k = 0;
//		for (int i = 0; i < deps.length / 2; i++) {
//			deps[k] = Deps.charAt(i * 8 + 1);
//			deps[k + 1] = Deps.charAt(i * 8 + 4);
//			k += 2;
//		}
//
//		// NOTE COULD HAVE TWO SEPARATE ARRAYS OF X's AND Y's.
//		char[] X = new char[(Deps.length() + 2) / 7];
//		char[] Y = new char[X.length];
//		for (int i = 0; i < X.length; i++) {
//			X[i] = Deps.charAt(i * 8 + 1);
//			Y[i] = Deps.charAt(i * 8 + 4);
//		}
//		print("X: ");
//		printChars(X);
//		print("Y: ");
//		printChars(Y);
//		
//		char[][] temp = convert2D(projs, X,Y);
//	}
//	public static char[][] convert2D(char[] projects, char[] x, char[] y)
//	{
//		int length = projects.length;
//		char[][] temp = new char[length][length];
//		int tempIndex = 0;
//		for(int i = 0; i < x.length; i++)
//		{
//			tempIndex = findIndex(projects, x[i]);	// index in projects
//			
//		}
//	}
//	
//	public static int findIndex(char[] projects, char temp)
//	{
//		int index = 0;
//		for(int i = 0; i < projects.length; i++)
//		{
//			if(projects[i] == temp)
//			{
//				index = i;
//				break;
//			}
//			
//		}
//		
//		return index;
//	}
//	public static void print(String s) {
//		System.out.print(s);
//	}
//	
//	// Test function
//		public static void printChars(char[] chars) {
//			for (int i = 0; i < chars.length; i++) {
//				print("" + chars[i]);
//			}
//			print("\n");
//		}
}
