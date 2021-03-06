package com.quinnox.ordermanagementsystem.adminmanager;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quinnox.ordermanagementsystem.daoclasses.UserDAO;
import com.quinnox.ordermanagementsystem.daomodel.User;

public class ViewUser extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewUser()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(false);
		Boolean logged=false;
		logged=(Boolean)session.getAttribute("Logged");
		System.out.println(logged);
		if(logged!=null && !logged)
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			UserDAO userDao = new UserDAO();
			ArrayList<User> users = null;
			try 
			{
				users = userDao.viewUsers();
				request.setAttribute("users", users);

				RequestDispatcher rd=request.getRequestDispatcher("AdminManagement/ViewUser.jsp");
				rd.include(request, response);
			}
			catch (NullPointerException e)
			{			
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e1)
			{
				e1.printStackTrace();
			} 
			catch (SQLException e1)
			{
				e1.printStackTrace();
			}

		}


	}


}
