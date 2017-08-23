package com.cguo.thread.producerConsumer;

/**
 * ���̣߳�������-������ģʽ
 * @author GuoCheng
 *
 */
public class Resource {
	private String name;
	
	private int count = 1;
	
	private boolean flag = false;
	
	public synchronized void set(String name) {
		
		while(flag) {
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		this.name = name + "-----" + count++;
		System.out.println(Thread.currentThread().getName()+"......������......"+this.name);
		flag = true;
		this.notifyAll();
	}
	
	public synchronized void out() {
		while(!flag) {
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println(Thread.currentThread().getName()+"......������......"+this.name);
		flag = false;
		this.notifyAll();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
}
