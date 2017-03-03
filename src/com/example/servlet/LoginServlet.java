package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.example.daoimp.adminImp;
import com.example.demo.Administrator;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upassword = request.getParameter("upassword");
	    adminImp imp = new adminImp();	
	    PrintWriter out = response.getWriter();
	    try {
	    	Administrator admin = imp.login(uname, upassword);	
	    	if(admin!= null){
	    		response.setHeader("Content-type", "text/html;charset=UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		HttpSession session = request.getSession();
	    		session.setAttribute("uname", uname);
	    		request.getRequestDispatcher("index.jsp").forward(request, response);	
	    	}else{
	    		out.print("<script language='javascript' >alert('Please check your password or your username');window.location.href='login.jsp';</script>");
	    		//request.getRequestDispatcher("/login.jsp").forward(request, response);
	    	}
	    	
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg","Õ¯¬Á∑±√¶£¨…‘∫Û‘Ÿ ‘");
			request.getRequestDispatcher("/test.jsp").forward(request, response);
		}

	}


	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
