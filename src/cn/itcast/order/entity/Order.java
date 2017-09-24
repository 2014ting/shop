package cn.itcast.order.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.itcast.user.entity.User;

/**
 * CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E5AA3D9C7` (`uid`),
  CONSTRAINT `FKC3DF62E5AA3D9C7` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=9004 DEFAULT CHARSET=utf8;
创建订单类
 * @author 李婷婷
 *
 */
public class Order {
		private int oid ;
		private double total ;
		private Date ordertime ;
		private int state ;
		private String name ;
		private String phone ;
		private String addr ;
		private User user;
		private Set<OrderItem> orderitems = new HashSet<OrderItem>();
		
		@Override
		public String toString() {
			return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state
					+ ", name=" + name + ", phone=" + phone + ", addr=" + addr + ", user=" + user + ", orderitems="
					+ orderitems + "]";
		}
		public int getOid() {
			return oid;
		}
		public void setOid(int oid) {
			this.oid = oid;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public Date getOrdertime() {
			return ordertime;
		}
		public void setOrdertime(Date ordertime) {
			this.ordertime = ordertime;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Set<OrderItem> getOrderitems() {
			return orderitems;
		}
		public void setOrderitems(Set<OrderItem> orderitems) {
			this.orderitems = orderitems;
		}
		
		
}
