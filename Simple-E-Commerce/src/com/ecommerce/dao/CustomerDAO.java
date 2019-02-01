package com.ecommerce.dao;
import java.sql.*;
import com.ecommerce.database.*;
import com.ecommerce.object.*;

public class CustomerDAO 
{
	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private Statement stm; 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public CustomerDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}
	
	public boolean createCustomer(Customer customer)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createCustomer ( ?, ?, ?, ?, ?, ?, ?, ? )}"); 
			cs.setString(1, customer.getUsername());
			cs.setString(2, customer.getEmail());
			cs.setString(3, customer.getPassword());
			cs.setString(4, customer.getName());
			cs.setString(5, customer.getSurname());
			cs.setString(6, customer.getAddress());
			cs.setString(7, customer.getPhone());
			cs.setString(8, customer.getMobilePhone());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getCustomer()
	{
		try
		{
			String query = "CALL getCustomer()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateCustomer (Customer customer,int customerId)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateCustomer ( ?, ?, ?, ?, ?, ?, ?, ?, ? )}");
			cs.setInt(1, customerId);
			cs.setString(2, customer.getUsername());
			cs.setString(3, customer.getEmail());
			cs.setString(4, customer.getPassword());
			cs.setString(5, customer.getName());
			cs.setString(6, customer.getSurname());
			cs.setString(7, customer.getAddress());
			cs.setString(8, customer.getPhone());
			cs.setString(9, customer.getMobilePhone());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean deleteCustomer (int customerId)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteCustomer( ?)}");
			cs.setInt(1, customerId);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
