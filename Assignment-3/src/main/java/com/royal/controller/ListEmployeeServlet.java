package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		EmployeeDao dao = new EmployeeDao();
		ArrayList<EmployeeBean> list = dao.getAllEmployees();
		out.print("<h1> Empluyee Records</h1>");
		if(list.size()>0)
		{
			out.print("<table border=1>");
			out.print("<tr>");
			out.print("<th>ID</th>");
			out.print("<th>Email</th>");
			out.print("<th>Feedback</th>");
			out.print("<th>OPERTATIONS</th>");
			out.print("</tr>");
		
			for (int i=0;i<list.size();i++)
			{
				EmployeeBean ebean =list.get(i);
				out.print("<tr>");
				out.print("<td>"+ ebean.getId() +"</td>");        	    out.print("<td>"+ ebean.getEmail() +"</td>");
				out.print("<td>"+ ebean.getFeedBack() +"</td>");        	    out.print("<td><a href =DeleteEmployeeServlet?id=" + ebean.getId() + ">DELETE</a></td>");        	    out.print("</tr>");
			}
			out.print("</table>");
		}
		else
		{
			out.print("<h1>No reacords Founds.</h1>");
		}
	}

	protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
    }

}
