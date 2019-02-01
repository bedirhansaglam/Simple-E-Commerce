package com.ecommerce.dao;
import java.sql.*;
import com.ecommerce.database.DatabaseConnection;
import com.ecommerce.object.Product;

public class ProductDAO {
	
	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private Statement stm; 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public ProductDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}

	public boolean createProduct(Product product)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createProduct ( ?, ?, ?, ? )}"); 
			cs.setString(1, product.getName());
			cs.setString(2, product.getDescription());
			cs.setInt(3, product.getCategoryID());
			cs.setBigDecimal(4, product.getPrice());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getProducts()
	{
		try
		{
			String query = "CALL getProducts()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public ResultSet getProductByID(int id)
	{
		try
		{
			cs=con.prepareCall ("{ CALL getProductByID (?)}");
			cs.setInt(1, id);
			resultSet=cs.executeQuery();
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateProduct(Product product, int productID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateProduct ( ?, ?, ?, ?,? )}"); 
			cs.setInt(1, productID);
			cs.setString(2, product.getName());
			cs.setString(3, product.getDescription());
			cs.setInt(4, product.getCategoryID());
			cs.setBigDecimal(5, product.getPrice());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	public boolean deleteProduct (int productID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteProduct( ?)}");
			cs.setInt(1, productID);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
