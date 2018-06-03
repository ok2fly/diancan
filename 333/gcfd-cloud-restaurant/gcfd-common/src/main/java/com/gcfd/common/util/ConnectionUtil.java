package com.gcfd.common.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;


/**
 * @类名：ConnectionUtil.java
 * @作者：one
 * @时间：2016年4月1日 下午6:55:33
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public class ConnectionUtil{
	
	private static ApplicationContext ct;
	private static DruidDataSource druidDataSource;
	/**
	 * 重新加载 spring xml 以取得数据库连接
	 * 仅供项目开发中测试使用 
	 * 方便 main 方法内使用
	 * @return
	 * @throws SQLException
	 */
	@Deprecated
	public static final Connection getConnectionXml() throws SQLException{
		if(ct==null)ct = new ClassPathXmlApplicationContext("classpath:com/sys/applicationContext.xml");
		if(druidDataSource==null)druidDataSource = (DruidDataSource) ct.getBean("dataSource");
		
		return druidDataSource.getConnection().getConnection();
	}
	/**
	 * 重新加载 spring xml 以取得数据库连接
	 * 仅供项目开发中测试使用 
	 * 方便 main 方法内使用
	 * @return
	 * @throws SQLException
	 */
	public static final Connection getConnectionXml(String dataSource) throws SQLException{
		if(ct==null)ct = new ClassPathXmlApplicationContext("classpath:applicationContext-init.xml");
		if(druidDataSource==null)druidDataSource = (DruidDataSource) ct.getBean("dataSource");
		return druidDataSource.getConnection().getConnection();
	}
	/**
	 * 
	 * @return 通过 spring bean 取得默认数据库连接
	 * @throws SQLException
	 */
	public static final Connection getConnection() throws SQLException{
		DataSource ds = (DataSource) SpringUtil.getBean("dataSource");
		if(ds==null) return null;
		return ds.getConnection();
	}
	/**
	 * 根据 dataSourceName 取 connection
	 * @param dataSource
	 * @return
	 * @throws SQLException
	 */
	public static final Connection getConnection(String dataSource) throws SQLException{
		DruidDataSource ds = (DruidDataSource) SpringUtil.getBean(dataSource);
		if(ds==null) return null;
		return ds.getConnection();
	}
	
	
	/**
	 * 关闭 Connection
	 * @param connection
	 */
	public static final void closeConnection(Connection connection){
		try{
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 关闭 Statement
	 * @param statement
	 */
	public static final void closeConnection(Statement statement){
		try{
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 关闭 ResultSet
	 * @param resultSet
	 */
	public static final void closeConnection(ResultSet resultSet){
		try{
			if(resultSet!=null && !resultSet.isClosed()){
				resultSet.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 Connection 
	 * 关闭 Statement 
	 * 关闭 ResultSet
	 * @param resultSet
	 */
	public static final void closeConnection(Connection connection,Statement statement,ResultSet resultSet){
		try{
			if(resultSet!=null && !resultSet.isClosed()){
				resultSet.close();
			}
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 CallableStatement 
	 * 关闭 ResultSet
	 * @param resultSet
	 */
	public static final void closeConnection(CallableStatement statement,ResultSet resultSet){
		try{
			if(resultSet!=null && !resultSet.isClosed()){
				resultSet.close();
			}
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 Statement
	 * 关闭 ResultSet
	 * @param resultSet
	 */
	public static final void closeConnection(Statement statement,ResultSet resultSet){
		try{
			if(resultSet!=null && !resultSet.isClosed()){
				resultSet.close();
			}
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 CallableStatement
	 * @param statement
	 */
	public static final void closeConnection(CallableStatement statement){
		try{
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 CallableStatement
	 * 关闭 Connection
	 * @param connection
	 */
	public static final void closeConnection(Connection connection,CallableStatement statement){
		try{
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 关闭 PreparedStatement
	 * 关闭 Connection
	 * @param connection
	 */
	public static final void closeConnection(Connection connection,PreparedStatement statement){
		try{
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 关闭 PreparedStatement
	 * @param statement
	 */
	public static final void closeConnection(PreparedStatement statement){
		try{
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
