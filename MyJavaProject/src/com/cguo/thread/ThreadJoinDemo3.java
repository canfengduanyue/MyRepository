package com.cguo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * setDaemon()�ػ��߳�
 * join() �ȴ��߳���ֹ
 * @author GuoCheng
 *
 */
public class ThreadJoinDemo3 implements Runnable{
	private CyclicBarrier cb = new CyclicBarrier(4);
	
	public ThreadJoinDemo3(CyclicBarrier cb,String name) {
		super();
		this.cb = cb;
	}
	public static void main(String[] args) throws Exception {
		
		CyclicBarrier cb = new CyclicBarrier(4);
		Thread t1 = new Thread(new ThreadJoinDemo3(cb,"һ�Ŵ���"));
		Thread t2 = new Thread(new ThreadJoinDemo3(cb,"���Ŵ���"));
		Thread t3 = new Thread(new ThreadJoinDemo3(cb,"���Ŵ���"));
		t1.start();
		t2.start();
		t3.start();
		cb.await();
		for(int i=0;i<10;i++) {
			System.out.println(">>>>>.....................main.........................."+i);
		}
			
	}
	
	public void run() {
		try {
			for(int i=0;i<100;i++) {
				System.out.println(Thread.currentThread().getName()+"....run...."+i);
			}
			cb.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
