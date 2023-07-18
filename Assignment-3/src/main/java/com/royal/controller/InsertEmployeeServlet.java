package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class InsertEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("InsertEmployeeServlet --- doGet()");
		
		String email    =request.getParameter("email");
		String feedback =request.getParameter("feedback");
		
		EmployeeBean ebean = new EmployeeBean(0,email,feedback);
		EmployeeDao edao = new EmployeeDao();
		int rowsAffected = edao.insertEmployee(ebean);
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		if(rowsAffected>0)
		{
			rd=request.getRequestDispatcher("ListEmployeeServlet");
		}
		else
		{
			out.print("<h1>Employee record not Inserted</h1>");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}

}
