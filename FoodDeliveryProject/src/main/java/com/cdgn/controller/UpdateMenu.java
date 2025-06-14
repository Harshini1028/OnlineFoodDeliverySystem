package com.cdgn.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdgn.dao1.MenuDao;
import com.cdgn.model.Menu;

@WebServlet("/update")
public class UpdateMenu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu m=new Menu();
		m.setSno(Integer.parseInt(request.getParameter("sno")));
		m.setItemName(request.getParameter("itemName"));
		m.setPrice(Integer.parseInt(request.getParameter("price")));
		MenuDao dao=new MenuDao();
		
		try {
			boolean status=dao.UpdateMenu(m);
			if(status) {
				dao.commit();
				request.setAttribute("status", "Updated Successfully");
				RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
				rd.forward(request, response);
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Updation Failed");
				RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
				rd.forward(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
