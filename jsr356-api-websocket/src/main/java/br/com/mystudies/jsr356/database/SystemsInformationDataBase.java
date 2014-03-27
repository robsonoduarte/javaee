package br.com.mystudies.jsr356.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mystudies.jsr356.domain.SystemInformation;

public class SystemsInformationDataBase {

	
	private static List<SystemInformation> listDataBase = new ArrayList<>();		
	private static Date lastUpdate;
	
	static{
		listDataBase.add(new SystemInformation("Bureau", 100));
		listDataBase.add(new SystemInformation("Concentre", 200));
		listDataBase.add(new SystemInformation("LNO", 300));
	}

	
	public List<SystemInformation> store(List<SystemInformation> systemsInformations) {
		
		lastUpdate = new Date();
		listDataBase = systemsInformations;
		
		return systemsInformations;
	}


	public List<SystemInformation> list() {
		return listDataBase;
	}


	public Date lastChange() {
		return lastUpdate;
	}

}
