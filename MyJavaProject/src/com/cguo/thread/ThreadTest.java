package com.cguo.thread;

public class ThreadTest extends Thread{
	 public static void main(String[] args) {
		 ThreadTest test = new ThreadTest();
		 test.start();
		 ThreadTest test2 = new ThreadTest();
		 test2.start();
		 ThreadTest test3 = new ThreadTest();
		 test3.start();
	}
	 
	@Override
	public void run() {
		for(int i = 0 ; i<100; i++) {
			System.out.println(Thread.currentThread().getName()+"。。。。。。。。"+i);
		}
		
	}
}
