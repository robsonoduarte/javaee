package br.com.mystudies.jsr356.service;

import java.util.List;

import br.com.mystudies.jsr356.domain.SystemInformation;

public class BasicSystemInformationService implements SystemsInformationService {

	
	
	@Override
	public boolean haveUpdate() {
		return false;
	}

	
	
	@Override
	public List<SystemInformation> getUpdate() {
		return null;
	}
	
}
