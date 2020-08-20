package kr.or.ddit.thread;

/**
 * Runnable/Thread  API 를 사용하여, 멀티 쓰레딩 환경 운영.
 * 1. 1~10 까지의 숫자를 매 1초마다 콘솔에 출력.
 * 2. 2번의 작업을 매 3초마다 새로 시작(최대 100개의 작업을 동시 진행).
 */
public class SimpleThread {
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
		@Override
		public void run() {
			while(Thread.activeCount()<100) {
				Thread thread = new Thread(new PrintNumberJob());
				thread.start();
				try {
					Thread.sleep(2000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Thread(new GenerateJob()).start();
	}
}








