package com.cguo.thread.lock;

public class Producer implements Runnable {
	private Resource res;
	
	Producer(Resource res){
		this.res = res;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				res.set("��Ʒ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
