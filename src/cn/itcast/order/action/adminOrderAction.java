package cn.itcast.order.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.Utils.PageBean;
import cn.itcast.order.entity.Order;
import cn.itcast.order.entity.OrderItem;
import cn.itcast.order.service.IOrderService;

public class adminOrderAction extends ActionSupport implements ModelDriven<Order> {
		private Order order =new Order();

		@Override
		public Order getModel() {
			// TODO Auto-generated method stub
			return order;
		}
		private IOrderService orderService;
		public void setOrderService(IOrderService orderService) {
			this.orderService = orderService;
		}
		private int page;
		public void setPage(int page) {
			this.page = page;
		}
		
		public String findAll(){
			PageBean<Order> pageBean =orderService.findpageall(page);
			ServletActionContext.getContext().getValueStack().set("pageBean", pageBean);
			return "findall";
		}
		public String findOrderItem(){
			List<OrderItem> list = orderService.findOrderItem(order.getOid());
			ActionContext.getContext().getValueStack().set("list", list);
			return "findOrderItem";
		}
		public String updateorder(){
			Order currorder = orderService.findByoid(order.getOid());
			
			currorder.setState(2);
			orderService.updateorder(currorder);
			
			return "updatesuccess";
			
		}
}
