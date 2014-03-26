package br.com.mystudies.jsr356.websocket.schedule;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.websocket.Session;


public class ScheduleSystemsInformationWebsocket {


	private Session session;



	private ScheduledExecutorService scheduledExecutorService;





	public ScheduleSystemsInformationWebsocket() {
		scheduledExecutorService = Executors.newScheduledThreadPool(1);
		// TODO: USE CDI
	}




	public ScheduleSystemsInformationWebsocket setSession(Session session){
		this.session = session;
		return this;
	}




	public void schedule() {

		if(session == null)
			throw new IllegalArgumentException("Session is null");

		scheduledExecutorService.scheduleAtFixedRate(
				new TaskSystemsInformationWebsocket(session),
				1,
				1,
				SECONDS
		);
	}

}
