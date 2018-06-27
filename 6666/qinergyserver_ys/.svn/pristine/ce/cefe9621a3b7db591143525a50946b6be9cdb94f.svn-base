package com.qinergy.controller.assetmanagement;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qinergy.base.BaseController;
import com.qinergy.dto.BaseTransferEntity;
import com.qinergy.dto.Pager;
import com.qinergy.dto.assetmanagement.AssetsDto;
import com.qinergy.dto.assetmanagement.AssetsPurPlanDto;
import com.qinergy.dto.assetmanagement.AssetsTypeDto;
import com.qinergy.dto.assetmanagement.DefectDto;
import com.qinergy.dto.assetmanagement.DefectTypeDto;
import com.qinergy.service.assetmanagement.AssetsManagementService;
import com.qinergy.util.DateUtil;
import com.qinergy.util.MobileConfig;
import com.qinergy.util.StringUtil;

@Controller
@RequestMapping(value = "")
public class AssetsManagementController extends BaseController{

	private static Logger log = Logger.getLogger(AssetsManagementController.class);

	@Autowired
	private AssetsManagementService assetManagementService;

	BaseTransferEntity baseTransferEntity;
		
	/**
	 * @Title: insAssetsType
	 * @Desc: 添加资产类型
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/insAssetsType")
	@ResponseBody
	public BaseTransferEntity insAssetsType(HttpServletRequest request, HttpServletResponse response,
			AssetsTypeDto assetsTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		assetsTypeDto.setCrt_use_id(getCurrentUserId(request));
		try {
			
			Map<String,Object> map = new HashMap<String, Object>();
			//资产类型名称
			map.put("typ_nam", assetsTypeDto.getTyp_nam());
			
			List<Map<String,Object>> lstName = assetManagementService.getAssetsTypByName(map);
			//判断类型名称是否重复
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
			//添加
			boolean insAssetsType = assetManagementService.insAssetsTyp(assetsTypeDto);
			baseTransferEntity.setData(insAssetsType);
			if (insAssetsType) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: insAssetsType:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加资产类型接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: updAssetsTyp
	 * @Desc: 修改 资产类型
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/updAssetsTyp")
	@ResponseBody
	public BaseTransferEntity updAssetsTyp(HttpServletRequest request, HttpServletResponse response,
			AssetsTypeDto assetsTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		assetsTypeDto.setMod_use_id(getCurrentUserId(request));
		try {
			// 修改 资产类型
			boolean updAssetsType = assetManagementService.updAssetsTyp(assetsTypeDto);
			
			baseTransferEntity.setData(updAssetsType);
			
			// 判断本次修改是否成功
			if (updAssetsType) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
				
			} else {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			
			log.error("AssetsManagementController: updAssetsTyp:--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("修改 资产类型接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: delAssetsTyp
	 * @Desc: 删除 资产类型 TODO 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/delAssetsTyp")
	@ResponseBody
	public BaseTransferEntity delAssetsTyp(HttpServletRequest request, HttpServletResponse response) {
	
		baseTransferEntity = new BaseTransferEntity();

		String typ_id = request.getParameter("id");// 资产类型id
		
		String mod_use_id = request.getParameter("mod_use_id");// 操作人id
		
		String com_id = request.getParameter("com_id");// 操作人id

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("ass_typ_id", typ_id);
		
		paramMap.put("sub_com_id", com_id);
		
		try {
			
			// 资产数量列表
			Integer count = assetManagementService.getAssetsListCount(paramMap);
			
			if(count > 0){
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.type.not.null"));
				
				baseTransferEntity.setDesc("先清理该类型的数据，再删除该类型!");
				
				return baseTransferEntity;
			}
			// 逻辑删除 资产类型
			boolean delAssetsTyp = assetManagementService.delAssetsTyp(typ_id, mod_use_id);
			
			if (delAssetsTyp) {
				
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
				
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			
			log.error("AssetsManagementController: delAssetsTyp:--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("删除 资产类型接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getAssetsTypById
	 * @Desc: 根据id 查询资产类型
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsTypById")
	@ResponseBody
	public BaseTransferEntity getAssetsTypById(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");// 资产类型id

		try {
			// 根据id获取该资产类型
			Map<String, Object> assetsTyp = assetManagementService.getAssetsTypById(id);
			
			baseTransferEntity.setData(assetsTyp);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			
			log.error("AssetsManagementController: getAssetsTypById:--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("根据id 查询资产类型 接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getAssetsTypList
	 * @Desc: 查询资产类型列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsTypList")
	@ResponseBody
	public BaseTransferEntity getAssetsTypList(HttpServletRequest request, HttpServletResponse response) {
		
		baseTransferEntity = new BaseTransferEntity();

		try {
			// 获取资产类型列表
			List<Map<String, Object>> assetsTypList = assetManagementService.getAssetsTypList();
			
			baseTransferEntity.setData(assetsTypList);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		
		} catch (Exception e) {
			
			log.error("AssetsManagementController: getAssetsTypById:--------->" + e.getMessage(), e);
			
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			
			baseTransferEntity.setDesc("查询资产类型列表接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	
	/*********************************************************************
	 * @Title: getAssetsListByTyp
	 * @Desc: 资产台账列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsListByTyp")
	@ResponseBody
	public BaseTransferEntity getAssetsListByTyp(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String typ_id = request.getParameter("typ_id");// 资产类型id
		String com_id = request.getParameter("com_id");// 公司id

		String words = request.getParameter("words");// 模糊 关键字 ：物资名称、规格型号、物资编号
		
		String currentPage = request.getParameter("currentPage");// 查询 页码
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ass_typ_id", typ_id);
		paramMap.put("sub_com_id", com_id);
		paramMap.put("words", words);

		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}

		try {
			//资产数量列表  
			Integer totalCount = assetManagementService.getAssetsListCount(paramMap);
			page.setTotalCount(totalCount);
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());
			// 获取该公司下的资产台账 统计数据
			List<Map<String, Object>> assetsList = assetManagementService.getAssetsListByTyp(paramMap);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(assetsList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsListByTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("分页查询该公司下的资产列表接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	
	/**
	 * @Title: getAssetsList  
	 * @Desc:  根据ass_num获取 资产列表(出入库操作页面使用)
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsList")
	@ResponseBody
	public BaseTransferEntity getAssetsList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();
		
		String typ_id = request.getParameter("typ_id");// 资产类型id
		String com_id = request.getParameter("com_id");// 公司id

		String words = request.getParameter("words");// 模糊 关键字 ：物资名称、规格型号、物资编号
		
		String currentPage = request.getParameter("currentPage");// 查询 页码
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ass_typ_id", typ_id);
		paramMap.put("sub_com_id", com_id);
		paramMap.put("words", words);

		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		try {
			// 资产数量列表  
			Integer totalCount = assetManagementService.getAssetsListCount(paramMap);
			page.setTotalCount(totalCount);
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());
			//获取该公司下的资产台账 统计数据
			List<Map<String, Object>> assetsList = assetManagementService.getAssetsListByTyp(paramMap);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(assetsList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据ass_num获取 资产列表(出入库操作页面使用)接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
	
	
	/**
	 * @Title: insAssets
	 * @Desc: 出入库 操作
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/assetsInOutBround")
	@ResponseBody
	public BaseTransferEntity assetsInOutBround(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String use_id = request.getParameter("use_id");// 
		String cou = request.getParameter("cou");// 出入库数量
		String ass_num = request.getParameter("ass_num");//  资产编号
		String bround_typ = request.getParameter("bround_typ");//  1:入库 2:出库
		
		if(ass_num == null || ass_num == ""){
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.assests.num.null"));
			baseTransferEntity.setDesc("资产编号为空！");
			return baseTransferEntity;
		}
		if(bround_typ == null || bround_typ == ""){
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.bround.state.null"));
			baseTransferEntity.setDesc("出入库状态为空！");
			return baseTransferEntity;
		}
		if(cou == null || cou == ""){
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.bround.num.null"));
			baseTransferEntity.setDesc("出入库数量为空！");
			return baseTransferEntity;
		}
		if(cou.equals("0")){ 
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.bround.num.zero"));
			baseTransferEntity.setDesc("出入库数量不能为0！");
			return baseTransferEntity;
		}
		
		try {
			
			// 获取当前ass_num 的静态信息
			List<Map<String, Object>> assetsByAssNum = assetManagementService.getAssetsByAssNum(ass_num);
			Map<String, Object> mapByAssNum = assetsByAssNum.get(0);
			if (mapByAssNum != null && !mapByAssNum.isEmpty()) {
				
				if("1".equals(bround_typ)){	//入库
					
					mapByAssNum.put("cou", cou);
					mapByAssNum.put("cur_sta", AssetsDto.BROUND_IN);
					mapByAssNum.put("ord_num", StringUtil.genOrderNumInbound());
				}else if("2".equals(bround_typ)){  //出库
					
					// 该资产的实际库存
					BigDecimal stock_num = (BigDecimal) mapByAssNum.get("stock_num");
					
					if (stock_num.intValue() >= Integer.parseInt(cou)) {
						mapByAssNum.put("cou",  0 - Integer.parseInt(cou));
						mapByAssNum.put("cur_sta", AssetsDto.BROUND_OUT);
						mapByAssNum.put("ord_num", StringUtil.genOrderNumOutbound());
						
					}else {	
						log.error("出库数量 超过库存啦！！！");
						baseTransferEntity.setData(ass_num + "库存 : " + stock_num + "大于出库数量："+ cou);
						baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
						baseTransferEntity.setDesc("出库数量 超过库存啦");
						return baseTransferEntity;
					}
				}
				
			}
			mapByAssNum.remove("stock_num");
			mapByAssNum.remove("mod_use_id");
			mapByAssNum.remove("mod_tim");
			
			mapByAssNum.put("crt_tim", DateUtil.getcurrentTime());
			mapByAssNum.put("crt_use_id", use_id);
			// 添加资产记录信息(出入库 操作)
			boolean insAssets = assetManagementService.insAssets(mapByAssNum);
			baseTransferEntity.setData(insAssets);
			if (insAssets) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
				throw new Exception("出入库 操作");
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: assetsInOutBround:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("出入库 操作接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	
	/**
	 * @Title: insAssetsInfo  
	 * @Desc:  添加 物资静态信息 
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/insAssetsInfo")
	@ResponseBody
	public BaseTransferEntity insAssetsInfo(HttpServletRequest request, HttpServletResponse response,
			AssetsDto assetsDto) {
		baseTransferEntity = new BaseTransferEntity();
		
		if(assetsDto.getCou() == null || assetsDto.getCou() == 0 ){
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.bround.num.zero"));
			baseTransferEntity.setDesc("请输入 入库数量 ！");
			return baseTransferEntity;
		}
		
		String size_lon = request.getParameter("size_lon");
		String size_wid = request.getParameter("size_wid");
		String size_hig = request.getParameter("size_hig");
		
		assetsDto.setSiz(size_lon + "*" + size_wid + "*" + size_hig );
		assetsDto.setCur_sta(AssetsDto.BROUND_IN);
		assetsDto.setOrd_num(StringUtil.genOrderNumInbound());
		
		try {
			
			// 物资新增 验证资产编号不可重复
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("ass_num", assetsDto.getAss_num().toString());
			// 据资产编号 GROUP BY 获取该资产统计信息
			List<Map<String, Object>> lstAssNum = assetManagementService.getAssetsByAssNumNew(map);
			
			if (lstAssNum != null && !lstAssNum.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("填写的资产编号重复，请重新检查资产编号，修改后再提交！");
				return baseTransferEntity;
			}
			// 添加资产静态信息
			boolean insAssets = assetManagementService.insAssets(assetsDto);
			
			if(insAssets){
				assetManagementService.insAssetsAlaInfo(assetsDto.getAss_num(), assetsDto.getCrt_use_id().toString());
				baseTransferEntity.setData(insAssets);
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: insAssetsInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加 物资静态信息接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}
		
	/**
	 * @Title: getAssetsByAssNum
	 * @Desc: to出入库信息 页面 / 修改资产静态信息
	 * 	 			根据资产编号 GROUP BY 获取该资产统计信息
	 * 				有ass_num参数 ：获取指定ass_num的信息
	 * 				无ass_num参数 ：获取所有ass_num的信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsByAssNum")
	@ResponseBody
	public BaseTransferEntity getAssetsByAssNum(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String ass_num = request.getParameter("ass_num");// 资产编号
		try {
			// 根据资产编号 GROUP BY 获取该资产统计信息
			List<Map<String, Object>> assetsInfo = assetManagementService.getAssetsByAssNum(ass_num);
			baseTransferEntity.setData(assetsInfo);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsByAssNum:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("to出入库信息 页面接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	
	
	/**
	 * @Title: updAssets
	 * @Desc: 根据id 修改资产静态信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/updAssetsInfo")
	@ResponseBody
	public BaseTransferEntity updAssetsInfo(HttpServletRequest request, HttpServletResponse response,
			AssetsDto assetsDto) {
		baseTransferEntity = new BaseTransferEntity();
		
		String size_lon = request.getParameter("size_lon");
		String size_wid = request.getParameter("size_wid");
		String size_hig = request.getParameter("size_hig");
		assetsDto.setSiz(size_lon + "*" + size_wid + "*" + size_hig );
		
		try {
			// 修改资产信息 (修改资产静态信息使用)
			boolean result = assetManagementService.updAssets(assetsDto);
			
			if (result) {
				baseTransferEntity.setData(result);
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}else {
				log.error("修改资产静态信息异常");
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
				baseTransferEntity.setDesc("修改资产信息接口异常，请联系管理员！");
				return baseTransferEntity;
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: updAssetsInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改资产信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: delAssets
	 * @Desc:   根据 ass_num 删除资产信息
	 * @return BaseTransferEntity
	 * @throws 
	 */
	@RequestMapping("/service/delAssets")
	@ResponseBody
	public BaseTransferEntity delAssets(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String ass_num = request.getParameter("ass_num");// 资产id
		String mod_use_id = request.getParameter("use_id");// 操作人id

		try {
			// 删除资产
			boolean delAssets = assetManagementService.delAssets(ass_num, mod_use_id);
			baseTransferEntity.setData(delAssets);
			if (delAssets) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: delAssets:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("删除资产信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: delBatchAssets
	 * @Desc:   根据 ass_num批量 删除资产信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@Transactional
	@RequestMapping("/service/delBatchAssets")
	@ResponseBody
	public BaseTransferEntity delBatchAssets(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String ass_nums = request.getParameter("ass_nums");// 资产ids
		String mod_use_id = request.getParameter("use_id");// 操作人id

		try {
			// 批量删除资产
			boolean delBatchAssets = assetManagementService.delBatchAssets(ass_nums, mod_use_id);
			baseTransferEntity.setData(delBatchAssets);

			if (delBatchAssets) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: delBatchAssets:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("批量删除资产信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getInOutBroundList
	 * @Desc: 出入库信息列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getInOutBroundList")
	@ResponseBody
	public BaseTransferEntity getInOutBroundList(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String com_id = request.getParameter("com_id");// 公司id
		String cur_sta = request.getParameter("cur_sta");// 出入库状态
		String start_tim = request.getParameter("start_tim");// 起始时间
		String end_tim = request.getParameter("end_tim");// 结束时间
		String words = request.getParameter("words");// 模糊 关键字 ：出入库单号、经手人

		String currentPage = request.getParameter("currentPage");// 查询 页码

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("cur_sta", cur_sta);
		paramMap.put("sub_com_id", com_id);
		paramMap.put("start_tim", start_tim);
		
		paramMap.put("words", words);

		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}

		try {

			if(end_tim != null && !end_tim.isEmpty()){
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
						
				paramMap.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			// 物资出入库信息count
			Integer totalCount = assetManagementService.getInOutBroundCount(paramMap);
			page.setTotalCount(totalCount);
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());
			// 物资出入库列表
			List<Map<String, Object>> assetsList = assetManagementService.getInOutBroundList(paramMap);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(assetsList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getInOutBroundList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("出入库信息列表接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getAssetsListByOrdNum
	 * @Desc: 根据出入库单号 获取 出入库详单
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsListByOrdNum")
	@ResponseBody
	public BaseTransferEntity getAssetsListByOrdNum(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String ord_num = request.getParameter("ord_num");// 出入库单号

		try {
			// 根据单号 查询 所有出入库信息
			List<Map<String, Object>> assetsListByOrdNum = assetManagementService.getAssetsListByOrdNum(ord_num);
			baseTransferEntity.setData(assetsListByOrdNum);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsListByOrdNum:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc(" 获取 出入库详单 接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: setAssetsStockAlaNum
	 * @Desc: 根据资产编号 设置 告警库存
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/setAssetsStockAlaNum")
	@ResponseBody
	public BaseTransferEntity setAssetsStockAlaNum(HttpServletRequest request, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		String ass_num = request.getParameter("ass_num");// 资产编号
		String ala_num = request.getParameter("ala_num");// 告警库存
		String mod_use_id = request.getParameter("use_id");// 操作人id

		try {
			// 设置 资产告警数量
			boolean setAssetsAlaCou = assetManagementService.setAssetsAlaCou(ass_num, ala_num, mod_use_id);
			if (setAssetsAlaCou) {
				baseTransferEntity.setData(setAssetsAlaCou);
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: getStoreHouseByComId:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取仓库信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getAssetsAlaCou
	 * @Desc: 根据资产编号获取 告警库存
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getAssetsAlaCou")
	@ResponseBody
	public BaseTransferEntity getAssetsAlaCou(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String ass_num = request.getParameter("ass_num");// 资产编号

		try {
			// 根据 ass_num 获取 资产告警数量 
			Map<String, Object> assetsAlaCou = assetManagementService.getAssetsAlaCou(ass_num);
			baseTransferEntity.setData(assetsAlaCou);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getStoreHouseByComId:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取仓库信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getStoreHouseByComId
	 * @Desc: 获得 仓库信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/getStoreHouseByComId")
	@ResponseBody
	public BaseTransferEntity getStoreHouseByComId(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		String com_id = request.getParameter("com_id");// 公司id

		try {
			List<Map<String, Object>> storeHouse = assetManagementService.getStoreHouseByComId(com_id);
			baseTransferEntity.setData(storeHouse);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getStoreHouseByComId:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取仓库信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/*******************************************
	 * @Title: uploadDef
	 * @Desc: 上传缺陷文件  
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping(value = { "service/uploadDef" }, method = { RequestMethod.POST })
	@ResponseBody
	public BaseTransferEntity uploadDef(@RequestParam("file") MultipartFile file,int use_id, String def_num, String remark) {
		baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> paramMap = new HashMap<String, Object>();

		if(file == null){
			log.error("uploadDef ：上传文件 为空");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传文件 为空");
			return baseTransferEntity;
		}
		// 显示文件上传大小
		if(file.getSize() > 100 * 1024 * 1024){ 
			log.error("uploadDef ：上传失败：文件大小不能超过100M");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传失败：文件大小不能超过100M");
            return baseTransferEntity;
        }
		
		try {
			paramMap.put("file_nam", file.getOriginalFilename());
			paramMap.put("def_num", def_num);
			paramMap.put("remark", remark);
			paramMap.put("crt_use_id", use_id);
			paramMap.put("crt_tim", DateUtil.getcurrentTime());
			// 上传文件
			boolean flag = assetManagementService.uploadFile(file, paramMap);
			baseTransferEntity.setData(flag);
			
			if (flag) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("文件上传成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件上传失败");
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: uploadDef:--------->" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: downloadDef
	 * @Desc: 下载文件
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/downloadDef")
	@ResponseBody
	public BaseTransferEntity downloadDef(@RequestParam("id") int id, HttpServletResponse response) {
		BaseTransferEntity baseTransferEntity = new BaseTransferEntity();

		try {
			// 根据id查询缺陷文件
			Map<String, Object> map = assetManagementService.getFileById(String.valueOf(id));
			// 判断文件是否存在
			if (map.size() == 0 || (map.get("del_flag").toString() == null)){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在");
				return baseTransferEntity;
			}

			String path = map.get("fil_url").toString();
			String file_name = map.get("fil_nam").toString();
			
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("path", path);
			map1.put("file_name", file_name);
			// 创建文件
			File file = new File(path);
			if (!file.exists()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
				return baseTransferEntity;
				
			}
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(map1);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
			
		} catch (Exception e) {
			log.error("AssetsManagementController: downloadDef:--------->" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("系统接口异常，请联系管理员！");
			
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: delFile
	 * @Desc: 根据id删除文件
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delFile")
	@ResponseBody
	public BaseTransferEntity delFile(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");// id
		String use_id = request.getParameter("use_id");// 操作人id

		try {
			boolean delFile = assetManagementService.delFile(id, use_id);
			if (delFile) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: delFile:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("删除文件接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getFileById
	 * @Desc: 根据id 获取文件信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getFileById")
	@ResponseBody
	public BaseTransferEntity getFileById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");

		try {

			baseTransferEntity.setData(assetManagementService.getFileById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getFileById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件信息 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: getFileListByDefId
	 * @Desc: 根据缺陷编号 获取文件信息列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getFileListByDefId")
	@ResponseBody
	public BaseTransferEntity getFileListByDefId(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String def_num = request.getParameter("def_num");// 缺陷编号

		try {

			baseTransferEntity.setData(assetManagementService.getFileListByDefId(def_num));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getFileListByDefId:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件列表 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/*********************************************
	 * @Title: insDefectTyp
	 * @Desc: 添加缺陷类型
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/insDefectTyp")
	@ResponseBody
	public BaseTransferEntity insDefectTyp(HttpServletRequest request, DefectTypeDto defectTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			
			
			Map<String,Object> map = new HashMap<String, Object>();
			
			map.put("typ_nam", defectTypeDto.getTyp_nam());
			
			List<Map<String,Object>> lstName = assetManagementService.getDefectTypByName(map);
			
			if (lstName != null && !lstName.isEmpty()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("类型名称重复，请重新填写！");
				return baseTransferEntity;
			}
			
			baseTransferEntity.setData(assetManagementService.insDefectTyp(defectTypeDto));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: insDefectTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加缺陷类型接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: getDefectTyp
	 * @Desc: 根据id获取 类型信息 修改回显
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getDefectTyp")
	@ResponseBody
	public BaseTransferEntity getDefectTyp(HttpServletRequest request, DefectTypeDto defectTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
		String id = request.getParameter("id");

		try {
			baseTransferEntity.setData(assetManagementService.getDefectTypById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getDefectTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据id获取 类型信息 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: updDefectTyp
	 * @Desc: 修改 缺陷类型信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/updDefectTyp")
	@ResponseBody
	public BaseTransferEntity updDefectTyp(HttpServletRequest request, DefectTypeDto defectTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			
			baseTransferEntity.setData(assetManagementService.updDefectTyp(defectTypeDto));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: updDefectTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改 缺陷类型信息接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: delDefectTyp
	 * @Desc: 删除缺陷类型
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delDefectTyp")
	@ResponseBody
	public BaseTransferEntity delDefectTyp(HttpServletRequest request, DefectTypeDto defectTypeDto) {
		baseTransferEntity = new BaseTransferEntity();
		String id = request.getParameter("id");
		String mod_use_id = request.getParameter("use_id"); // 操作人id

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("typ_id", id);
		paramMap.put("del_flag", DefectTypeDto.DEL_FLAG_NO);
		paramMap.put("start", 0);
		paramMap.put("everyPage", 10);
		try {
			
			List<Map<String, Object>> defectList = assetManagementService.getDefectList(paramMap);
			
			if(defectList != null && defectList.size() > 0){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.type.not.null"));
				baseTransferEntity.setDesc("先清理该类型的数据，再删除该类型");
				return baseTransferEntity;
			}
			
			boolean delDefectTyp = assetManagementService.delDefectTyp(id, mod_use_id);
			
			if (delDefectTyp) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: updDefectTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("删除 缺陷类型信息接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: getDefectTypList
	 * @Desc: 获取 缺陷类型列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getDefectTypList")
	@ResponseBody
	public BaseTransferEntity getDefectTypList(HttpServletRequest request, DefectTypeDto defectTypeDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			List<Map<String, Object>> defectTypList = assetManagementService.getDefectTypList();
			baseTransferEntity.setData(defectTypList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: updDefectTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改 缺陷类型信息接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	// /////////////////////////////////////////////

	/**
	 * @Title: insDefectInfo
	 * @Desc: 添加缺陷信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/insDefectInfo")
	@ResponseBody
	public BaseTransferEntity insDefectInfo(HttpServletRequest request, DefectDto defectDto) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			boolean insDefectInfo = assetManagementService.insDefectInfo(defectDto);
			baseTransferEntity.setData(insDefectInfo);
			if (insDefectInfo) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: insDefectTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加缺陷信息接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: getDefectInfoByDefnum
	 * @Desc: 返回 缺陷信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getDefectInfoByDefnum")
	@ResponseBody
	public BaseTransferEntity getDefectInfoByDefnum(HttpServletRequest request, DefectDto defectDto) {
		baseTransferEntity = new BaseTransferEntity();

		String def_num = request.getParameter("def_num"); // 缺陷编号

		try {
			baseTransferEntity.setData(assetManagementService.getDefectInfoByDefnum(def_num));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getDefectInfoByDefnum:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("返回 缺陷信息 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: updDefectInfo
	 * @Desc: 修改缺陷信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/updDefectInfo")
	@ResponseBody
	public BaseTransferEntity updDefectInfo(HttpServletRequest request, DefectDto defectDto) {
		baseTransferEntity = new BaseTransferEntity();
		try {
			boolean updDefectInfo = assetManagementService.updDefectInfo(defectDto);
			baseTransferEntity.setData(updDefectInfo);
			if (updDefectInfo) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: updDefectInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改缺陷信息 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: delDefectInfo
	 * @Desc:   根据def_num 删除缺陷信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delDefectInfo")
	@ResponseBody
	public BaseTransferEntity delDefectInfo(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String def_num = request.getParameter("def_num"); // 缺陷编号
		String id = request.getParameter("id"); // 缺陷ID
		String mod_use_id = request.getParameter("use_id"); // 操作人id

		
		try {
			List<Map<String, Object>> defectFilList = assetManagementService.getFileListByDefId(def_num);
			
			if(defectFilList != null && defectFilList.size() > 0){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.type.not.null"));
				baseTransferEntity.setDesc("先清理该类型的数据，再删除该类型");
				return baseTransferEntity;
			}
			
			boolean delDefectInfo = assetManagementService.delDefectInfo(def_num,id, mod_use_id);
			baseTransferEntity.setData(delDefectInfo);
			if (delDefectInfo) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: delDefectInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据def_num 删除缺陷信息 异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: delBatchDefectInfo
	 * @Desc: TODO 根据def_num 批量删除缺陷信息
	 * 				--无用接口--
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delBatchDefectInfo")
	@ResponseBody
	public BaseTransferEntity delBatchDefectInfo(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String def_nums = request.getParameter("def_nums"); // 缺陷编号
		String mod_use_id = request.getParameter("use_id"); // 操作人id

		try {
			baseTransferEntity.setData(assetManagementService.delBatchDefectInfo(def_nums, mod_use_id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: delBatchDefectInfo:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据def_num 批量删除缺陷信息 异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getDefectList
	 * @Desc: 分页查询缺陷列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getDefectList")
	@ResponseBody
	public BaseTransferEntity getDefectList(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String com_id = request.getParameter("com_id");// 公司id
		String def_grade = request.getParameter("def_grade");// 缺陷等级
		String def_sta = request.getParameter("def_sta");//
		String start_tim = request.getParameter("start_tim");
		String end_tim = request.getParameter("end_tim");
		String typ_id = request.getParameter("typ_id");//
		String words = request.getParameter("words");// 模糊 关键字 ：缺陷编号、缺陷描述

		String currentPage = request.getParameter("currentPage");// 查询 页码

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("sub_com_id", com_id);
		paramMap.put("def_sta", def_sta);
		paramMap.put("def_grade", def_grade);
		paramMap.put("typ_id", typ_id);
		paramMap.put("start_tim", start_tim);
		paramMap.put("end_tim", end_tim);
		paramMap.put("words", words);
		paramMap.put("del_flag", AssetsDto.DEL_FLAG_NO);

		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}

		try {
			Integer totalCount = assetManagementService.getDefectListCount(paramMap);
			page.setTotalCount(totalCount);
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> defectList = assetManagementService.getDefectList(paramMap);

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(defectList);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsListByTyp:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("分页查询该公司下的资产列表接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * ********************************资产采购计划***********************************
	 * **
	 * 
	 * @Title: insAssetsPurPlan
	 * @Desc: 添加 采购计划
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/insAssetsPurPlan")
	@ResponseBody
	public BaseTransferEntity insAssetsPurPlan(HttpServletRequest request, AssetsPurPlanDto assetsPurPlanDto) {
		baseTransferEntity = new BaseTransferEntity();
		
		HashMap<String, Object> user = (HashMap<String, Object>)(request.getSession().getAttribute("user"));
		if(user != null && !user.isEmpty()){
			assetsPurPlanDto.setCrt_use_id( (Integer)user.get("id"));
		}
		
		try {

			boolean insAssetsPurPlan = assetManagementService.insAssetsPurPlan(assetsPurPlanDto);
			baseTransferEntity.setData(insAssetsPurPlan);

			if (insAssetsPurPlan) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: insAssetsPurPlan:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("添加 采购计划接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getAssetsPurPlanById
	 * @Desc: 根据id获取计划信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getAssetsPurPlanById")
	@ResponseBody
	public BaseTransferEntity getAssetsPurPlanById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");// id
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);

		try {
			Map<String, Object> assetsPurPlan = assetManagementService.getAssetsPurPlanById(paramMap);
			baseTransferEntity.setData(assetsPurPlan);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsPurPlanById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据id获取计划信息接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: updAssetsPurPlan
	 * @Desc: 修改采购计划
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/updAssetsPurPlan")
	@ResponseBody
	public BaseTransferEntity updAssetsPurPlan(HttpServletRequest request, AssetsPurPlanDto assetsPurPlanDto) {
		baseTransferEntity = new BaseTransferEntity();

		
		
		try {
			
			HashMap<String, Object> user = (HashMap<String, Object>)(request.getSession().getAttribute("user"));
			if(user != null && !user.isEmpty()){
				assetsPurPlanDto.setCrt_use_id( (Integer)user.get("id"));
				String plan_use_id = request.getParameter("plan_use_id");
				assetsPurPlanDto.setPlan_use_id(Integer.valueOf(plan_use_id));
			}

			boolean updAssetsPurPlan = assetManagementService.updAssetsPurPlan(assetsPurPlanDto);
			baseTransferEntity.setData(updAssetsPurPlan);

			if (updAssetsPurPlan) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: insAssetsPurPlan:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("修改采购计划接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: delAssetsPurPlan
	 * @Desc:  根据id删除计划
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delAssetsPurPlan")
	@ResponseBody
	public BaseTransferEntity delAssetsPurPlan(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");// id
		String use_id = request.getParameter("use_id"); 
		String plan_num = request.getParameter("plan_num"); 

		
		try {
			List<Map<String, Object>> purPlanFileList = assetManagementService.getPurPlanFileListByPlanNum(plan_num);
			
			if(purPlanFileList != null && purPlanFileList.size() > 0){
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.error.file.not.null"));
				baseTransferEntity.setDesc("请先删除该采购计划的文件，再删除该计划！");
				return baseTransferEntity;
			}
			
			boolean delAssetsPurPlan = assetManagementService.delAssetsPurPlan(id, use_id);
			baseTransferEntity.setData(delAssetsPurPlan);
			if (delAssetsPurPlan) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: delAssetsPurPlan:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("根据id删除计划接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: delBatchAssetsPurPlan
	 * @Desc: 根据ids批量删除计划
	 * 				--	该接口未使用	--
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delBatchAssetsPurPlan")
	@ResponseBody
	public BaseTransferEntity delBatchAssetsPurPlan(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String ids = request.getParameter("ids");// ids: '1,2,3'
		String mod_use_id = request.getParameter("use_id");// id

		try {
			boolean delAssetsPurPlan = assetManagementService.delBatchAssetsPurPlan(ids, mod_use_id);
			baseTransferEntity.setData(delAssetsPurPlan);
			if (delAssetsPurPlan) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: delBatchAssetsPurPlan:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("批量删除采购计划接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getAssetsPurPlanList
	 * @Desc: 查询采购计划列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getAssetsPurPlanList")
	@ResponseBody
	public BaseTransferEntity getAssetsPurPlanList(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		Map<String, Object> paramMap = new HashMap<String, Object>();

		String words = request.getParameter("words");// 模糊 关键字 ：创建人 、采购人
		String end_tim = request.getParameter("end_tim");//
		
		//app 要传过来的 为 开始时间的参数 
		String start_tim = request.getParameter("start_tim");//
		//pc端 传过来的 为 开始时间的参数
		String sta_tim = request.getParameter("sta_tim");//
		String is_finish = request.getParameter("is_finish");//
		String currentPage = request.getParameter("currentPage");// 查询 页码

		paramMap.put("words", words);
		
		if (start_tim != null && !start_tim.isEmpty()) {
			paramMap.put("start_tim", start_tim);
		}
		if (sta_tim != null && !sta_tim.isEmpty()) {
			paramMap.put("start_tim", sta_tim);
		}

		paramMap.put("is_finish", is_finish);
		paramMap.put("del_flag", AssetsPurPlanDto.DEL_FLAG_NO);

		Pager page = new Pager();
		if (currentPage != null && !currentPage.isEmpty()) {
			page.setCurrentPage(Integer.parseInt(currentPage));
		}

		try {
			if(end_tim != null && !end_tim.isEmpty()){
				
				SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_DATE);
				
				paramMap.put("end_tim", DateUtil.addDay(sdf.parse(end_tim), 1));
			}
			int totalCount = assetManagementService.getAssetsPurPlanCount(paramMap);
			page.setTotalCount(totalCount);
			paramMap.put("start", page.getStart());
			paramMap.put("everyPage", page.getEveryPage());

			List<Map<String, Object>> resultList = null;

			List<Map<String, Object>> assetsPurPlanList = assetManagementService.getAssetsPurPlanList(paramMap);
			if (assetsPurPlanList != null && assetsPurPlanList.size() > 0) {
				resultList = new ArrayList<Map<String, Object>>();

				for (Map<String, Object> purPlan : assetsPurPlanList) {

					if (purPlan != null && !purPlan.isEmpty()) {

						// 获取采购信息对应的文件
						List<Map<String, Object>> fileList = assetManagementService.getPurPlanFileListByPlanNum(purPlan
								.get("plan_num").toString());
						if (fileList != null && fileList.size() > 0) {
							purPlan.put("fileList", fileList);
						}
					}
					resultList.add(purPlan);
				}
			}

			baseTransferEntity.setCurrentPage(page.getCurrentPage());
			baseTransferEntity.setEveryPage(page.getEveryPage());
			baseTransferEntity.setTotalCount(page.getTotalCount());
			baseTransferEntity.setTotalPage(page.getTotalPage());
			baseTransferEntity.setData(resultList);

			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getAssetsPurPlanList:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("查询采购计划列表接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/*******************************************
	 * @Title: uploadPurPlan
	 * @Desc: 上传采购计划文件 file_type文件类型(1:文件 2:图片)
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping(value = { "service/uploadPurPlan" }, method = { RequestMethod.POST })
	@ResponseBody
	public BaseTransferEntity uploadPurPlan(@RequestParam("file") MultipartFile file,int use_id, String plan_num) {
		baseTransferEntity = new BaseTransferEntity();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		if(file == null){
			log.error("uploadDef ：上传文件 为空");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传文件 为空");
			return baseTransferEntity;
		}
		if(file.getSize() > 100 * 1024 * 1024){ 
			log.error("uploadDef ：上传失败：文件大小不能超过100M");
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传失败：文件大小不能超过100M");
            return baseTransferEntity;
        }
		
		try {
			paramMap.put("file_nam", file.getOriginalFilename());
			paramMap.put("plan_num", plan_num);
			paramMap.put("crt_use_id", use_id);
			paramMap.put("crt_tim", DateUtil.getcurrentTime());

			boolean flag = assetManagementService.uploadPurPlanFile(file, paramMap);
			baseTransferEntity.setData(flag);
			
			if (flag) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc("文件上传成功");
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("msg.global.failed"));
				baseTransferEntity.setDesc("文件上传失败");
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: uploadPurPlan:--------->" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("上传采购计划文件 接口异常，请联系管理员！");
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: downloadPurPlan
	 * @Desc: 下载采购计划文件
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("/service/downloadPurPlan")
	@ResponseBody
	public BaseTransferEntity downloadPurPlan(@RequestParam("id") int id, HttpServletResponse response) {
		baseTransferEntity = new BaseTransferEntity();

		try {
			/*boolean download = assetManagementService.downloadPurPlanFile(response, id, baseTransferEntity);
			baseTransferEntity.setData(download);
			return baseTransferEntity;
*/
			Map<String, Object> map = assetManagementService.getPurPlanFileById(String.valueOf(id));
			
			if (map.size() == 0 || !((Integer) map.get("del_flag") == 0)) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在");
				return baseTransferEntity;
			}
			String path = map.get("fil_url").toString();
			String file_name =map.get("fil_nam").toString();
			
			Map<String,Object> map1 = new HashMap<String, Object>();
			map1.put("path", path);
			map1.put("file_name", file_name);
			
			File file = new File(path);
			if (!file.exists()) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc("请求的文件不存在，可能被非法删除");
				return baseTransferEntity;
				
			}
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setData(map1);
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			
		} catch (Exception e) {
			log.error("AssetsManagementController: downloadPurPlan:--------->" + e.getMessage());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("下载采购计划文件   接口异常，请联系管理员！");
			
		}
		return baseTransferEntity;
	}

	/**
	 * @Title: delPurPlanFile
	 * @Desc: 逻辑删除采购计划文件
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/delPurPlanFile")
	@ResponseBody
	public BaseTransferEntity delPurPlanFile(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");// id
		String use_id = request.getParameter("use_id");// 操作人id

		try {
			boolean delTrainFile = assetManagementService.delPurPlanFile(id, use_id);
			baseTransferEntity.setData(delTrainFile);
			if (delTrainFile) {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
			} else {
				baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.failed"));
				baseTransferEntity.setDesc(MobileConfig.get("msg.global.failed"));
			}
		} catch (Exception e) {
			log.error("AssetsManagementController: delPurPlanFile:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("删除文件接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getPurPlanFileById
	 * @Desc: 根据id查询采购计划附件信息
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getPurPlanFileById")
	@ResponseBody
	public BaseTransferEntity getPurPlanFileById(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String id = request.getParameter("id");
		
		try {
			baseTransferEntity.setData(assetManagementService.getPurPlanFileById(id));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getFileById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件信息 接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}

	/**
	 * @Title: getPurPlanFileList
	 * @Desc: 根据计划编号 获取采购计划文件列表
	 * @return BaseTransferEntity
	 * @throws
	 */
	@RequestMapping("service/getPurPlanFileList")
	@ResponseBody
	public BaseTransferEntity getPurPlanFileList(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();

		String plan_num = request.getParameter("plan_num");
		try {
			baseTransferEntity.setData(assetManagementService.getPurPlanFileListByPlanNum(plan_num));
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getFileById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件信息列表 接口异常，请联系管理员！");
		}

		return baseTransferEntity;
	}
	
	/**
	 * 查询所有仓库
	 * @param request
	 * @return
	 */
	@RequestMapping("service/getAllWareHouseName")
	@ResponseBody
	public BaseTransferEntity getAllWareHouseName(HttpServletRequest request) {
		baseTransferEntity = new BaseTransferEntity();
		
		try {
			baseTransferEntity.setData(assetManagementService.getAllWareHouseName());
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.success"));
			baseTransferEntity.setDesc(MobileConfig.get("msg.global.success"));
		} catch (Exception e) {
			log.error("AssetsManagementController: getFileById:--------->" + e.getMessage(), e);
			baseTransferEntity.setResultcode(MobileConfig.getStringCode("code.global.error.exception"));
			baseTransferEntity.setDesc("获取文件信息列表 接口异常，请联系管理员！");
		}
		
		return baseTransferEntity;
	}

}
