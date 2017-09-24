package cn.itcast.category.entity;

import java.util.Set;

import cn.itcast.categorysecond.entity.CategorySecond;

/**
 * CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
)
创建一级分类对象
 * @author 李婷婷
 *
 */
public class Category {
	private  int cid;
	private String cname;
	private Set<CategorySecond> categoryseconds;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategoryseconds() {
		return categoryseconds;
	}
	public void setCategoryseconds(Set<CategorySecond> categoryseconds) {
		this.categoryseconds = categoryseconds;
	}
	
	
	
}
