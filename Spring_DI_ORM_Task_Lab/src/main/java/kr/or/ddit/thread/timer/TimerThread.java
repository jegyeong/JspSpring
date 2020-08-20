package kr.or.ddit.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerThread {
	public static class PrintNumberJob extends TimerTask{
		private int number;
		@Override
		public void run() {
			if(number==10) {
				cancel();
			}
			System.out.printf("%s - %d\n", Thread.currentThread().getName(), ++number);
		}
		
	}
	
	public static class GenerateJob extends TimerTask{
		Timer timer;
		public GenerateJob(Timer timer) {
			super();
			this.timer = timer;
		}

		@Override
		public void run() {
			if(Thread.activeCount()==100) {
				cancel();
			}
			timer.scheduleAtFixedRate(new PrintNumberJob(), 0, 1000);
		}
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new GenerateJob(timer), 0, 2000);
	}
}










