package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.daoimp.filedImp;
import com.example.demo.Field;

public class FieldlistServlet extends HttpServlet {

	private int page_current=1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public FieldlistServlet() {
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
	public void  pageCurrent(String current,int page_total){
		if(current==null){
			page_current=1;
		}else{
			page_current=Integer.parseInt(current);
		}
		if(page_current<=0){
			page_current=1;
		}else{
			if(page_current>page_total){
				page_current=page_total;
			}else{
			}
		}
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String current=request.getParameter("page_current");
		filedImp imp =new filedImp();
		ArrayList<Field> flist = new ArrayList<Field> ();
		flist=imp.show();
		int page_size=6;
		int page_total=flist.size()/page_size+1;
		pageCurrent(current,page_total);
		request.setAttribute("page_current", page_current);
		ArrayList<Field> cflist =new ArrayList<Field>();
		for(int i=0;i<page_size;i++){
			if((i+(page_current-1)*page_size)<flist.size())
			cflist.add(flist.get(i+(page_current-1)*page_size));
		}
		request.setAttribute("flist", cflist);
		
		request.getRequestDispatcher("/filed_list.jsp").forward(request, response);
	
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

		response.setContentType("text/html");
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
