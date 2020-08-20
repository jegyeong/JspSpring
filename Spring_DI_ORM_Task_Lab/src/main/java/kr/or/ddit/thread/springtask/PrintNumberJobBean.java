package kr.or.ddit.thread.springtask;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class PrintNumberJobBean {
	private int number;
	
	@Scheduled(initialDelay = 0, fixedRate = 1000)
	public void printNumber() {
		System.out.printf("%s - %d\n", Thread.currentThread().getName(), ++number);
	}
	
	@Scheduled(cron="0 0 3 * * MON")
	public void printDate() {
		System.err.printf("%s\n", new Date().toString());
	}
}
