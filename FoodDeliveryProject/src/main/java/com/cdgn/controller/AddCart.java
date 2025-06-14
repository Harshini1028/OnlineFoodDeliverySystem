package com.cdgn.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

//@WebServlet("/cart")
//public class AddCart extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 int sno=Integer.parseInt(request.getParameter("sno"));
//		 String itemName=request.getParameter("itemName");
//		 int price=Integer.parseInt(request.getParameter("price"));
//		 Menu menu=new Menu();
//		 menu.setSno(sno);
//		 menu.setItemName(itemName);
//		 menu.setPrice(price);
//		 if(menu!=null) {
//			 List<Menu> list=new ArrayList<Menu>();
//			 list.add(menu);
//			 request.setAttribute("list", list);
//			 RequestDispatcher rd=request.getRequestDispatcher("addcart.jsp");
//			 rd.forward(request, response);
//		 }
//		 
//		 
//		 
		 
@WebServlet("/cart")
public class AddCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        String itemName = request.getParameter("itemName");
        int price = Integer.parseInt(request.getParameter("price"));

        Menu menu = new Menu();
        menu.setSno(sno);
        menu.setItemName(itemName);
        menu.setPrice(price);

        // Access the session
        HttpSession session = request.getSession();

        // Retrieve existing cart or create new one
        List<Menu> cartList = (List<Menu>) session.getAttribute("cart");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        // Add new item
        cartList.add(menu);

        // Save updated list back to session
        session.setAttribute("cart", cartList);

        // Forward to cart display page
        request.setAttribute("list", cartList);
        RequestDispatcher rd = request.getRequestDispatcher("addcart.jsp");
        rd.forward(request, response);
    }

 
		 
		 
		 
		 
		 
		 
		 
//		 for(Menu m:list) {
//			 System.out.println(m);
//		 }
		 
		 
		 
		 
//		    MenuDao dao=new MenuDao();
//		    
//		    try {
//				Menu menu=dao.fetchById(sno);
//				if(menu!=null) {
//					request.setAttribute("menu", menu);
//					RequestDispatcher rd=request.getRequestDispatcher("addcart.jsp");
//					rd.forward(request, response);
//				}
//			} 
//		    catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
		
		
		
//		MenuDao dao=new MenuDao();
//		Menu menu=new Menu();
//		menu.setSno(Integer.parseInt(request.getParameter("sno")));
//		menu.setItemName(request.getParameter("itemName"));
//		menu.setPrice(Integer.parseInt(request.getParameter("price")));
//		try {
//			boolean status=dao.addItems(menu);
//			RequestDispatcher rd=request.getRequestDispatcher("addcart.jsp");
//			if(status) {
//				dao.commit();
//				request.setAttribute("status", "Menu added to cart....");
//				rd.forward(request, response);
//			}
//			else {
//				dao.rollback();
//				request.setAttribute("status", "Menu not added to cart....");
//				rd.forward(request, response);
//			}
//		} 
//		catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    
    
    

	
}
