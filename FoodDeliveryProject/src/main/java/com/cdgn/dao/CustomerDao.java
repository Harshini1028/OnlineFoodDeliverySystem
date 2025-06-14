package com.cdgn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cdgn.model.Customer;
import com.cdgn.model.Menu;

public class CustomerDao {
	Connection connection=null;
	public boolean saveCustomer(Customer c) throws SQLException, ClassNotFoundException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("insert into Customer value(?,?,?,?,?,?)");
		statement.setString(1, c.getName());
		statement.setString(2, c.getEmail());
		statement.setString(3, c.getPassword());
		statement.setString(4, c.getPhno());
		statement.setInt(5,c.getAge());
		statement.setString(6, c.getAddress());
		
		int status=statement.executeUpdate();
		if(status==1) {
			return true;
		}
		
		return false;
	}
	public void commit() throws SQLException {
		connection.commit();
		connection.close();
		
	}
	public void rollback() throws SQLException {
		connection.rollback();
		connection.close();
		
	}
	public boolean checkLoginDetails(String email, String password) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select count(*) from Customer where email=? and password=?");
		statement.setString(1, email);
		statement.setString(2, password);
		ResultSet rs=statement.executeQuery();
		int count=0;
		if(rs.next()) {
			count=rs.getInt(1);
		}
		if(count==1) {
			return true;
		}
		return false;
	}
	public List<Customer> ViewAllCustomers() throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from Customer");
		
		ResultSet rs=statement.executeQuery();
		List<Customer> orderList=new ArrayList<>();
		while(rs.next()) {
			Customer c=new Customer();
			c.setName(rs.getString(1));
			c.setEmail(rs.getString(2));
			c.setPassword(rs.getString(3));
			c.setPhno(rs.getString(4));
			c.setAge(rs.getInt(5));
			c.setAddress(rs.getString(6));
			orderList.add(c);
		}
		return orderList;
	}
	public Customer getDetails(String email) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select* from customer where email=?");
		statement.setString(1, email);
		ResultSet rs=statement.executeQuery();
		Customer c=new Customer();
		if(rs.next()) {
			c.setName(rs.getString(1));
			c.setEmail(rs.getString(2));
			c.setPassword(rs.getString(3));
			c.setPhno(rs.getString(4));
			c.setAge(rs.getInt(5));
			c.setAddress(rs.getString(6));
		}
		return c;
	}
	public List<Menu> getCustomerMenu() throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from menu");
		
		ResultSet rs=statement.executeQuery();
		List<Menu> list=new ArrayList<Menu>();
		while(rs.next()) {
			Menu menu=new Menu();
			menu.setSno(rs.getInt(1));
			menu.setItemName(rs.getString(2));
			menu.setPrice(rs.getInt(3));
			list.add(menu);
		}
		return list;
	}
	
	
}
