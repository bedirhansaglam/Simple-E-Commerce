package com.ecommerce.object;

public class Supplier 
{
	int supplierId, storeId;
	String username, email, password, name, surname, phone, mobilePhone;
	boolean isAdmin;
	
	public Supplier ()
	{
	}
	
	public Supplier (int supplierId, int storeId, String username, String email, String password, String name, String surname, String phone, String mobilePhone, boolean isAdmin)
	{
		this.supplierId=supplierId;
		this.storeId=storeId;
		this.username=username;
		this.email=email;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.phone=phone;
		this.mobilePhone=mobilePhone;
		this.isAdmin=isAdmin;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
