package Quiz4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TopoBuild 
{
	private char[][] dependecies;	//array representing dependecies
	private int numP;				//number of projects
	private List<Character> result;
	private Set<Character> tempMarks, permMarks;
	
	public TopoBuild(char[][] arr, int numOfP)
	{
		store(arr);
		numP = numOfP;
        result = new LinkedList<Character>();
        tempMarks = new HashSet<Character>();
        permMarks = new HashSet<Character>();
	}
	
	public void build()
	{
        for (int i = 0; i < dependecies.length; i++) 
        {
            if (!permMarks.contains(i)) 
            {
                checkD((char)(i+97),tempMarks, permMarks, result);
            }
        }
	}
	
	private void checkD(char currProcess, Set<Character> tempMarks, 
						Set<Character> permMarks, List<Character> result)
	{
        if (tempMarks.contains(currProcess)) 	//if cycle throw error
            throw new RuntimeException("ERROR - Cyclic pattern detected");
        
        if (!permMarks.contains(currProcess)) //if node not visited recurse search
        {
            tempMarks.add(currProcess);
            
            for (int i : dependecies[currProcess]) 
            {
                checkD((char)(i+97), tempMarks, permMarks, result);
            }
            
            permMarks.add(currProcess);		//add perm mark
            tempMarks.remove(currProcess);	//remove temp mark
            result.add(currProcess);		//add to results
        }
	}
	
	public void store(char[][] temp)	//stores char array and also a int array
	{
		for(int i = 0; i < temp.length; i++)
		{
			for(int j = 0; j < temp[i].length; j++)
			{
				dependecies[i][j] = temp[i][j];
			}
		}
	}
	public void printProjects()
	{
		
		int charN = 97;					//prints projects
		char charNC = (char)charN;
		for(int i = 0; i < numP; i++)
		{
			if(i == 0)
				System.out.printf("{ %c ", charNC);
			else
				System.out.printf("%c ", charNC);
			charN++;
			charNC = (char)charN;
		}
		System.out.printf("}\n");
	}
	public void printDependecies()	//ERROR PRONE WATCH OUT
	{
		for(int i = 0; i < numP; i++)
		{
			for(int j = 0; dependecies[i][j] != 0; j++)
			{
				System.out.printf("{%c, %c}, ", dependecies[i][j]);
			}
		}
	}
	public void printFinalOrder()
	{
		System.out.println(result);
//		List<Character> temp = new LinkedList<Character>();
//		for(int i = 0; i < result.size(); i++)
//		{
//			if(i == 0)
//				System.out.printf("%c,", (char)((int)result.get(i)));
//			else
//				System.out.printf(", %c,", (char)((int)result.get(i)));
//		}
	}
	public void printResults()
	{
		System.out.printf("Projects\n--------\n");
		printProjects();
		System.out.printf("Dependecies\n-----------\n");
		printDependecies();
		System.out.printf("\n-----------\n");
		System.out.printf("Resulting Project Order\n-----------------------\n");
		printFinalOrder();
	}
}

