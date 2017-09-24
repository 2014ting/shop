package cn.itcast.category.service.impl;

import java.util.List;

import cn.itcast.category.dao.ICategoryDao;
import cn.itcast.category.entity.Category;
import cn.itcast.category.service.ICategoryService;

public class CategoryService implements ICategoryService{
	private ICategoryDao categoryDao;
	public void setCategoryDao(ICategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}
	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
		
	}
	@Override
	public void update(Category category) {
		
		categoryDao.update(category);
	}
	@Override
	public Category findByCid(int cid) {
		return categoryDao.findByCid(cid);
	}
}
