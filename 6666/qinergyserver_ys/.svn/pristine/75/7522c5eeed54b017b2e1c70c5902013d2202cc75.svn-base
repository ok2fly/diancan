package com.qinergy.controller.commens;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qinergy.controller.utils.IpUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/commens")
public class CommensController {
	
	
	/*  各个页面的首页   */
	@RequestMapping("/{url}/main")
	public String urlmain(@PathVariable String url, HttpSession session,HttpServletRequest req) {
		//定义跳转路径
		String returnStr = "zhjk/main";
		if (url.equals("zhjk")) {
			String app_typ_id = req.getParameter("app_typ_id");
			String pws_id = req.getParameter("pws_id");
			String typ_ide = req.getParameter("typ_ide");
			String goJumpType = req.getParameter("goJumpType");
			String id = req.getParameter("id");
			String equNum = req.getParameter("equNum");
			req.setAttribute("app_typ_id",app_typ_id);
			req.setAttribute("pws_id",pws_id);
			req.setAttribute("typ_ide",typ_ide);
			req.setAttribute("goJumpType",goJumpType);
			req.setAttribute("id",id);
			req.setAttribute("equNum",equNum);
			returnStr = "zhjk/main";
		} else if (url .equals("ywgl")) {
			returnStr = "ywgl/main";
		}  else if (url .equals("khgl")) {
			returnStr = "khgl/main";
		} else if (url .equals("tjfx")) {
			returnStr = "tjfx/main";
		} else if (url .equals("xtgl")) {
			returnStr = "xtgl/main";
		} else if (url .equals("rcbg")) {
			returnStr = "rcbg/main";
		} else if (url .equals("zcgl")) {
			returnStr = "zcgl/main";
		} else if (url .equals("aqgl")) {
			returnStr = "aqgl/main";
		} else if (url .equals("jhgl")) {
			returnStr = "jhgl/main";
		} else if (url .equals("zsk")) {
			returnStr = "zsk/main";
		} 
		return returnStr;
	}
	
	/*  各个页面的顶部   */
	@RequestMapping("/{url}/top")
	public String top(@PathVariable String url,HttpSession session,HttpServletRequest req) {
		//定义跳转路径
		String returnStr = "top";
		if (url.equals("zhjk")) {
			String app_typ_id = req.getParameter("app_typ_id");
			String pws_id = req.getParameter("pws_id");
			String typ_ide = req.getParameter("typ_ide");
			String goJumpType = req.getParameter("goJumpType");
			String id = req.getParameter("id");
			String equNum = req.getParameter("equNum");
			req.setAttribute("app_typ_id",app_typ_id);
			req.setAttribute("pws_id",pws_id);
			req.setAttribute("typ_ide",typ_ide);
			req.setAttribute("goJumpType",goJumpType);
			req.setAttribute("id",id);
			req.setAttribute("equNum",equNum);
			returnStr = "zhjk/top";
		}
		return returnStr;
	}
	
	/*  各个页面的菜单   */
	@RequestMapping("/{url}/menu")
	public String menu(@PathVariable String url, HttpSession session,HttpServletRequest req) {
		//判断登录之后的主页面显示的页面，根据角色权限设置
		List menuList =  (List) session .getAttribute("menu");
		
		//定义返回的list
		List list=new ArrayList();
				
		if(menuList.size() > 0){
			//默认跳转到第一条菜单的页面
			Map<String, Object> map = (Map<String, Object>)menuList.get(0);
			String module_code = (String) map.get("module_code");
			if(url.equals("zhjk")){
				String app_typ_id = req.getParameter("app_typ_id");
				String pws_id = req.getParameter("pws_id");
				String typ_ide = req.getParameter("typ_ide");
				String goJumpType = req.getParameter("goJumpType");
				String id = req.getParameter("id");
				String equNum = req.getParameter("equNum");
				req.setAttribute("app_typ_id",app_typ_id);
				req.setAttribute("pws_id",pws_id);
				req.setAttribute("typ_ide",typ_ide);
				req.setAttribute("goJumpType",goJumpType);
				req.setAttribute("id",id);
				req.setAttribute("equNum",equNum);
				return "/zhjk/menu";
			}else if(url.equals("ywgl")){
				list = getMenu(menuList,"YWGL");
			}else if(url.equals("khgl") ){
				list = getMenu(menuList,"KHGL");
			}else if(url.equals("tjfx") ){
				list = getMenu(menuList,"TJFX");
			}else if(url.equals("xtgl") ){
				list = getMenu(menuList,"XTGL");
			}else if(url.equals("rcbg")){
				list = getMenu(menuList,"RCBG");
			}else if(url.equals("zcgl")){
				list = getMenu(menuList,"ZCGL");
			}else if(url.equals("aqgl") ){
				list = getMenu(menuList,"AQGL");
			}else if(url.equals("jhgl") ){
				list = getMenu(menuList,"JHGL");
			}else if(url.equals("zsk") ){
				list = getMenu(menuList,"ZSK");
			}      
			System.out.println("list---"+list);
			req.setAttribute("menu", list);
		} 
		
		return  "/menu";
	}
	
	
	/* 首页  */
	@RequestMapping("/main")
	public String main(HttpSession session,HttpServletRequest req) {
		Map<String, Object>  user = (Map<String, Object>)session .getAttribute("user");
		req.setAttribute("user", user);
		return "main";
	}
	
	/* 主页  */
	@RequestMapping("/index")
	public String index(HttpSession session,HttpServletRequest req) {
		
		//定义跳转路径
		String returnStr = "index";
		
		return returnStr;
	}
	
	@RequestMapping("/resetPwd")
	public String resetPwd(HttpSession session,HttpServletRequest req) {
		
		
		String id = req.getParameter("id");
		req.setAttribute("id",id);
		
		return "resetPwd";
	}
	/**
	 * 获取一级菜单下的下级菜单权限
	 * @param menuList
	 * @param type_url
	 * @return
	 */
	private List getMenu(List menuList, String code) {
		List list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < menuList.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) menuList.get(i); 
			String module_url = (String) map.get("module_code");
			if(module_url.indexOf(code) > -1 ){
				list =  (List) map.get("menu");
			}
		}
		return list;
	}
 
	
	/* 底部导航  */
	@RequestMapping("/bottom")
	public String bottom(HttpSession session,HttpServletRequest req) {
		Map<String, Object>  user = (Map<String, Object>)session .getAttribute("user");
		req.setAttribute("user", user);
		return "bottom";
	}
	/********************************* 综合监控 *********************************/
	
	
	/* 综合监控地图  */
	@RequestMapping("/map")
	public String map(HttpSession session,HttpServletRequest req) {
		
		return "zhjk/map";
	}
	
	/* 综合监控地图列表  */
	@RequestMapping("/maplist")
	public String maplist(HttpSession session,HttpServletRequest req) {
		
		return "zhjk/maplist";
	}

	/* 综合监控电站详情  */
	@RequestMapping("/detail")
	public String detail(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id",id);
		return "zhjk/detail";
	}

	/* 综合监控设备列表  */
	@RequestMapping("/sblb")
	public String sblb(HttpSession session,HttpServletRequest req) {
		
		return "zhjk/sblb";
	}
	
	@RequestMapping("/zhjk/sb/sb")
	public String sb(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		String goJumpType = req.getParameter("goJumpType");
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		req.setAttribute("goJumpType",goJumpType);
		req.setAttribute("id",id);
		req.setAttribute("equNum",equNum);
		return "zhjk/sb/sb";
	}
	
	/*储能电池*/
	@RequestMapping("/zhjk/sb/energy")
	public String energy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/energy";
	}
	
	/*储能电池历史*/
	@RequestMapping("/zhjk/sb/energyhistory")
	public String energyhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/energyhistory";
	}
	
	/*储能电池健康*/
	@RequestMapping("/zhjk/sb/energyhealthy")
	public String energyhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/energyhealthy";
	}
	
	/*电表*/
	@RequestMapping("/zhjk/sb/enwatch")
	public String enwatch(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/enwatch";
	}
	/*电表历史*/
	@RequestMapping("/zhjk/sb/enwatchhistory")
	public String enwatchhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/enwatchhistory";
	}
	/*电表健康*/
	@RequestMapping("/zhjk/sb/enwatchhealthy")
	public String enwatchhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/enwatchhealthy";
	}
	/*dc*/
	@RequestMapping("/zhjk/sb/dc")
	public String dc(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/dc";
	}
	/*dc健康*/
	@RequestMapping("/zhjk/sb/dchealthy")
	public String dchealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/dchealthy";
	}
	/*dc历史*/
	@RequestMapping("/zhjk/sb/dchistory")
	public String dchistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/dchistory";
	}
	
	/*光伏逆变器*/
	@RequestMapping("/zhjk/sb/pvinverter")
	public String pvinverter(HttpSession session,HttpServletRequest req){
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/pvinverter";
	}
	
	/*光伏逆变器历史*/
	@RequestMapping("/zhjk/sb/pvshistory")
	public String pvshistory(HttpSession session,HttpServletRequest req){
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/pvshistory";
	}
	/*光伏逆变器健康*/
	@RequestMapping("/zhjk/sb/pvshealthy")
	public String pvshealthy(HttpSession session,HttpServletRequest req){
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/pvshealthy";
	}
	
	/*储能逆变器*/
	@RequestMapping("/zhjk/sb/storage")
	public String storage(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/storage";
	}
	/*储能逆变器历史*/
	@RequestMapping("/zhjk/sb/storagehistory")
	public String storagehistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/storagehistory";
	}
	/*储能逆变器健康*/
	@RequestMapping("/zhjk/sb/storagehealthy")
	public String storagehealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/storagehealthy";
	}
	/*变压器*/
	@RequestMapping("/zhjk/sb/transformer")
	public String transfotmer(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/transformer";
	}
	
	/*变压器历史*/
	@RequestMapping("/zhjk/sb/transformerhistory")
	public String transformerhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/transformerhistory";
	}
	/*变压器健康*/
	@RequestMapping("/zhjk/sb/transformerhealthy")
	public String transformerhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/transformerhealthy";
	}
	
	
	/*电能检测*/
	@RequestMapping("/zhjk/sb/powercheck")
	public String powercheck(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/powercheck";
	}
	
	/*电能检测历史*/
	@RequestMapping("/zhjk/sb/powercheckhistory")
	public String powcheckhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/powercheckhistory";
	}
	/*电能检测健康*/
	@RequestMapping("/zhjk/sb/powercheckhealthy")
	public String powercheckhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/powercheckhealthy";
	}
	
	/*环境检测*/
	@RequestMapping("/zhjk/sb/environment")
	public String environment(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String pws_id = req.getParameter("pws_id");
		String app_typ_id = req.getParameter("app_typ_id");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("pws_id", pws_id);
		req.setAttribute("app_typ_id", app_typ_id);
		return "zhjk/sb/environment";
	}
	/*环境检测历史*/
	@RequestMapping("/zhjk/sb/environmenthistory")
	public String environmenthistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/environmenthistory";
	}
	/*环境检测健康*/
	@RequestMapping("/zhjk/sb/environmenthealthy")
	public String environmenthealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/environmenthealthy";
	}
	/*汇流箱*/
	@RequestMapping("/zhjk/sb/headerbox")
	public String headerbox(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/headerbox";
	}
	/*汇流箱历史*/
	@RequestMapping("/zhjk/sb/headerboxhistory")
	public String headerboxhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/headerboxhistory";
	}
	/*汇流箱健康*/
	@RequestMapping("/zhjk/sb/headerboxhealthy")
	public String headerboxhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/headerboxhealthy";
	}
	/*交流充电桩*/
	@RequestMapping("/zhjk/sb/dcz")
	public String dcz(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/dcz";
	}
	/*交流充电桩历史*/
	@RequestMapping("/zhjk/sb/dczhistory")
	public String dczhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/dczhistory";
	}
	/*交流充电桩健康*/
	@RequestMapping("/zhjk/sb/dczhealthy")
	public String dczhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/dczhealthy";
	}
	 
	/*直流充电桩*/
	@RequestMapping("/zhjk/sb/acz")
	public String acz(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/acz";
	}
	/*直流充电桩历史*/
	@RequestMapping("/zhjk/sb/aczhistory")
	public String aczhistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/aczhistory";
	}
	/*直流充电桩健康*/
	@RequestMapping("/zhjk/sb/aczhealthy")
	public String aczhealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/aczhealthy";
	}
	
	/*线路保护*/
	@RequestMapping("/zhjk/sb/protect")
	public String protect(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/protect";
	}
	/*线路保护历史*/
	@RequestMapping("/zhjk/sb/protecthistory")
	public String protecthistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/protecthistory";
	}
	/*线路保护健康*/
	@RequestMapping("/zhjk/sb/protecthealthy")
	public String protecthealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/protecthealthy";
	}
	/*解列*/
	@RequestMapping("/zhjk/sb/jielie")
	public String jielie(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/jielie";
	}
	
	/*解列历史*/
	@RequestMapping("/zhjk/sb/jieliehistory")
	public String jieliehistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/jieliehistory";
	}
	/*解列健康*/
	@RequestMapping("/zhjk/sb/jieliehealthy")
	public String jieliehealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/jieliehealthy";
	}
	
	/*交流配电柜*/
	@RequestMapping("/zhjk/sb/peidiangui")
	public String peidiangui(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/peidiangui";
	}
	
	/*交流配电柜历史*/
	@RequestMapping("/zhjk/sb/peidianguihistory")
	public String peidianguihistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/peidianguihistory";
	}
	/*交流配电柜健康*/
	@RequestMapping("/zhjk/sb/peidianguihealthy")
	public String peidianguihealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/peidianguihealthy";
	}
	
	/*直流配电柜*/
	@RequestMapping("/zhjk/sb/zlpeidiangui")
	public String zlpeidiangui(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/zlpeidiangui";
	}
	/*直流配电柜历史*/
	@RequestMapping("/zhjk/sb/zlpeidianguihistory")
	public String zlpeidianguihistory(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/zlpeidianguihistory";
	}
	/*直流配电柜健康*/
	@RequestMapping("/zhjk/sb/zlpeidianguihealthy")
	public String zlpeidianguihealthy(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/zlpeidianguihealthy";
	}
	/*微网*/
	@RequestMapping("/zhjk/sb/microgrid")
	public String microgrid(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/microgrid";
	}
	
	
	
	/*储能电池*/
	@RequestMapping("/zhjk/sb/sb-energy")
	public String sb_energy(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-energy";
	}
	/*电表*/
	@RequestMapping("/zhjk/sb/sb-enwatch")
	public String sb_enwatch(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-enwatch";
	}
	/*dc*/
	@RequestMapping("/zhjk/sb/sb-dc")
	public String sb_dc(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-dc";
	}
	 
	/*储能逆变器*/
	@RequestMapping("/zhjk/sb/sb-storage")
	public String sb_storage(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-storage";
	}
	/*变压器*/
	@RequestMapping("/zhjk/sb/sb-transformer")
	public String sb_transfotmer(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-transformer";
	}
	
	/*电能检测*/
	@RequestMapping("/zhjk/sb/sb-powercheck")
	public String sb_powercheck(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-powercheck";
	}
	
	/*环境检测*/
	@RequestMapping("/zhjk/sb/sb-environment")
	public String sb_environment(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-environment";
	}
	
	/*汇流箱*/
	@RequestMapping("/zhjk/sb/sb-headerbox")
	public String sb_headerbox(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-headerbox";
	}
	/*交流充电桩*/
	@RequestMapping("/zhjk/sb/sb-dcz")
	public String sb_dcz(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-dcz";
	}
	/*直流充电桩*/
	@RequestMapping("/zhjk/sb/sb-acz")
	public String sb_acz(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-acz";
	}
	/*线路保护*/
	@RequestMapping("/zhjk/sb/sb-protect")
	public String sb_protect(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-protect";
	}
	/*解列*/
	@RequestMapping("/zhjk/sb/sb-jielie")
	public String sb_jielie(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-jielie";
	}
	
	/*直流配电柜*/
	@RequestMapping("/zhjk/sb/sb-zlpeidiangui")
	public String sb_zlpeidiangui(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-zlpeidiangui";
	}
	
	
	/*交流配电柜*/
	@RequestMapping("/zhjk/sb/sb-peidiangui")
	public String sb_peidiangui(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-peidiangui";
	}
	
	/*控制器*/
	@RequestMapping("/zhjk/sb/sb-kzq")
	public String sb_kzq(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-kzq";
	}
	
	/*微网*/
	@RequestMapping("/zhjk/sb/sb-microgrid")
	public String sb_microgrid(HttpSession session,HttpServletRequest req) {
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-microgrid";
	}
	
	
	/*光伏逆变器*/
	@RequestMapping("/zhjk/sb/sb-gf")
	public String sb_gf(HttpSession session,HttpServletRequest req){
		String app_typ_id = req.getParameter("app_typ_id");
		String pws_id = req.getParameter("pws_id");
		String typ_ide = req.getParameter("typ_ide");
		req.setAttribute("app_typ_id",app_typ_id);
		req.setAttribute("pws_id",pws_id);
		req.setAttribute("typ_ide",typ_ide);
		
		String id = req.getParameter("id");
		String equNum = req.getParameter("equNum");
		String goJumpType = req.getParameter("goJumpType");
		req.setAttribute("id", id);
		req.setAttribute("equNum", equNum);
		req.setAttribute("goJumpType", goJumpType);
		return "zhjk/sb/sb-gf";
	}
	
	@RequestMapping("/text")
	public String text(HttpSession session,HttpServletRequest req){
		return "zhjk/sb/text";
	}
	@RequestMapping("/text2")
	public String text2(HttpSession session,HttpServletRequest req){
		IpUtil i = new IpUtil();
		String ip = i.getIpAddr(req);
		System.out.println("ip=="+ip);
		req.setAttribute("ipAdd", ip);
		return "zhjk/sb/text2";
	}
	@RequestMapping("/text3")
	public String text3(HttpSession session,HttpServletRequest req){
		IpUtil i = new IpUtil();
		String ip = i.getIpAddr(req);
		System.out.println("ip=="+ip);
		req.setAttribute("ipAdd", ip);
		return "zhjk/sb/text3";
	}
	
	/*********************************综合监控 end *********************************/
	/***********************************设备详情***********************************/
	@RequestMapping("/zhjk/sb/xq/jlcdz")
	public String jlcdz(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/jlcdz";
	}
	@RequestMapping("/zhjk/sb/xq/cndc")
	public String cndc(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/cndc";
	}

	@RequestMapping("/zhjk/sb/xq/hlx")
	public String hlx(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/hlx";
	}
	@RequestMapping("/zhjk/sb/xq/zlcdz")
	public String zlcdz(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/zlcdz";
	}
	@RequestMapping("/zhjk/sb/xq/jl")
	public String jl(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/jl";
	}
	@RequestMapping("/zhjk/sb/xq/dcdc")
	public String dcdc(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/dcdc";
	}
	@RequestMapping("/zhjk/sb/xq/hjjcy")
	public String hjjcy(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/hjjcy";
	}
	@RequestMapping("/zhjk/sb/xq/xlbh")
	public String xlbh(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/xlbh";
	}
	@RequestMapping("/zhjk/sb/xq/db")
	public String db(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/db";
	}
	@RequestMapping("/zhjk/sb/xq/byq")
	public String byq(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/byq";
	}
	@RequestMapping("/zhjk/sb/xq/gf")
	public String gf(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/gf";
	}
	@RequestMapping("/zhjk/sb/xq/dnzljc")
	public String dnzljc(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/dnzljc";
	}
	@RequestMapping("/zhjk/sb/xq/cnnbq")
	public String cnnbq(HttpSession session,HttpServletRequest req){
		String equNum=req.getParameter("equNum");
		req.setAttribute("equNum", equNum);
		return "zhjk/sb/xq/cnnbq";
	}
	
	
	/***********************************设备详情end ***********************************/
	/********************************* 统计分析 *********************************/
	
	//TODO
	
	/*电站对比分析 - 多电站统计对比分析*/
	@RequestMapping("/tjfx/dzdbfx/ddztjdbfx")
	public String tjfxdzdbfxddztjdbfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzdbfx/ddztjdbfx";
	}
	
	/*电站对比分析 - 电站故障率等对比分析*/
	@RequestMapping("/tjfx/dzdbfx/dzgzlddbfx")
	public String tjfxdzdbfxdzgzlddbfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzdbfx/dzgzlddbfx";
	}
	/*电站对比分析 - 电站排行*/
	@RequestMapping("/tjfx/dzdbfx/dzph")
	public String tjfxdzdbfxdzph(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzdbfx/dzph";
	}
	
	/*电站对比分析 - 计划发电量与实际发电量*/
	@RequestMapping("/tjfx/dzdbfx/jhfdlysjfdl")
	public String tjfxdzdbfxjhfdlysjfdl(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzdbfx/jhfdlysjfdl";
	}
	
	/*电站对比分析 - 计划充放电量与实际充放电量*/
	@RequestMapping("/tjfx/dzdbfx/jhcfdlysjcfdl")
	public String tjfxdzdbfxjhcfdlysjcfdl(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzdbfx/jhcfdlysjcfdl";
	}
	
	/*电站对比分析 - 储能收益*/
	@RequestMapping("/tjfx/dzdbfx/cnsy")
	public String tjfxdzdbfxcnsy(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzdbfx/cnsy";
	}
	
	/*电站分析 - 综合分析*/
	@RequestMapping("/tjfx/dzfx/zhfx")
	public String tjfxdzfxzhfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzfx/zhfx";
	}
	
	/*电站分析 - 电站分析 */
	@RequestMapping("/tjfx/dzfx/dzfx")
	public String tjfxdzfxdzfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzfx/dzfx";
	}
	
	/*电站分析 - 电量与收益分析 */
	@RequestMapping("/tjfx/dzfx/dlysyfx")
	public String tjfxdzfxdlysyfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzfx/dlysyfx";
	}
	
	/*电站分析 - 能耗分析 */
	@RequestMapping("/tjfx/dzfx/nhfx")
	public String tjfxdzfxnhfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzfx/nhfx";
	}
	
	/*电站分析 - 太阳能分析 */
	@RequestMapping("/tjfx/dzfx/tynfx")
	public String tjfxdzfxtynfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzfx/tynfx";
	}
	/*电站统计分析*/
	@RequestMapping("/tjfx/dzfx/dztjfx")
	public String tjfxdzfxdztjfx(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzfx/dztjfx";
	}
	
	
	/********************************* 报表管理 *********************************/
	
	
	/*发电量报表*/
	@RequestMapping("/tjfx/dzbb/fdlbb")
	public String tjfxdzbbfdlbb(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/fdlbb";
	}	
	
	/*充放电报表*/
	@RequestMapping("/tjfx/dzbb/cfdbb")
	public String tjfxdzbbcfdbb(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/cfdbb";
	}
	
	/*充电量报表*/
	@RequestMapping("/tjfx/dzbb/cdlbb")
	public String tjfxdzbbcdlbb(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/cdlbb";
	}
	
	
	/*光伏逆变器*/
	@RequestMapping("/tjfx/dzbb/gfnbq")
	public String tjfxdzbbgfnbq(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/gfnbq";
	}	
	
	/*储能逆变器*/
	@RequestMapping("/tjfx/dzbb/cnnbq")
	public String tjfxdzbbcnnbq(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/cnnbq";
	}
	
	/*充电桩*/
	@RequestMapping("/tjfx/dzbb/cdz")
	public String tjfxdzbbcdz(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/cdz";
	}
	
	
	/*电表报表*/
	@RequestMapping("/tjfx/dzbb/dbbb")
	public String dbbb(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/dbbb";
	}
	/*采集数据*/
	@RequestMapping("/tjfx/dzbb/cjsj")
	public String cjsj(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/cjsj";
	}
	
	/*告警数据*/
	@RequestMapping("/tjfx/dzbb/gjsj")
	public String gjsj(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/gjsj";
	}
	/*年报报表*/
	@RequestMapping("/tjfx/dzbb/yxnb")
	public String nybb(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/yxnb";
	}
	/*月报报表*/
	@RequestMapping("/tjfx/dzbb/yxyb")
	public String yybb(HttpSession session,HttpServletRequest req) {
		
		return "tjfx/dzbb/yxyb";
	}
	
	/********************************* 报表管理 end *********************************/	
	
	
	/*********************************统计分析 end *********************************/
	
	/********************************* 考核管理 *********************************/
	
	@RequestMapping("/khgl/khgl")
	public String khgl(HttpSession session,HttpServletRequest req) {
		
		return "khgl/khgl";
	}
	
	
	
	
	
	
	
	
	
	
	/*********************************考核管理 end *********************************/
	
	
	/********************************* 日常办公  *********************************/
	/*文档管理*/
	@RequestMapping("/rcbg/wdgl/list")
	public String rcbgwdgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "rcbg/wdgl/list";
	}
	/*添加类型*/
	@RequestMapping("/rcbg/wdgl/addType")
	public String addwdgllist(HttpSession session,HttpServletRequest req) {
		
		return "rcbg/wdgl/addType";
	}
	/*文档上传*/
	@RequestMapping("/rcbg/wdgl/add")
	public String add(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/wdgl/add";
	}
	
	/*修改文档类型*/
	@RequestMapping("/rcbg/wdgl/editType")
	public String editType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/wdgl/editType";
	}
	/*员工管理*/
	@RequestMapping("/rcbg/yggl/list")
	public String rcbgyggllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "rcbg/yggl/list";
	}
	@RequestMapping("/rcbg/yggl/Z")
	public String rcbgygglZ(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/Z";
	}@RequestMapping("/rcbg/yggl/GJ")
	public String rcbgygglGJ(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/GJ";
	}
	
	@RequestMapping("/rcbg/yggl/add")
	public String rcbgyggladd(HttpSession session,HttpServletRequest req) {
		String type = req.getParameter("type");
		req.setAttribute("type", type);
		return "rcbg/yggl/add";
	}
	
	@RequestMapping("/rcbg/yggl/edit")
	public String rcbgyggledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/edit";
	}
	
	@RequestMapping("/rcbg/yggl/detal")
	public String rcbgyggldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/detal";
	}
	
	@RequestMapping("/rcbg/yggl/zp")
	public String rcbgygglzp(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/zp";
	}
	
	@RequestMapping("/rcbg/yggl/editGx")
	public String rcbgyggleditGx(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/editGx";
	}
	
	@RequestMapping("/rcbg/yggl/addlogo")
	public String rcbgyggladdlogo(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/addlogo";
	}
	/*运维人员分数修改*/
	@RequestMapping("/rcbg/yggl/ywfsxg")
	public String rcbgygglywfsxg(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yggl/ywfsxg";
	}
	
	/*客户管理*/
	@RequestMapping("/rcbg/khgl/list")
	public String rcbgkhgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "rcbg/khgl/list";
	}
	
	
	@RequestMapping("/rcbg/khgl/add")
	public String rcbgkhgladd(HttpSession session,HttpServletRequest req) {
		
		return "rcbg/khgl/add";
	}
	
	@RequestMapping("/rcbg/khgl/edit")
	public String rcbgkhgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/khgl/edit";
	}
	 
	@RequestMapping("/rcbg/khgl/detal")
	public String rcbgkhgldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/khgl/detal";
	}

	@RequestMapping("/rcbg/khgl/editGx")
	public String rcbgkhgleditGx(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/khgl/editGx";
	}
	/*客户通讯录*/
	@RequestMapping("/rcbg/khtxl/list")
	public String rcbgkhtxllist(HttpSession session,HttpServletRequest req) {
		
		return "rcbg/khtxl/list";
	}
	/*员工通讯录*/
	@RequestMapping("/rcbg/ygtxl/list")
	public String rcbgygtxllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "rcbg/ygtxl/list";
	}
	/*意见反馈*/
	@RequestMapping("/rcbg/yjfk/list")
	public String rcbgyjfkllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "rcbg/yjfk/list";
	}
	/*意见反馈-添加*/
	@RequestMapping("/rcbg/yjfk/add")
	public String rcbgyjfkladd(HttpSession session,HttpServletRequest req) {
		
		return "rcbg/yjfk/add";
	}
	/*意见反馈-回复*/
	@RequestMapping("/rcbg/yjfk/huifu")
	public String rcbgyjfklhuifu(HttpSession session,HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		return "rcbg/yjfk/huifu";
	}
	
	
	
	
	
	
	
	
	
	
	
	/********************************* 日常办公  end *********************************/
	
	
	/********************************* 运维管理  *********************************/
	
	//TODO
	/*巡视管理*/
	/* 列表   */
	@RequestMapping("/ywgl/xsgl/list")
	public String ywglxsgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "ywgl/xsgl/list";
	}
	
	/* 新增   */
	@RequestMapping("/ywgl/xsgl/add")
	public String ywglxsgladd(HttpSession session,HttpServletRequest req) {
		
		return "ywgl/xsgl/add";
	}
	
	/* 修改   */
	@RequestMapping("/ywgl/xsgl/edit")
	public String ywglxsgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/xsgl/edit";
	}
	
	/* 开始执行   */
	@RequestMapping("/ywgl/xsgl/excute")
	public String ywglxsglexcute(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		return "ywgl/xsgl/excute";
	}
	
	/* 查看   */
	@RequestMapping("/ywgl/xsgl/excuteQuery")
	public String ywglxsglexcuteQuery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		String treId=req.getParameter("treId");
		req.setAttribute("treId", treId);
		return "ywgl/xsgl/excuteQuery";
	}
	/* 查看其他   */
	@RequestMapping("/ywgl/xsgl/excuteQueryOther")
	public String excuteQueryOther(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		String treId=req.getParameter("treId");
		req.setAttribute("treId", treId);
		return "ywgl/xsgl/excuteQueryOther";
	}
	
	/* 修改   */
	@RequestMapping("/ywgl/xsgl/editRoute")
	public String ywglxsgledit2(HttpSession session,HttpServletRequest req) {
		 
		String task_id = req.getParameter("task_id");
		String routeId=req.getParameter("routeId");

		req.setAttribute("task_id", task_id);
		req.setAttribute("routeId", routeId);
		return "ywgl/xsgl/editRoute";
	}
	/* 查看   */
	@RequestMapping("/ywgl/xsgl/queryRoute")
	public String ywglxsglqueryRoute(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String pws_id = req.getParameter("pws_id");
		String task_id = req.getParameter("task_id");
		String treId=req.getParameter("treId");
		req.setAttribute("id", id);
		req.setAttribute("pws_id", pws_id);
		req.setAttribute("task_id", task_id);
		req.setAttribute("treId", treId);
		
		return "ywgl/xsgl/queryRoute";
	}
	
	/* 审核   */
	@RequestMapping("/ywgl/xsgl/shenhe")
	public String ywglxsglshenhe(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/xsgl/shenhe";
	}
	
	/* 指派   */
	@RequestMapping("/ywgl/xsgl/appoint")
	public String ywglxsglappoint(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/xsgl/appoint";
	}
	
	
	/*检修管理*/
	/* 列表   */
	@RequestMapping("/ywgl/jxgl/list")
	public String ywgljxgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "ywgl/jxgl/list";
	}
	
	/* 新增   */
	@RequestMapping("/ywgl/jxgl/add")
	public String ywgljxgladd(HttpSession session,HttpServletRequest req) {
		
		return "ywgl/jxgl/add";
	}
	
	/* 修改   */
	@RequestMapping("/ywgl/jxgl/edit")
	public String ywgljxgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/jxgl/edit";
	}
	
	/* 开始执行   */
	@RequestMapping("/ywgl/jxgl/excute")
	public String ywgljxglexcute(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		return "ywgl/jxgl/excute";
	}
	
	/* 查看   */
	@RequestMapping("/ywgl/jxgl/excuteQuery")
	public String ywgljxglexcuteQuery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		String oreId=req.getParameter("oreId");
		req.setAttribute("oreId", oreId);
		return "ywgl/jxgl/excuteQuery";
	}

	/* 查看其他   */
	@RequestMapping("/ywgl/jxgl/excuteQueryOther")
	public String ywgljxglexcuteQueryOther(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		String oreId=req.getParameter("oreId");
		req.setAttribute("oreId", oreId);
		return "ywgl/jxgl/excuteQueryOther";
	}
	
	
	/* 修改   */
	@RequestMapping("/ywgl/jxgl/editRoute")
	public String ywgljxgledit2(HttpSession session,HttpServletRequest req) {
		String task_id = req.getParameter("task_id");
		String routeId=req.getParameter("routeId");

		req.setAttribute("task_id", task_id);
		req.setAttribute("routeId", routeId);
		return "ywgl/jxgl/editRoute";
	}
	/* 查看   */
	@RequestMapping("/ywgl/jxgl/queryRoute")
	public String ywgljxglqueryRoute(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String task_id = req.getParameter("task_id");
		String oreId=req.getParameter("oreId");
		
		req.setAttribute("id", id);
		req.setAttribute("task_id",task_id);
		req.setAttribute("oreId",oreId);

		return "ywgl/jxgl/queryRoute";
	}
	
	/* 审核   */
	@RequestMapping("/ywgl/jxgl/shenhe")
	public String ywgljxglshenhe(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/jxgl/shenhe";
	}
	
	/* 指派   */
	@RequestMapping("/ywgl/jxgl/appoint")
	public String ywgljxglappoint(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/jxgl/appoint";
	}
	
	/*报修管理*/
	/* 列表   */
	@RequestMapping("/ywgl/bxgl/list")
	public String ywglbxgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "ywgl/bxgl/list";
	}
	
	/* 新增   */
	@RequestMapping("/ywgl/bxgl/add")
	public String ywglbxgladd(HttpSession session,HttpServletRequest req) {
		
		return "ywgl/bxgl/add";
	}
	
	/* 修改   */
	@RequestMapping("/ywgl/bxgl/edit")
	public String ywglbxgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/bxgl/edit";
	}
	
	/* 开始执行   */
	@RequestMapping("/ywgl/bxgl/excute")
	public String ywglbxglexcute(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		return "ywgl/bxgl/excute";
	}
	
	/* 查看   */
	@RequestMapping("/ywgl/bxgl/excuteQuery")
	public String ywglbxglexcuteQuery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		return "ywgl/bxgl/excuteQuery";
	}
	
	/* 查看其他  */
	@RequestMapping("/ywgl/bxgl/excuteQueryOther")
	public String ywglbxglexcuteQueryOther(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String routeId = req.getParameter("routeId");
		req.setAttribute("routeId", routeId);
		return "ywgl/bxgl/excuteQueryOther";
	}
	
	
	/* 修改   */
	@RequestMapping("/ywgl/bxgl/editRoute")
	public String ywglbxgledit2(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String pws_id = req.getParameter("pws_id");
		String task_id = req.getParameter("task_id");
		req.setAttribute("id", id);
		req.setAttribute("pws_id", pws_id);
		req.setAttribute("task_id", task_id);
		return "ywgl/bxgl/editRoute";
	}
	/* 查看   */
	@RequestMapping("/ywgl/bxgl/queryRoute")
	public String ywglbxglqueryRoute(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String pws_id = req.getParameter("pws_id");
		String task_id = req.getParameter("task_id");
		req.setAttribute("id", id);
		req.setAttribute("pws_id", pws_id);
		req.setAttribute("task_id", task_id);
		return "ywgl/bxgl/queryRoute";
	}
	
	/* 审核   */
	@RequestMapping("/ywgl/bxgl/shenhe")
	public String ywglbxglshenhe(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/bxgl/shenhe";
	}
	
	
	/*报废管理*/
	/* 列表   */
	@RequestMapping("/ywgl/bfgl/list")
	public String ywglbfgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "ywgl/bfgl/list";
	}
	
	/* 新增   */
	@RequestMapping("/ywgl/bfgl/add")
	public String ywglbfgladd(HttpSession session,HttpServletRequest req) {
		
		return "ywgl/bfgl/add";
	}
	
	/* 修改   */
	@RequestMapping("/ywgl/bfgl/edit")
	public String ywglbfgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/bfgl/edit";
	}
	
	
	/*  查看详情   */
	@RequestMapping("/ywgl/bfgl/query")
	public String ywglbfglquery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/bfgl/query";
	}
	
	/*  审核   */
	@RequestMapping("/ywgl/bfgl/shenhe")
	public String ywglbfglshenhe(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/bfgl/shenhe";
	}
	/*  审核   */
	@RequestMapping("/ywgl/bfgl/shenhe2")
	public String ywglbfglshenhe2(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/bfgl/shenhe2";
	}
	
	/*路线规划*/
	@RequestMapping("/ywgl/lxgh/list")
	public String ywgllxghlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "ywgl/lxgh/list";
	}
	 
	@RequestMapping("/ywgl/lxgh/add")
	public String ywgllxghadd(HttpSession session,HttpServletRequest req) {
		
		return "ywgl/lxgh/add";
	}
	
	@RequestMapping("/ywgl/lxgh/edit")
	public String ywgllxghedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		req.setAttribute("id", id);
		req.setAttribute("type", type);
		return "ywgl/lxgh/edit";
	}
	
	@RequestMapping("/ywgl/lxgh/query")
	public String ywgllxghquery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String type = req.getParameter("type");
		req.setAttribute("id", id);
		req.setAttribute("type", type);
		return "ywgl/lxgh/query";
	}
	/*培训管理*/
	/* 列表   */
	@RequestMapping("/ywgl/pxgl/list")
	public String ywglpxgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "ywgl/pxgl/list";
	}
	/*培训管理添加信息*/
	@RequestMapping("/ywgl/pxgl/add")
	public String ywglpxgladd(HttpSession session,HttpServletRequest req) {
		
		return "ywgl/pxgl/add";
	}
	/*培训管理修改信息*/
	@RequestMapping("/ywgl/pxgl/edit")
	public String ywgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "ywgl/pxgl/edit";
	}
	/********************************* 运维管理  end *********************************/
	
	
	/********************************* 资产管理  *********************************/
	/*物资管理*/
	@RequestMapping("/zcgl/wzgl/list")
	public String zcglwzgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zcgl/wzgl/list";
	}
	/*物资管理添加*/
	@RequestMapping("/zcgl/wzgl/add")
	public String zcglwzgladd(HttpSession session,HttpServletRequest req) {
		
		return "zcgl/wzgl/add";
	}
	
	/*物资管理修改*/
	@RequestMapping("/zcgl/wzgl/edit")
	public String zcglwzgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "zcgl/wzgl/edit";
	}
	 
	/*新增物资管理类型*/
	@RequestMapping("/zcgl/wzgl/addType")
	public String zcglwzgladdType(HttpSession session,HttpServletRequest req) {
		
		return "zcgl/wzgl/addType";
	}
	/*修改物资管理类型*/
	@RequestMapping("/zcgl/wzgl/editType")
	public String zcglwzgleditType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "zcgl/wzgl/editType";
	}
	/*缺陷管理*/
	@RequestMapping("/zcgl/qxgl/list")
	public String zcglqxgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zcgl/qxgl/list";
	} 
	/*缺陷管理新增*/
	@RequestMapping("/zcgl/qxgl/add")
	public String zcglqxgladd(HttpSession session,HttpServletRequest req) {

		return "zcgl/qxgl/add";
	} 

	/*缺陷管理修改*/
	@RequestMapping("/zcgl/qxgl/edit")
	public String zcglqxgledit(HttpSession session,HttpServletRequest req) {
		String def_num=req.getParameter("def_num");
		req.setAttribute("def_num", def_num);
		return "zcgl/qxgl/edit";
	} 
	
	/*缺陷管理查看*/
	@RequestMapping("/zcgl/qxgl/query")
	public String zcglqxglquery(HttpSession session,HttpServletRequest req) {
		String def_num=req.getParameter("def_num");
		req.setAttribute("def_num", def_num);
		return "zcgl/qxgl/query";
	}  
	
	/*缺陷管理上传文件*/
	@RequestMapping("/zcgl/qxgl/file")
	public String zcglqxglfile(HttpSession session,HttpServletRequest req) {
		String def_num=req.getParameter("def_num");
		req.setAttribute("def_num", def_num);
		return "zcgl/qxgl/file";
	}  
	/*缺陷管理新增*/
	@RequestMapping("/zcgl/qxgl/addType")
	public String zcglqxgladdType(HttpSession session,HttpServletRequest req) {
		
		return "zcgl/qxgl/addType";
	} 
	
	/*缺陷管理修改*/
	@RequestMapping("/zcgl/qxgl/editType")
	public String zcglqxgleditType(HttpSession session,HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		return "zcgl/qxgl/editType";
	} 
	
	/*物资台账*/
	@RequestMapping("/zcgl/wztz/list")
	public String zcglwztzlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zcgl/wztz/list";
	}  
 
	/*物资台账添加类型*/
	@RequestMapping("/zcgl/wztz/addType")
	public String zcglwztzaddType(HttpSession session,HttpServletRequest req) {
		return "zcgl/wztz/addType";
	}  
	/*物资台账修改类型*/
	@RequestMapping("/zcgl/wztz/editType")
	public String zcglwztzeditType(HttpSession session,HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		return "zcgl/wztz/editType";
	}  
	/*物资入库*/
	@RequestMapping("/zcgl/wzrk/list")
	public String zcglwzrklist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zcgl/wzrk/list";
	}  
	/*物资入库 入库*/
	@RequestMapping("/zcgl/wzrk/inbround")
	public String zcglwzrkinbround(HttpSession session,HttpServletRequest req) {
		String ass_num=req.getParameter("ass_num");
		req.setAttribute("ass_num", ass_num);
		String typ_id=req.getParameter("typ_id");
		req.setAttribute("typ_id", typ_id);
		return "zcgl/wzrk/inbround";
	}  
	/*物资入库 出库*/
	@RequestMapping("/zcgl/wzrk/outbround")
	public String zcglwzrkoutbround(HttpSession session,HttpServletRequest req) {
		String ass_num=req.getParameter("ass_num");
		req.setAttribute("ass_num", ass_num);
		String typ_id=req.getParameter("typ_id");
		req.setAttribute("typ_id", typ_id);
		return "zcgl/wzrk/outbround";
	}  
	/*物资入库 添加*/
	@RequestMapping("/zcgl/wzrk/add")
	public String zcglwzrkadd(HttpSession session,HttpServletRequest req) {
		return "zcgl/wzrk/add";
	} 
	/*物资入库 修改*/
	@RequestMapping("/zcgl/wzrk/edit")
	public String zcglwzrkedit(HttpSession session,HttpServletRequest req) {
		String ass_num=req.getParameter("ass_num");
		req.setAttribute("ass_num", ass_num);
		return "zcgl/wzrk/edit";
	} 
	/*物资入库 详细*/
	@RequestMapping("/zcgl/wzrk/detal")
	public String zcglwzrkdetal(HttpSession session,HttpServletRequest req) {
		String ass_num=req.getParameter("ass_num");
		req.setAttribute("ass_num", ass_num);
		return "zcgl/wzrk/detal";
	} 
	/*出入库*/
	@RequestMapping("/zcgl/crkxd/list")
	public String zcglcrkxdlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zcgl/crkxd/list";
	} 
	/*出入库 查看*/
	@RequestMapping("/zcgl/crkxd/query")
	public String zcglcrkxdquery(HttpSession session,HttpServletRequest req) {
		String ord_num=req.getParameter("ord_num");
		req.setAttribute("ord_num",ord_num);
		return "zcgl/crkxd/query";
	} 
	/*物资告警*/
	@RequestMapping("/zcgl/wzgj/list")
	public String zcglwzgjlist(HttpSession session,HttpServletRequest req){
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zcgl/wzgj/list";
	}
	/*物资告警 设置*/
	@RequestMapping("/zcgl/wzgj/query")
	public String zcglwzgjquery(HttpSession session,HttpServletRequest req){
		String ass_num=req.getParameter("ass_num");
		req.setAttribute("ass_num", ass_num);
		return "zcgl/wzgj/query";
	}
	/********************************* 资产管理  end *********************************/
	
	
	/********************************* 安全管理  *********************************/
	
	@RequestMapping("/aqgl/list")
	public String aqgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "aqgl/list";
	}
	/*添加类型*/
	@RequestMapping("/aqgl/addType")
	public String addType(HttpSession session,HttpServletRequest req) {
		return "aqgl/addType";
	}
	/*修改类型*/
	@RequestMapping("/aqgl/editType")
	public String eidtType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "aqgl/editType";
	}
	/*修改*/
	@RequestMapping("/aqgl/edit")
	public String eidt(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "aqgl/edit";
	}
	/*添加*/
	@RequestMapping("/aqgl/add")
	public String aqgladd(HttpSession session,HttpServletRequest req) {
		String type = req.getParameter("type");
		req.setAttribute("type", type);
		return "aqgl/add";
	}
	/*查看*/
	@RequestMapping("/aqgl/query")
	public String query(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "aqgl/query";
	}
	/*上传*/
	@RequestMapping("/aqgl/editFile")
	public String aqgleditFile(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "aqgl/editFile";
	}
	
	
	/********************************* 安全管理  end *********************************/
	
	

	
	
	/*********************************系统配置 *********************************/
	
	/*电站配置*/
	@RequestMapping("/xtgl/dzpz/list")
	public String xtgldzpzlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		
		return "xtgl/dzpz/list";
	}
	@RequestMapping("/xtgl/dzpz/addlogo")
	public String xtgldzpzaddlogo(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/dzpz/addlogo";
	}
	@RequestMapping("/xtgl/dzpz/add")
	public String xtgldzpzadd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/dzpz/add";
	}
	
	@RequestMapping("/xtgl/dzpz/edit")
	public String xtgldzpzedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/dzpz/edit";
	}
	@RequestMapping("/xtgl/dzpz/detal")
	public String xtgldzpzdetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/dzpz/detal";
	}
	/*通讯设备管理*/
	@RequestMapping("/xtgl/txsbwh/list")
	public String xtgltxsbwhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/txsbwh/list";
	}
	
	@RequestMapping("/xtgl/txsbwh/add")
	public String xtgltxsbwhadd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/txsbwh/add";
	}
	
	@RequestMapping("/xtgl/txsbwh/edit")
	public String xtgltxsbwhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/txsbwh/edit";
	}
	@RequestMapping("/xtgl/txsbwh/detal")
	public String xtgltxsbwhdetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/txsbwh/detal";
	}
	
	/*基础设备管理*/
	@RequestMapping("/xtgl/jcsbwh/list")
	public String xtgljcsbwhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/jcsbwh/list";
	}
	
	@RequestMapping("/xtgl/jcsbwh/add")
	public String xtgljcsbwhadd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/jcsbwh/add";
	}
	
	@RequestMapping("/xtgl/jcsbwh/edit")
	public String xtgltjcsbwhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/jcsbwh/edit";
	}
	
	@RequestMapping("/xtgl/jcsbwh/detal")
	public String xtgltjcsbwhdetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/jcsbwh/detal";
	}
	
	/*业主管理*/
	@RequestMapping("/xtgl/yzgl/list")
	public String xtglyzgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/yzgl/list";
	}
	
	@RequestMapping("/xtgl/yzgl/add")
	public String xtglyzgladd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String level = req.getParameter("level");
		req.setAttribute("level", level);
		return "xtgl/yzgl/add";
	}
	
	@RequestMapping("/xtgl/yzgl/edit")
	public String xtglyzgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/yzgl/edit";
	}
	
	@RequestMapping("/xtgl/yzgl/detal")
	public String xtglyzgldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/yzgl/detal";
	}
	
	@RequestMapping("/xtgl/yzgl/addlogo")
	public String xtglyzgladdlogo(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/yzgl/addlogo";
	}
	/*合作伙伴管理管理*/
	@RequestMapping("/xtgl/hzhbgl/list")
	public String xtglhzhbgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/hzhbgl/list";
	}
	
	@RequestMapping("/xtgl/hzhbgl/add")
	public String xtglhzhbgladd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String level = req.getParameter("level");
		req.setAttribute("level", level);
		return "xtgl/hzhbgl/add";
	}
	
	@RequestMapping("/xtgl/hzhbgl/edit")
	public String xtglhzhbgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/hzhbgl/edit";
	}
	
	@RequestMapping("/xtgl/hzhbgl/detal")
	public String xtglhzhbgldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/hzhbgl/detal";
	}
	
	@RequestMapping("/xtgl/hzhbgl/addlogo")
	public String xtglhzhbgladdlogo(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/hzhbgl/addlogo";
	}
	/*组织机构管理*/
	@RequestMapping("/xtgl/zzjggl/list")
	public String xtglzzjggllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/zzjggl/list";
	}
	
	@RequestMapping("/xtgl/zzjggl/add")
	public String xtglzzjggladd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String level = req.getParameter("level");
		req.setAttribute("level", level);
		return "xtgl/zzjggl/add";
	}
	
	@RequestMapping("/xtgl/zzjggl/edit")
	public String xtglzzjggledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/zzjggl/edit";
	}
	
	@RequestMapping("/xtgl/zzjggl/detal")
	public String xtglzzjggldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/zzjggl/detal";
	}
	
	@RequestMapping("/xtgl/zzjggl/addDep")
	public String xtglzzjggladdDep(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/zzjggl/addDep";
	}
	
	@RequestMapping("/xtgl/zzjggl/editDep")
	public String xtglzzjggleditDep(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String com_id = req.getParameter("com_id");
		req.setAttribute("id", id);
		req.setAttribute("com_id", com_id);
		return "xtgl/zzjggl/editDep";
	}
	@RequestMapping("/xtgl/zzjggl/addlogo")
	public String xtglzzjggladdlogo(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/zzjggl/addlogo";
	}
	
	/*角色管理*/
	@RequestMapping("/xtgl/jsgl/list")
	public String xtgljsgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/jsgl/list";
	}
	
	@RequestMapping("/xtgl/jsgl/add")
	public String xtgljsgladd(HttpSession session,HttpServletRequest req) {
		
		return "xtgl/jsgl/add";
	}
	
	@RequestMapping("/xtgl/jsgl/edit")
	public String xtgljsgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/jsgl/edit";
	}
	
	@RequestMapping("/xtgl/jsgl/editApp")
	public String xtgljsgleditapp(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/jsgl/editApp";
	}
	@RequestMapping("/xtgl/jsgl/editOne")
	public String xtgljsgleditOne(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/jsgl/editOne";
	}
	@RequestMapping("/xtgl/jsgl/editBut")
	public String xtgljsgleditBut(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		String rol_id = req.getParameter("rol_id");
		req.setAttribute("rol_id", rol_id);
		req.setAttribute("id", id);
		return "xtgl/jsgl/editBut";
	}
	
	/*告警码*/
	@RequestMapping("/xtgl/gjmwh/list")
	public String xtglgjmlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/gjmwh/list";
	}
	/*告警添加*/
	@RequestMapping("/xtgl/gjmwh/add")
	public String xtglgjmadd(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id",id);
		String app_typ_id=req.getParameter("app_typ_id");
		req.setAttribute("app_typ_id",app_typ_id);
		return "xtgl/gjmwh/add";
	}
	/*告警类型添加*/
	@RequestMapping("/xtgl/gjmwh/addType")
	public String xtglgjmaddtype(HttpSession session,HttpServletRequest req) {
		String app_typ_id=req.getParameter("app_typ_id");
		req.setAttribute("app_typ_id",app_typ_id);
		return "xtgl/gjmwh/addType";
	}
	/*告警类型修改*/
	@RequestMapping("/xtgl/gjmwh/editType")
	public String xtglgjmedittype(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/gjmwh/editType";
	}
	/*告警修改*/
	@RequestMapping("/xtgl/gjmwh/edit")
	public String xtglgjmedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/gjmwh/edit";
	}
	/*厂家信息*/
	@RequestMapping("/xtgl/sbsccjgl/list")
	public String xtglsbsccjgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/sbsccjgl/list";
	}
	/*厂家类型添加*/
	@RequestMapping("/xtgl/sbsccjgl/addType")
	public String xtglsbsccjgladdType(HttpSession session,HttpServletRequest req) {
		return "xtgl/sbsccjgl/addType";
	}
	/*厂家类型修改*/
	@RequestMapping("/xtgl/sbsccjgl/editType")
	public String sbsccjgleidtType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbsccjgl/editType";
	}
	/*厂家信息修改*/
	@RequestMapping("/xtgl/sbsccjgl/edit")
	public String sbsccjgleidt(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbsccjgl/edit";
	}
	
	/*厂家信息详细*/
	@RequestMapping("/xtgl/sbsccjgl/detal")
	public String sbsccjgldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbsccjgl/detal";
	}
	/*添加厂家信息*/
	@RequestMapping("/xtgl/sbsccjgl/add")
	public String sbsccjgladd(HttpSession session,HttpServletRequest req) {
		
		return "xtgl/sbsccjgl/add";
	}
	
	/*设备型号管理*/
	@RequestMapping("/xtgl/sbxhgl/list")
	public String downsbxhgllist(HttpSession session,HttpServletRequest req) {
		
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbxhgl/list";
	}

	@RequestMapping("/xtgl/sbxhgl/add")
	public String downsbxhgladd(HttpSession session,HttpServletRequest req) {
		String app_typ=req.getParameter("app_typ");
		req.setAttribute("app_typ",app_typ);
		return "xtgl/sbxhgl/add";
	}
	
	
	@RequestMapping("/xtgl/sbxhgl/edit")
	public String downsbxhgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbxhgl/edit";
	}
	
	@RequestMapping("/xtgl/sbxhgl/detal")
	public String downsbxhgldetal(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbxhgl/detal";
	}
	
	@RequestMapping("/xtgl/sbxhgl/addType")
	public String downsbxhgladdType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbxhgl/addType";
	}
	
	@RequestMapping("/xtgl/sbxhgl/editType")
	public String downsbxhgleditType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sbxhgl/editType";
	}
	/*数据字典管理*/
	@RequestMapping("xtgl/sjzdgl/list")
	public String sjzdgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sjzdgl/list";
	}
	
	@RequestMapping("xtgl/sjzdgl/add")
	public String sjzdgladd(HttpSession session,HttpServletRequest req) {
		return "xtgl/sjzdgl/add";
	}
	
	@RequestMapping("xtgl/sjzdgl/edit")
	public String sjzdgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sjzdgl/edit";
	}
	
	@RequestMapping("xtgl/sjzdgl/addType")
	public String sjzdaddtype(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sjzdgl/addType";
	}
	
	@RequestMapping("xtgl/sjzdgl/editType")
	public String sjzdeditType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "xtgl/sjzdgl/editType";
	}
	
	/*地区管理*/
	@RequestMapping("xtgl/dqxxgl/list")
	public String xtgldqgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/dqxxgl/list";
	}
	
	@RequestMapping("xtgl/dqxxgl/edit")
	public String xtgldqxxgledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);	
		return "xtgl/dqxxgl/edit";
	}
	
	@RequestMapping("xtgl/dqxxgl/add")
	public String xtgldqxxgladd(HttpSession session,HttpServletRequest req) {
		String reg_ide = req.getParameter("reg_ide");
		String tim = req.getParameter("tim");
		req.setAttribute("reg_ide", reg_ide);	
		req.setAttribute("time", tim);	
		return "xtgl/dqxxgl/add";
	}
	
	
	/*公告管理*/
	@RequestMapping("xtgl/gggl/list")
	public String xtglgggllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/gggl/list";
	}
	
	@RequestMapping("xtgl/gggl/add")
	public String xtglgggladd(HttpSession session,HttpServletRequest req) {
		return "xtgl/gggl/add";
	}
	
	@RequestMapping("xtgl/gggl/edit")
	public String xtglgggledit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);	
		return "xtgl/gggl/edit";
	}
	
	/*日志管理*/
	@RequestMapping("xtgl/rzgl/list")
	public String xtglrzgllist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "xtgl/rzgl/list";
	}
	/*********************************系统配置  end *********************************/
	
	
	/*********************************知识库 *********************************/
	
	@RequestMapping("/zsk/list")
	public String zsklist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "zsk/list";
	}

	@RequestMapping("/zsk/add")
	public String zskadd(HttpSession session,HttpServletRequest req) {
		String type=req.getParameter("type");
		req.setAttribute("type",type);
		return "zsk/add";
	}
	
	
	@RequestMapping("/zsk/edit")
	public String zskedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "zsk/edit";
	}
	
	/*查询知识库下的文档*/
	@RequestMapping("/zsk/query")
	public String zskquery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "zsk/query";
	}
	/*新增知识库类型*/
	@RequestMapping("/zsk/addType")
	public String zskaddType(HttpSession session,HttpServletRequest req) {
		
		return "zsk/addType";
	}
	/*修改知识库类型*/
	@RequestMapping("/zsk/editType")
	public String zskeditType(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "zsk/editType";
	}
	
	/*修改知识库类型*/
	@RequestMapping("/zsk/editFile")
	public String zskeditFile(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "zsk/editFile";
	}
	
	
	/*********************************知识库 end *********************************/
	/*********************************计划管理  *********************************/

	/*物资采购*/
	@RequestMapping("/jhgl/xsjh/list")
	public String jhglxsjhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/xsjh/list";
	}
	
	 
	@RequestMapping("/jhgl/xsjh/edit")
	public String jhglxsjhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/xsjh/edit";
	}
	@RequestMapping("/jhgl/xsjh/add")
	public String jhglxsjhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/xsjh/add";
	}
	
	@RequestMapping("/jhgl/jxjh/list")
	public String jhgljxjhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/jxjh/list";
	}
	 
	@RequestMapping("/jhgl/jxjh/edit")
	public String jhgljxjhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/jxjh/edit";
	}
	@RequestMapping("/jhgl/jxjh/add")
	public String jhgljxjhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/jxjh/add";
	}
	
	/*物资采购*/
	@RequestMapping("/jhgl/wzcgjh/list")
	public String wzcgjhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/wzcgjh/list";
	}
	/*物资采购查看*/
	@RequestMapping("/jhgl/wzcgjh/query")
	public String wzcgjhquery(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/wzcgjh/query";
	}
	/*物资采购修改*/
	@RequestMapping("/jhgl/wzcgjh/edit")
	public String wzcgjhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/wzcgjh/edit";
	}
	/*物资采购添加*/
	@RequestMapping("/jhgl/wzcgjh/add")
	public String wzcgjhadd(HttpSession session,HttpServletRequest req) {
		String type = req.getParameter("type");
		req.setAttribute("type", type);
		return "jhgl/wzcgjh/add";
	}
	/*物资采购上传 */
	@RequestMapping("/jhgl/wzcgjh/addfile")
	public String wzcgjhaddfile(HttpSession session,HttpServletRequest req) {
		String plan_num = req.getParameter("plan_num");
		req.setAttribute("plan_num", plan_num);
		return "jhgl/wzcgjh/addfile";
	}
	
	/*理论放电量计划*/
	@RequestMapping("/jhgl/kyfdljh/list")
	public String kyfdljhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/kyfdljh/list";
	}
	/*理论发电量计划 添加信息*/
	@RequestMapping("/jhgl/kyfdljh/add")
	public String kyfdljhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/kyfdljh/add";
	}
	/*理论发电量 修改信息*/
	@RequestMapping("/jhgl/kyfdljh/edit")
	public String kyfdljhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/kyfdljh/edit";
	}
	/*理论辐射量计划*/
	@RequestMapping("/jhgl/kyfsljh/list")
	public String kyfsljhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/kyfsljh/list";
	}
	/*理论辐射量计划 添加信息*/
	@RequestMapping("/jhgl/kyfsljh/add")
	public String kyfsljhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/kyfsljh/add";
	}
	/*理论辐射量 修改信息*/
	@RequestMapping("/jhgl/kyfsljh/edit")
	public String kyfsljhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/kyfsljh/edit";
	}
	/*培训计划*/
	@RequestMapping("/jhgl/pxjh/list")
	public String pxjhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		String type = req.getParameter("type");
		req.setAttribute("type", type);
		return "jhgl/pxjh/list";
	}
	/*培训计划添加类型*/
	@RequestMapping("/jhgl/pxjh/addType")
	public String pxjhaddType(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/pxjh/addType";
	}
	/*培训计划修改类型*/
	@RequestMapping("/jhgl/pxjh/editType")
	public String pxjheditType(HttpSession session,HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/pxjh/editType";
	}
	/*培训计划添加信息*/
	@RequestMapping("/jhgl/pxjh/add")
	public String pxjhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/pxjh/add";
	}
	/*培训计划修改信息*/
	@RequestMapping("/jhgl/pxjh/edit")
	public String pxjhedit(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/pxjh/edit";
	}
	/*培训计划查看*/
	@RequestMapping("/jhgl/pxjh/query")
	public String pxjhquery(HttpSession session,HttpServletRequest req) {
		String tra_num=req.getParameter("tra_num");
		req.setAttribute("tra_num", tra_num);
		return "jhgl/pxjh/query";
	}
	/*培训计划上传*/
	@RequestMapping("/jhgl/pxjh/file")
	public String pxjhfile(HttpSession session,HttpServletRequest req) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		String tra_num=req.getParameter("tra_num");
		req.setAttribute("tra_num", tra_num);
		return "jhgl/pxjh/file";
	}
	
	/*发电量 计划*/
	@RequestMapping("/jhgl/fdljh/list")
	public String fdljhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/fdljh/list";
	}
	
	/*发电量 添加*/
	@RequestMapping("/jhgl/fdljh/add")
	public String fdljhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/fdljh/add";
	}
	/*发电量 修改*/
	@RequestMapping("/jhgl/fdljh/edit")
	public String fdljhedit(HttpSession session,HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/fdljh/edit";
	}
	
	/*充放电量 计划*/
	@RequestMapping("/jhgl/cfdljh/list")
	public String cfdljhlist(HttpSession session,HttpServletRequest req) {
		String menu_id = req.getParameter("menu_id");
		String is_button = req.getParameter("is_button");
		
		req.setAttribute("menu_id", menu_id);
		req.setAttribute("is_button", is_button);
		return "jhgl/cfdljh/list";
	}
	
	/*充放电量 添加*/
	@RequestMapping("/jhgl/cfdljh/add")
	public String cfdljhadd(HttpSession session,HttpServletRequest req) {
		
		return "jhgl/cfdljh/add";
	}
	/*充放电量 修改*/
	@RequestMapping("/jhgl/cfdljh/edit")
	public String cfdljhedit(HttpSession session,HttpServletRequest req) {
		String id=req.getParameter("id");
		req.setAttribute("id", id);
		return "jhgl/cfdljh/edit";
	}
	/*********************************计划管理 end *********************************/
	
	//天气
	@RequestMapping("/weather")
	@ResponseBody
	public  JSONObject weather(HttpSession session,HttpServletRequest req) throws Exception{
		//参数url化
		String city=req.getParameter("city");
		
		city = java.net.URLEncoder.encode(city, "utf-8");
		
		//拼地址
		String apiUrl = String.format("http://api.map.baidu.com/telematics/v3/weather?location=%s&output=json&ak=spS1jTrhDurkl3nOFkx5YcgMMfXbWalP",city);
		//开始请求
		URL url= new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		//这里转换为String，带上包名，怕你们引错包
		String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		//输出
		System.out.println(result);
		
		JSONObject obj = JSONObject.fromObject(result);
		
		return obj;
	}
}
