package com.ecommerce.object;

public class Customer 
{
	int customerId;
	String username, email, password, name, surname, address, phone, mobilePhone;
	
	public Customer()
	{
	}
	
	public Customer (int customerId, String username, String email, String password, String name, String surname, String address, String phone, String mobilePhone)
	{
		this.customerId=customerId;
		this.username=username;
		this.email=email;
		this.password=password;
		this.name=name;
		this.surname=surname;
		this.address=address;
		this.phone=phone;
		this.mobilePhone=mobilePhone;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	
}
