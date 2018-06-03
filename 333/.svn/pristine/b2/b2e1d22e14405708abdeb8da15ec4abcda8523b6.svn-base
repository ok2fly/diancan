package com.gcfd.common.util.code;

import com.gcfd.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
* @类名：CodeMapper.java
* @作者：one
* @时间：2016年6月21日 下午9:41:37
* @版权：pengkaione@icloud.com
* @描述： 
*/
public class CodeBase {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeBase.class);
	
	private String sqlEntity = " SELECT "+
							    " (CASE WHEN t.`DATA_TYPE` IN ('int','bigint','varchar','char') THEN 'String '  "+
							    " WHEN t.`DATA_TYPE` IN ('float','double') THEN 'BigDecimal '  "+
							    " WHEN t.`DATA_TYPE` IN ('datetime') THEN 'Date ' ELSE t.`DATA_TYPE` END) AS javatype, "+
							    " t.`COLUMN_NAME` AS cname, "+
							    " CONCAT('//',t.`COLUMN_COMMENT`) AS comen "+
							 " FROM information_schema.`COLUMNS` t WHERE t.`TABLE_NAME`=? "; 
	
	private String sqlMapper = " SELECT t.`COLUMN_NAME` as  msql FROM information_schema.`COLUMNS` t WHERE t.`TABLE_NAME`= ?";
	
	private StringBuffer javaFile= null;
	
	/**
	 * 生产 rest server 路由
	 * @param codeEntity
	 * @return
	 */
	public String getServer(CodeEntity codeEntity){
		javaFile= new StringBuffer();
		String name = codeEntity.getEntityName();
		String nameObject = name.substring(0, 1).toLowerCase().concat(name.substring(1,name.length()));
		javaFile.append("package ".concat(codeEntity.getServerrUrl()).concat(";").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		//javaFile.append("import java.util.ArrayList;".concat(Constant.NEW_LINE));
		javaFile.append("import java.util.List;".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("import javax.ws.rs.Consumes;".concat(Constant.NEW_LINE));
		//javaFile.append("import javax.ws.rs.FormParam;".concat(Constant.NEW_LINE));
		javaFile.append("import javax.ws.rs.POST;".concat(Constant.NEW_LINE));
		javaFile.append("import javax.ws.rs.Path;".concat(Constant.NEW_LINE));
		javaFile.append("import javax.ws.rs.Produces;".concat(Constant.NEW_LINE));
		javaFile.append("import javax.ws.rs.core.MediaType;".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("import org.slf4j.Logger;".concat(Constant.NEW_LINE));
		javaFile.append("import org.slf4j.LoggerFactory;".concat(Constant.NEW_LINE));
		javaFile.append("import org.springframework.beans.factory.annotation.Autowired;".concat(Constant.NEW_LINE));
		javaFile.append("import org.springframework.stereotype.Component;".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("import com.sys.systemModule.DataCenter;".concat(Constant.NEW_LINE));
		//javaFile.append("import com.one.comm.EnumNetCode;".concat(Constant.NEW_LINE));
		//添加引入实体
		//javaFile.append(Constant.NEW_LINE.concat("import com.one.util.SpringContextUtil;").concat(Constant.NEW_LINE));
		javaFile.append(Constant.NEW_LINE.concat("import com.sys.systemModule.baseMybatis.BaseMybatis;").concat(Constant.NEW_LINE));
		javaFile.append("import ".concat(codeEntity.getImplUrl().concat(".")).concat(codeEntity.getEntityName()).concat("Impl;").concat(Constant.NEW_LINE)); 
		javaFile.append("import ".concat(codeEntity.getEntityUrl()).concat(".").concat(name).concat("Entity;").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append(CodeUtil.annotate.replace("#1", name.concat("Server.java")).concat(Constant.NEW_LINE));
		javaFile.append("@Component".concat(Constant.NEW_LINE));
		javaFile.append("@Path(\"".concat(name).concat("\")").concat(Constant.NEW_LINE));
		javaFile.append("@Produces(MediaType.APPLICATION_JSON+\";charset=utf-8\")".concat(Constant.NEW_LINE));
		javaFile.append("@Consumes(MediaType.APPLICATION_JSON+\";charset=utf-8\")".concat(Constant.NEW_LINE));
		javaFile.append("public class ".concat(name).concat("Server").concat("{").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		
		javaFile.append("\t@Autowired".concat(Constant.NEW_LINE));
		javaFile.append("\tprivate ".concat(name).concat("Impl ").concat(nameObject).concat("Impl;").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("\t@Autowired".concat(Constant.NEW_LINE));
		javaFile.append("\tprivate BaseMybatis baseMybatis;".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		
		javaFile.append("\tprivate static final Logger logger = LoggerFactory.getLogger(".concat(name).concat("Server.class").concat(");").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		
//		//查询单个对象
//		javaFile.append("\t@POST".concat(Constant.NEW_LINE));
//		javaFile.append("\t@Path(\"".concat("query").concat(name).concat("\")").concat(Constant.NEW_LINE));
//		javaFile.append("\tpublic DataCenter<".concat(name).concat("Entity> ").concat("query").concat(name).concat("(){").concat(Constant.NEW_LINE));
//		javaFile.append("\t\tDataCenter<".concat(name).concat("Entity> netData = new DataCenter<").concat(name).concat("Entity>();//实例化统一网络包 ").concat(Constant.NEW_LINE));
//		
//		javaFile.append("\t\t".concat(name).concat("Entity ").concat(nameObject).concat("Entity = ").concat(nameObject).concat("Impl.get").concat(name).concat("(id);").concat(Constant.NEW_LINE));
//		javaFile.append("\t\tnetData.setData(".concat(nameObject).concat("Entity);").concat(Constant.NEW_LINE));
//		javaFile.append("\t\tlogger.debug(\"------------- 【{}】 server 请求成功！--------------\",\"query".concat(name).concat("\");").concat(Constant.NEW_LINE));
//		javaFile.append("\t\treturn netData;".concat(Constant.NEW_LINE).concat("\t}").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		//查询List
		javaFile.append("\t@POST".concat(Constant.NEW_LINE));
		javaFile.append("\t@Path(\"".concat("queryList").concat(name).concat("\")").concat(Constant.NEW_LINE));
		
		javaFile.append("\tpublic DataCenter<Object> ".concat("query").concat(name).concat("(DataCenter<".concat(name).concat("Entity> dataCenter){")).concat(Constant.NEW_LINE));
		javaFile.append("\t\t DataCenter<Object> netData = new DataCenter<Object>();//实例化统一网络包 ".concat(Constant.NEW_LINE));
		javaFile.append("\t\t// int i  = baseMybatis.insertEntity(testEntity); //插入例子".concat(Constant.NEW_LINE));
		javaFile.append("\t\t// int y  = baseMybatis.updateEntity(testEntity, testEntity); // 更新例子".concat(Constant.NEW_LINE));
		javaFile.append("\t\t// netData.setOData(baseMybatis.getEntityNoCache(netData.getData())); // 直查询例子，不取缓存".concat(Constant.NEW_LINE));
		javaFile.append("\t\t netData.setOData(baseMybatis.getEntity(netData.getData())); // 查询例子，默认取缓存".concat(Constant.NEW_LINE));
		//javaFile.append("\t\tList<".concat(name).concat("Entity> ").concat(nameObject).concat("Entity = ").concat(nameObject).concat("Impl.getList").concat(name).concat("(dataCenter);").concat(Constant.NEW_LINE));
		//javaFile.append("\t\tnetData.setRowCount(".concat(nameObject).concat("Impl").concat(".getCount(dataCenter.getData()));").concat(Constant.NEW_LINE));
		//javaFile.append("\t\tnetData.setData(".concat(nameObject).concat("Entity);").concat(Constant.NEW_LINE)); 
		javaFile.append("\t\tlogger.debug(\"------------- 【{}】 server 请求成功！--------------\",\"queryList".concat(name).concat("\");").concat(Constant.NEW_LINE));
		//List<SysUserEntity> listEntity = baseMybatis.getEntityNoCache(dataCenter.getData());
		javaFile.append("\t\treturn netData;".concat(Constant.NEW_LINE).concat("\t}").concat(Constant.NEW_LINE));
		javaFile.append("}");
		
		//更新 引入事务
		
		
		logger.debug("---------------生产  rest server 成功！------------------");
		return javaFile.toString();
	}
	
	/**
	 * 生产 Impl
	 * @param codeEntity
	 * @return
	 */
	public String getImpl(CodeEntity codeEntity){
		javaFile= new StringBuffer();
		String name = codeEntity.getEntityName();
		String nameObject = name.substring(0, 1).toLowerCase().concat(name.substring(1,name.length()));
		javaFile.append("package ".concat(codeEntity.getImplUrl()).concat(";").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("import java.util.List;".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("import org.springframework.beans.factory.annotation.Autowired;".concat(Constant.NEW_LINE));
		javaFile.append("import org.springframework.stereotype.Service;".concat(Constant.NEW_LINE));
		javaFile.append("import ".concat(codeEntity.getDaoUrl().concat(".").concat(name).concat("Dao;")).concat(Constant.NEW_LINE));
		javaFile.append("import com.sys.systemModule.DataCenter;".concat(Constant.NEW_LINE));
		javaFile.append("import ".concat(codeEntity.getEntityUrl().concat(".").concat(name).concat("Entity;")).concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append(CodeUtil.annotate.replace("#1", name.concat("Impl.java")).concat(Constant.NEW_LINE));
		javaFile.append("@Service ".concat(Constant.NEW_LINE).concat("public class ").concat(name).concat("Impl implements ").concat(name).concat("Dao{").concat(Constant.NEW_LINE));
		javaFile.append("\t@Autowired".concat(Constant.NEW_LINE).concat("\tprivate ").concat(name).concat("Dao ").concat(nameObject).concat("Dao;").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		
		javaFile.append("\t@Override".concat(Constant.NEW_LINE).concat("\tpublic ").concat(name).concat("Entity ").concat("get").concat(name).concat("(String id){").concat(Constant.NEW_LINE));
		javaFile.append("\t\treturn ".concat(nameObject).concat("Dao.get").concat(name).concat("(id);").concat(Constant.NEW_LINE));
		javaFile.append("\t}".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		
//		javaFile.append("\t@Override".concat(Constant.NEW_LINE).concat("\tpublic List<").concat(name).concat("Entity> ").concat("getList").concat(name).concat("(DataCenter<".concat(name).concat("Entity>").concat(" dataCenter){")).concat(Constant.NEW_LINE));
//		javaFile.append("\t\treturn ".concat(nameObject).concat("Dao.getList").concat(name).concat("(dataCenter);").concat(Constant.NEW_LINE));
//		javaFile.append("\t}".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		
//		javaFile.append("\t@Override".concat(Constant.NEW_LINE).concat("\tpublic Integer getCount(".concat(name).concat("Entity ").concat(nameObject)).concat("Entity){").concat(Constant.NEW_LINE));
//		javaFile.append("\t\treturn ".concat(nameObject).concat("Dao.getCount(".concat(nameObject).concat("Entity);").concat(Constant.NEW_LINE)));
//		javaFile.append("\t}".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		
//		javaFile.append("\t@Override".concat(Constant.NEW_LINE).concat("\tpublic Integer update".concat(name).concat("(").concat(name).concat("Entity ").concat(nameObject).concat("Entity){").concat(Constant.NEW_LINE)));
//		javaFile.append("\t\treturn ".concat(nameObject).concat("Dao.update").concat(name).concat("(").concat(nameObject).concat("Entity);").concat(Constant.NEW_LINE));
//		javaFile.append("\t}".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		
//		javaFile.append("\t@Override".concat(Constant.NEW_LINE).concat("\tpublic Integer insert".concat(name).concat("(").concat(name).concat("Entity ").concat(nameObject).concat("Entity){").concat(Constant.NEW_LINE)));
//		javaFile.append("\t\treturn ".concat(nameObject).concat("Dao.insert").concat(name).concat("(").concat(nameObject).concat("Entity);").concat(Constant.NEW_LINE));
//		javaFile.append("\t}".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		
		javaFile.append("}");
		
		logger.debug("---------------生产  Impl 成功！------------------");
		return javaFile.toString();
	}
	
	
	/**
	 * 生产 mapper
	 * @param codeEntity
	 * @return
	 */
	public String getMapper(CodeEntity codeEntity,Connection conn) throws Exception{
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		javaFile= new StringBuffer();
		String name = codeEntity.getEntityName();
		StringBuffer sqlC = new StringBuffer("  ");
		StringBuffer ifelseData = new StringBuffer("  \t<if test=\"data!=null\">".concat(Constant.NEW_LINE));
		StringBuffer ifelse = new StringBuffer("  ");
		StringBuffer insrtinto = new StringBuffer("");
		StringBuffer insrtValue = new StringBuffer("");
		StringBuffer updates = new StringBuffer("");
		preparedStatement = conn.prepareStatement(sqlMapper);
		preparedStatement.setString(1, codeEntity.getTableName());
		rs = preparedStatement.executeQuery();
		String msql = null;
		while (rs.next()) {
			msql = rs.getString("msql");
			sqlC.append("t.".concat(msql).concat(","));
			ifelseData.append("\t\t<if test=\"data.".concat(msql).concat("!=null and data.").concat(msql).concat("!=''\">  and t.").concat(msql).concat("=${data.").concat(msql).concat("} </if>").concat(Constant.NEW_LINE));
			ifelse.append("\t\t<if test=\"".concat(msql).concat("!=null and ").concat(msql).concat("!=''\">  and t.").concat(msql).concat("=${").concat(msql).concat("} </if>").concat(Constant.NEW_LINE));
			insrtinto.append(msql.concat(","));
			insrtValue.append("${".concat(msql).concat("},"));
			updates.append(msql.concat("=").concat("${").concat(msql).concat("},").concat(Constant.NEW_LINE).concat("\t\t\t"));
		}
		ifelseData.append("\t</if>".concat(Constant.NEW_LINE));
		sqlC.delete(sqlC.length()-1, sqlC.length());
		sqlC.append(Constant.NEW_LINE);
		insrtinto.delete(insrtinto.length()-1, insrtinto.length());//清理最后一个逗号
		insrtValue.delete(insrtValue.length()-1, insrtValue.length());//清理最后一个逗号
		updates.delete(insrtValue.length()-1, insrtValue.length());//清理最后一个逗号
		//开始拼接xml
		javaFile.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".concat(Constant.NEW_LINE));
		javaFile.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">".concat(Constant.NEW_LINE));
		javaFile.append("<mapper namespace=\"".concat(codeEntity.getDaoUrl()).concat(".").concat(name).concat("Dao").concat("\">").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("\t<!-- mybatis 启用自定义二级缓存机制    useCache=\"false\" 就能屏蔽缓存-->".concat(Constant.NEW_LINE));
		javaFile.append("\t<cache type=\"com.sys.systemModule.RedisCache\">".concat(Constant.NEW_LINE));
		javaFile.append("\t\t<!-- <property name=\"timeOut\" value=\"60\"/> 参数秒，系统有默认参数-->".concat(Constant.NEW_LINE));
		javaFile.append("\t\t<!-- <property name=\"permanent\" value=\"false\"/>参数是否永久有效，默认为系统参数-->".concat(Constant.NEW_LINE));
		javaFile.append("\t</cache>".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		// 根据条件查询 object
		javaFile.append("\t<select id=\"get".concat(name).concat("\""));
		javaFile.append(" parameterType=\"java.lang.String\"");
		javaFile.append(" resultType=\"".concat(codeEntity.getEntityUrl()).concat(".").concat(name).concat("Entity\">").concat(Constant.NEW_LINE));
		javaFile.append("\tSELECT".concat(sqlC.toString()).concat(" \t\tFROM ").concat(codeEntity.getTableName()).concat(" t WHERE 1=1 ").concat(Constant.NEW_LINE));
		javaFile.append("\t</select>".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		// 根据条件查询List<T>
//		javaFile.append("\t<select id=\"getList".concat(name).concat("\""));
//		javaFile.append(" parameterType=\"com.sys.DataCenter\"");
//		javaFile.append(" resultType=\"".concat(codeEntity.getEntityUrl()).concat(".").concat(name).concat("Entity\">").concat(Constant.NEW_LINE));
//		javaFile.append("\tSELECT".concat(sqlC.toString()).concat(" \t\tFROM ").concat(codeEntity.getTableName()).concat(" t ").concat(Constant.NEW_LINE).concat("\tWHERE 1=1 ").concat(Constant.NEW_LINE));
//		javaFile.append(ifelseData.toString());
//		javaFile.append("\t\t LIMIT #{pageStart},#{pageSize} ".concat(Constant.NEW_LINE));
//		javaFile.append("\t</select>".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		//查询总数
//		javaFile.append("\t<select id=\"getCount\"");
//		javaFile.append(" parameterType=\"".concat(codeEntity.getEntityUrl()).concat(".").concat(name).concat("Entity\""));
//		javaFile.append(" resultType=\"java.lang.Integer\">".concat(Constant.NEW_LINE));
//		javaFile.append("\t\t SELECT COUNT(1) FROM ".concat(codeEntity.getTableName()).concat("t where 1=1 ").concat(Constant.NEW_LINE));
//		javaFile.append(ifelse.toString());
//		javaFile.append("\t</select>".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		//更新
//		javaFile.append("\t<update id=\"".concat("update").concat(name).concat("\""));
//		javaFile.append(" parameterType=\"".concat(codeEntity.getEntityUrl()).concat(".").concat(name).concat("Entity\">").concat(Constant.NEW_LINE));
//		javaFile.append("\t\tUPDATE ".concat(codeEntity.getTableName()).concat(" SET ").concat(Constant.NEW_LINE));
//		javaFile.append("\t\t\t".concat(updates.toString()).concat(Constant.NEW_LINE));
//		javaFile.append("\t</update>".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		//插入
//		javaFile.append("\t<insert id=\"".concat("insert").concat(name).concat("\""));
//		javaFile.append(" parameterType=\"".concat(codeEntity.getEntityUrl()).concat(".").concat(name).concat("Entity\" >").concat(Constant.NEW_LINE));
//		javaFile.append("\t\tINSERT INTO ".concat(codeEntity.getTableName()).concat(Constant.NEW_LINE));
//		javaFile.append("\t\t\t(".concat(insrtinto.toString()).concat(")").concat(Constant.NEW_LINE));
//		javaFile.append("\t\tVALUES".concat(Constant.NEW_LINE));
//		javaFile.append("\t\t\t(".concat(insrtValue.toString()).concat(");").concat(Constant.NEW_LINE));
//		javaFile.append("\t</insert>".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
//		
		javaFile.append("</mapper>");
		
		logger.debug("---------------生产  mapper 成功！------------------");
		return javaFile.toString();
	}
	
	
	/**
	 * 生产 dao
	 * @param codeEntity
	 * @return
	 */
	public String getDao(CodeEntity codeEntity){
		javaFile = new StringBuffer("");
		String name = codeEntity.getEntityName();
		//String nameObject = name.substring(0, 1).toLowerCase().concat(name.substring(1,name.length()));
		javaFile.append("package ".concat(codeEntity.getDaoUrl()).concat(";").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("import java.util.List;".concat(Constant.NEW_LINE));
		javaFile.append("import ".concat(codeEntity.getEntityUrl()).concat(".").concat(codeEntity.getEntityName()).concat("Entity;").concat(Constant.NEW_LINE));
		javaFile.append("import com.sys.systemModule.DataCenter;".concat(Constant.NEW_LINE));
		javaFile.append(Constant.NEW_LINE.concat(CodeUtil.annotate.replace("#1", name.concat("Dao"))));
		javaFile.append("public interface ".concat(name.concat("Dao")).concat("{").concat(Constant.NEW_LINE));
		javaFile.append(Constant.NEW_LINE);
		javaFile.append("\tpublic ".concat(name.concat("Entity ")).concat("get").concat(name).concat("(").concat("String primaryKey);"));
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append("\tpublic List<".concat(name.concat("Entity> ")).concat("getList").concat(name).concat("(DataCenter<").concat(name).concat("Entity> dataCenter);"));
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append("\tpublic Integer ".concat("getCount(").concat(name).concat("Entity entity);"));
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append("\tpublic Integer ".concat("update").concat(name).concat("(").concat(name).concat("Entity ".concat(nameObject).concat(");")));
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append(Constant.NEW_LINE);
//		javaFile.append("\tpublic Integer ".concat("insert").concat(name).concat("(").concat(name).concat("Entity ".concat(nameObject).concat(");")));
		javaFile.append(Constant.NEW_LINE);
		javaFile.append(Constant.NEW_LINE.concat("}") );
		
		logger.debug("---------------生产  dao 成功！------------------");
		return javaFile.toString();
	}
	
	
	/**
	 * 生产实体属性
	 * @param codeEntity
	 * @param conn
	 * @return
	 */
	public String getEntity(CodeEntity codeEntity,Connection conn) throws Exception{
		javaFile = new StringBuffer("");
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String javatype = "";
		String cname = "";
		String comen = "";
		StringBuffer sx = new StringBuffer();
		List<String> name = new ArrayList<String>();
		preparedStatement = conn.prepareStatement(sqlEntity);
		preparedStatement.setString(1, codeEntity.getTableName());
		rs = preparedStatement.executeQuery();
		javaFile.append("package ".concat(codeEntity.getEntityUrl()).concat(";").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		boolean date = true;
		boolean bigd = true; 
		
		while(rs.next()){
			javatype = rs.getString("javatype");
			cname = rs.getString("cname");
			comen = rs.getString("comen");
			name.add(javatype.concat(",").concat(cname));
			
			sx.append("\tprivate ".concat(String.format("%-36s", String.format("%-11s",javatype).concat(cname).concat(";"))).concat(comen).concat(Constant.NEW_LINE));
			if(javatype!=null && javatype.indexOf("Date")!=-1 && date){
				javaFile.append("import java.util.Date;".concat(Constant.NEW_LINE));
				date = false;
			}
			if(javatype!=null && javatype.indexOf("BigDecimal")!=-1 && bigd){
				javaFile.append("import java.math.BigDecimal;".concat(Constant.NEW_LINE)); 
				bigd = false;
			}
		}
		javaFile.append("import java.io.Serializable;".concat(Constant.NEW_LINE));
		javaFile.append("import com.sys.systemModule.baseMybatis.BaseAnnotation;".concat(Constant.NEW_LINE));
		javaFile.append(Constant.NEW_LINE);
		javaFile.append(CodeUtil.annotate.replace("#1", codeEntity.getEntityName().concat("Entity")));
		javaFile.append("@BaseAnnotation(tableName=\"".concat(codeEntity.getTableName()).concat("\")").concat(Constant.NEW_LINE));
		javaFile.append("public class ".concat(codeEntity.getEntityName()).concat("Entity").concat(" implements  Serializable { ").concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append("private static final long serialVersionUID = 1L;".concat(Constant.NEW_LINE).concat(Constant.NEW_LINE));
		javaFile.append(sx.append(Constant.NEW_LINE));
		for (String javaX : name) {
			javatype = javaX.split(",")[0];
			cname = javaX.split(",")[1];
			javaFile.append("\tpublic ".concat(javatype));
			javaFile.append(" get".concat(cname.substring(0, 1).toUpperCase().concat(cname.substring(1, cname.length()))).concat("(){").concat(Constant.NEW_LINE));
			javaFile.append("\t\treturn this.".concat(cname).concat(";").concat(Constant.NEW_LINE).concat("\t}"));
			javaFile.append(Constant.NEW_LINE);
			javaFile.append("\tpublic void set".concat(cname.substring(0, 1).toUpperCase().concat(cname.substring(1, cname.length()))).concat("(").concat(javatype).concat(" ").concat(cname).concat(")"));
			javaFile.append("{".concat(Constant.NEW_LINE).concat("\t\tthis.").concat(cname).concat("=").concat(cname).concat(";").concat(Constant.NEW_LINE).concat("\t}"));
			javaFile.append(Constant.NEW_LINE);
		}
		javaFile.append(Constant.NEW_LINE.concat("}"));
		
		logger.debug("---------------生产  entity 成功！------------------");
		return javaFile.toString();
	}
} 
