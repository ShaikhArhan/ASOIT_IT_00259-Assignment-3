package com.royal.controller;

import java.io.IOException;

import com.royal.dao.EmployeeDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id =Integer.parseInt(request.getParameter("id"));
		
		EmployeeDao dao =new EmployeeDao();
		int rowAffected =dao.deleteEmployee(id);
		RequestDispatcher rd= null;		
		if(rowAffected>0)
		{
			rd =request.getRequestDispatcher("ListEmployeeServlet");
		}	
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
