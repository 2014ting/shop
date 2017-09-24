package cn.itcast.order.service;

import java.util.List;

import cn.itcast.Utils.PageBean;
import cn.itcast.order.entity.Order;
import cn.itcast.order.entity.OrderItem;

public interface IOrderService {

	void save(Order order);

	void delete(Order order);

	PageBean<Order> findBypageUid(int uid, int page);

	Order findByoid(int oid);

	void updateorder(Order currorder);

	PageBean<Order> findpageall(int page);

	List<OrderItem> findOrderItem(int oid);

}
