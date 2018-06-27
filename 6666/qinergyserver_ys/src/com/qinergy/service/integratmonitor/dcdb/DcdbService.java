/* ========================================== */
/*   Copyright(c) 2017 Neusoft Corporation.   */
/*            All rights reserved.            */
/*            Neusoft CONFIDENTIAL            */
/* ========================================== */
package com.qinergy.service.integratmonitor.dcdb;

import java.util.List;
import java.util.Map;


/**
 * TODO
 * <p>
 * This contains the following methods:<br/>
 * <p>
 * 
 * @author zy
 * @version 1.0
 * @since 1.0
 */

public interface DcdbService {

	public List<Map<String, Object>> getDcdbInfByEquNum(Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> getDcdbInfoNewById(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> getDcdbById(Map<String, Object> map) throws Exception;
	
	


}
