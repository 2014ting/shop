package cn.itcast.product.service;

import java.util.List;

import cn.itcast.Utils.PageBean;
import cn.itcast.product.entity.Product;

public interface IProductService {

	List<Product> findhost();

	List<Product> findnew();

	Product findByid(int pid);

	PageBean<Product> findBypagecid(int cid, int page);

	PageBean<Product> findBypagecsid(int csid, int page);

	PageBean<Product> findallpage(int page);

	void delete(Product product);

	void save(Product product);

	void update(Product product);


}
