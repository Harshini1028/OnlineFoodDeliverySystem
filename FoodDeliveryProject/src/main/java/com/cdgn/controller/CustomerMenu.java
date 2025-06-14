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
import com.cdgn.dao1.MenuDao;
import com.cdgn.model.Menu;

@WebServlet("/customermenu")
public class CustomerMenu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDao dao=new CustomerDao();
		try {
			List<Menu> menu=dao.getCustomerMenu();
			request.setAttribute("list", menu);
			RequestDispatcher rd=request.getRequestDispatcher("customermenu.jsp");
			rd.forward(request, response);
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
