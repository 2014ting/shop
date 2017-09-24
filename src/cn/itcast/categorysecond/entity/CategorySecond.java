package cn.itcast.categorysecond.entity;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.category.entity.Category;
import cn.itcast.product.entity.Product;

public class CategorySecond {
	private int csid;
	private String csname;
	private Category category;
	private Set<Product> productlist =new HashSet<Product>();
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(Set<Product> productlist) {
		this.productlist = productlist;
	}
	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", category=" + category + ", productlist="
				+ productlist + "]";
	}
	
	
	
}
