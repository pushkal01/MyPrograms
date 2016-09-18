package com.org.pushkal;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class CandidateNO {

	public static void main(String[] args) {

		int arr[] = {2,2,1,2,2,20,2,61,12,2};
		System.out.println(CompanyRecruitment(arr,4));
	}

	
	public static int CompanyRecruitment(int[] input1,int input2)
    {
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int i=0;i<input1.length;i++)
		{
			if (map.containsKey(input1[i]))
			{
				int x = map.get(input1[i]);
				x = x+1;
				map.put(input1[i], x);
			}
			else
			{
				map.put(input1[i], 1);
			}
		}
		NavigableSet<Integer> nmap = map.descendingKeySet();
		Integer key = 0;
		for (Iterator<Integer> itr = nmap.iterator();itr.hasNext();)
		{
			key = itr.next();
			if (input2 > map.get(key))
				input2 = input2 - map.get(key);
			else
				break;
		}
		
		if (input2 == 0)
			return 1;
		else
		{
			return getnCr(map.get(key), input2);
		}
			
    }
	
	public static int getnCr(int n, int r)
	{
		int finalValue = n;
		
		if (r ==1)
			return finalValue;
		else
		{
			for (int i=n-r-1;i>0;i--)
			{
				finalValue = finalValue*(n-i);
			}
			return finalValue/getFact(r);
		}
	}
	
	public static int getFact(int num)
	{
		int fact = 1;
		for (int i=1;i<=num;i++)
		{
			fact = fact*i;
		}
		
		return fact;
	}
}
