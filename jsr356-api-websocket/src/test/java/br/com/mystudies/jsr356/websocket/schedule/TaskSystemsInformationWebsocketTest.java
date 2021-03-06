package br.com.mystudies.jsr356.websocket.schedule;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.RemoteEndpoint.Async;
import javax.websocket.Session;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.mystudies.jsr356.domain.SystemInformation;
import br.com.mystudies.jsr356.service.SystemsInformationsService;

public class TaskSystemsInformationWebsocketTest {



	@Mock
	private Session session;


	@Mock
	private Async async;


	@Mock
	private SystemsInformationsService systemsInformationService;


	@InjectMocks
	private TaskSystemsInformationWebsocket task;


	@Before
	public void setUp() throws Exception {
		task =  new TaskSystemsInformationWebsocket(session);
		initMocks(this);
	}




	@Test
	public void sendMsgToSessionOnlyWhenHaveNewInformationOfSystems() {

		when(systemsInformationService.haveUpdate()).thenReturn(true); // <-- new information
		when(systemsInformationService.getUpdate()).thenReturn(getUpdate()); // <-- get the news informations
		when(session.getAsyncRemote()).thenReturn(async);

		task.run();

		verify(systemsInformationService).haveUpdate();
		verify(systemsInformationService).getUpdate();
		verify(session).getAsyncRemote();
		
		verify(async).sendText(
				"["
				+ "{\"name\":\"Bureau\",\"numberAccess\":100},"
				+ "{\"name\":\"Concentre\",\"numberAccess\":200},"
				+ "{\"name\":\"LNO\",\"numberAccess\":300}"
				+"]"); // <-- send the new informations to session

	}


	
	@Test
	public void dontSendMsgToSessionWhenHaventNewInformationOfSystems() {

		when(systemsInformationService.haveUpdate()).thenReturn(false); // <- haven't news information

		task.run();

		verify(systemsInformationService).haveUpdate(); // <- only this interaction
		verify(systemsInformationService, times(0)).getUpdate();
		verifyZeroInteractions(session);
		verifyZeroInteractions(async);

	}









	private List<SystemInformation> getUpdate() {

		List<SystemInformation> systemsInformations = new ArrayList<>();


		systemsInformations.add(new SystemInformation("Bureau", 100));
		systemsInformations.add(new SystemInformation("Concentre", 200));
		systemsInformations.add(new SystemInformation("LNO", 300));

		
		
		return systemsInformations;
	}


}
