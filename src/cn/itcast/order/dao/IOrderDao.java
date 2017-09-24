package cn.itcast.order.dao;

import java.util.List;

import cn.itcast.order.entity.Order;
import cn.itcast.order.entity.OrderItem;
import cn.itcast.product.entity.Product;

public interface IOrderDao {

	void save(Order order);

	void delete(Order order);

	int findBycountuid(int uid);

	List<Order> findBypageuid(int uid, int begin, int limit);

	Order findByoid(int oid);

	void updateorder(Order currorder);


	List<Order> findbypagecount(int begin, int limit);

	int findcount();

	List<OrderItem> findOrderItem(int oid);

}
