package kr.or.ddit.thread.pooling;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolingThread {
	public static class PrintNumberJob implements Runnable{
		private int number;
		@Override
		public void run() {
			while(number < 10) {
				System.out.printf("%s - %d\n", Thread.currentThread().getName(), ++number);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static class GenerateJob implements Runnable{
		ThreadPoolExecutor executor;
		public GenerateJob(ThreadPoolExecutor executor) {
			super();
			this.executor = executor;
		}

		@Override
		public void run() {
			while(Thread.activeCount()<100) {
				executor.execute(new PrintNumberJob());
				try {
					Thread.sleep(2000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(5));
		executor.execute(new GenerateJob(executor));
	}
}













