package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.EmployeeBean;
import com.royal.util.DbConnection;

public class EmployeeDao 
{
	
	public int insertEmployee(EmployeeBean ebean)
	{
		String insertQuery = " INSERT INTO Employee(email,feedback) VALUES('" + ebean.getEmail() + "','" + ebean.getFeedBack() + "')";		
		Connection conn =DbConnection.getDbConnection();		
		Statement stmt =null;		
		int rowsAffected = 0;
		if (conn!=null)
		{
			try 
			{
				stmt =conn.createStatement();
				
				rowsAffected =stmt.executeUpdate(insertQuery);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		else 
		{
			System.out.println("Db not Connection : " + conn);
		}
		return rowsAffected;
	}
	
	public int deleteEmployee(int id)
	{
		Connection conn =DbConnection.getDbConnection();
		Statement stmt=null;
		String deleteQuery = "DELETE FROM employee WHERE ID =" +id;
		int rowsAffected=0;
		if(conn!=null)
		{
			try
			{
				stmt =conn.createStatement();
				rowsAffected =stmt.executeUpdate(deleteQuery);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Db not connected --- deleteEmployee() --- EmployeeDao");
		}
		return rowsAffected;
		
	}
	
	public ArrayList<EmployeeBean> getAllEmployees()
	{
		String selectQuery = "SELECT * FROM employee";
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		 Connection conn =DbConnection.getDbConnection();
		 Statement stmt =null;
		 ResultSet rs =null;
		 EmployeeBean ebean =null;
		 if(conn!=null)
		 {
			 try
			 {
			 	 stmt =conn.createStatement();
				 rs= stmt.executeQuery(selectQuery);
			  
				 while(rs.next())
			 	{
					 ebean =new EmployeeBean(rs.getInt(1),rs.getString(2),rs.getString(3));
					 list.add(ebean);
			 	}
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
		 }
		 else
		 {
			 System.out.println("EmployeeDao --- getAllEmployees() --- Db not Connected");
		 }
		 return list;
	}
	
	public static void main(String args[]) 
	{
		 System.out.println(new EmployeeDao().getAllEmployees().size());
	}
}
