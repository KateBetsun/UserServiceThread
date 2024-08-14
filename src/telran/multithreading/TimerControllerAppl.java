package telran.multithreading;

import java.time.format.DateTimeFormatter;

public class TimerControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		//displaying time in a given format and a given resolution
		//example displaying each second, or each 5 seconds, etc.
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
		Timer timer = new Timer(formatter, 1000);
		timer.start();
		Thread.sleep(3000);
		timer.interrupt();
		Thread.sleep(3000);
		System.out.println("Application finished");
	}

}
