package cn.itcast.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.cart.entity.Cart;
import cn.itcast.cart.entity.CartItem;
import cn.itcast.product.entity.Product;
import cn.itcast.product.service.IProductService;
import cn.itcast.product.service.impl.ProductService;

public class CartAction extends ActionSupport{
	private Integer pid;
	private int count;
	public void setCount(int count) {
		this.count = count;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private IProductService productService;
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	public String addcart(){
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		
		Product product = productService.findByid(pid);
		cartItem.setProduct(product);
		//获得session中保存的购物车，如果购物车为空，则在session中新建一个购物车
		Cart cart = getCart();
		cart.addcart(cartItem);
		return "addcart";
	}
	private Cart getCart() {
		Cart cart=null;
		cart = (Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart==null){
			cart =new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);;
		}
	
		return cart;
	}
	
	public String clearcart(){
		Cart cart = getCart();
		cart.clear();
		return "clearcart";
	}
	public String deletecart(){
		Cart cart = getCart();
		cart.removecart(pid);
		return "deletecart";
	}
	public String mycart(){
		
		return "mycart";
	}
	
}
