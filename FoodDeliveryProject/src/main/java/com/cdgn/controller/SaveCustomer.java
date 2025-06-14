package com.cdgn.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdgn.dao.CustomerDao;
import com.cdgn.model.Customer;

@WebServlet("/save")
public class SaveCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c=new Customer();
		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		c.setPassword(request.getParameter("password"));
		c.setPhno(request.getParameter("phno"));
		c.setAge(Integer.parseInt(request.getParameter("age")));
		c.setAddress(request.getParameter("address"));
		
		CustomerDao dao=new CustomerDao();
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
		try {
			boolean status=dao.saveCustomer(c);
			if(status) {
				dao.commit();
				request.setAttribute("status", "Registered Successfully");
				rd.forward(request, response);
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Registration Failed");
				rd.forward(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
