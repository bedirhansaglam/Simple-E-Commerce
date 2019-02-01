package com.ecommerce.object;

public class Store 
{
	int storeId;
	String storeName, taxNumber, address, phone, logoUrl;


	public Store ()
	{
	}
	
	public Store (int storeId, String storeName, String taxNumber, String address, String phone, String logoUrl)
	{
		this.storeId=storeId;
		this.storeName=storeName;
		this.taxNumber=taxNumber;
		this.address=address;
		this.phone=phone;
		this.logoUrl=logoUrl;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
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

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	
	
}

