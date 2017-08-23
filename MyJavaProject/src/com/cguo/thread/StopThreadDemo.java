package com.cguo.thread;

public class StopThreadDemo implements Runnable{
	private boolean flag = true;
	public static void main(String[] args) {
		StopThreadDemo s = new StopThreadDemo();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		t1.start();
		t2.start();
		int i = 0;
		while(true){
			if(i++ == 60) {
				//s.change();
				t1.interrupt();
				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName()+".................run");
		}
		System.out.println(Thread.currentThread().getName()+"..............麼�潦冥疂�.................");
	}
	
	public void change() {
		flag = false;
	}
	
	public synchronized void run() {
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				flag = false;
				System.err.println("。。。。。。error。。。。。");
			}
			System.out.println(Thread.currentThread().getName()+"。。。。。run");
		}
	}
}
