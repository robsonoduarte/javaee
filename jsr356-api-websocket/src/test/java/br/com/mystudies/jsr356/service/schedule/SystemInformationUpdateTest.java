package br.com.mystudies.jsr356.service.schedule;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import br.com.mystudies.jsr356.database.SystemsInformationDataBase;
import br.com.mystudies.jsr356.domain.SystemInformation;
import br.com.mystudies.jsr356.service.schudele.SystemInformationUpdate;

public class SystemInformationUpdateTest {

	
	
	
	@InjectMocks
	private SystemInformationUpdate systemInformationUpdate;

	
	
	
	@Before
	public void setUp() throws Exception {
		systemInformationUpdate = new SystemInformationUpdate();
	}


	
	@Test
	public void test() {
		
		systemInformationUpdate.update();
		
		List<SystemInformation> si = new SystemsInformationDataBase().list();
		
		assertThat(si, hasItem(new SystemInformation("Bureau", 110)));
		assertThat(si, hasItem(new SystemInformation("Concentre", 210)));
		assertThat(si, hasItem(new SystemInformation("LNO", 310)));
		
	}

	
}
