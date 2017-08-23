package com.cguo.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���̣߳�������-������ģʽ
 * @author GuoCheng
 *
 */
public class Resource {
	private String name;
	
	private int count = 1;
	
	private boolean flag = false;
	
	private Lock lock = new ReentrantLock();
	
	//һ��lock��������֧�ֶ����ص� Condition ����
	private Condition condition_c = lock.newCondition();//��������
	
	private Condition condition_p = lock.newCondition();//��������
	
	public void set(String name) throws InterruptedException {
		try {
			lock.lock();//�����߳�
			while(flag) {
				condition_p.await();
			}
			this.name = name + "-----" + count++;
			System.out.println(Thread.currentThread().getName()+"......������......"+this.name);
			flag = true;
			condition_c.signalAll();//�����߳�
		} finally {
			lock.unlock();//�߳̽���
		}
		
	}
	
	public void out() throws InterruptedException {
		try {
			lock.lock();
			while(!flag) {
				//condition.await();
				condition_c.await();
			}
			System.out.println(Thread.currentThread().getName()+"......������......"+this.name);
			flag = false;
			//condition.signalAll();//�����߳�
			condition_p.signalAll();//�����߳�
		}finally {
			lock.unlock();
		}
		
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
