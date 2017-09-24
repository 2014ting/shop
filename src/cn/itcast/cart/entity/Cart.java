package cn.itcast.cart.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ���ﳵ�࣬���������������ļ��ϣ�������Ʒ���ܼ�
 * ������ɾ��һ����������һ���������ջ���վ
 * @author ����
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
	//��ӹ���������ֿ��ܣ�1�����ﳵ��û�д˹��������ӣ�
	//2�����ﳵ���д˹��������ӣ���Ҫ��ԭ����С����Ҫ��ӵĹ�����С�����
	
	public void addcart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			//�д˹�����
			//��ù��ﳵ��ԭ���Ĺ�����
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			//û�д˹�����
			map.put(pid, cartItem);
		}
		total =total +cartItem.getSubtotal();
	}
	public void removecart(Integer pid){
		CartItem cartItem = map.remove(pid);//�Ƴ���������������Ƴ��Ĺ�����
		total -= cartItem.getSubtotal();
	}
	public  void clear(){
		//��չ�����
		map.clear();
		//�����ܼ�Ϊ0
		total=0;
	}
}
