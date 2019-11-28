package com.ustglobal.webapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		String companyName = context.getInitParameter("company-name");
		ServletConfig config = getServletConfig();
		String batchName = config.getInitParameter("batch-name");
		PrintWriter out = resp.getWriter();
		Object obj = req.getAttribute("obj");
		resp.setContentType("text/html");
		out.println("<html>");
		out.println("<body>");
		Date date = new Date();
		out.println("<h1 style='color: Red'>Date and Time is:");
		out.println(date.toString());
		out.println("</h1>");
		out.println("<br>");
		String url = req.getRequestURI();
		String method = req.getMethod();
		out.println(url);
		out.println("<br>");
		out.println(method);
		out.println("<br>");
		out.println("<h2>");
		out.println("Company Name:"+companyName);
		out.println("</h2>");
		out.println("<br>");
		out.println("<h3>");
		out.println("Batch Name: "+batchName);
		out.println("</h3>");
		out.println("<h3>");
		out.println("Request Attribute: "+obj);
		out.println("</h3>");
		out.println("</body>");
		out.println("</html>");
	}
}
