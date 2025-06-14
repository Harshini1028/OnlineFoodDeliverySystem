package com.cdgn.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdgn.dao.CustomerDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(email.equals("harshinimokkapati@gmail.com") && password.equals("harshini")) {
			session.setAttribute("email",email);
			response.sendRedirect("admin.jsp");
		}
		else {
			CustomerDao dao=new CustomerDao();
			try {
				boolean status=dao.checkLoginDetails(email,password);
				if(status) {
					session.setAttribute("email",email);
					response.sendRedirect("user.jsp");
				}
				else {
					request.setAttribute("status", "Invalid Details");
					RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
					rs.forward(request, response);
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
