package br.com.mystudies.jsr356.service.schudele;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;

import br.com.mystudies.jsr356.database.SystemsInformationDataBase;
import br.com.mystudies.jsr356.domain.SystemInformation;

@Singleton
public class SystemInformationUpdate {

	
	private SystemsInformationDataBase systemsInformationDataBase;
	
	
	
	
	public SystemInformationUpdate() {
		systemsInformationDataBase = new SystemsInformationDataBase();
	}




	@Schedule(second="*/5", minute= "*", hour = "*")	
	public void update() {
	
		System.out.println("updating data.....");
		
		List<SystemInformation> systemsInformations = systemsInformationDataBase.list();
		
		update(systemsInformations);
		
		systemsInformationDataBase.store(systemsInformations);
		
	}



	private void update(List<SystemInformation> systemsInformations) {
		for (SystemInformation systemInformation : systemsInformations) {
			systemInformation.addAcess(10);
		}		
	}

	
	
	
}
