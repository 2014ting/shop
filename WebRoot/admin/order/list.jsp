<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/01.js"></script>
		<script type="text/javascript">
			function showDetail(oid){
					
				 var div = document.getElementById("div"+oid);
			 	 var but =  document.getElementById("but"+oid);
			  
			  if(but.value == "订单详情"){
			  	 var ajax = create();
				 var method ="get";
				
				 var url= "${pageContext.request.contextPath}/adminOrder_findOrderItem?time="+new Date().getTime()+"&oid="+oid;
				 ajax.open(method,url);
				 ajax.send(null);
				 ajax.onreadystatechange =function(){
				 	if(ajax.readyState==4){
				 		if(ajax.status==200){
				 			var text = ajax.responseText;
				 			div.innerHTML=text;
				 			but.value="关闭";
				 		}
				 	}
				  
				  }
			
			 
			 }else{
			 	but.value="订单详情";
			 	div.innerHTML="";
			 }
			}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1"  method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>订单列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addUser()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="18%">
										序号
									</td>
									<td align="center" width="10%">
										订单编号
									</td>
									<td align="center" width="10%">
										总金额
									</td>
									<td align="center" width="10%">
										收货人
									</td>
									<td align="center" width="15%">
										订单状态
									</td>
									
									<td width="*" align="center">
										订单详情
									</td>
									
								</tr>
								<s:iterator var="o" value="pageBean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="18%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#o.oid"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#o.total"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#o.name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
											
												<s:if test="#o.state==0">
												未付款
												</s:if>
												<s:if test="#o.state==1">
												<a href="${pageContext.request.contextPath}/adminOrder_updateorder?oid=<s:property value="#o.oid"/>"><font color="blue">发货</font></a>
												</s:if>
												<s:if test="#o.state==2">
												等待确认收货
												</s:if>
												<s:if test="#o.state==3">
												订单完成
												</s:if>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<input id="but<s:property value="#o.oid" />" type="button" value="订单详情" onclick="showDetail(<s:property value="#o.oid" />)"/>
												<div id="div<s:property value="#o.oid" />"></div>
											</td>
									
											
										</tr>
									</s:iterator>	
							</table>
							<center>
								<span>第 <s:property value="pageBean.page"/>/<s:property value="pageBean.totalpage"/>页</span>
								<s:if test="pageBean.page!=1">
									<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=1">首页</a> 
													<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.page-1"/>">前一页</a>
								
								
								</s:if>
								<s:if test="pageBean.page!=pageBean.totalpage">
									<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.page+1"/>">后一页</a> 
													<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.totalpage"/>">尾页</a>
								
								</s:if>
								
							
							
							</center>
							
							
							
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

