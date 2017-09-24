package cn.itcast.admin.dao;

import cn.itcast.admin.entity.AdminUser;

public interface IAdminUserDao {

	AdminUser login(AdminUser adminUser);

}
