package kr.ac.sunmoon;

import java.util.ArrayList;

public class BubbleSort {

	public static ArrayList<Integer> bubbleSort(ArrayList<Integer> A)
	{
		int n = A.size();
		
		while(true)
		{
			int newn = 0;
			for(int i=1; i<=n-1; i++)
			{
				if(A.get(i-1) > A.get(i))
				{
					int temp = A.get(i-1);
					A.set(i-1, A.get(i));
					A.set(i, temp);
					newn = i;
				}
			}
			n = newn;
			if(n == 0)
				break;
		}
		
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);	A.add(2);
		A.add(10);	A.add(25);
		A.add(1);	A.add(9);
		A.add(-3);	A.add(100);
		A = bubbleSort(A);
		
		for(int i=0; i<A.size(); i++)
			System.out.println(A.get(i).intValue());
	}

}
