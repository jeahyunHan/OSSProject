package kr.ac.sunmoon;

import java.util.ArrayList;
import java.util.Random;

public class WhoIsBetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>();
		Random random = new Random();
		for(int i=0; i<50000; i++)
			A.add(random.nextInt(50000));
		
		long start, end, time;
		
		start = System.currentTimeMillis();
		A = BubbleSort.bubbleSort(A);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Buvvle sorting: " + time);
		
		start = System.currentTimeMillis();
		A = BubbleSort.bubbleSort(A);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Merge sorting: " + time);
	}

}
