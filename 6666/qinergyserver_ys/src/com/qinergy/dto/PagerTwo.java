package com.qinergy.dto;

import java.util.List;

public class PagerTwo<T> {

	// 当前页数
	private int currentPage = 1;
	// 每页显示数量
	private int everyPage = 10;
	// 总页数
	private int totalPage;
	// 总数量
	private int totalCount;
	//开始的记录
	private int start;
	
	
	// 封装返回的集合
	private List<T> result;
	
	public int getStart() {
		return start=(currentPage-1)*everyPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	
	public int getTotalPage() {
		totalPage=totalCount/everyPage;
		return totalCount%everyPage==0? totalPage:totalPage+1 ;
	}

	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Pager [currentPage=" + currentPage + ", everyPage=" + everyPage
				+ ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", start=" + start + ", result=" + result + "]";
	}

}
