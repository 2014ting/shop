package cn.itcast.cart.entity;

import cn.itcast.product.entity.Product;
/**
 * 购物项类
 * 有三个参数，商品，商品数量，一种商品的小计
 * @author 李婷婷
 *
 */
public class CartItem {
	private Product product;
	private int count;
	private double subtotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
}
