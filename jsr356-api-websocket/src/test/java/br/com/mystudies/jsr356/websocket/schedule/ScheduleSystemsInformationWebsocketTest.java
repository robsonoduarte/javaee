package br.com.mystudies.jsr356.websocket.schedule;


import static java.util.concurrent.TimeUnit.SECONDS;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.concurrent.ScheduledExecutorService;

import javax.websocket.Session;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ScheduleSystemsInformationWebsocketTest {



	@Mock
	private ScheduledExecutorService scheduledExecutorService;


	@InjectMocks
	private ScheduleSystemsInformationWebsocket scheduleSystemsInformationWebsocket;



	@Before
	public void setUp() throws Exception {
		scheduleSystemsInformationWebsocket = new ScheduleSystemsInformationWebsocket();
		initMocks(this);
	}



	@Test
	public void test1() {

		Session session = mock(Session.class);

		scheduleSystemsInformationWebsocket.setSession(session).schedule();

		verify(scheduledExecutorService).scheduleAtFixedRate(
				any(TaskSystemsInformationWebsocket.class),
				eq(1L),
				eq(1L),
				eq(SECONDS)
		);
	}


	@Test(expected=IllegalArgumentException.class)
	public void test2() {
		scheduleSystemsInformationWebsocket.schedule();
	}

}
