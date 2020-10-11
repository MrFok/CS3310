/***************************************************************
* file: main
* author: Ricky Fok
* class: CS 3310
*
* assignment: Midterm
* date last modified: 10/9/2020
*
* purpose: main class where problems will be tested and solved
****************************************************************/
package Midterm2;

import java.util.concurrent.ThreadLocalRandom;

public class ProblemTest 
{	
	public static void main(String[] args)
	{
		int[] sortH = new int[100];		//hundreds sorted array
		int[] sortK = new int[100];	//thousands sorted array
		int[] sortHK = new int[100];	//100k sorted array
		int[] sortM = new int[100];	//1M sorted array
		
		int theAnswer = ThreadLocalRandom.current().nextInt(-200, 201);
		
		//test for aSolution1
		aSolution1 a1H = new aSolution1(sortH, theAnswer);
		aSolution1 a1K = new aSolution1(sortK, theAnswer);
		aSolution1 a1HK = new aSolution1(sortHK, theAnswer);
		aSolution1 a1M = new aSolution1(sortM, theAnswer);
		
		printSolutionA1(a1H);
		//printSolutionA1(a1K);
		//printSolutionA1(a1HK);
		//printSolutionA1(a1M);
		System.out.println();
		
		//test for aSolution2
		aSolution2 a2H = new aSolution2(sortH, theAnswer);
		aSolution2 a2K = new aSolution2(sortK, theAnswer);
		aSolution2 a2HK = new aSolution2(sortHK, theAnswer);
		aSolution2 a2M = new aSolution2(sortM, theAnswer);

		printSolutionA2(a2H);
		//printSolutionA2(a2K);
		//printSolutionA2(a2HK);
		//printSolutionA2(a2M);
		System.out.println();
		
		//test for bSolution1
		bSolution1 b1H = new bSolution1(sortH, theAnswer);
		bSolution1 b1K = new bSolution1(sortK, theAnswer);
		bSolution1 b1HK = new bSolution1(sortHK, theAnswer);
		bSolution1 b1M = new bSolution1(sortM, theAnswer);
		
		printSolutionB1(b1H);
		//printSolutionB1(b1K);
		//printSolutionB1(b1HK);
		//printSolutionB1(b1M);
		System.out.println();
		
		//test for bSolution2
		bSolution2 b2H = new bSolution2(sortH, theAnswer);
		bSolution2 b2K = new bSolution2(sortK, theAnswer);
		bSolution2 b2HK = new bSolution2(sortHK, theAnswer);
		bSolution2 b2M = new bSolution2(sortM, theAnswer);
		
		printSolutionB2(b2H);
		//printSolutionB2(b2K);
		//printSolutionB2(b2HK);
		//printSolutionB2(b2M);	
		System.out.println();

	}
	
	static void printSolutionA1(aSolution1 t)
	{
		t.findAns();
		t.printAns();
	}
	
	static void printSolutionA2(aSolution2 t)
	{
		t.findAns();
		t.printAns();
	}
	
	static void printSolutionB1(bSolution1 t)
	{
		t.findAns();
		t.printAns();
	}
	
	static void printSolutionB2(bSolution2 t)
	{
		t.findAns();
		t.printAns();
	}
	
}
