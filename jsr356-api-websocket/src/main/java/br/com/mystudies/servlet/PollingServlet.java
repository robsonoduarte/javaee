package br.com.mystudies.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/polling")

public class PollingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


    public PollingServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print(" 1 2 3 testing...");
		response.getWriter().print("<br>");
	}


}
