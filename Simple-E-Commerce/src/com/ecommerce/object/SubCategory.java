package com.ecommerce.object;

public class SubCategory {

	int subCategoryID,categoryID;
	String name,description;
	
	public int getSubCategoryID() {
		return subCategoryID;
	}
	public void setSubCategoryID(int subCategoryID) {
		this.subCategoryID = subCategoryID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
