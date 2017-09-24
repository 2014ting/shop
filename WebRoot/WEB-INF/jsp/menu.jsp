<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.exitsUser ==null ">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_loginpage">登录</a>|
					</li>
					<li id="headerRegister" class="headerRegister" style="display: list-item;">
						<a href="${pageContext.request.contextPath}/user_registerpage">注册</a>|
					</li>
				</s:if>
				<s:else>
					<li >欢迎你  ：<s:property value="#session.exitsUser.name"/></li>
						<li >
					<a href="${pageContext.request.contextPath}/user_quit">[退出]</a>|
					</li>
					<li  style="display: list-item;">
						<a href="${pageContext.request.contextPath}/order_findBypageUid?page=1">我的订单</a>|
					</li>
				</s:else>
						<li>
							<a >会员中心</a>
							|
						</li>
						<li>
							<a >购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a href="${pageContext.request.contextPath}/cart_mycart">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath}/index">首页</a>
						|
					</li>
					<s:iterator  var="c" value="#session.catelist">
						<li>
							<a href="${pageContext.request.contextPath}/product_findBycid?cid=<s:property value="#c.cid"/>&&page=1"><s:property value="#c.cname"/></a>
							|
						</li>
					</s:iterator>
					
					
		</ul>
	</div>
</html>
