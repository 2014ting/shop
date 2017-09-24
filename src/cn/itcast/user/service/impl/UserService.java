package cn.itcast.user.service.impl;

import cn.itcast.user.dao.IUserDao;
import cn.itcast.user.entity.User;
import cn.itcast.user.service.IUserService;

public class UserService implements IUserService{
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	@Override
	public User findByName(String username) {
		return userDao.findByName(username);
	}
	@Override
	public void save(User user) {
		userDao.save(user);
		
	}
	@Override
	public User  login(User user) {
		return userDao.login(user);
	}

}
