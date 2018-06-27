package com.qinergy.dao.base;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qinergy.util.DbUtil;

public class CharInfo_dao {
	
		/**
		 * 查询数据
		 * */
//		public  ResultSet getList(Connection con) {
//			ResultSet rs=null;
//			StringBuffer sql = new StringBuffer("select * from dat_cha_inf where 1=1 ");		
//			PreparedStatement pst;
//			try {
//				pst = con.prepareStatement(sql.toString());
//				rs= pst.executeQuery();
//				while (rs.next()){
//					System.out.println(rs.getString("zhuangId"));
//				}
//			} catch (Exception e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			return rs;
//		}
		
		/**
		 * 使用UseId获取预约中的记录(该状态记录，有且只有一条)
		 * @throws Exception 
		 * */
		public static List<Map<String, Object>> getInOrdRecByUseId(Map<String,Object> map) throws Exception {
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
			ResultSet rs=state.executeQuery("select dor.id,dor.chp_id from dat_ord dor where dor.use_id = "+map.get("use_id")+" and dor.ord_sta = 1");
			
			aaa.closeCon(aaa.getCon());
			
			return convertList(rs);
		}
		
		/**
		 * 使用chp_num(桩编号)获取充电桩状态信息(从cha_app_ser表中获取)
		 * @throws Exception 
		 * */
		public static List<Map<String, Object>> getChpStaByChpNum(Map<String,Object> map) throws Exception {
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=state.executeQuery("select bcp.cha_pil_sta from bas_cha_pil bcp where bcp.cha_num = '"+map.get("cha_num")+"'");
			
			aaa.closeCon(aaa.getCon());
			
			return convertList(rs);
		}
		
		/**
		 * 使用公司识别码获取app端公司id(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static List<Map<String, Object>> getComIdByComIde(Map<String,Object> map) throws Exception {
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=state.executeQuery("select bc.id from bas_com bc where bc.com_ide = '"+map.get("com_ide")+"'");
			
			aaa.closeCon(aaa.getCon());
			
			return convertList(rs);
		}
		
		/**
		 * 使用区域名称与区域级别获取区域ID
		 * @throws Exception 
		 * */
		public static List<Map<String, Object>> getRegIdByRegNamLev(Map<String,Object> map) throws Exception {
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=state.executeQuery("select br.id from bas_reg br where br.reg_nam = '"+map.get("reg_nam").toString() + "' and br.reg_lev = "+map.get("reg_lev").toString());
			
			aaa.closeCon(aaa.getCon());
			
			return convertList(rs);
		}
		
		/**
		 * 使用充电站编号获取app端充电站id(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static List<Map<String, Object>> getChpStaByChsNum(Map<String,Object> map) throws Exception {
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=state.executeQuery("select bcs.id from bas_cha_sta bcs where bcs.chs_num = '"+map.get("chs_num")+"'");
			
			aaa.closeCon(aaa.getCon());
			
			return convertList(rs);
		}
		
		/**
		 * 使用chp_num(桩编号)更新充电桩状态信息(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static int updateChpStaByChpNum(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("update bas_cha_pil set cha_pil_sta = "+map.get("cha_pil_sta")+" where cha_num = '"+map.get("cha_num")+"'");
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 
		
		/**
		 * 使用chs_num(充电站编号)更新充电站信息(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static int updateChsByChsNum(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("update bas_cha_pil set "
					+" chs_nam='"+map.get("chs_nam") 
					+"',chs_typ="+map.get("chs_typ") 
					+",ope_typ="+map.get("ope_typ") 
					+",cur_sta="+map.get("cur_sta") 
					+",chs_com_equ="+map.get("chs_com_equ") 
					+",dev_add_num="+map.get("dev_add_num") 
					+",pro_id=" +map.get("pro_id") 
					+",cit_id="+map.get("cit_id") 
					+",are_id="+map.get("are_id") 
					+",con_nam='"+map.get("con_nam") 
					+"',con_mob='"+map.get("con_mob") 
					+"',ope_tim="+map.get("ope_tim") 
					+",are_cov="+map.get("are_cov") 
					+",chs_add='"+map.get("chs_add") 
					+"',chs_lon="+map.get("chs_lon") 
					+",chs_lat="+map.get("chs_lat") 
					+",pic_id="+map.get("pic_id") 
					+",rem='"+map.get("rem") 
					+"',com_id="+map.get("com_id") 
					+",chs_sor="+map.get("chs_sor")
					+"where chs_num = '"+map.get("chs_num")+"'");
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 
		
		/**
		 * 使用chs_num(充电站编号)更新充电站信息(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static int updateChpByChpNum(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("update bas_cha_pil set "
					+"chp_nam='"+map.get("chp_nam") 
					+"',man_id="+map.get("man_id") 
					+",chp_mod_id="+map.get("chp_mod_id") 
					+",chs_id="+map.get("chs_id") 
					+",chp_com_equ="+map.get("chp_com_equ") 
					+",dev_add_num="+map.get("dev_add_num")
					+",con_num='"+map.get("con_num") 
					+"',ass_num='"+map.get("ass_num") 
					+"',ins_add='"+map.get("ins_add") 
					+"',chp_lon="+map.get("chp_lon") 
					+",chp_lat="+map.get("chp_lat") 
					+",pro_tim="+map.get("pro_tim") 
					+",ope_tim="+map.get("ope_tim") 
					+",per_res="+map.get("per_res") 
					+",rem='"+map.get("rem") 
					+"',cha_inf="+map.get("cha_inf") 
					+",spe_cha="+map.get("spe_cha") 
					+",cha_net="+map.get("cha_net") 
					+",cha_pil_sta="+map.get("cha_pil_sta") 
					+",cha_ip="+map.get("cha_ip") 
					+",cha_por="+map.get("cha_por") 
					+",chp_sor="+map.get("chp_sor") 
					+",cur_sta="+map.get("cur_sta") 
					+"where cha_num = '"+map.get("cha_num"));
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 
		
		/**
		 * 使用chp_num(站编号)更新充电站信息(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static int insertChsStaByChsNum(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("insert into bas_cha_sta "+
			"(chs_nam,chs_typ,ope_typ,cur_sta,chs_com_equ,dev_add_num,pro_id,cit_id,are_id,con_nam,"+
			"con_mob,ope_tim,are_cov,chs_add,chs_lon,chs_lat,pic_id,rem,com_id,chs_sor) VALUES ('"+
			map.get("chs_nam")+"',"+
			map.get("chs_typ")+","+
			map.get("ope_typ")+","+
			map.get("cur_sta")+","+
			map.get("chs_com_equ")+","+
			map.get("dev_add_num")+","+
			map.get("pro_id")+","+
			map.get("cit_id")+","+
			map.get("are_id")+",'"+
			map.get("con_nam")+"','"+
			map.get("con_mob")+"',"+
			map.get("ope_tim")+","+
			map.get("are_cov")+",'"+
			map.get("chs_add")+"',"+
			map.get("chs_lon")+","+
			map.get("chs_lat")+","+
			map.get("pic_id")+",'"+
			map.get("rem")+"',"+
			map.get("com_id")+","+
			map.get("chs_sor")+")");
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 
		/**
		 * 使用chp_num(桩编号)更新充电桩状态信息(从cha_app_ser数据库中获取)
		 * @throws Exception 
		 * */
		public static int insertChpStaByChpNum(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("insert into bas_cha_pil (chp_nam,man_id,chp_mod_id,chs_id,"+
					"chp_com_equ,dev_add_num,con_num,ass_num,ins_add,chp_lon,chp_lat,pro_tim,"+
					"ope_tim,per_res,rem,cha_inf,spe_cha,cha_net,cha_pil_sta,cha_num,"+
					"cha_ip,cha_por,chp_sor,cur_sta,fau_sta) VALUES ('"+
					map.get("chp_nam")+"',"+
					map.get("man_id")+","+
					map.get("chp_mod_id")+","+
					map.get("chs_id")+","+
					map.get("cha_pil_sta")+","+
					map.get("chp_com_equ")+","+
					map.get("dev_add_num")+",'"+
					map.get("con_num")+"','"+
					map.get("ass_num")+"','"+
					map.get("ins_add")+"',"+
					map.get("chp_lon")+","+
					map.get("chp_lat")+","+
					map.get("pro_tim")+","+
					map.get("ope_tim")+","+
					map.get("per_res")+",'"+
					map.get("rem")+"',"+
					map.get("cha_inf")+","+
					map.get("spe_cha")+","+
					map.get("cha_net")+","+
					map.get("cha_pil_sta")+",'"+
					map.get("cha_num")+"',"+
					map.get("cha_ip")+","+
					map.get("cha_por")+","+
					map.get("chp_sor")+","+
					map.get("cur_sta")+","+
					map.get("fau_sta")+")");
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 
		
		/**
		 * 获取充电站所属公司的运营平台的IP、端口号、分成比例
		 * @throws Exception 
		 * */
		public static List<Map<String, Object>> getOpeConInf(Map<String,Object> map) throws Exception {
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=state.executeQuery("select bc.com_ip,bc.com_por,bc.spl_rat,bcp.cha_num from bas_cha_sta bcs,bas_com bc,bas_cha_pil bcp where bcs.com_id = bc.id and bcs.id = bcp.chs_id and bcp.id = "+map.get("chp_id"));
			
			aaa.closeCon(aaa.getCon());
			
			return convertList(rs);
		}
		
		private static List<Map<String, Object>> convertList(ResultSet rs) throws SQLException {
			
	        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	        
	        ResultSetMetaData md = rs.getMetaData();
	        
	        int columnCount = md.getColumnCount();
	        
	        while (rs.next()) {
	        	
	            Map<String, Object> rowData = new HashMap<String, Object>();
	            
	            for (int i = 1; i <= columnCount; i++) {
	            	
	                rowData.put(md.getColumnName(i), rs.getObject(i));
	            }
	            
	            list.add(rowData);
	        }
	        
	        return list;
		}
		
		/**
		 * 添加数据
		 * @throws Exception 
		 * */
//		public int addCharInfo(Connection con,CharInfo charInfo) throws SQLException{
//			String sql="insert into dat_cha_inf values(?,?,?,?,?,?,?,?,?,?," +
//					"?,?,?,?,?,?,?,?,?,?," +"?)";
//			PreparedStatement pst = con.prepareStatement(sql);		
//			pst.setInt(1, charInfo.getId());
//			pst.setString(2, charInfo.getZhuangId());
//			pst.setInt(3, charInfo.getGunType());
//			pst.setInt(4, charInfo.getGun());
//			pst.setString(5, charInfo.getCard());
//			pst.setString(6, charInfo.getStartTim());
//			pst.setString(7, charInfo.getEndTim());
//			pst.setInt(8, charInfo.getTimeLen());
//			pst.setString(9, charInfo.getStartSOC());
//			pst.setString(10, charInfo.getEndSOC());
//			pst.setInt(11, charInfo.getReason());
//			pst.setDouble(12, charInfo.getElecQua());
//			pst.setDouble(13, charInfo.getStaRead());
//			pst.setDouble(14, charInfo.getEndRead());
//			pst.setDouble(15, charInfo.getMoney());
//			pst.setDouble(16, charInfo.getStaMoney());
//			pst.setInt(17, charInfo.getCharStra());
//			pst.setInt(18, charInfo.getCharStraPara());
//			pst.setString(19, charInfo.getCarVIN());
//			for(int i=0;i<48;i++){
//				pst.setDouble(20, charInfo.getElecTim()[i]);			
//			}
//			pst.setInt(21, charInfo.getStaMod());
//			return pst.executeUpdate();
//		}
		
		public static int updateChaPilSta(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("update bas_cha_pil set cha_pil_sta = "+map.get("cha_pil_sta")+" where id = "+map.get("chp_id"));
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 
		
		public static int updOrdSta(Map<String,Object> map) throws Exception{ 
			
			DbUtil aaa=new DbUtil();
			
			Statement state=aaa.getCon().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			int flag=state.executeUpdate("update dat_ord set ord_sta = "+map.get("ord_sta")+" where use_id = "+map.get("use_id")+" and ord_sta = 1");
			
			aaa.closeCon(aaa.getCon());
			
			return flag; 	
		} 


}
