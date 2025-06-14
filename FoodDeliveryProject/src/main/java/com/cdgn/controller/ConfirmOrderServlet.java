package com.cdgn.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdgn.model.Menu;

@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    List<Menu> cart = (List<Menu>)session.getAttribute("cart");

	    // Retrieve form parameters
	    String upiId = request.getParameter("upiId");

	    String ifsc = request.getParameter("ifsc");

	    String accountHolderName = request.getParameter("accountHolderName");

	    String bankName = request.getParameter("bankName");

	    String mobile = request.getParameter("mobile");

	    String notes = request.getParameter("notes");
	    
	    response.sendRedirect("orderconfirmation.jsp");

	}

}
