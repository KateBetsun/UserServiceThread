package telran.multithreading;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimerControllerAppl {	

	private static final int TIME_SLEEP = 6000;
	private static final String TIME_FORMAT = "yyyy-MM-dd hh:mm:ss a";
	private static final int TIME_SLEEP_FOR_TIMER = 1000;

	public static void main(String[] args) throws InterruptedException {
		//figure out a solution allowing timer stop
		//as example in 5 seconds you stop the timer
		//following 5 seconds application is running with no timer

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
		Timer timer = new Timer(formatter, TIME_SLEEP_FOR_TIMER);
		
		System.out.println("Enter the second of the timer stop from 1 to not more then " + TIME_SLEEP/1000 
				+ " sec, \notherwise the timer with the appl will stop at the same time");
		
		Scanner scanner = new Scanner(System.in);
		int stopSeconds = scanner.nextInt();
		long stopTimeMillis = stopSeconds * 1000;
		
		if(stopTimeMillis > TIME_SLEEP) {
			stopTimeMillis = TIME_SLEEP;
		}
		System.out.println("Appl is started");		
		timer.start();
		
		Thread.sleep(stopTimeMillis);
	    timer.interrupt();
	    
	    long remainingTimeMillis = TIME_SLEEP - stopTimeMillis;
	    if (remainingTimeMillis > 0) {
	        Thread.sleep(remainingTimeMillis);
	    }
	    
	    System.out.println("Application finished");
	    
		}

}
