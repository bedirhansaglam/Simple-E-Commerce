package com.ecommerce.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ecommerce.database.DatabaseConnection;
import com.ecommerce.object.Category;

public class CategoryDAO {
	
	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private Statement stm; 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public CategoryDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}

	public boolean createCategory(Category category)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createCategory ( ?, ? )}"); 
			cs.setString(1, category.getName());
			cs.setString(2, category.getDescription());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean updateCategory(Category category)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateCategory ( ?, ? ,? )}"); 
			cs.setInt(1, category.getCategoryID());
			cs.setString(2, category.getName());
			cs.setString(3, category.getDescription());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getCategory()
	{
		try
		{
			String query = "CALL getCategory()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean deleteCategory (int categoryID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteCategory( ?)}");
			cs.setInt(1, categoryID);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
