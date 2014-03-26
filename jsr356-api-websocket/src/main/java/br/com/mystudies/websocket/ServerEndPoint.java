package br.com.mystudies.websocket;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint("/server")
public class ServerEndPoint {


	
	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


	@OnOpen
	public void ready(final Session session) {
		
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				session.getAsyncRemote().sendText("1 2 3 testing...");
				
			}

		}, 1, 1, TimeUnit.SECONDS);
	}




}
