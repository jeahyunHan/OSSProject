package kr.ac.sunmoon;

import java.util.ArrayList;

public class MergeSort {

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> A)
	{
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		if(A.size() <= 1)
			return A;
		else
		{
			int middle = A.size()/2;
			for(int i=0; i<middle; i++)
				left.add(A.get(i));
			for(int i=0; i<A.size(); i++)
				right.add(A.get(i));
		
			left = mergeSort(left);
			right = mergeSort(right);
			
			return merge(left,right);
		}
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(left.size()>0 && right.size()>0)
		{
			if(left.get(0) <= right.get(0))
			{
				result.add(left.get(0));
				left.remove(0);
			}
			else
			{
				result.add(right.get(0));
				right.remove(0);
			}
		}
		if(left.size() >0)
			result.addAll(left);
		if(right.size()>0)
			result.addAll(right);
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);	A.add(2);
		A.add(10);	A.add(25);
		A.add(1);	A.add(9);
		A.add(-3);	A.add(100);
		
		A = mergeSort(A);
		
		for(int i=0; i<A.size(); i++)
			System.out.println(A.get(i).intValue());
	}

}
