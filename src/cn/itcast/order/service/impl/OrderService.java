package cn.itcast.order.service.impl;


import java.util.List;

import cn.itcast.Utils.PageBean;
import cn.itcast.order.dao.IOrderDao;
import cn.itcast.order.entity.Order;
import cn.itcast.order.entity.OrderItem;
import cn.itcast.order.service.IOrderService;
import cn.itcast.product.entity.Product;

public class OrderService implements IOrderService{
		private IOrderDao orderDao;
		public void setOrderDao(IOrderDao orderDao) {
			this.orderDao = orderDao;
		}
		@Override
		public void save(Order order) {
				orderDao.save(order);
		}
		@Override
		public void delete(Order order) {
			orderDao.delete(order);
		}
		@Override
		public PageBean<Order> findBypageUid(int uid, int page) {
			PageBean<Order> pageBean =new PageBean<Order>();
			int limit =4;
			pageBean.setLimit(limit);
			pageBean.setPage(page);
			//通过用户名编号查询用户的订单数量
			int totalCount =orderDao.findBycountuid(uid);
			pageBean.setTotalCount(totalCount);
			
			int totalpage ;
			if(totalCount % limit == 0){
				totalpage = totalCount/limit;
			}else{
				totalpage = totalCount/limit+1 ;
			}
			pageBean.setTotalpage(totalpage);
			int begin =(page-1)*limit;
			
			//通过uid和page查找当前页的list集合
			List<Order> list = orderDao.findBypageuid(uid,begin,limit);
			pageBean.setList(list);
			return pageBean;
		}
		@Override
		public Order findByoid(int oid) {
			return orderDao.findByoid(oid);
		}
		@Override
		public void updateorder(Order currorder) {
				orderDao.updateorder(currorder);
		}
		@Override
		public PageBean<Order> findpageall(int page) {
			PageBean<Order> pageBean =new PageBean<Order>();
			pageBean.setPage(page);
			int limit=6;
			pageBean.setLimit(limit);
			int totalCount =0;
			totalCount = orderDao.findcount();
			pageBean.setTotalCount(totalCount);
			int totalpage =0;
			if(totalCount%limit==0){
				totalpage = totalCount/limit;
			}else{
				totalpage = totalCount/limit+1;
			}
			pageBean.setTotalpage(totalpage);
			int begin =(page-1)*limit;
			List<Order> list= orderDao.findbypagecount(begin, limit);
			pageBean.setList(list);
			return pageBean;
			
		}
		@Override
		public List<OrderItem> findOrderItem(int oid) {
			List<OrderItem>	list = orderDao.findOrderItem(oid);
			return list;
		}
		
}
