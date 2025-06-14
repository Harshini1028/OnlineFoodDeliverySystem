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


@WebServlet("/savee")
public class SaveeMenuServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDao dao=new MenuDao();
		Menu m=new Menu();
		m.setSno(Integer.parseInt(request.getParameter("sno")));
		m.setItemName(request.getParameter("itemName"));
		m.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			boolean status=dao.saveMenu(m);
			RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
			if(status) {
				dao.commit();
				request.setAttribute("status", "Menu Saved....");
				rd.forward(request, response);
			}
			else {
				dao.rollback();
				request.setAttribute("status", "Menu UnSaved....");
				rd.forward(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
