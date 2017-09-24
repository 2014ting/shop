package cn.itcast.Utils;

import java.util.List;

public class PageBean<T> {
	private int page;//当前页数
	private int totalCount;//总记录数
	private  int totalpage;//总页数
	private int limit;//每页记录的个数
	private List<T> list;//每页记录的商品集合
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", totalCount=" + totalCount + ", totalpage=" + totalpage + ", limit=" + limit
				+ ", list=" + list + "]";
	}
	
	
}
