package cn.itcast.category.service;

import java.util.List;

import cn.itcast.category.entity.Category;

public interface ICategoryService {

	List<Category>  findAll();

	void save(Category category);

	void delete(Category category);

	void update(Category category);

	Category findByCid(int cid);

}
