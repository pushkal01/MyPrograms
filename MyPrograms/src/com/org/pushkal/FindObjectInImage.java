package com.org.pushkal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindObjectInImage {
    static int arr[][] ;;
    static int rowSize = 8;
    static int columnSize = 9;
    int size;
    static int aaa[] ;
    static List<String> area = new LinkedList<String>();
//    static int aaa[] = {1,1,4,0,2,1,3,0,3,1,7,0,3,1,5,0,4,1,10,0};//6x7
//    static int aaa[] = {6,0,3,1,2,0,1,1,1,0,1,1,2,0,3,1,6,0};//5x5
//    static int aaa[] = {11,0,2,1,2,0,3,1,7,0,2,1,10,0,17,1,3,0,4,1,2,0,3,1,6,0};//8x9
    int bb[] = {1,4,2,3,3,7,5,4,10};
//    static List<Integer[]> area = new LinkedList<Integer[]>();
//    List<Set<String>>  objects = new ArrayList<Set<String>>();
    public static void main(String aa[])
    {
//    	aaa = new int[] {191,0,2,1,97,0,4,1,4,0,2,1,92,0,3,1,98,0,3,1,3,0,3,1,92,0,3,1,3,0,3,1,78,0,8,1,11,0,4,1,77,0,9,1,13,0,1,1,78,0,9,1,7,0,4,1,82,0,8,1,7,0,5,1,81,0,8,1,7,0,2,1,1,0,2,1,80,0,8,1,8,0,5,1,81,0,7,1,7,0,5,1,85,0,1,1,1,0,2,1,99,0,3,1,91,0,9,1,91,0,10,1,93,0,5,1,1,0,2,1,93,0,8,1,93,0,8,1,92,0,9,1,95,0,7,1,94,0,6,1,94,0,7,1,91,0,10,1,92,0,8,1,94,0,1,1,2,0,3,1,94,0,1,1,2350,0};
    	aaa = new int[] {11,0,2,1,2,0,3,1,7,0,2,1,10,0,17,1,3,0,4,1,2,0,3,1,6,0};//8x9
//    	aaa = new int[]{16,0};
//        System.out.println(pixelValue(new int[]{51, 101}, aaa));
        System.out.println(pixelValue(new int[]{8, 9}, aaa));
    }
    
    public static int pixelValue(int[] input1,int[] input2)
    {
    	FindObjectInImage f = new FindObjectInImage();
    	rowSize = input1[0];
    	columnSize = input1[1];
        arr = new int[input1[0]][input1[1]];
        aaa = input2;
        f.fillArray(aaa, rowSize, columnSize);
        System.out.println(area);
        return f.getObjectInImage(f);
    }
    public int getObjectInImage(FindObjectInImage f)
    {
    	for (int i=0;i<rowSize;i++)
        {
            for (int j=0;j<columnSize;j++)
            {
                System.out.print(f.arr[i][j]+" ");
            }
            System.out.println();
        }
        f.size = area.size();
        int noOfObjecs = 0;
        for (int i= 0 ; i<f.size;i++)
        {
            String index[] = area.get(i).split(",");
            int row = Integer.parseInt(index[0]);
            int column = Integer.parseInt(index[1]);
            arr[row][column] = 0;
            f.getTop(row, column);
            f.getBottom(row, column);
            f.getLeft(row, column);
            f.getRight(row, column);
            
            noOfObjecs++;
        }
        return noOfObjecs;
    }
    
    public  void fillArray(int ar[],int row, int column)
    {
        int y = 0;
        int tempRow = 0;
        int sum = 0;
        for (int i=0;i<aaa.length;i+=2)
        {
            sum = sum + aaa[i];
            for(int j=0;j<aaa[i];j++)
            {
                if(y-1 == columnSize-1)
                {
                    y = 0;
                    tempRow++;
                }
                if (tempRow<rowSize)
                {
	                arr[tempRow][y] = aaa[i+1];
	                if (aaa[i+1] == 1)
	                {
	                    area.add(tempRow+","+y);
	                }
                }
                y++;
            }
        }
    }
    
    public void getLeft(int row, int column)
    {
        column =  column - 1;
        recursiveCall(row, column);
    }
    public void getRight(int row, int column)
    {
        column =  column + 1;
        recursiveCall(row, column);
    }
    public void getTop(int row, int column)
    {
        row = row - 1;
        recursiveCall(row, column);
    }
    public void getBottom(int row, int column)
    {
        row = row + 1;
        recursiveCall(row, column);
    }
    
    public void recursiveCall(int row,int column)
    {
        if (row !=-1 && column != -1 && row< rowSize && column<columnSize && arr[row][column] == 1)
        {
            arr[row][column] = 0;
            area.remove(row+","+column);
            size--;
            this.getTop(row, column);
            this.getBottom(row, column);
            this.getLeft(row, column);
            this.getRight(row, column);
        }
    }
}