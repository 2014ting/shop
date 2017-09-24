package cn.itcast.product.dao;

import java.util.List;

import cn.itcast.product.entity.Product;

public interface IProductDao {

	List<Product> findhost();

	List<Product> findnew();

	Product findByid(int pid);

	int findcountcid(int cid);

	List<Product> findbypagecid(int cid, int begin, int limit);

	int findcountcsid(int csid);

	List<Product> findbypagecsid(int csid, int begin, int limit);

	int findcount();

	List<Product> findbypagecount(int begin, int limit);

	void delete(Product product);

	void save(Product product);

	void update(Product product);



}
