package br.com.mystudies.jsr356.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mystudies.jsr356.domain.SystemInformation;
import br.com.mystudies.jsr356.service.BasicSystemInformationService;
import br.com.mystudies.jsr356.service.SystemsInformationsService;

import com.google.gson.Gson;


@WebServlet("/systemsInformations")
public class SystemsInformationsServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	private SystemsInformationsService systemsInformationsService;

    public SystemsInformationsServlet() {
        systemsInformationsService = new BasicSystemInformationService();
        // TODO: USE CDI
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(systemsInformationsService.haveUpdate()){
			List<SystemInformation> systemsInformations = systemsInformationsService.getUpdate();			
			response.getWriter().append( new Gson().toJson(systemsInformations));
		}
	}

}
