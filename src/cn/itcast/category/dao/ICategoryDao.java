package cn.itcast.category.dao;

import java.util.List;

import cn.itcast.category.entity.Category;

public interface ICategoryDao {

	List<Category> findAll();

	void save(Category category);

	void delete(Category category);

	Category findByCid(int cid);

	void update(Category category);

}
