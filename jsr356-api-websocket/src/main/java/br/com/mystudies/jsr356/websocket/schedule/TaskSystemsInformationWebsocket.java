package br.com.mystudies.jsr356.websocket.schedule;

import java.util.List;

import javax.websocket.Session;

import br.com.mystudies.jsr356.domain.SystemInformation;
import br.com.mystudies.jsr356.service.BasicSystemInformationService;
import br.com.mystudies.jsr356.service.SystemsInformationsService;

import com.google.gson.Gson;

public class TaskSystemsInformationWebsocket implements Runnable{



	private SystemsInformationsService systemsInformationService;


	private Session session;

	
	




	public TaskSystemsInformationWebsocket(Session session) {
		this.session = session;
		systemsInformationService = new BasicSystemInformationService();
	}





	@Override
	public void run() {

		System.out.println("task in running");

		try {

			if (systemsInformationService.haveUpdate()) {

				List<SystemInformation> systemsInformationUpdated = systemsInformationService.getUpdate();

				session.getAsyncRemote().sendText(new Gson().toJson(systemsInformationUpdated));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
