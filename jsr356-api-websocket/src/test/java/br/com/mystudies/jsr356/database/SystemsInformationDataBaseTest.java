package br.com.mystudies.jsr356.database;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.mystudies.jsr356.domain.SystemInformation;

public class SystemsInformationDataBaseTest {

	



	private SystemsInformationDataBase systemsInformationDataBase;



	@Before
	public void setUp() throws Exception {
		systemsInformationDataBase = new SystemsInformationDataBase();
	}


	
	
	
	@Test
	public void test1() {
		List<SystemInformation> systemsInformations = systemsInformationDataBase.store(getSystemsInformations());
		verifyList(systemsInformations);
	}

	

	





	@Test
	public void test2() {
		List<SystemInformation> systemsInformations = systemsInformationDataBase.list();
		verifyList(systemsInformations);
	}
	

	
	
	@Test
	public void test3() {
		
		systemsInformationDataBase.store(getSystemsInformations());
		
		stop(1);
		
		Date date = systemsInformationDataBase.lastChange();
		
		assertThat(date, not(equalTo(new Date())));
	}

	

	
	
	@Test
	public void test4(){
		
		systemsInformationDataBase = new SystemsInformationDataBase();
		
		List<SystemInformation> si1 = systemsInformationDataBase.list();
		
		systemsInformationDataBase = new SystemsInformationDataBase();
		
		List<SystemInformation> si2 = systemsInformationDataBase.list();
		
		assertThat(si1, equalTo(si2));
	}

	

	
	
	private void verifyList(List<SystemInformation> systemsInformations) {
		assertThat(systemsInformations, hasItem(new SystemInformation("Bureau", 110)));
		assertThat(systemsInformations, hasItem(new SystemInformation("Concentre", 210)));
		assertThat(systemsInformations, hasItem(new SystemInformation("LNO", 310)));		
	}

	
	
	
	private void stop(int time) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}



	private List<SystemInformation> getSystemsInformations() {

		List<SystemInformation> systemsInformations = new ArrayList<>();

		systemsInformations.add(new SystemInformation("Bureau", 110));
		systemsInformations.add(new SystemInformation("Concentre", 210));
		systemsInformations.add(new SystemInformation("LNO", 310));

		return systemsInformations;
	}
}
