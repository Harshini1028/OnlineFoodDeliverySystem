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

@WebServlet("/search")
public class SearchMenu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno=Integer.parseInt(request.getParameter("sno"));
		MenuDao dao=new MenuDao();
		try {
			Menu m = dao.searchById(sno);
			if(m.getSno()!=0) {
				request.setAttribute("m", m);
				RequestDispatcher rd=request.getRequestDispatcher("viewmenu.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("status", "Invalid Id");
				RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
				rd.forward(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
