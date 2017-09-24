package cn.itcast.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.admin.entity.AdminUser;
import cn.itcast.order.action.adminOrderAction;
/**
 * ��̨Ȩ�������������û�е�¼������ת����¼ҳ�棬���ܽ��к�̨����ɾ�Ĳ�Ĳ���
 * @author ������
 *
 */
public class myinterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		AdminUser adminUser = (AdminUser) ServletActionContext.getContext().getSession().get("exitsAdminUser");
		if(adminUser ==null){
			//û�е�¼
			ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
			actionSupport.addActionMessage("�ף��㻹û�е�¼�����ܶԺ�̨���ݽ��в���");
			return "loginfail";
		}else{
			//�Ѿ���¼
			return actionInvocation.invoke();
		}
	}

}
