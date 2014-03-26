package br.com.mystudies.jsr356.websocket.schedule;

import java.util.List;

import javax.websocket.Session;

import br.com.mystudies.jsr356.domain.SystemInformation;
import br.com.mystudies.jsr356.service.SystemsInformationService;

public class TaskSystemsInformationWebsocket implements Runnable{



	private SystemsInformationService systemsInformationService;


	private Session session;



	public TaskSystemsInformationWebsocket(Session session) {
		this.session = session;
	}





	@Override
	public void run() {

		System.out.println("task in running");

		try {

			if (systemsInformationService.haveUpdate()) {

				List<SystemInformation> systemsInformationUpdated =
						systemsInformationService.getUpdate();

				String temp = "";

				for (SystemInformation systemInformation : systemsInformationUpdated) {
					temp += systemInformation.getTemp() + " ";
				}

				session.getAsyncRemote().sendText(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
