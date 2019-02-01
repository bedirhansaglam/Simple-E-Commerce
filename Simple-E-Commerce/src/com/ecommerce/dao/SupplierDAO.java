package com.ecommerce.dao;
import java.sql.*;
import com.ecommerce.database.*;
import com.ecommerce.object.*;

public class SupplierDAO 
{
	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private Statement stm; 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public SupplierDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}
	
	public boolean createSupplier(Supplier supplier)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createSupplier ( ?, ?, ?, ?, ?, ?, ?, ?, ? )}"); 
			cs.setInt(1, supplier.getStoreId());
			cs.setString(2, supplier.getUsername());
			cs.setString(3, supplier.getEmail());
			cs.setString(4, supplier.getPassword());
			cs.setString(5, supplier.getName());
			cs.setString(6, supplier.getSurname());
			cs.setString(7, supplier.getPhone());
			cs.setString(8, supplier.getMobilePhone());
			cs.setBoolean(9, supplier.isAdmin());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getSupplier()
	{
		try
		{
			String query = "CALL getSupplier()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateSupplier (Supplier supplier,int supplierId)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateSupplier ( ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setInt(1, supplierId);
			cs.setString(2, supplier.getUsername());
			cs.setString(3, supplier.getEmail());
			cs.setString(4, supplier.getPassword());
			cs.setString(5, supplier.getName());
			cs.setString(6, supplier.getSurname());
			cs.setString(7, supplier.getPhone());
			cs.setString(8, supplier.getMobilePhone());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean deleteSupplier (int supplierId)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteSupplier( ?)}");
			cs.setInt(1, supplierId);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
