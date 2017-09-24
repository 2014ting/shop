package cn.itcast.category.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.category.dao.ICategoryDao;
import cn.itcast.category.entity.Category;

public class CategoryDao implements ICategoryDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Category> findAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	@Override
	public void save(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}
	@Override
	public void delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		System.out.println("rRRRRRRRRRRRR");
		
	}
	@Override
	public Category findByCid(int cid) {
		return sessionFactory.getCurrentSession().get(Category.class, cid);
	}
	@Override
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}
}
