package cn.itcast.indexAction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.category.entity.Category;
import cn.itcast.category.service.ICategoryService;
import cn.itcast.product.entity.Product;
import cn.itcast.product.service.IProductService;

public class indexAction extends ActionSupport {
	private ICategoryService categoryService;
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private IProductService productService;
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public String execute() throws Exception {
		List<Category> catelist = categoryService.findAll();
		ActionContext.getContext().getSession().put("catelist", catelist);
		List<Product> hlist = productService.findhost();
		ActionContext.getContext().getValueStack().set("hlist", hlist);;
		
		List<Product> newlist = productService.findnew();
		ActionContext.getContext().getValueStack().set("newlist", newlist);;
		
		return "index";
	}

}
