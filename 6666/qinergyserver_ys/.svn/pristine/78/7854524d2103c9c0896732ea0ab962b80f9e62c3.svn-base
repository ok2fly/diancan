package com.qinergy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DbUtil{
	
	public DbUtil(){
		
	}
	
	private String jdbcName=MobileConfig.get("jdbcName");
	
	private String dbUrl=MobileConfig.get("dbUrl");
	
	private String dbUserName=MobileConfig.get("dbUserName");
	
	private String dbPassword=MobileConfig.get("dbPassword");
	
	public Connection getCon()throws Exception {
		
		Class.forName(jdbcName);
		
		Connection con =DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		
		return con;
	}
	
	public void closeCon(Connection con) throws SQLException{
		
		if(con!=null){
			
			con.close();
		}
	}
}
