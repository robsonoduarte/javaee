package br.com.mystudies.jsr356.websocket.schedule;

import javax.websocket.Session;

import org.junit.Before;
import org.junit.Test;

public class ScheduleSystemsInformationTest {

	
	private Session session;
	private ScheduleSystemsInformationWebsocket scheduleSystemsInformationWebsocket;



	@Before
	public void setUp() throws Exception {
		scheduleSystemsInformationWebsocket = new ScheduleSystemsInformationWebsocket();
	}



	@Test
	public void test() {
		scheduleSystemsInformationWebsocket.setSession(session).schedule();
	}

}
