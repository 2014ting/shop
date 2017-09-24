package cn.itcast.order.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.Utils.PageHibernateCallback;
import cn.itcast.order.dao.IOrderDao;
import cn.itcast.order.entity.Order;
import cn.itcast.order.entity.OrderItem;

public class OrderDao extends HibernateDaoSupport implements IOrderDao{

	@Override
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	@Override
	public void delete(Order order) {
		this.getHibernateTemplate().delete(order);
	}

	@Override
	public int findBycountuid(int uid) {
		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, uid);
		if(list !=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findBypageuid(int uid, int begin, int limit) {
		String hql = "from Order  o where o.user.uid = ? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,new Object[]{uid},begin,limit));
		if(list !=null && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public Order findByoid(int oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	@Override
	public void updateorder(Order currorder) {
			this.getHibernateTemplate().update(currorder);
	}

	@Override
	public List<Order> findbypagecount(int begin, int limit) {
		String hql="from Order";
		List<Order> list =this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql,null,begin,limit));
		if(list !=null && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int findcount() {
		List<Long> list = (List<Long>) this.getHibernateTemplate().find("select count(*) from Order");
		if(list!= null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<OrderItem> findOrderItem(int oid) {
		String hql ="from OrderItem oi where oi.order.oid=?";
		List<OrderItem> list= 	(List<OrderItem>) this.getHibernateTemplate().find(hql, oid);
		
		return list;
	}
	
}
