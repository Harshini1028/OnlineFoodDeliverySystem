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

@WebServlet("/delete")
public class DeleteMenu extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sno=Integer.parseInt(request.getParameter("sno"));
		MenuDao dao=new MenuDao();
		try {
			boolean status = dao.deleteBySno(sno);
			if(status) {
				dao.commit();
				RequestDispatcher rd=request.getRequestDispatcher("managemenu");
				rd.forward(request, response);
			}
			else {
				dao.rollback();
				RequestDispatcher rd=request.getRequestDispatcher("managemenu");
				rd.forward(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}