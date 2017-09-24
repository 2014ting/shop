package cn.itcast.user.dao;

import cn.itcast.user.entity.User;

public interface IUserDao {
		public User findByName(String username);

		public void save(User user);

		public User login(User user);
}
