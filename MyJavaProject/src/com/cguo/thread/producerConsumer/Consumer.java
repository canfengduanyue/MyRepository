package com.cguo.thread.producerConsumer;

public class Consumer implements Runnable {
	private Resource res;
	
	Consumer(Resource res){
		this.res = res;
	}
	@Override
	public void run() {
		while(true) {
			res.out();
		}
	}

}
