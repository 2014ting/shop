package cn.itcast.product.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.If;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.Utils.PageBean;
import cn.itcast.categorysecond.entity.CategorySecond;
import cn.itcast.categorysecond.service.CategorySecondService;
import cn.itcast.product.entity.Product;
import cn.itcast.product.service.IProductService;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}
	//注入商品service
	private IProductService productService;
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	//注入二级分类Service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	public File upload;
	public String uploadFileName;
	public String uploadContextPath;
	public void setUploadContextPath(String uploadContextPath) {
		this.uploadContextPath = uploadContextPath;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String findAll(){
		PageBean<Product> pageBean = productService.findallpage(page);
		ServletActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findall";
	}
	//跳转到添加页面
	public String addpage(){
		List<CategorySecond> cslist = categorySecondService.findall();
		ServletActionContext.getContext().getValueStack().set("cslist", cslist);
		return "addpage";
	}
	//保存添加的商品信息
	public String save() throws IOException{
		product.setPdate(new Date());
		if(upload!=null){
			String realpath = ServletActionContext.getServletContext().getRealPath("/products");
			File disfile =  new File(realpath+"//"+uploadFileName);
			FileUtils.copyFile(upload, disfile);
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		return "addsuccess";
	}
	public String delete(){
		
			product = productService.findByid(product.getPid());
			String image = 	product.getImage();
			if(image !=null){
				String path = ServletActionContext.getServletContext().getRealPath("/"+image);
				File disfile = new File(path);
				disfile.delete();
			}
			productService.delete(product);
			return "deletesuccess";
		
	}
	public String editpage(){
		List<CategorySecond> cslist = categorySecondService.findall();
		ServletActionContext.getContext().getValueStack().set("cslist", cslist);
		product = productService.findByid(product.getPid());
		return "edit";
	}
	public String update() throws IOException{
		product.setPdate(new Date());
		if(upload!=null){
			//删除原来的图片
			String image = product.getImage();
			String path = ServletActionContext.getServletContext().getRealPath("/"+image);
			File disfile = new File(path);
			disfile.delete();
			//添加刚上传的图片
			String realpath = ServletActionContext.getServletContext().getRealPath("/products");
			File diskfile =  new File(realpath+"//"+uploadFileName);
			FileUtils.copyFile(upload, diskfile);
			product.setImage("products/"+uploadFileName);
		}
		productService.update(product);
		return "updatesuccess";
	}
	
	
}
