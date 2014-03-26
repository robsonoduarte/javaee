package br.com.mystudies.jsr356.websocket;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import br.com.mystudies.jsr356.websocket.schedule.ScheduleSystemsInformationWebsocket;

@ServerEndpoint("/systemsInformations")
public class SystemsInformationsWebsocketEndPoint {


	private ScheduleSystemsInformationWebsocket scheduleSystemsInformationWebsocket;





	public SystemsInformationsWebsocketEndPoint() {
		super();
		// TODO: USE CDI
		scheduleSystemsInformationWebsocket = new ScheduleSystemsInformationWebsocket();
	}





	@OnOpen
	public void read(Session session) {
		scheduleSystemsInformationWebsocket.setSession(session).schedule();
	}



}
