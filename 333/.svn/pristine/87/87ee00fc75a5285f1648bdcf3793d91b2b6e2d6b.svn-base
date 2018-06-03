package com.gcfd.common;


/**
 * @类名：dataCenter.java
* @作者：one
* @时间：2016年6月19日 下午12:35:33
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class DataCenter<T> {
	
	/**
	 * 总页数 默认 0 页
	 */
	@SuppressWarnings("unused")
	private int pagerCount = 0;
	/**
	 * 当前页数  默认 第1页
	 */
	private int pageNum = 1;
	/**
	 * 总行数 默认 0 行
	 */
	private int rowCount = 0;
	/**
	 * 每页行数
	 * 默认20条每页
	 * 最多为200条一页
	 */
	private int pageSize=20;
	
	/**
	 * 分页 开始行
	 */
	private int pageStart=0;
	
	/**
	 * 请求反馈编码
	 * 1000 请求成功
	 * 2002 请求接口无效
	 * 2003 请求接口异常
	 * 3001 接口授权过期
	 * 3002 非法访问
	 */
	private String netCode;
	/**
	 * 请求反馈信息
	 */
	private String netMessage;
	
	/**
	 * 数据承载器
	 */
	private  T data;
	

	
	public DataCenter(){
		setNetCode(EnumNetCode.C1000); //默认为接口请求成功
	}
	
	public Integer getPageStart() {
		setPageStart((getPageNum() - 1) * getPageSize());
		return pageStart;
	}
	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}
	
	public int getPagerCount() {
		if(this.rowCount<=0)return 1;
		return this.rowCount % getPageSize() > 0 ? ( this.rowCount / getPageSize() +1) : this.rowCount / getPageSize();
	}

	public void setPagerCount(int pagerCount) {
		this.pagerCount = pagerCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getRowCount() {
		rowCount = rowCount<=0 ? 0 : rowCount;
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		rowCount = rowCount<=0 ? 0 : rowCount;
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		pageSize = (pageSize<=0)? 20 : (pageSize>=200)? 200 : pageSize;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		pageSize = (pageSize<=0)? 20 : (pageSize>=200)? 200 : pageSize;
		this.pageSize = pageSize;
	}

	public String getNetCode() {
		return netCode;
	}

	public void setNetCode(EnumNetCode enumNetCode) {
		this.netCode = enumNetCode.toString();
		this.netMessage = Constant.NET_CODE.get(enumNetCode.toString());
	}
	
	public void setUserNetCode(EnumNetCode enumNetCode) {
		this.netCode = enumNetCode.toString();
		this.netMessage = Constant.NET_CODE.get(enumNetCode.toString());
	}
	
	public String getNetMessage() {
		return netMessage;
	}

	public void setNetMessage(String netMessage) {
		this.netMessage = netMessage;
	}
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data =  data;
	}

	@SuppressWarnings("unchecked")
	public void setOData(Object data) {
		this.data =  (T) data;
	}
}
