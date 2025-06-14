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
import javax.servlet.http.HttpSession;

import com.cdgn.dao1.MenuDao;
import com.cdgn.model.Menu;

@WebServlet("/deletebyid")
public class RemoveFromCart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int sno = Integer.parseInt(request.getParameter("sno"));
	        
	        HttpSession session = request.getSession();
	        List<Menu> cartList = (List<Menu>) session.getAttribute("cart");
	        
	        if (cartList != null) {
	            // Remove the item with matching sno
	            cartList.removeIf(item -> item.getSno() == sno);
	            session.setAttribute("cart", cartList); // Update session
	        }
	        
	        response.sendRedirect("displaycart.jsp"); // Redirect back to cart 
		
	}

}
