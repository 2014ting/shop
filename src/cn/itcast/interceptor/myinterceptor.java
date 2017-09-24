package cn.itcast.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.admin.entity.AdminUser;
import cn.itcast.order.action.adminOrderAction;
/**
 * 后台权限拦截器，如果没有登录，就跳转至登录页面，不能进行后台的增删改查的操作
 * @author 李婷婷
 *
 */
public class myinterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		AdminUser adminUser = (AdminUser) ServletActionContext.getContext().getSession().get("exitsAdminUser");
		if(adminUser ==null){
			//没有登录
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionMessage("亲！你还没有登录，不能对后台数据进行操作");
			return "loginfail";
		}else{
			//已经登录
			return actionInvocation.invoke();
		}
	}

}
