package com.cguo.thread;
/**
 * setDaemon()守护线程
 * join() 等待线程终止
 * @author GuoCheng
 *
 */
public class ThreadJoinDemo2 implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		ThreadJoinDemo2 d = new ThreadJoinDemo2();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		Thread t3 = new Thread(d);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		for(int i=0;i<100;i++) {
			System.out.println(">>>>>.....................main.........................."+i);
		}
			
	}
	
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"....run...."+i);
		}
	}
}
