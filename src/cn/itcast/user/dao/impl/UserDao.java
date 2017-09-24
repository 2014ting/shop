package cn.itcast.user.dao.impl;


import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.user.dao.IUserDao;
import cn.itcast.user.entity.User;

public class UserDao implements IUserDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByName(String username) {
		
		
		
		List<User>	userlist =sessionFactory.getCurrentSession()
					.createQuery("from User where username ='"+username+"'")
					.list();
		
		
		if(userlist!= null && userlist.size() >0){
			return userlist.get(0);
		}
		return null;
	}

	@Override
	public void save(User user) {
			sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User login(User user) {
		List<User> list = sessionFactory.getCurrentSession()
				.createQuery("from User where username=? and password =?" )
				.setParameter(0, user.getUsername())
				.setParameter(1, user.getPassword())
				.list();
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

}
