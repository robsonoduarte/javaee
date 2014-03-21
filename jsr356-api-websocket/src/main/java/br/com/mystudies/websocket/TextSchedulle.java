package br.com.mystudies.websocket;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TextSchedulle {

	public static void main(String[] args) {
		
		
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
				
				
				scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("running");
						
					}
				}, 1, 1, TimeUnit.SECONDS);
		
		
		/*ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		
		
		
		
		scheduledExecutorService.schedule(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Running");				
			}
		}, 1, TimeUnit.SECONDS);*/
		
		
		
		/*ExecutorService executorService = Executors.newScheduledThreadPool(1);
		
		
		executorService.execute(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Running");				
			}
		});*/
		
	}
}
