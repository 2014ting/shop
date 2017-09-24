package cn.itcast.user.service;

import cn.itcast.user.entity.User;

public interface IUserService {
	public User findByName(String username);

	public void save(User user);

	public User login(User user);

}
