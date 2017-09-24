package cn.itcast.categorysecond.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.Utils.PageHibernateCallback;
import cn.itcast.categorysecond.entity.CategorySecond;

public class CategorySecondDao extends HibernateDaoSupport {
	
	public int findcount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list =(List<Long>) this.getHibernateTemplate().find(hql);
	
		if(list != null &&list.size()>0){
			return list.get(0).intValue();
		}
		
		return 0;
	}
	public List<CategorySecond> findpagelist(int begin, int limit) {
		String hql ="from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list != null &&list.size()>0){
			return list;
		}
		return null;
	}
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}
	public CategorySecond findbycsid(int csid) {
		String hql="from CategorySecond where csid = ?";
		List<CategorySecond> list = (List<CategorySecond>) this.getHibernateTemplate().find(hql, csid);
		if(list != null &&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}
	public void delete(CategorySecond categorySecond) {
			this.getHibernateTemplate().delete(categorySecond);
	}
	public List<CategorySecond> findall() {
		 List<CategorySecond> list =  (List<CategorySecond>) this.getHibernateTemplate().find("from CategorySecond");
		 if(list != null &&list.size()>0){
				return list;
			}
		return null;
	}
}
