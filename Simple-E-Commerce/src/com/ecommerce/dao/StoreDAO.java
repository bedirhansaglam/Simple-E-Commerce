package com.ecommerce.dao;
import java.sql.*;
import com.ecommerce.database.*;
import com.ecommerce.object.*;

public class StoreDAO 
{
	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private Statement stm; 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public StoreDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}
	
	public boolean createStore(Store store)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createStore ( ?, ?, ?, ?, ? )}"); 
			cs.setString(1, store.getStoreName());
			cs.setString(2, store.getTaxNumber());
			cs.setString(3, store.getAddress());
			cs.setString(4, store.getPhone());
			cs.setString(5, store.getLogoUrl());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getStore()
	{
		try
		{
			String query = "CALL getStore()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateStore (Store store,int storeId)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateStore ( ?, ?, ?, ?, ?, ? )}");
			cs.setInt(1, storeId);
			cs.setString(2, store.getStoreName());
			cs.setString(3, store.getTaxNumber());
			cs.setString(4, store.getAddress());
			cs.setString(5, store.getPhone());
			cs.setString(6, store.getLogoUrl());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean deleteStore (int storeId)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteStore( ?)}");
			cs.setInt(1, storeId);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
