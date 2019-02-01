package com.ecommerce.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.ecommerce.database.DatabaseConnection;
import com.ecommerce.object.SubCategory;

public class SubCategoryDAO {

	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public SubCategoryDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		
	}
	
	public boolean createSubCategory(SubCategory subCategory)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createSubcategory ( ?, ?,? )}"); 
			cs.setInt(1, subCategory.getCategoryID());
			cs.setString(2, subCategory.getName());
			cs.setString(3, subCategory.getDescription());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	public boolean updateSubCategory(SubCategory subCategory)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateSubcategory ( ?, ?,?,? )}"); 
			cs.setInt(1, subCategory.getSubCategoryID());
			cs.setInt(2, subCategory.getCategoryID());
			cs.setString(3, subCategory.getName());
			cs.setString(4, subCategory.getDescription());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getSubCategory(int subCategoryID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL getSubcategory (?)}");
			cs.setInt(1, subCategoryID);
			resultSet=cs.executeQuery();
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean deleteSubCategory (int subCategoryID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteSubcategory( ?)}");
			cs.setInt(1, subCategoryID);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
