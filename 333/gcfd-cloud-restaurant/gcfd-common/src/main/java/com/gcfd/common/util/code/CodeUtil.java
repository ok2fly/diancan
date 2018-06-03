package com.gcfd.common.util.code;

import com.gcfd.common.Constant;
import com.gcfd.common.util.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @类名：CodeUtil.java
* @作者：one
* @时间：2016年6月21日 下午11:27:31
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class CodeUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeUtil.class);
	/**
	 * Constant.SYS_LOGIN_USERNAME 可以替换成个性化的名称
	 */
	public static String annotate = "/**"+ Constant.NEW_LINE 
									+ " * @类名：#1.java" + Constant.NEW_LINE
									+ " * @作者："+ Constant.SYS_LOGIN_USERNAME + Constant.NEW_LINE
									+ " * @时间 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ Constant.NEW_LINE
									+ " * @版权："+ Constant.SYS_LOGIN_USERNAME + Constant.NEW_LINE
									+ " * @version  1.0" + Constant.NEW_LINE
									+ " * @描述："+ Constant.NEW_LINE
									+ "*/"+ Constant.NEW_LINE ;
	
	
	@SuppressWarnings("deprecation")
	public static void makeJavaCode(String tableName,String entityName){
		Connection conn = null;
		String urlFrist = System.getProperty("user.dir").concat("/src");
		FileWriter filew = null;
		File file = null;
		try{
			conn = ConnectionUtil.getConnectionXml();
			CodeBase cb = new CodeBase();
			//CodeEntity ce = new CodeEntity("login_log","LoginLog");
			CodeEntity ce = new CodeEntity(tableName,entityName);
			String dao = ce.getDaoUrl();
			dao = urlFrist.concat("/").concat(dao.replaceAll("\\.", "/").concat("/").concat(ce.getEntityName()).concat("Dao.java"));
			String mapper = ce.getMapperUrl();
			mapper = urlFrist.concat("/").concat(mapper.replaceAll("\\.", "/").concat("/").concat(ce.getEntityName()).concat("Mapper.xml"));
			String entity = ce.getEntityUrl();
			entity = urlFrist.concat("/").concat(entity.replaceAll("\\.", "/").concat("/").concat(ce.getEntityName()).concat("Entity.java"));
			String impl = ce.getImplUrl();
			impl = urlFrist.concat("/").concat(impl.replaceAll("\\.", "/").concat("/").concat(ce.getEntityName()).concat("Impl.java"));
			String server = ce.getServerrUrl();
			server = urlFrist.concat("/").concat(server.replaceAll("\\.", "/").concat("/").concat(ce.getEntityName()).concat("Server.java"));
			
			try{
				file = new File(entity);
				if(!file.isFile()){
					filew = new FileWriter(file);
					filew.write(cb.getEntity(ce, conn));
					filew.flush();
					filew.close();
				}else{
					logger.debug("---------------   entity 存在 不允许覆盖编辑 ！------------------");
				}
			}catch(Exception e){e.printStackTrace();}
			try{
				file = new File(dao);
				if(!file.isFile()){
					filew = new FileWriter(file);
					filew.write(cb.getDao(ce));
					filew.flush();
					filew.close();
				}else{
					logger.debug("---------------   dao 存在 不允许覆盖编辑 ！------------------");
				}
			}catch(Exception e){e.printStackTrace();}
			try{
				file = new File(mapper);
				if(!file.isFile()){
					filew = new FileWriter(file);
					filew.write(cb.getMapper(ce,conn));
					filew.flush();
					filew.close();
				}else{
					logger.debug("---------------   mapper 存在 不允许覆盖编辑 ！------------------");
				}
			}catch(Exception e){e.printStackTrace();}
			try{
				file = new File(impl);
				if(!file.isFile()){
					filew = new FileWriter(file);
					filew.write(cb.getImpl(ce));
					filew.flush();
					filew.close();
				}else{
					logger.debug("---------------  impl 存在 不允许覆盖编辑 ！------------------");
				}
			}catch(Exception e){e.printStackTrace();}
			try{
				file = new File(server);
				if(!file.isFile()){
					filew = new FileWriter(file);
					filew.write(cb.getServer(ce));
					filew.flush();
					filew.close();
				}else{
					logger.debug("---------------   rest server 存在 不允许覆盖编辑 ！------------------");
				}
			}catch(Exception e){e.printStackTrace();}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			ConnectionUtil.closeConnection(conn);
		}
	}
	
	/**
	 * 生产代码
	 * @param args
	 */
	/*public static void main(String[] args) {
		makeJavaCode("interface_center","InterfaceCenter");
	}*/
}
