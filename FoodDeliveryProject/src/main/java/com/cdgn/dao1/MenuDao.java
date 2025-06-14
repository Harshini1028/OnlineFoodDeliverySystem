package com.cdgn.dao1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdgn.dao.ConnectionManager;
import com.cdgn.model.Customer;
import com.cdgn.model.Menu;

public class MenuDao {
	Connection connection=null;
	public boolean saveMenu(Menu m) throws ClassNotFoundException, SQLException {
		connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement("INSERT INTO Menu VALUES(?, ?, ?)");
		statement.setInt(1, m.getSno());
		statement.setString(2, m.getItemName());
		statement.setInt(3, m.getPrice());
		
		int status = statement.executeUpdate();
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
		connection.commit();
		connection.close();
	}
	
	
	public List<Menu> ViewAllMenu() throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from Menu");
		
		ResultSet rs=statement.executeQuery();
		List<Menu> menuList=new ArrayList<>();
		while(rs.next()) {
			Menu m=new Menu();
			m.setSno(rs.getInt(1));       
	        m.setItemName(rs.getString(2));
	        m.setPrice(rs.getInt(3));
			
			menuList.add(m);
		}
		return menuList;
	}
	public boolean UpdateMenu(Menu m) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("update Menu set itemName=?,price=? where sno=?");
		
		statement.setString(1, m.getItemName());
		statement.setInt(2, m.getPrice());
		statement.setInt(3, m.getSno());
		int status=statement.executeUpdate();
		if(status==1) {
			return true;
		}
		return false;
	}
	public boolean deleteBySno(int sno) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("delete from menu where sno=?");
		statement.setInt(1, sno);
		int status=statement.executeUpdate();
		if(status==1) {
			return true;
		}
		return false;
	}
	public Menu searchById(int sno) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from menu where sno=?");
		statement.setInt(1, sno);
		ResultSet rs=statement.executeQuery();
		Menu m=new Menu();
		if(rs.next()) {
			m.setSno(rs.getInt(1));       
	        m.setItemName(rs.getString(2));
	        m.setPrice(rs.getInt(3));
		}
		return m;
	}
	public boolean addItems(Menu menu) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("insert into menu values(?,?,?)");
		statement.setInt(1, menu.getSno());
		statement.setString(2, menu.getItemName());
		statement.setInt(3, menu.getPrice());
		
		int status = statement.executeUpdate();
		if(status==1) {
			return true;
		}
		return false;
	}
	public Menu fetchById(int sno) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("select * from menu where sno=?");
		statement.setInt(1, sno);
		ResultSet rs=statement.executeQuery();
		Menu menu=new Menu();
		if(rs.next()) {
			menu.setSno(rs.getInt(1));
			menu.setItemName(rs.getString(2));
			menu.setPrice(rs.getInt(3));
		}
		return menu;
	}
	public boolean removeCart(int sno) throws ClassNotFoundException, SQLException {
		connection=ConnectionManager.getConnection();
		PreparedStatement statement=connection.prepareStatement("delete from menu where sno=?");
		statement.setInt(1, sno);
		int status=statement.executeUpdate();
		if(status==1) {
			return true;
		}
		return false;
	}
	
	
}
