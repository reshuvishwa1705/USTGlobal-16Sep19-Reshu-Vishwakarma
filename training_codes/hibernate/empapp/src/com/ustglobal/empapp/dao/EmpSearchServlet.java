package com.ustglobal.empapp.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmpSearchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PrintWriter out = resp.getWriter();
		String eid = req.getParameter("id1");
		Integer id = Integer.parseInt(eid);
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=reshu";
		String sql = "select * from employee where id=?";
		//		String sql = "select * from employee where id="+id;
		//		if you want to add value via a concadinate opr then their
		//		is no need to set value like pstmt.setInt(1, id);
		//      so not need to write pstmt.setInt(1, id);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int id2 = rs.getInt("id");
				String empname = rs.getString("name");
				int salary = rs.getInt("sal");
				String gender = rs.getString("gender");
				out.println("<html>");
				out.println("<body>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<td>");
				out.println("Id");
				out.println("</td>");
				out.println("<td>");
				out.println("Name");
				out.println("</td>");
				out.println("<td>");
				out.println("Salary");
				out.println("</td>");
				out.println("<td>");
				out.println("Gender");
				out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td></td>");
				//				out.println("<td>id2</td>");
				//				out.println("<td>empname</td>");
				//				out.println("<td>salary</td>");
				//				out.println("<td>gender</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br>");
				out.println("Name "+rs.getString("name"));
				out.println("Id "+rs.getInt("id"));
				out.println("Gender "+rs.getString("gender"));
				out.println("Salary "+rs.getInt("sal"));
				out.println("</body>");
				out.println("</html>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
