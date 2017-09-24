package cn.itcast.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.Utils.PageHibernateCallback;
import cn.itcast.product.dao.IProductDao;
import cn.itcast.product.entity.Product;

public class ProductDao extends HibernateDaoSupport implements IProductDao{
	
	//查找热门商品并分页
	@Override
	public List<Product> findhost() {
		DetachedCriteria criteria =DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list =(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		if(list.size()>0){
			return list;
		}
		return null;
		
	}
	//查找最新商品并分页
	public List<Product> findnew(){
		DetachedCriteria criteria =DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list =(List<Product>) this.getHibernateTemplate().findByCriteria(criteria,0,10);
		if(list.size()>0){
			return list;
		}
		return null;
		
		
	}
	
	//通过商品id查询商品
	@Override
	public Product findByid(int pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	//通过一级分类编号查询该分类下的所有商品
	@Override
	public int findcountcid(int cid) {
		List<Long> list = (List<Long>) this.getHibernateTemplate().find("select count(*) from Product p where p.categorySecond.category.cid=? ", cid);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	@Override
	public List<Product> findbypagecid(int cid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=? ";
		List<Product> list =  this.getHibernateTemplate().execute( new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	@Override
	public int findcountcsid(int csid) {
		String hql="select count(*) from Product p where p.categorySecond.csid=? ";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, csid);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	@Override
	public List<Product> findbypagecsid(int csid, int begin, int limit) {
		String hql="select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list  = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	@Override
	public int findcount() {
		String hql="select count(*) from Product ";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		
		return 0;
	}
	@Override
	public List<Product> findbypagecount(int begin, int limit) {
		String hql="from Product order by pdate desc";
		List<Product> list  = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql,null, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}
	
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}
	@Override
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}
	@Override
	public void update(Product product) {
		this.getHibernateTemplate().update(product);		
	}
	
	
}
