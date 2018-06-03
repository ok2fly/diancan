package com.gcfd.util;
/**
 * page
 * @author WGX
 *
 */
public class PageBean {
	private int page;// 当前页  
	private int limit;// 每页显示记录数 常量  
	private int totalRecord;// 总记录数  
	private int totalPage;// 总页数  
	private int firstPage;// 第一页  
	private int lastPage;// 最后一页  
	private int prePage;// 上一页  
	private int nextPage;// 下一页  
	private int position;// 从第几条信息记录 开始查询  
	private int start;


	public int getStart() {
		start = (this.getCurrentPage()-1)*this.limit;
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}


	public PageBean() {
		super();
	}
	public PageBean(int totalRecord) { 
		this();
		this.totalRecord = totalRecord;  
	}  
	public PageBean(int page, int limit) { 
		this();
		this.page = page;
		this.limit = limit;
	}  

	public PageBean(int page, int limit , int totalRecord) {
		this();
		this.totalRecord = totalRecord;  
		this.page = page;
		this.limit = limit;
	}  

	public int getCurrentPage() {  
		if (this.page < 1 || this.getTotalPage()== 0 ){
			this.page = 1;  
		}else{
			if (this.page > this.getTotalPage()){
				this.page = this.getTotalPage();  
			}  
		}  
		return page;  
	}  

	public void setCurrentPage(int currentPage) {  
		this.page = currentPage;  
	}  

	public int getPageSize() {  
		return limit;  
	}  

	public void setPageSize(int pageSize) {  
		this.limit = pageSize;  
	}  

	public int getTotalRecord() {  
		return totalRecord;  
	}  

	public void setTotalRecord(int totalRecord) {  
		this.totalRecord = totalRecord;  
	}  

	public int getTotalPage() {  
		if (this.getTotalRecord() % limit == 0)  
			return this.getTotalRecord() / limit;  
		return this.getTotalRecord() / limit + 1;  
	}  

	public void setTotalPage(int totalPage) {  
		this.totalPage = totalPage;  
	}  

	public int getFirstPage() {  
		return 1;  
	}  

	public void setFirstPage(int firstPage) {  
		this.firstPage = firstPage;  
	}  

	public int getLastPage() {  
		return this.getTotalPage();  
	}  

	public void setLastPage(int lastPage) {  
		this.lastPage = lastPage;  
	}  

	public int getPrePage() {  
		if (this.getCurrentPage() - 1 <= 0)  
			return 1;  
		return this.getCurrentPage() - 1;  
	}  

	public void setPrePage(int prePage) {  
		this.prePage = prePage;  
	}  

	public int getNextPage() {  
		if (this.getCurrentPage() + 1 >= this.getTotalPage())  
			return this.getTotalPage();  
		return this.getCurrentPage() + 1;  
	}  

	public void setNextPage(int nextPage) {  
		this.nextPage = nextPage;  
	}  

	public int getPosition() {  
		return (this.getCurrentPage() - 1) * limit + 1;  
	}  

	public void setPosition(int position) {  
		this.position = position;  
	}  
}
