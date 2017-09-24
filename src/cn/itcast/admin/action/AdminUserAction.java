package cn.itcast.admin.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.admin.entity.AdminUser;
import cn.itcast.admin.service.IAdminUserService;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	private IAdminUserService adminUserService;
	public void setAdminUserService(IAdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	private AdminUser adminUser=new AdminUser();
	@Override
	public AdminUser getModel() {
		return adminUser;
	}
	public String login() {
		AdminUser exitsAdminUser = adminUserService.login(adminUser);
		if(exitsAdminUser!=null){
			//��¼�ɹ�
			ServletActionContext.getRequest().getSession().setAttribute("exitsAdminUser", exitsAdminUser);
			return "loginsuccess";
			
		}else{
			//��¼ʧ��
			this.addActionError("�û�����������������µ�¼");
			return "loginfail";
		}
	
	}
}
