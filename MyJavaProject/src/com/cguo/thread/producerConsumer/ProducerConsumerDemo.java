package com.cguo.thread.producerConsumer;


public class ProducerConsumerDemo {
	public static void main(String[] args) {
		
		Resource resource = new Resource();
		Producer p = new Producer(resource);
		Consumer c = new Consumer(resource);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
