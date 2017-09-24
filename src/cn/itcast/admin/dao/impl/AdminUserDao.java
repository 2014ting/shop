package cn.itcast.admin.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.admin.dao.IAdminUserDao;
import cn.itcast.admin.entity.AdminUser;

public class AdminUserDao  implements IAdminUserDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public AdminUser login(AdminUser adminUser) {
		String hql="from AdminUser where username=? and password = ?";
		System.out.println("dddddddddd");
		List<AdminUser> list = sessionFactory.getCurrentSession()
								.createQuery(hql)
								.setParameter(0, adminUser.getUsername())
								.setParameter(1, adminUser.getPassword())
								.list();
		System.out.println(list);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	
		
	}

}
