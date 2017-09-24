package cn.itcast.cart.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车类，参数：多个购物项的集合，多种商品的总计
 * 方法：删除一个购物项，添加一个购物项，清空回收站
 * @author 李婷
 *
 */
public class Cart implements Serializable{
		
	private Map<Integer,CartItem> map =new LinkedHashMap<Integer,CartItem> ();	private double total;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public  Collection<CartItem> getCartItems(){
		return map.values();
	}
	//添加购物项，有两种可能，1：购物车中没有此购物项，则添加，
	//2：购物车中有此购物项，则不添加，但要把原来的小计与要添加的购物项小计相加
	
	public void addcart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			//有此购物项
			//获得购物车中原来的购物项
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			//没有此购物项
			map.put(pid, cartItem);
		}
		total =total +cartItem.getSubtotal();
	}
	public void removecart(Integer pid){
		CartItem cartItem = map.remove(pid);//移除购物项，并返回所移除的购物项
		total -= cartItem.getSubtotal();
	}
	public  void clear(){
		//清空购物项
		map.clear();
		//设置总计为0
		total=0;
	}
}
