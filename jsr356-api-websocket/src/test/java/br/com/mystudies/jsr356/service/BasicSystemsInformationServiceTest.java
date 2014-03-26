package br.com.mystudies.jsr356.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.mystudies.jsr356.domain.SystemInformation;
import br.com.mystudies.jsr356.service.BasicSystemInformationService;

public class BasicSystemsInformationServiceTest {

	
	
	private BasicSystemInformationService basicSystemInformationService;


	@Before
	public void setUp() throws Exception {
		basicSystemInformationService = new BasicSystemInformationService();
	}


	
	@Test
	public void test1() {
	  boolean haveUpdate = basicSystemInformationService.haveUpdate();
	}
	

	
	@Test
	public void test2() {
		List<SystemInformation> systemsInformation = basicSystemInformationService.getUpdate();
	}
	

}
