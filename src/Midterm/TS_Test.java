package Midterm;

public class TS_Test 
{
	public static void main(String[] args)
	{
		int[] valueArr = {1, 8, 3, 5, 7, 11, 14, 13, 2};

		TreeSort tree = new TreeSort(valueArr);
		tree.createBTree();
		Node temp = tree.getRoot();
		tree.print();
	}
}