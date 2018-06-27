//@formatter:off
/* ========================================== */
/*  Copyright(c) 2017 Neusoft Corporation.    */
/*            All rights reserved.            */
/*           Neusoft CONFIDENTIAL             */
/* ========================================== */
//@formatter:on
package com.qinergy.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.qinergy.util.JsonUtils;

/**
 * 返回参数
 * <p>
 * This contains the following attributes:<br/>
 * <li><code>resultcode</code></li>
 * <li><code>desc</code></li>
 * <li><code>data</code></li>
 * <li><code>saleusercount</code></li>
 * <li><code>saleWeightCount</code></li>
 * <p>
 * 
 * 
 * @author Neusoft
 * @version 1.0
 * @since 1.0
 */
public class ResultObject implements Serializable {

	/**
	 * Unique serial version UID.
	 */
	private static final long serialVersionUID = 4210294864072444235L;

	/**
	 * 编码
	 */
	private String resultcode;

	/**
	 * 消息
	 */
	private String desc;

	/**
	 * 返回 json 数据
	 */
	private Object data;

	/**
	 * 买入总用户量
	 */
	private String saleusercount;

	/**
	 * 总重量
	 */
	private String saleWeightCount;

	/**
	 * <code>Default constructor.</code>
	 */
	public ResultObject() {
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

	/**
	 * Gets the value of the <code>saleWeightCount</code> property.
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
	 * @return the current value of <code>saleWeightCount</code> property.
	 */
	public String getSaleWeightCount() {
		return saleWeightCount;
	}

	/**
	 * Sets the value of the <code>saleWeightCount</code> property.
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
	 * @param pSaleWeightCount
	 *            the new value of the <code>saleWeightCount</code> property.
	 */
	public void setSaleWeightCount(String pSaleWeightCount) {
		this.saleWeightCount = pSaleWeightCount;
	}

	/**
	 * Gets the value of the <code>saleusercount</code> property.
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
	 * @return the current value of <code>saleusercount</code> property.
	 */
	public String getSaleusercount() {
		return saleusercount;
	}

	/**
	 * Sets the value of the <code>saleusercount</code> property.
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
	 * @param pSaleusercount
	 *            the new value of the <code>saleusercount</code> property.
	 */
	public void setSaleusercount(String pSaleusercount) {
		this.saleusercount = pSaleusercount;
	}
}
