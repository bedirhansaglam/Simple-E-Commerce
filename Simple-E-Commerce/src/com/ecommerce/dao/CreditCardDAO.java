package com.ecommerce.dao;
import java.sql.*;
import com.ecommerce.database.DatabaseConnection;
import com.ecommerce.object.CreditCard;


public class CreditCardDAO {

	private Connection con; 
	private String driver=DatabaseConnection.getDriver(); 
	private String url=DatabaseConnection.getUrl(); 
	private Statement stm; 
	private ResultSet resultSet = null; 
	private CallableStatement cs;
	
	public CreditCardDAO()
	{
		try { Class.forName(driver).newInstance(); System.out.println("JDBC surucu basari ile yüklendi."); } catch (Exception e) { System.out.println("JDBC surucu Yüklenemedi. Hata:"+e.getMessage()); System.exit(0); }
		try{con=DriverManager.getConnection(url,DatabaseConnection.getKullaniciadi(),DatabaseConnection.getSifre());System.out.println("Veritabanina Baglanildi.");}catch (Exception e) { System.out.println("Veri Tabanina Baglanilmadi. Hata:"+e.getMessage()); System.exit(0); }
		try {stm=con.createStatement();}catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); }
	}
	
	public boolean createCreditCard(CreditCard creditCard)
	{
		try
		{
			cs=con.prepareCall ("{ CALL createCreditCard ( ?, ?, ?, ?, ?, ? )}"); 
			cs.setInt(1, creditCard.getCustomerID());
			cs.setString(2, creditCard.getNumber());
			cs.setString(3, creditCard.getName());
			cs.setString(4, creditCard.getSurname());
			cs.setString(5, creditCard.getExpirationDate());
			cs.setString(6, creditCard.getCvv());
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public ResultSet getCreditCard()
	{
		try
		{
			String query = "CALL getCreditCard()";
			resultSet=stm.executeQuery(query);
			
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0);}
		return resultSet;
	}
	
	public boolean updateCreditCard (CreditCard creditCard,int creditCardID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL updateCreditCard ( ?, ?, ?, ?, ?, ?, ? )}");
			cs.setInt(1, creditCardID);
			cs.setInt(2, creditCard.getCustomerID());
			cs.setString(3, creditCard.getNumber());
			cs.setString(4, creditCard.getName());
			cs.setString(5, creditCard.getSurname());
			cs.setString(6, creditCard.getExpirationDate());
			cs.setString(7, creditCard.getCvv());

			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
	
	public boolean deleteCreditCard (int creditCardID)
	{
		try
		{
			cs=con.prepareCall ("{ CALL deleteCreditCard( ?)}");
			cs.setInt(1, creditCardID);
			cs.execute();
			return true;
		}
		catch (Exception e) { System.out.println("Hata:"+e.getMessage()); System.exit(0); return false;}
	}
}
