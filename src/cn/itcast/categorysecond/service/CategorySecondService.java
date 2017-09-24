package cn.itcast.categorysecond.service;

import java.util.List;

import cn.itcast.Utils.PageBean;
import cn.itcast.categorysecond.dao.CategorySecondDao;
import cn.itcast.categorysecond.entity.CategorySecond;

public class CategorySecondService {
	private CategorySecondDao categorySecondDao;
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	public PageBean<CategorySecond> findallpage(int page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		pageBean.setPage(page);
		int limit = 12;
		pageBean.setLimit(limit);
		int totalCount = categorySecondDao.findcount();
		pageBean.setTotalCount(totalCount);
		int totalpage = 0;
		if(totalCount%limit ==0){
			totalpage = totalCount/limit;
		}else{
			totalpage = totalCount/limit+1;
		}
		pageBean.setTotalpage(totalpage);
		int begin = (page-1)*limit;
		List<CategorySecond> list = categorySecondDao.findpagelist(begin,limit);
		
		pageBean.setList(list);
		return pageBean;
	}
	public void save(CategorySecond categorySecond) {
			categorySecondDao.save(categorySecond);
	}
	public CategorySecond findbycsid(int csid) {
		return categorySecondDao.findbycsid(csid);
	}
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
		}
	public void delete(CategorySecond categorySecond) {
			categorySecondDao.delete(categorySecond);		
	}
	public List<CategorySecond> findall() {
		return categorySecondDao.findall();
	}
}
