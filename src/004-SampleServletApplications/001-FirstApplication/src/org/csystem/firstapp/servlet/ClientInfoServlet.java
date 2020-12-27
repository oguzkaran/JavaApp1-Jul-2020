package org.csystem.firstapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/clientinfo")
public class ClientInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static void validate(String name, String surname)
	{
		if (name == null || surname == null)
			throw new IllegalArgumentException();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		var printWriter = response.getWriter();
		
		try {
			var name = request.getParameter("name");
			var surname = request.getParameter("surname");
			
			validate(name, surname);
			
			printWriter.printf("Merhaba %s %s, Ip Adresiniz:%s", name, surname.toUpperCase(), request.getRemoteHost());
		}
		catch (IllegalArgumentException ex) {
			printWriter.println("Invalid parameters");			
		}
		catch (Throwable ex) {
			printWriter.println(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}

}
