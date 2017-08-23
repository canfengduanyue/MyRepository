package com.cguo.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程：生产者-消费者模式
 * @author GuoCheng
 *
 */
public class Resource {
	private String name;
	
	private int count = 1;
	
	private boolean flag = false;
	
	private Lock lock = new ReentrantLock();
	
	//一个lock锁，可以支持多个相关的 Condition 对象。
	private Condition condition_c = lock.newCondition();//消费者锁
	
	private Condition condition_p = lock.newCondition();//生产者锁
	
	public void set(String name) throws InterruptedException {
		try {
			lock.lock();//锁定线程
			while(flag) {
				condition_p.await();
			}
			this.name = name + "-----" + count++;
			System.out.println(Thread.currentThread().getName()+"......生产者......"+this.name);
			flag = true;
			condition_c.signalAll();//唤醒线程
		} finally {
			lock.unlock();//线程解锁
		}
		
	}
	
	public void out() throws InterruptedException {
		try {
			lock.lock();
			while(!flag) {
				//condition.await();
				condition_c.await();
			}
			System.out.println(Thread.currentThread().getName()+"......消费者......"+this.name);
			flag = false;
			//condition.signalAll();//唤醒线程
			condition_p.signalAll();//唤醒线程
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
