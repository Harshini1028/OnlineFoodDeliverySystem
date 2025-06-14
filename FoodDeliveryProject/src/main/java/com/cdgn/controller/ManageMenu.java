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

import com.cdgn.dao1.MenuDao;
import com.cdgn.model.Menu;

@WebServlet("/managemenu")
public class ManageMenu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuDao dao=new MenuDao();
		try {
			List<Menu> menuList=dao.ViewAllMenu();
			request.setAttribute("menuList", menuList);
			RequestDispatcher rd=request.getRequestDispatcher("managemenu.jsp");
			rd.forward(request, response);
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
