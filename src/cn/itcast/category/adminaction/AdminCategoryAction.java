package cn.itcast.category.adminaction;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.category.entity.Category;
import cn.itcast.category.service.ICategoryService;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	private Category category=new Category();

	@Override
	public Category getModel() {
		// TODO Auto-generated method stub
		return category;
	}
	private ICategoryService categoryService;
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public String findAll(){
		List<Category> clist  = categoryService.findAll();
		if(clist!=null){
			ActionContext.getContext().getValueStack().set("clist", clist);
		}
		return "findall";
	}
	public String addpage(){
		return "addpage";
	}
	public String save(){
		categoryService.save(category);
		return "savesuccess";
	}
	public String delete() {
		 category = categoryService.findByCid(category.getCid());
		categoryService.delete(category);
		return "deletesuccess";
		
	}
	public String update() {
		categoryService.update(category);
		return "update";
	}
	public String editpage(){
		 category  = categoryService.findByCid(category.getCid());
		return "editpage";
	}
	
}
