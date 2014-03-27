package br.com.mystudies.jsr356.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.mystudies.jsr356.database.SystemsInformationDataBase;
import br.com.mystudies.jsr356.domain.SystemInformation;

public class BasicSystemsInformationServiceTest {

	
	
	@Mock
	private SystemsInformationDataBase systemsInformationDataBase;
	
	
	
	@InjectMocks
	private BasicSystemInformationService basicSystemInformationService;

	

	@Before
	public void setUp() throws Exception {
		basicSystemInformationService = new BasicSystemInformationService();
		initMocks(this);
	}


	@Test
	public void test1() {
		
	  when(systemsInformationDataBase.lastChange()).thenReturn(new Date());	
		
	  boolean haveUpdate = basicSystemInformationService.haveUpdate();
	  
	  assertThat(haveUpdate, equalTo(true));
	  
	  verify(systemsInformationDataBase).lastChange();	  
	}
	

	
	@Test
	public void test2() {
		when(systemsInformationDataBase.list()).thenReturn(getSystemsInformations());
		List<SystemInformation> systemsInformation = basicSystemInformationService.getUpdate();
		assertThat(systemsInformation, hasSize(3));
		verify(systemsInformationDataBase).list();
	}
	

	private List<SystemInformation> getSystemsInformations() {

		List<SystemInformation> systemsInformations = new ArrayList<>();

		systemsInformations.add(new SystemInformation("Bureau", 110));
		systemsInformations.add(new SystemInformation("Concentre", 210));
		systemsInformations.add(new SystemInformation("LNO", 310));

		return systemsInformations;
	}
}
