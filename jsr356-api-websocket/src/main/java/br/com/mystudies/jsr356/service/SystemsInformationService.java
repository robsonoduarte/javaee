package br.com.mystudies.jsr356.service;

import java.util.List;

import br.com.mystudies.jsr356.domain.SystemInformation;

public interface SystemsInformationService {

	boolean haveUpdate();

	List<SystemInformation> getUpdate();

}
