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

@WebServlet("/view")
public class viewProfile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		CustomerDao dao=new CustomerDao();
		Customer c;
		try {
			c = dao.getDetails(email);
			if(email.equals(c.getEmail())) {
				request.setAttribute("list", c);
					RequestDispatcher rd=request.getRequestDispatcher("viewcustomer.jsp");
					rd.forward(request, response);
			}
			else {
				request.setAttribute("status", "Invalid email");
				RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
