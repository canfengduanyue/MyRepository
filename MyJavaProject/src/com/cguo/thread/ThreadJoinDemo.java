package com.cguo.thread;
/**
 * setDaemon()ÊØ»¤Ïß³Ì
 * join() µÈ´ýÏß³ÌÖÕÖ¹
 * @author GuoCheng
 *
 */
public class ThreadJoinDemo implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		ThreadJoinDemo d = new ThreadJoinDemo();
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		//t1.join();
		t2.start();
	
		
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"¡£¡£¡£¡£"+i);
		}
			
	}
	
	public void run() {
		for(int i=0;i<100;i++) {
			//System.out.println(Thread.currentThread().getName()+"¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£run¡£¡£¡£¡£"+i);
			System.out.println(Thread.currentThread().toString()+"¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£run¡£¡£¡£¡£"+i);
		}
	}
}
