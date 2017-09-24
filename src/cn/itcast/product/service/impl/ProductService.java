package cn.itcast.product.service.impl;

import java.util.Date;
import java.util.List;

import cn.itcast.Utils.PageBean;
import cn.itcast.product.dao.IProductDao;
import cn.itcast.product.entity.Product;
import cn.itcast.product.service.IProductService;

public class ProductService implements IProductService{
	private IProductDao productDao;
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}
	@Override
	public List<Product> findhost() {
		return productDao.findhost();
	}
	@Override
	public List<Product> findnew() {
		return productDao.findnew();
	}
	@Override
	public Product findByid(int pid) {
		return productDao.findByid(pid);
	}
	
	@Override
	public PageBean<Product> findBypagecid(int cid, int page) {
		PageBean<Product> productpageBean = new PageBean<Product>();
		int limit =12 ;
		productpageBean.setLimit(limit);//设置每页记录的个数
		productpageBean.setPage(page);//设置当前页数
		int totalCount =0 ;
		totalCount = productDao.findcountcid(cid);
		productpageBean.setTotalCount(totalCount);
		int totalpage =0 ;
		if(totalCount%limit==0){
			totalpage = totalCount/limit;
		}else{
			totalpage = totalCount/limit+1;
		}
		productpageBean.setTotalpage(totalpage);
		int begin = (page-1)*limit;
		List<Product> productlist  = productDao.findbypagecid(cid,begin,limit);
		productpageBean.setList(productlist);
		return productpageBean;
	}
	@Override
	public PageBean<Product> findBypagecsid(int csid, int page) {
		PageBean<Product> productpageBean = new PageBean<Product>();
		int limit =8 ;
		productpageBean.setLimit(limit);//设置每页记录的个数
		productpageBean.setPage(page);//设置当前页数
		int totalCount =0 ;
		totalCount = productDao.findcountcsid(csid);
		productpageBean.setTotalCount(totalCount);
		int totalpage =0 ;
		if(totalCount%limit==0){
			totalpage = totalCount/limit;
		}else{
			totalpage = totalCount/limit+1;
		}
		productpageBean.setTotalpage(totalpage);
		int begin = (page-1)*limit;
		List<Product> productlist  = productDao.findbypagecsid(csid,begin,limit);
		productpageBean.setList(productlist);
		return productpageBean;
	}
	
	public PageBean<Product> findallpage(int page) {
		PageBean<Product> pageBean =new PageBean<Product>();
		pageBean.setPage(page);
		int limit=12;
		pageBean.setLimit(limit);
		int totalCount =0;
		totalCount = productDao.findcount();
		pageBean.setTotalCount(totalCount);
		int totalpage =0;
		if(totalCount%limit==0){
			totalpage = totalCount/limit;
		}else{
			totalpage = totalCount/limit+1;
		}
		pageBean.setTotalpage(totalpage);
		int begin =(page-1)*limit;
		List<Product> list= productDao.findbypagecount(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public void delete(Product product) {
		productDao.delete(product);
	}
	@Override
	public void save(Product product) {
		productDao.save(product);
	}
	@Override
	public void update(Product product) {
		productDao.update(product);
	}
	
	
	
}
