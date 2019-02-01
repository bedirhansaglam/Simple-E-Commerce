package com.ecommerce.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.ecommerce.database.DatabaseConnection;
import com.ecommerce.object.ProductImage;

public class ProductImageDAO {

	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public ProductImageDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }

	}
	
	public boolean createProductImage(ProductImage productImg)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createProductImage ( ?, ? )}"); 
			cs.setInt(1, productImg.getProductID());
			cs.setString(2, productImg.getImageURL());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getProductImage(int id)
	{
		try
		{
			cs=con.prepareCall ("{ CALL getProductImage (?)}");
			cs.setInt(1, id);
			resultSet=cs.executeQuery();
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateProductImage(ProductImage productImg, int productImgID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateProductImage ( ?, ?, ? )}"); 
			cs.setInt(1, productImgID);
			cs.setInt(2, productImg.getProductID());
			cs.setString(3, productImg.getImageURL());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean deleteProductImage (int productImgID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteProductImage( ?)}");
			cs.setInt(1, productImgID);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
