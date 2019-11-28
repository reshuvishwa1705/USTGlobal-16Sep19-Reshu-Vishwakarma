package com.ustglobal.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	/*
	 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { String empname =
	 * req.getParameter("empname"); String email = req.getParameter("email"); String
	 * pwd = req.getParameter("pwd"); PrintWriter out = resp.getWriter();
	 * out.println("<html>"); out.println("<body>"); out.println("<h1>");
	 * out.println("Name: "+empname); out.println("<br>"); out.println("Email:"
	 * +email); out.println("<br>"); out.println("Password:"+pwd);
	 * out.println("</h1>"); out.println("</body>"); out.println("</html>");
	 * 
	 * }//end of doGet()*/ 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		String trainerName = config.getInitParameter("trainer-name");
		String companyName = context.getInitParameter("company-name");
		
		String empname = req.getParameter("empname");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");
		out.println("Name: "+empname);
		out.println("<br>");
		out.println("Email:" +email);
		out.println("<br>");
		out.println("Password:"+pwd);
		out.println("</h1>");
		out.println("<br>");
		out.println("<h2>");
		out.println("Trainer Name:"+trainerName);
		out.println("</h2>");
		out.println("<br>");
		out.println("<h2>");
		out.println("Company Name:"+companyName);
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");

	}//end of doPost()
}

