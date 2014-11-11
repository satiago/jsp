/**
 * 
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yangsatiago
 *
 */
public class UserServlet extends HttpServlet {

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = (String) req.getParameter("method");
		PrintWriter out = resp.getWriter();
		out.print("method:" + method + "<br>");
		if(method == null)
		{

			out.print("invalid request");
		}
		else
		{
			if(method.equals("login"))
			{
				try {
					Login(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					out.println("error!");
					e.printStackTrace();
					out.println(e);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		out.print("doPost Called!" + "<br>");
		doGet(req, resp);
	}
	
	protected void Login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		out.print("username:" + username + "<br>");
		out.print("password:" + password + "<br>");
		
		DBAccess db = new DBAccess();
		
		String sql = "select * from tb_user where username='" + username +"' and pwd='" + password + "'";
		
		out.print(sql + "<1br>");
		db.createConn();
		out.print(sql + "<2br>");
		db.query(sql);
		
		out.print(sql + "<3br>");
		
		if(db.next())
		{
			out.print("rs if called!<br>");
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			resp.sendRedirect("welcome.jsp");
			return;
		}
		else
		{
			out.print("rs else called!<br>");
			resp.sendRedirect("login.jsp");
			return;
		}
	}
	
}
