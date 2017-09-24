package cn.itcast.categorysecond.adminaction;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.Utils.PageBean;
import cn.itcast.categorysecond.entity.CategorySecond;
import cn.itcast.categorysecond.service.CategorySecondService;

public class AdminCategorySecondAction  extends ActionSupport implements ModelDriven<CategorySecond>{
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	private CategorySecond categorySecond =new CategorySecond();
	
	
	public CategorySecond getModel() {
		return categorySecond;
	}
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	public String findAll(){
		PageBean<CategorySecond> pageBean = categorySecondService.findallpage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findall";
	}
	public String addpage() {
		return "addpage";
	}
	public String save(){
		categorySecondService.save(categorySecond);
		return "savasuccess";
	}
	public String editpage() {
		categorySecond  =categorySecondService.findbycsid(categorySecond.getCsid());
		return "editpage";
		
	}
	public String update(){
		 categorySecondService.update(categorySecond);
		return "updatesuccess";
	}
	public String delete(){
		
		 categorySecondService.delete(categorySecond);
		return "deletesuccess";
	}
}
