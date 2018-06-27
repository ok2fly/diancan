/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.qinergy.util.JsonUtils;

/**
 * <code>BaseTransferEntity</code> class contain information specific to a Base
 * Transfer.<br>
 * This contains the following attributes:<br>
 * <ul>
 * <code> <li>resultcode <li>desc <li>data </code>
 * </ul>
 * <p>
 * This contains the following attributes:<br/>
 * <li><code>data</code></li>
 * <li><code>desc</code></li>
 * <li><code>resultcode</code></li>
 * <li><code>serialVersionUID</code></li>
 * <p>
 * 
 * @see com.xjtraffic.util.JsonUtils
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */

public class BaseTransferEntity implements Serializable {

	/**
	 * 返回 json 数据
	 */
	private Object data;

	/**
	 * 消息
	 */
	private String desc;

	/**
	 * 编码
	 */
	private String resultcode;

	/**
	 * 总数
	 */
//	private String totalCount;
	
	/**
	 * 返回是否成功标识
	 */
	private int isSuccess;
	
	/**
	 * 当前页数
	 */
	private int currentPage = 1;
	
	/**
	 * 每页显示数量
	 */
	private int everyPage = 10;
	
	/**
	 * 总页数
	 */
	private int totalPage = 1;
	
	/**
	 * 总数量
	 */
	private int totalCount = 0;
	
	/**
	 * Unique serial version UID.
	 */
	private static final long serialVersionUID = 7910723050441294574L;

	/**
	 * <code>Default constructor.</code>
	 */
	public BaseTransferEntity() {
	}

	/**
	 * TODO
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @return <code>Map&lt;String,Object&gt;</code> TODO
	 */
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", isSuccess);
//		map.put("totalCount", totalCount);
		map.put("resultcode", resultcode);
		map.put("desc", desc != null ? desc : "");
		map.put("data", data != null ? data : "");
		return map;
	}

	/**
	 * TODO
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @return <code>String</code> TODO
	 */
	@Override
	public String toString() {
		return JsonUtils.getInstance().beanToJson(this);
	}

	/**
	 * Gets the value of the <code>data</code> property.
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @return the current value of <code>data</code> property.
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Sets the value of the <code>data</code> property.
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @param pData
	 *            the new value of the <code>data</code> property.
	 */
	public void setData(Object pData) {
		this.data = pData;
	}

	/**
	 * Gets the value of the <code>desc</code> property.
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @return the current value of <code>desc</code> property.
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the value of the <code>desc</code> property.
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @param pDesc
	 *            the new value of the <code>desc</code> property.
	 */
	public void setDesc(String pDesc) {
		this.desc = pDesc;
	}

	/**
	 * Gets the value of the <code>resultcode</code> property.
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @return the current value of <code>resultcode</code> property.
	 */
	public String getResultcode() {
		return resultcode;
	}

	/**
	 * Sets the value of the <code>resultcode</code> property.
	 * 
	 * <p>
	 * <b>Release Notes:</b> <br/>
	 * <table border="1" cellspacing="0" cellpadding="5" width="80%">
	 * <tr>
	 * <th align="left">Release</th>
	 * <th align="left">Notes</th>
	 * </tr>
	 * <tr>
	 * <td>@since 1.0</td>
	 * <td>&nbsp;</td>
	 * </tr>
	 * </table>
	 * <p>
	 * 
	 * @param pResultcode
	 *            the new value of the <code>resultcode</code> property.
	 */
	public void setResultcode(String pResultcode) {
		this.resultcode = pResultcode;
	}

//	public String getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(String totalCount) {
//		this.totalCount = totalCount;
//	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * Gets the value of the <code>currentPage</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>currentPage</code> property.
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets the value of the <code>currentPage</code> property.
	 * <p>
	 *
	 * @param <code>currentPage</code>
	 *        Holds the new value of the <code>currentPage</code> property.
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * Gets the value of the <code>everyPage</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>everyPage</code> property.
	 */
	public int getEveryPage() {
		return everyPage;
	}

	/**
	 * Sets the value of the <code>everyPage</code> property.
	 * <p>
	 *
	 * @param <code>everyPage</code>
	 *        Holds the new value of the <code>everyPage</code> property.
	 */
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	/**
	 * Gets the value of the <code>totalPage</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>totalPage</code> property.
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * Sets the value of the <code>totalPage</code> property.
	 * <p>
	 *
	 * @param <code>totalPage</code>
	 *        Holds the new value of the <code>totalPage</code> property.
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * Gets the value of the <code>totalCount</code> property.
	 * <p>
	 *
	 * @return Returns the current value of <code>totalCount</code> property.
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the value of the <code>totalCount</code> property.
	 * <p>
	 *
	 * @param <code>totalCount</code>
	 *        Holds the new value of the <code>totalCount</code> property.
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
