package telran.multithreading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
	//displaying time in a given format and a given resolution
	//example displaying each second, or each 5 seconds, etc.
	
	private DateTimeFormatter formatter;
	private int  resolution;
	
	// define as service thread, it mean that Appl is finishing and this service thread is finishing
	public Timer(DateTimeFormatter formatter, int  resolution) { 
		setDaemon(true);
		this.formatter = formatter;
		this.resolution = resolution;
	}
	
	public void run() {
		while(!isInterrupted()) {
			System.out.println(LocalDateTime.now().format(formatter));
			try {
				sleep(resolution);
			} catch (InterruptedException e) {
				 System.out.println("Timer is stoped");
				break;
			   
			}
		}
	}
}
