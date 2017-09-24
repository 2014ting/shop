package cn.itcast.Utils;

import java.util.List;

public class PageBean<T> {
	private int page;//��ǰҳ��
	private int totalCount;//�ܼ�¼��
	private  int totalpage;//��ҳ��
	private int limit;//ÿҳ��¼�ĸ���
	private List<T> list;//ÿҳ��¼����Ʒ����
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
