package br.com.mystudies.jsr356.websocket;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.websocket.Session;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.mystudies.jsr356.websocket.schedule.ScheduleSystemsInformationWebsocket;

public class SystemsInformationsWebsocketEndPointTest {

	@Mock
	private Session session;


	@Mock
	private ScheduleSystemsInformationWebsocket scheduleSystemsInformationWebsocket;


	@InjectMocks
	private SystemsInformationsWebsocketEndPoint systemsInformationsWebsocketEndPoint;


	@Before
	public void setUp() throws Exception {
		systemsInformationsWebsocketEndPoint = new SystemsInformationsWebsocketEndPoint();
		initMocks(this);
	}



	@Test
	public void test() {

		when(scheduleSystemsInformationWebsocket.setSession(session)).thenReturn(scheduleSystemsInformationWebsocket);

		systemsInformationsWebsocketEndPoint.read(session);

		verify(scheduleSystemsInformationWebsocket).setSession(session);
		verify(scheduleSystemsInformationWebsocket).schedule();

	}


}
