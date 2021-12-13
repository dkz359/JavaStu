package com.dukz.thread.base.visibility;

/**
 * 可见性证明
 * @author dukezheng
 * @ClassName VisibilityDemo
 * @date 2021/10/27 12:31
 */
public class VisibilityDemo {
	public static void main(String[] args) throws InterruptedException {
		Servcie servcie = new Servcie();
		ThreadA threadA = new ThreadA(servcie);
		ThreadB threadB = new ThreadB(servcie);
		threadA.start();
		threadB.start();
		threadA.join();
		threadB.join();
		System.out.println("结束");
	}
}
class Servcie{
	/**
	 * 不加volatile,end方法修改不可见
	 */
	private boolean flag = true;
	// private volatile boolean flag = true;

	public void start(){
		while (true){
			if(!flag){
				System.out.println("任务停止了。。。");
				break;
			}
		}
	}

	public void end(){
		flag = false;
	}
}

class ThreadA extends Thread{
	private Servcie servcie;
	public ThreadA(Servcie servcie){
		this.servcie = servcie;
	}
	@Override public void run() {
		servcie.start();
	}
}
class ThreadB extends Thread{
	private Servcie servcie;
	public ThreadB(Servcie servcie){
		this.servcie = servcie;
	}
	@Override public void run() {
		System.out.println("停止任务");
		servcie.end();
	}
}
