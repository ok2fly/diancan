package com.qinergy.service.integratmonitor.env;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinergy.dao.integratmonitor.env.EnvDao;
import com.qinergy.dao.others.OthersDao;
import com.qinergy.util.DateUtil;


/**
 * 
 * @author zy
 *
 */

@Service
public class EnvServiceImpl implements EnvService{
	
	@Autowired
	EnvDao envDao;
	
	@Autowired
	OthersDao othersDao;

	/**
	 * 查询所有 环境监测仪 数据
	 */
	@Override
	public List<Map<String, Object>> getEnvInfo() throws Exception {
		// 查询所有 环境监测仪 数据
		List<Map<String, Object>> retLst = envDao.getEnvInfo();
		
		if(retLst != null && !retLst.isEmpty()){
			
			for(Map<String, Object> retMap:retLst){
				
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("equ_num", map.get("equ_num"));
				
				// 获取到站内的设备信息,传入健康信息获取接口中
				List<Map<String, Object>> healthLst = othersDao.getEquHealthScorTop(map);
				
				// 获取健康评分,并进行判断
				if(healthLst != null && !healthLst.isEmpty()){
					
					for(Map<String, Object> healthMap : healthLst){
						// 获取设备评分
						Double equHealthRate = Double.valueOf(healthMap.get("health_scor").toString());
						// 判断如果设备评分大于等于90分
						if(equHealthRate >= 90){
							// 优秀
							retMap.put("healthStat", 1);
						// 判断如果设备评分大于等于80分	
						}else if(equHealthRate >= 80 && equHealthRate < 90){
							// 良好
							retMap.put("healthStat", 2);
						// 判断如果设备评分大于等于70分	
						}else if(equHealthRate >= 70 && equHealthRate < 80){
							// 中
							retMap.put("healthStat", 3);
						// 判断如果设备评分小于等于70分	
						}else if(equHealthRate < 70){
							// 差
							retMap.put("healthStat", 4);
							
						}
					}
				}
			}
		}
		
		return retLst;
	}

	/**
	 * 查询最新的环境监测仪数据
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoNew(Map<String,Object> map) throws Exception {
		// 查询最新 环境监测仪 数据
		List<Map<String, Object>> envInfLst = envDao.getEnvInfoNew(map);
		// 对查询回来的集合进行非空判断
		if(envInfLst != null && !envInfLst.isEmpty()){
			// 遍历查询回来的集合
			for(Map<String, Object> retMap:envInfLst){
				
				map.put("equ_num", retMap.get("equ_num"));
				
				// 获取到站内的设备信息,传入健康信息获取接口中
				List<Map<String, Object>> healthLst = othersDao.getEquHealthScorTop(map);
				
				// 获取健康评分,并进行判断
				if(healthLst != null && !healthLst.isEmpty()){
					
					for(Map<String, Object> healthMap : healthLst){
						// 获取设备评分
						Double equHealthRate = Double.valueOf(healthMap.get("health_scor").toString());
						// 判断如果设备评分大于等于90分
						if(equHealthRate >= 90){
							// 优秀
							retMap.put("healthStat", 1);
						// 判断如果设备评分大于等于80分	
						}else if(equHealthRate >= 80 && equHealthRate < 90){
							// 良好
							retMap.put("healthStat", 2);
						// 判断如果设备评分大于等于70分	
						}else if(equHealthRate >= 70 && equHealthRate < 80){
							// 中
							retMap.put("healthStat", 3);
						// 判断如果设备评分小于等于70分	
						}else if(equHealthRate < 70){
							// 差
							retMap.put("healthStat", 4);
							
						}
					}
				}
			}
		}
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		// 声明时间格式化
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		String crtTim = sdf.format(new Date());
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取某站内环境检测仪的设备数据
		List<Map<String, Object>> envEquLst = envDao.getEquInfByPwsIdByForEnv(map);
		
		if(envEquLst != null && !envEquLst.isEmpty()){
			
			map.put("equ_num", envEquLst.get(0).get("equ_num"));
		}
		
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = envDao.getEnvInfoByYearGraph(map);
		// 将回去回来的曲线信息集合，格式化成15分钟一个点的数据集合
		retLst = DateUtil.getFifteenMinutesCurves(crtTim, curLst);
		// 对站内环境监测仪设备集合进行非空判断
		if(envInfLst != null && !envInfLst.isEmpty() && envInfLst.get(0) != null){
			// 循环遍历
			for(Map<String, Object> envInfMap:envInfLst){
				
				String windLvl = "";
				// 判断风速是否为空
				if(envInfMap != null && envInfMap.get("windSpeed") != null){
					
					Double windSpeed = Double.valueOf(envInfMap.get("windSpeed").toString());
					
					// 无风（0级）
					if(windSpeed>=0.0 && windSpeed<0.3){
						windLvl = "0级";
					// 软风（1级）
					}else if(windSpeed>=0.3 && windSpeed<1.6){
						windLvl = "1级";
					// 轻风（2级）
					}else if(windSpeed>=1.6 && windSpeed<3.4){
						windLvl = "2级";
					// 微风（3级）
					}else if(windSpeed>=3.4 && windSpeed<5.5){
						windLvl = "3级";
					// 和风（4级）
					}else if(windSpeed>=5.5 && windSpeed<8.0){
						windLvl = "4级";
					// 轻劲风（5级）
					}else if(windSpeed>=8.0 && windSpeed<10.8){
						windLvl = "5级";
					// 强风（6级）
					}else if(windSpeed>=10.8 && windSpeed<13.9){
						windLvl = "6级";
					// 疾风（7级）
					}else if(windSpeed>=13.9 && windSpeed<17.2){
						windLvl = "7级";
					// 大风（8级）
					}else if(windSpeed>=17.2 && windSpeed<20.8){
						windLvl = "8级";
					// 烈风（9级）
					}else if(windSpeed>=20.8 && windSpeed<24.5){
						windLvl = "9级";
					// 狂风（10级）
					}else if(windSpeed>=24.5 && windSpeed<28.5){
						windLvl = "10级";
					// 暴风（11级）
					}else if(windSpeed>=28.5 && windSpeed<32.7){
						windLvl = "11级";
					// 台风（12级）	
					}else if(windSpeed>=32.7 && windSpeed<36.9){
						windLvl = "12级";
					}
				}
				envInfMap.put("windLvl", windLvl);
				
				String windDirStr = "";

				String windDirNSEW = "";
				// 判断风向是否为空
				if(envInfMap != null && envInfMap.get("windDir") != null){
					
					Double windDir = Double.valueOf(envInfMap.get("windDir").toString());
					// 进行风向判断
					if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
						
						windDirStr = "北风";
						
					}else if(windDir>=22.5 && windDir<67.5){
						
						windDirStr = "东北风";
						
					}else if(windDir>=67.5 && windDir<112.5){
						
						windDirStr = "东风";
						
					}else if(windDir>=112.5 && windDir<157.5){
						
						windDirStr = "东南风";
						
					}else if(windDir>=157.5 && windDir<202.5){
						
						windDirStr = "南风";
						
					}else if(windDir>=202.5 && windDir<247.5){
						
						windDirStr = "西南风";
						
					}else if(windDir>=247.5 && windDir<292.5){
						
						windDirStr = "西风";
						
					}else if(windDir>=292.5 && windDir<337.5){
						
						windDirStr = "西北风";
					}
				}
				
				envInfMap.put("windDirStr", windDirStr);
				
				envInfMap.put("windDirNSEW", windDirNSEW);
				
				// 获取到当天第一条环境数据
				List<Map<String, Object>> envInfFirstLst = envDao.getEnvInfoNewFirst(map);
				// 判断当天的数据是否有
				if(envInfFirstLst != null && !envInfFirstLst.isEmpty() && envInfFirstLst.get(0) != null){
					// 有就进行循环遍历
					for(Map<String, Object> envInfFirstMap:envInfFirstLst){
						// 如果累计辐射量不为空
						if(envInfFirstMap != null && envInfFirstMap.get("hg")!=null){
							
							if(envInfMap.get("equ_num").equals(envInfFirstMap.get("equ_num"))&&envInfMap.get("hg")!=null){
								// 计算日辐射量
								Double dayHg = Double.valueOf(envInfMap.get("hg").toString())-Double.valueOf(envInfFirstMap.get("hg").toString());
								
								if(dayHg<0){
									
									dayHg = 0.0;
								}
								
								envInfMap.put("dayHg", dayHg);
							}
						}
					}
				}
				
				envInfMap.put("envLst", retLst);
			}
		}else{
			envInfLst = new ArrayList<Map<String,Object>>();
			
			Map<String, Object> envInfMap = new HashMap<String, Object>();

			envInfMap.put("envLst", retLst);
			
			envInfLst.add(envInfMap);
		}
		
		return envInfLst;
	}
	
	/**
	 * 查询最新的环境监测仪数据
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoNew24Hours(Map<String,Object> map) throws Exception {
		
		Date crtTim = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		// 获取某一天所有1小时时间点(环境检测仪用)
		List<Map<String, Object>> hoursLst = DateUtil.getDayByHoursEnv(sdf.format(crtTim));
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		// 判断时间点集合非空
		if(hoursLst != null && !hoursLst.isEmpty()){
			// 遍历时间点集合
			for(Map<String, Object> hoursMap:hoursLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", hoursMap.get("sta_tim"));
				
				map.put("end_tim", hoursMap.get("end_tim"));
				// 通过上面的时间点集合中的开始与结束时间，获取制定条件下的环境监测仪数据
				List<Map<String, Object>> curLst = envDao.getEnvInfoByYearGraph(map);
				// 判断返回集合不为空
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						String windDirStr = "";
						
						String windDirNSEW = "";
						// 风向判断
						if(curMap != null && curMap.get("windDir") != null){
							
							Double windDir = Double.valueOf(curMap.get("windDir").toString());
							
							if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
								
								windDirStr = "北风";
								
							}else if(windDir>=22.5 && windDir<67.5){
								
								windDirStr = "东北风";
								
							}else if(windDir>=67.5 && windDir<112.5){
								
								windDirStr = "东风";
								
							}else if(windDir>=112.5 && windDir<157.5){
								
								windDirStr = "东南风";
								
							}else if(windDir>=157.5 && windDir<202.5){
								
								windDirStr = "南风";
								
							}else if(windDir>=202.5 && windDir<247.5){
								
								windDirStr = "西南风";
								
							}else if(windDir>=247.5 && windDir<292.5){
								
								windDirStr = "西风";
								
							}else if(windDir>=292.5 && windDir<337.5){
								
								windDirStr = "西北风";
							}
							// 图表 中的风向判断（风速风向图中）
							if((windDir>=0.0 && windDir<11.25) || (windDir>=348.75 && windDir<0.0)){
								
								windDirNSEW = "N";
								
							}else if(windDir>=11.25 && windDir<33.75){
								
								windDirNSEW = "NNE";
								
							}else if(windDir>=33.75 && windDir<56.25){
								
								windDirNSEW = "NE";
								
							}else if(windDir>=56.25 && windDir<78.75){
								
								windDirNSEW = "ENE";
								
							}else if(windDir>=78.75 && windDir<101.25){
								
								windDirNSEW = "E";
								
							}else if(windDir>=101.25 && windDir<123.75){
								
								windDirNSEW = "ESE";
								
							}else if(windDir>=123.75 && windDir<146.25){
								
								windDirNSEW = "SE";
								
							}else if(windDir>=146.25 && windDir<168.75){
								
								windDirNSEW = "SSE";
								
							}else if(windDir>=168.75 && windDir<191.25){
								
								windDirNSEW = "S";
								
							}else if(windDir>=191.25 && windDir<213.75){
								
								windDirNSEW = "SSW";
								
							}else if(windDir>=213.75 && windDir<236.25){
								
								windDirNSEW = "SW";
								
							}else if(windDir>=236.25 && windDir<258.75){
								
								windDirNSEW = "WSW";
								
							}else if(windDir>=258.75 && windDir<281.25){
								
								windDirNSEW = "W";
								
							}else if(windDir>=281.25 && windDir<303.75){
								
								windDirNSEW = "WNW";
								
							}else if(windDir>=303.75 && windDir<326.25){
								
								windDirNSEW = "NW";
								
							}else if(windDir>=326.25 && windDir<348.75){
								
								windDirNSEW = "NNW";
								
							}
						}
						
						retMap.put("windDirStr", windDirStr);
						
						retMap.put("windDirNSEW", windDirNSEW);
						
						retMap.put("windSpeed", curMap.get("windSpeed"));
						
						retMap.put("windDir", curMap.get("windDir"));
					}
				}
				retMap.put("tol_tim", hoursMap.get("tol_tim"));
				
				retLst.add(retMap);
			}
		}
		return retLst;
	}

	/**
	 * 使用ID获取环境监测仪最新数据
	 */
	@Override
	public List<Map<String, Object>> getEnvInfoNewById(Map<String, Object> map)
			throws Exception {
		
		return envDao.getEnvInfoNewById(map);
	}

	/**
	 * 环境监测仪 按 年 查询图表信息
	 */
	@Override
	public Map<String, Object> getEnvInfoByYearList(
			Map<String, Object> map) throws Exception {
		
		// 环境监测仪 按 年 查询图表信息
		List<Map<String, Object>> listYear = envDao.getEnvInfoByYear(map);
		// 非空判断
		if(listYear != null && listYear.isEmpty()){
			// 数据集合循环遍历
			for(Map<String, Object> mapYear:listYear){
				
				String windDirStr = "";
				
				String windDirNSEW = "";
				
				if(mapYear != null && mapYear.get("windDir") != null){
					// 获取风向信息
					Double windDir = Double.valueOf(mapYear.get("windDir").toString());
					// 风向判断
					if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
						
						windDirStr = "北风";
						
					}else if(windDir>=22.5 && windDir<67.5){
						
						windDirStr = "东北风";
						
					}else if(windDir>=67.5 && windDir<112.5){
						
						windDirStr = "东风";
						
					}else if(windDir>=112.5 && windDir<157.5){
						
						windDirStr = "东南风";
						
					}else if(windDir>=157.5 && windDir<202.5){
						
						windDirStr = "南风";
						
					}else if(windDir>=202.5 && windDir<247.5){
						
						windDirStr = "西南风";
						
					}else if(windDir>=247.5 && windDir<292.5){
						
						windDirStr = "西风";
						
					}else if(windDir>=292.5 && windDir<337.5){
						
						windDirStr = "西北风";
					}
					// 图表 中的风向判断（风速风向图中）
					if((windDir>=0.0 && windDir<11.25) || (windDir>=348.75 && windDir<0.0)){
						
						windDirNSEW = "N";
						
					}else if(windDir>=11.25 && windDir<33.75){
						
						windDirNSEW = "NNE";
						
					}else if(windDir>=33.75 && windDir<56.25){
						
						windDirNSEW = "NE";
						
					}else if(windDir>=56.25 && windDir<78.75){
						
						windDirNSEW = "ENE";
						
					}else if(windDir>=78.75 && windDir<101.25){
						
						windDirNSEW = "E";
						
					}else if(windDir>=101.25 && windDir<123.75){
						
						windDirNSEW = "ESE";
						
					}else if(windDir>=123.75 && windDir<146.25){
						
						windDirNSEW = "SE";
						
					}else if(windDir>=146.25 && windDir<168.75){
						
						windDirNSEW = "SSE";
						
					}else if(windDir>=168.75 && windDir<191.25){
						
						windDirNSEW = "S";
						
					}else if(windDir>=191.25 && windDir<213.75){
						
						windDirNSEW = "SSW";
						
					}else if(windDir>=213.75 && windDir<236.25){
						
						windDirNSEW = "SW";
						
					}else if(windDir>=236.25 && windDir<258.75){
						
						windDirNSEW = "WSW";
						
					}else if(windDir>=258.75 && windDir<281.25){
						
						windDirNSEW = "W";
						
					}else if(windDir>=281.25 && windDir<303.75){
						
						windDirNSEW = "WNW";
						
					}else if(windDir>=303.75 && windDir<326.25){
						
						windDirNSEW = "NW";
						
					}else if(windDir>=326.25 && windDir<348.75){
						
						windDirNSEW = "NNW";
						
					}
				}
				
				mapYear.put("windDirStr", windDirStr);
				
				mapYear.put("windDirNSEW", windDirNSEW);
			}
		}
		
		// 环境监测仪 按 年 查询列表信息
		List<Map<String, Object>> listlast = envDao.getEnvInfoByYearList(map);
		// 非空判断
		if(listlast != null && listlast.isEmpty()){
			// 循环遍历
			for(Map<String, Object> mapLast:listlast){
				
				String windDirStr = "";
				
				String windDirNSEW = "";
				
				if(mapLast != null && mapLast.get("windDir") != null){
					// 获取风向数据
					Double windDir = Double.valueOf(mapLast.get("windDir").toString());
					// 风向判断
					if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
						
						windDirStr = "北风";
						
					}else if(windDir>=22.5 && windDir<67.5){
						
						windDirStr = "东北风";
						
					}else if(windDir>=67.5 && windDir<112.5){
						
						windDirStr = "东风";
						
					}else if(windDir>=112.5 && windDir<157.5){
						
						windDirStr = "东南风";
						
					}else if(windDir>=157.5 && windDir<202.5){
						
						windDirStr = "南风";
						
					}else if(windDir>=202.5 && windDir<247.5){
						
						windDirStr = "西南风";
						
					}else if(windDir>=247.5 && windDir<292.5){
						
						windDirStr = "西风";
						
					}else if(windDir>=292.5 && windDir<337.5){
						
						windDirStr = "西北风";
					}
					// 图表 中的风向判断（风速风向图中）
					if((windDir>=0.0 && windDir<11.25) || (windDir>=348.75 && windDir<0.0)){
						
						windDirNSEW = "N";
						
					}else if(windDir>=11.25 && windDir<33.75){
						
						windDirNSEW = "NNE";
						
					}else if(windDir>=33.75 && windDir<56.25){
						
						windDirNSEW = "NE";
						
					}else if(windDir>=56.25 && windDir<78.75){
						
						windDirNSEW = "ENE";
						
					}else if(windDir>=78.75 && windDir<101.25){
						
						windDirNSEW = "E";
						
					}else if(windDir>=101.25 && windDir<123.75){
						
						windDirNSEW = "ESE";
						
					}else if(windDir>=123.75 && windDir<146.25){
						
						windDirNSEW = "SE";
						
					}else if(windDir>=146.25 && windDir<168.75){
						
						windDirNSEW = "SSE";
						
					}else if(windDir>=168.75 && windDir<191.25){
						
						windDirNSEW = "S";
						
					}else if(windDir>=191.25 && windDir<213.75){
						
						windDirNSEW = "SSW";
						
					}else if(windDir>=213.75 && windDir<236.25){
						
						windDirNSEW = "SW";
						
					}else if(windDir>=236.25 && windDir<258.75){
						
						windDirNSEW = "WSW";
						
					}else if(windDir>=258.75 && windDir<281.25){
						
						windDirNSEW = "W";
						
					}else if(windDir>=281.25 && windDir<303.75){
						
						windDirNSEW = "WNW";
						
					}else if(windDir>=303.75 && windDir<326.25){
						
						windDirNSEW = "NW";
						
					}else if(windDir>=326.25 && windDir<348.75){
						
						windDirNSEW = "NNW";
						
					}
				}
				
				mapLast.put("windDirStr", windDirStr);
				
				mapLast.put("windDirNSEW", windDirNSEW);
			}
		}
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listYear", listYear);
		mapnew.put("listlast", listlast);
		return mapnew;
	}
	/**
	 * 环境监测仪 按 月 查询图表信息
	 */
	@Override
	public Map<String, Object> getEnvInfoByMonthList(Map<String, Object> map)
			throws Exception {
		List<Map<String, Object>> listMonth = envDao.getEnvInfoByMonth(map);
		List<Map<String, Object>> listlast = envDao.getEnvInfoByMonthList(map);
		Map<String, Object> mapnew = new HashMap<String, Object>();
		mapnew.put("listMonth", listMonth);
		mapnew.put("listlast", listlast);
		return mapnew;
	}

	@Override
	public List<Map<String, Object>> getEnvInfoByDayList(Map<String, Object> map) throws Exception {
		if(map.get("year") != null){
			
			List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("year").toString(), "5");
			
			map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
			
			map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		}
		List<Map<String, Object>> envLst = envDao.getEnvInfoByDayList(map);
		
		if(envLst != null && !envLst.isEmpty()){
			
			for(Map<String, Object> envMap:envLst){
				
				String windDirStr = "";
				
				String windDirNSEW = "";
				
				if(envMap != null && envMap.get("windDir") != null){
					
					Double windDir = Double.valueOf(envMap.get("windDir").toString());
					
					if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
						
						windDirStr = "北风";
						
					}else if(windDir>=22.5 && windDir<67.5){
						
						windDirStr = "东北风";
						
					}else if(windDir>=67.5 && windDir<112.5){
						
						windDirStr = "东风";
						
					}else if(windDir>=112.5 && windDir<157.5){
						
						windDirStr = "东南风";
						
					}else if(windDir>=157.5 && windDir<202.5){
						
						windDirStr = "南风";
						
					}else if(windDir>=202.5 && windDir<247.5){
						
						windDirStr = "西南风";
						
					}else if(windDir>=247.5 && windDir<292.5){
						
						windDirStr = "西风";
						
					}else if(windDir>=292.5 && windDir<337.5){
						
						windDirStr = "西北风";
					}
					
					if((windDir>=0.0 && windDir<11.25) || (windDir>=348.75 && windDir<0.0)){
						
						windDirNSEW = "N";
						
					}else if(windDir>=11.25 && windDir<33.75){
						
						windDirNSEW = "NNE";
						
					}else if(windDir>=33.75 && windDir<56.25){
						
						windDirNSEW = "NE";
						
					}else if(windDir>=56.25 && windDir<78.75){
						
						windDirNSEW = "ENE";
						
					}else if(windDir>=78.75 && windDir<101.25){
						
						windDirNSEW = "E";
						
					}else if(windDir>=101.25 && windDir<123.75){
						
						windDirNSEW = "ESE";
						
					}else if(windDir>=123.75 && windDir<146.25){
						
						windDirNSEW = "SE";
						
					}else if(windDir>=146.25 && windDir<168.75){
						
						windDirNSEW = "SSE";
						
					}else if(windDir>=168.75 && windDir<191.25){
						
						windDirNSEW = "S";
						
					}else if(windDir>=191.25 && windDir<213.75){
						
						windDirNSEW = "SSW";
						
					}else if(windDir>=213.75 && windDir<236.25){
						
						windDirNSEW = "SW";
						
					}else if(windDir>=236.25 && windDir<258.75){
						
						windDirNSEW = "WSW";
						
					}else if(windDir>=258.75 && windDir<281.25){
						
						windDirNSEW = "W";
						
					}else if(windDir>=281.25 && windDir<303.75){
						
						windDirNSEW = "WNW";
						
					}else if(windDir>=303.75 && windDir<326.25){
						
						windDirNSEW = "NW";
						
					}else if(windDir>=326.25 && windDir<348.75){
						
						windDirNSEW = "NNW";
						
					}
				}
				
				envMap.put("windDirStr", windDirStr);
				
				envMap.put("windDirNSEW", windDirNSEW);
			}
		}
		
		return envLst;
	}
	/**
	 * {@inheritDoc}
	 * @param map
	 * @return
	 */
	@Override
	public Map<String, Object> getEnvInfoByDayListCou(Map<String, Object> map) throws Exception {

		if(map.get("year") != null){
			
			List<Map<String, Object>> dayMonYearTimLst = DateUtil.getDayMonYearTimLst(map.get("year").toString(), "5");
			
			map.put("sta_tim", dayMonYearTimLst.get(0).get("sta_tim"));
			
			map.put("end_tim", dayMonYearTimLst.get(0).get("end_tim"));
		}
		
		
		List<Map<String, Object>> couLst = envDao.getEnvInfoByDayListCou(map);

		if (couLst != null && couLst.size() > 0) {

			for (Map<String, Object> couMap : couLst) {

				return couMap;
			}
		}
		return null;
	}
	

	@Override
	public List<Map<String, Object>> getEnvInfoByYearGraph(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("year").toString();
		// 获取一天的开始时间与结束时间的信息
		List<Map<String, Object>> min2Lst = DateUtil.getDayMonYearTimLst(crtTim, "5");
		
		map.put("sta_tim", min2Lst.get(0).get("sta_tim"));
		
		map.put("end_tim", min2Lst.get(0).get("end_tim"));
		// 获取曲线图的信息
		List<Map<String, Object>> curLst = envDao.getEnvInfoByYearGraphHistory(map);
		
		if(curLst != null && !curLst.isEmpty()){
			
			for(Map<String, Object> envMap:curLst){
				
				String windDirStr = "";
				
				String windDirNSEW = "";
				
				if(envMap != null && envMap.get("windDir") != null){
					
					Double windDir = Double.valueOf(envMap.get("windDir").toString());
					
					if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
						
						windDirStr = "北风";
						
					}else if(windDir>=22.5 && windDir<67.5){
						
						windDirStr = "东北风";
						
					}else if(windDir>=67.5 && windDir<112.5){
						
						windDirStr = "东风";
						
					}else if(windDir>=112.5 && windDir<157.5){
						
						windDirStr = "东南风";
						
					}else if(windDir>=157.5 && windDir<202.5){
						
						windDirStr = "南风";
						
					}else if(windDir>=202.5 && windDir<247.5){
						
						windDirStr = "西南风";
						
					}else if(windDir>=247.5 && windDir<292.5){
						
						windDirStr = "西风";
						
					}else if(windDir>=292.5 && windDir<337.5){
						
						windDirStr = "西北风";
					}
					
					if((windDir>=0.0 && windDir<11.25) || (windDir>=348.75 && windDir<0.0)){
						
						windDirNSEW = "N";
						
					}else if(windDir>=11.25 && windDir<33.75){
						
						windDirNSEW = "NNE";
						
					}else if(windDir>=33.75 && windDir<56.25){
						
						windDirNSEW = "NE";
						
					}else if(windDir>=56.25 && windDir<78.75){
						
						windDirNSEW = "ENE";
						
					}else if(windDir>=78.75 && windDir<101.25){
						
						windDirNSEW = "E";
						
					}else if(windDir>=101.25 && windDir<123.75){
						
						windDirNSEW = "ESE";
						
					}else if(windDir>=123.75 && windDir<146.25){
						
						windDirNSEW = "SE";
						
					}else if(windDir>=146.25 && windDir<168.75){
						
						windDirNSEW = "SSE";
						
					}else if(windDir>=168.75 && windDir<191.25){
						
						windDirNSEW = "S";
						
					}else if(windDir>=191.25 && windDir<213.75){
						
						windDirNSEW = "SSW";
						
					}else if(windDir>=213.75 && windDir<236.25){
						
						windDirNSEW = "SW";
						
					}else if(windDir>=236.25 && windDir<258.75){
						
						windDirNSEW = "WSW";
						
					}else if(windDir>=258.75 && windDir<281.25){
						
						windDirNSEW = "W";
						
					}else if(windDir>=281.25 && windDir<303.75){
						
						windDirNSEW = "WNW";
						
					}else if(windDir>=303.75 && windDir<326.25){
						
						windDirNSEW = "NW";
						
					}else if(windDir>=326.25 && windDir<348.75){
						
						windDirNSEW = "NNW";
						
					}
				}
				
				envMap.put("windDirStr", windDirStr);
				
				envMap.put("windDirNSEW", windDirNSEW);
			}
		}
		return DateUtil.getFifteenMinutesCurves(crtTim, curLst);
		
	}
	
	@Override
	public List<Map<String, Object>> getEnvInfoByYear24HoursGraph(Map<String, Object> map) throws Exception {
		
		String crtTim = map.get("year").toString();
		
//		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATETIME);
		
		List<Map<String, Object>> hoursLst = DateUtil.getDayByHoursEnv(crtTim);
		
		List<Map<String, Object>> retLst = new ArrayList<Map<String,Object>>();
		
		if(hoursLst != null && !hoursLst.isEmpty()){
			
			for(Map<String, Object> hoursMap:hoursLst){
				
				Map<String,Object> retMap = new HashMap<String,Object>();
				
				map.put("sta_tim", hoursMap.get("sta_tim"));
				
				map.put("end_tim", hoursMap.get("end_tim"));
				
				List<Map<String, Object>> curLst = envDao.getEnvInfoByYearGraphHistory(map);
				
				if(curLst != null && !curLst.isEmpty() && curLst.get(0) != null){
					
					for(Map<String, Object> curMap:curLst){
						
						String windDirStr = "";
						
						String windDirNSEW = "";
						
						if(curMap != null && curMap.get("windDir") != null){
							
							Double windDir = Double.valueOf(curMap.get("windDir").toString());
							
							if((windDir>=0.0 && windDir<22.5) || (windDir>=337.5 && windDir<0.0)){
								
								windDirStr = "北风";
								
							}else if(windDir>=22.5 && windDir<67.5){
								
								windDirStr = "东北风";
								
							}else if(windDir>=67.5 && windDir<112.5){
								
								windDirStr = "东风";
								
							}else if(windDir>=112.5 && windDir<157.5){
								
								windDirStr = "东南风";
								
							}else if(windDir>=157.5 && windDir<202.5){
								
								windDirStr = "南风";
								
							}else if(windDir>=202.5 && windDir<247.5){
								
								windDirStr = "西南风";
								
							}else if(windDir>=247.5 && windDir<292.5){
								
								windDirStr = "西风";
								
							}else if(windDir>=292.5 && windDir<337.5){
								
								windDirStr = "西北风";
							}
							
							if((windDir>=0.0 && windDir<11.25) || (windDir>=348.75 && windDir<0.0)){
								
								windDirNSEW = "N";
								
							}else if(windDir>=11.25 && windDir<33.75){
								
								windDirNSEW = "NNE";
								
							}else if(windDir>=33.75 && windDir<56.25){
								
								windDirNSEW = "NE";
								
							}else if(windDir>=56.25 && windDir<78.75){
								
								windDirNSEW = "ENE";
								
							}else if(windDir>=78.75 && windDir<101.25){
								
								windDirNSEW = "E";
								
							}else if(windDir>=101.25 && windDir<123.75){
								
								windDirNSEW = "ESE";
								
							}else if(windDir>=123.75 && windDir<146.25){
								
								windDirNSEW = "SE";
								
							}else if(windDir>=146.25 && windDir<168.75){
								
								windDirNSEW = "SSE";
								
							}else if(windDir>=168.75 && windDir<191.25){
								
								windDirNSEW = "S";
								
							}else if(windDir>=191.25 && windDir<213.75){
								
								windDirNSEW = "SSW";
								
							}else if(windDir>=213.75 && windDir<236.25){
								
								windDirNSEW = "SW";
								
							}else if(windDir>=236.25 && windDir<258.75){
								
								windDirNSEW = "WSW";
								
							}else if(windDir>=258.75 && windDir<281.25){
								
								windDirNSEW = "W";
								
							}else if(windDir>=281.25 && windDir<303.75){
								
								windDirNSEW = "WNW";
								
							}else if(windDir>=303.75 && windDir<326.25){
								
								windDirNSEW = "NW";
								
							}else if(windDir>=326.25 && windDir<348.75){
								
								windDirNSEW = "NNW";
								
							}
						}
						
						retMap.put("windDirStr", windDirStr);
						
						retMap.put("windDirNSEW", windDirNSEW);
						
						retMap.put("windSpeed", curMap.get("windSpeed"));
						
						retMap.put("windDir", curMap.get("windDir"));
					}
				}
				retMap.put("tol_tim", hoursMap.get("tol_tim"));
				
				retLst.add(retMap);
			}
		}
		return retLst;
	}
	
	@Override
	public List<Map<String, Object>> getEnvInfLst(Map<String, Object> map)
			throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> resultLst = new ArrayList<Map<String, Object>>();
		
		// 获取某电站中某设备类型的所有设备信息
		List<Map<String, Object>> equLst = envDao.getEnvLstByPwsEquTyp(map);
		List<Map<String, Object>> pcsRelTimLst = new ArrayList<Map<String, Object>>();
		if (equLst != null && !equLst.isEmpty()) {

			for (Map<String, Object> equMap : equLst) {
				// 获取PCS设备的最新实时数据(列表页中)

				map.put("equ_num", equMap.get("equ_num"));

				List<Map<String, Object>> temp = envDao.getEnvInfByEquNum(map);
				
				pcsRelTimLst.addAll(temp);
				
			}
		}
		
		resultLst.add(pcsRelTimLst.get(0));
		resultLst.addAll(envDao.getEnvDayHg());
		return resultLst;
	}
	
	@Override
	public List<Map<String, Object>> getEnvLstByPwsEquTyp(Map<String, Object> map) throws Exception {
		// 建立最终结果返回集合
		List<Map<String, Object>> equLst = envDao.getEnvLstByPwsEquTyp(map);
		return equLst;
	}
	

	
	

}
