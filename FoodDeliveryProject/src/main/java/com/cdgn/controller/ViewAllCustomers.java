package com.cdgn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdgn.dao.CustomerDao;
import com.cdgn.model.Customer;


@WebServlet("/viewCustomers")
public class ViewAllCustomers extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao dao=new CustomerDao();
		try {
			List<Customer> c=dao.ViewAllCustomers();
			request.setAttribute("c", c);
			RequestDispatcher rd=request.getRequestDispatcher("viewCustomers.jsp");
			rd.forward(request, response);
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
