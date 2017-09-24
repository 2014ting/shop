package cn.itcast.product.action;




import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.Utils.PageBean;
import cn.itcast.category.service.ICategoryService;
import cn.itcast.product.entity.Product;
import cn.itcast.product.service.IProductService;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product=new Product();
	public void setProduct(Product product) {
		this.product = product;
	}
	private IProductService productService;
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	private ICategoryService categoryService;
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	private int cid;
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCid() {
		return cid;
	}
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	private int csid;
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public int getCsid() {
		return csid;
	}
	public String findByid(){
		product = productService.findByid(product.getPid());
		return "findByid";
	}
	public String findBycid() {
		PageBean<Product> pageBean=productService.findBypagecid(cid, page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findBycid";
	}
	public String findBycsid() {
		PageBean<Product> pageBean=productService.findBypagecsid(csid, page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findBycsid";
	}
	
	@Override
	public Product getModel() {
		return product;
	}
	
}
