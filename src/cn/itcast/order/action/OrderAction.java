package cn.itcast.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.Utils.PageBean;
import cn.itcast.Utils.PaymentUtil;
import cn.itcast.cart.entity.Cart;
import cn.itcast.cart.entity.CartItem;
import cn.itcast.order.entity.Order;
import cn.itcast.order.entity.OrderItem;
import cn.itcast.order.service.IOrderService;
import cn.itcast.user.entity.User;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{
		private  Order order =new Order();
		@Override
		public Order getModel() {
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
		private String pd_FrpId;
		public void setPd_FrpId(String pd_FrpId) {
			System.out.println(pd_FrpId+"===============>");
			this.pd_FrpId = pd_FrpId;
		}
		//接收支付网站返回的商品信息
		private String r6_Order;
		public void setR6_Order(String r6_Order) {
			this.r6_Order = r6_Order;
		}
		private String r3_Amt;
		public void setR3_Amt(String r3_Amt) {
			this.r3_Amt = r3_Amt;
		}
		public String saveorder() {
			User exitsUser  = (User) ServletActionContext.getRequest().getSession().getAttribute("exitsUser");
			if(exitsUser==null){
				this.addActionError("亲！你还没有登录，请先去登录！！");
				return "loginpage";
			}
			System.out.println("========");
			order.setOrdertime(new Date());
			order.setState(0);
			Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
			order.setTotal(cart.getTotal());
			for (CartItem  cartItem : cart.getCartItems()) {
				OrderItem orderItem  =new OrderItem();
				orderItem.setSubtotal(cartItem.getSubtotal());
				orderItem.setCount(cartItem.getCount());
				orderItem.setOrder(order);
				orderItem.setProduct(cartItem.getProduct());
				order.getOrderitems().add(orderItem);
			}
			
			
			order.setUser(exitsUser);
			orderService.save(order);
			Cart cart1 = (Cart)ServletActionContext.getContext().getSession().get("cart");
			cart1.clear();
			return "savesuccess";
			
			
		}
		public String deleteorder() {
			orderService.delete(order);
			return "deleteorder";
		}
		
		public String findBypageUid() {
			User user = (User)ServletActionContext.getRequest().getSession().getAttribute("exitsUser");
			int uid = user.getUid();
			PageBean<Order> pageBean = orderService.findBypageUid(uid,page);
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			
			
			return "findBypageUid";
		}
		//根据oid查询订单
		public String findByoid() {
			order = orderService.findByoid(order.getOid());
			
			return "findByoid";
		}
		//订单付款方法
		public String payOrder() throws IOException  {
			
				Order currorder = 	orderService.findByoid(order.getOid());
				currorder.setName(order.getName());
				currorder.setAddr(order.getAddr());
				currorder.setPhone(order.getPhone());
				orderService.updateorder(currorder);
				//转向第三方支付公司的请求参数的设置
				String  p0_Cmd = "Buy";  //业务类型
				String p1_MerId ="10001126856"; //商户编号
				String p2_Order =order.getOid()+""; //订单编号
				String p3_Amt ="0.01"; //付款金额
				String  p4_Cur ="CNY"; //交易币种
				String p5_Pid =""; //商品名称
				String p6_Pcat =""; //商品种类
				String p7_Pdesc =""; //商品描述
				String  p8_Url ="http://localhost:8080/shopping/order_callback ";//支付成功后跳转的页面路径
				String  p9_SAF =""; //送货地址
				String  pa_MP =""; // 扩展信息
				String   pd_FrpId =this.pd_FrpId; //支付通道编码
				String pr_NeedResponse="1"; //应答机制
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
				StringBuffer stringBuffer = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
				stringBuffer.append("p0_Cmd="+p0_Cmd+"&");
				stringBuffer.append("p1_MerId="+p1_MerId+"&");
				stringBuffer.append("p2_Order="+p2_Order+"&");
				stringBuffer.append("p3_Amt="+p3_Amt+"&");
				stringBuffer.append("p4_Cur="+p4_Cur+"&");
				stringBuffer.append("p5_Pid="+p5_Pid+"&");
				stringBuffer.append("p6_Pcat="+p6_Pcat+"&");
				stringBuffer.append("p7_Pdesc="+p7_Pdesc+"&");
				
				stringBuffer.append("p8_Url="+p8_Url+"&");
				
				stringBuffer.append("p9_SAF="+p9_SAF+"&");
				stringBuffer.append("pa_MP ="+pa_MP+"&");
				stringBuffer.append("pd_FrpId="+pd_FrpId+"&");
				stringBuffer.append("pr_NeedResponse="+pr_NeedResponse+"&");
				stringBuffer.append("hmac="+hmac);
				ServletActionContext.getResponse().sendRedirect(stringBuffer.toString());
			
			return NONE;
		}
		public String  callback() {
			Order currOrder = orderService.findByoid(Integer.parseInt(r6_Order));
			currOrder.setState(1);
			orderService.updateorder(currOrder);
			this.addActionMessage("付款成功！！ 商品编号："+r6_Order+" 付款金额："+r3_Amt);
			return "msg";
			
		}
		public String updatestate(){
			Order currorder = orderService.findByoid(order.getOid());
			currorder.setState(3);
			orderService.updateorder(currorder);
			
			return "updatesuccess";
		}
		
}
