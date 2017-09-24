<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table border="1">
	<tr>
    <td>商品图片</td>
    <td>商品数量</td>
    <td>小计</td>
  
  </tr>
  <s:iterator  var="orderItem" value="list">
  <tr>
    <td><img width="30px" height="35px" src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>"/></td>
    <td><s:property value="#orderItem.count"/></td>
    <td><s:property value="#orderItem.subtotal"/></td>
  
  </tr>
  </s:iterator>
</table>

