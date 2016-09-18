package com.org.pushkal;

import java.util.Vector;

public class PandCProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Producer implements Runnable{

	private final Vector<String> sharedQueue;
	private int SIZE;
	
	public Producer(Vector shareQueue , int size) {
	
		this.sharedQueue = shareQueue;
		this.SIZE = size;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
