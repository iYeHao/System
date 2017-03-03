package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.adminImp;
import com.example.demo.Administrator;
import com.example.demo.Register;

public class AdminAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AdminAddServlet() {
		super();
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		String uname = new String(request.getParameter("uname").getBytes("8859_1"),"utf-8");
		String upassword = request.getParameter("upassword");
		String repassword = request.getParameter("repassword");
		adminImp imp = new adminImp(); 
		PrintWriter out = response.getWriter();
		boolean b = false;
		try {
			b=imp.find(uname);
		}catch(Exception e1){
			e1.printStackTrace();
		}
		Register form = new Register();
		form.setUname(uname);
		form.setUpassword(upassword);
		form.setCpassword(repassword);
		if(b == true)
		{
			form.getErrors().put(uname, "用户名存在");
		}
		if(form.validate()==false||b==true)
		{
			request.setAttribute("form", form);
			response.setHeader("Content-type", "text/html;charset=UTF-8");
    		response.setCharacterEncoding("UTF-8");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return ;
		}
		Administrator user=imp.register(uname,upassword);
		response.setHeader("Content-type", "text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    if(user!=null)
	    {
	    	out.print("<script language='javascript' >alert('Sucessfully signed up! Please login in!');window.location.href='login.jsp';</script>");
	    	//	request.getRequestDispatcher("/login.jsp").forward(request, response);	
	    }else
	    {
	    	request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }
		}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
			request.setAttribute("msg","网络繁忙，稍后再试");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
	    }
		}
	

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
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
