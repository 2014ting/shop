<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>我的订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="./网上商城/index.htm">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	
</div>
	
	<%@include file="menu.jsp" %>
</div>	

<div class="container cart">

		<div class="span24">
		
				<table>
					<tbody>
					<s:iterator value="pageBean.list" var="order">
						<tr>
							<th colspan="2">
							订单编号：<s:property  value="#order.oid"/>
							</th>
							<th colspan="3">
								<s:if test="#order.state==0">
									订单状态 : 未付款   &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/order_findByoid?oid=<s:property  value="#order.oid"/>"><font color="red">去付款</font></a>
								</s:if>
								<s:if test="#order.state==1">
									订单状态 : &nbsp;已付款
								</s:if>
								<s:if test="#order.state==2">
									订单状态 :&nbsp; <a href="${pageContext.request.contextPath}/order_updatestate?oid=<s:property  value="#order.oid"/>"><font color="red">确认收货</font></a>
								</s:if>
								<s:if test="#order.state==3">
									订单状态 : &nbsp;&nbsp;<a href="#"> <font color="red">订单完成</font></a>
								</s:if>
							</th>
						</tr>
						
						<tr>
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
					
						<s:iterator value = "#order.orderitems" var="orderItem">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>"/>
							</td>
							<td>
								<a target="_blank"><s:property value="#orderItem.product.pname"/></a>
							</td>
							<td>
								<s:property value="#orderItem.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
								<input type="text" name="count" value="<s:property value="#orderItem.count"/>" maxlength="4" onpaste="return false;"/>
								<div>
									<span class="increase">&nbsp;</span>
									<span class="decrease">&nbsp;</span>
								</div>
							</td>
							<td width="140">
								<span class="subtotal">￥<s:property value="#orderItem.subtotal"/></span>
							</td>
							
						</tr>
					</s:iterator>
					</s:iterator>
					</tbody>
					
			</table>
				<div class="pagination">
						
						<span>第<s:property value="pageBean.page"/>/<s:property  value="pageBean.totalpage"/>页</span>
				
							<s:if test="pageBean.page!=1">
								<a  class="firstPage" href="${pageContext.request.contextPath}/order_findBypageUid?page=1">&nbsp;</a>
								<a  class="previousPage" href="${pageContext.request.contextPath}/order_findBypageUid?page=<s:property value="pageBean.page-1"/>">&nbsp;</a>
							</s:if>
				
							<s:iterator var="i" begin="1" end="pageBean.totalpage">
								<s:if test="pageBean.page!=#i">
								<!-- 不是当前页 -->
									<a href="${pageContext.request.contextPath}/order_findBypageUid?page=<s:property value="#i"/>">	<span ><s:property value="#i"/></span></a>
								
								</s:if>
								<s:else>
									<a href="${pageContext.request.contextPath}/order_findBypageUid?page=<s:property value="#i"/>"><span class="currentPage"><s:property value="#i"/></span></a>
								</s:else>
							</s:iterator> 
					
							<s:if test="pageBean.page!=pageBean.totalpage">
								<a class="nextPage" href="${pageContext.request.contextPath}/order_findBypageUid?page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
								
								<a class="lastPage" href="${pageContext.request.contextPath}/order_findBypageUid?page=<s:property value="pageBean.totalpage"/>">&nbsp;</a>
							</s:if>
				
						</div>
			
		</div>
		
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950">
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body>
</html>
								