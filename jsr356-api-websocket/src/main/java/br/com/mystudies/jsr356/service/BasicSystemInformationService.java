package br.com.mystudies.jsr356.service;

import java.util.Date;
import java.util.List;

import br.com.mystudies.jsr356.database.SystemsInformationDataBase;
import br.com.mystudies.jsr356.domain.SystemInformation;

public class BasicSystemInformationService implements SystemsInformationsService {

	
	private SystemsInformationDataBase systemsInformationDataBase;
	
	
	private Date lastVerify;
	
	
	public BasicSystemInformationService() {
		super();
		// TODO USE CDI
		systemsInformationDataBase = new SystemsInformationDataBase();
	}



	@Override
	public boolean haveUpdate() {
		return verify(systemsInformationDataBase.lastChange());
	}



	@Override
	public List<SystemInformation> getUpdate() {
		return systemsInformationDataBase.list();
	}


	
	
	private boolean verify(Date lastChange) {
		return lastVerify != lastChange;
	}

	
	
	
	
	
}
