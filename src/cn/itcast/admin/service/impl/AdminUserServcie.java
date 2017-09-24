package cn.itcast.admin.service.impl;

import cn.itcast.admin.dao.IAdminUserDao;
import cn.itcast.admin.entity.AdminUser;
import cn.itcast.admin.service.IAdminUserService;

public class AdminUserServcie implements IAdminUserService{
	private IAdminUserDao adminUserDao;
	public void setAdminUserDao(IAdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	@Override
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

}
