package com.qinergy.util;
 
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jcraft.jsch.ChannelSftp;

/**
 * 
 * @author Administrator
 *	2016年4月27日 17:31:29
 */
public class UploadFile {
	
	Logger logger  =  Logger.getLogger(UploadFile.class );
	
	/**
	 * 单文件上传  
	 * @param file
	 * @param path 
	 * @return
	 * @throws IOException 
	 */
	public void uploadFile(InputStream fil, String path) throws IOException {
		// /upload/images/filename.jpg
		File destFile = new File(path);
		
			//InputStream fil = file.getInputStream();
			
			// FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
			// 复制临时文件到指定目录下
		FileUtils.copyInputStreamToFile(fil, destFile);
			
	}
	/**
	 * SFTP单文件上传  
	 * @param file
	 * @param path 
	 * @return
	 */
	public void SFTPuploadFile(CommonsMultipartFile file, String directory,String fileName) {
		// /upload/images/filename.jpg
		// File destFile = new File(path);
		
		SFTP sf = new SFTP();
		
		//连接SFTP服务器的属性值
		//String host = "182.50.1.8";
		String host = "101.201.154.205";
		//int port = 10383;//外网测试
		int port = 22;//内网
		String username = "root";
		//String password = "1qaz!QAZ";
		String password = "AIte123456";
		//打开SFTP服务器连接
		ChannelSftp sftp = sf.connect(host, port, username, password);
		//文件上传
		sf.upload(directory, file, sftp, fileName);
		
	}
	
	/**
	 * 多文件上传
	 * @param file
	 * @return
	 */
	public void uploadFiles(CommonsMultipartFile[] files ,String path) {
		
		if (files != null) {
			for (int i = 0; i < files.length; i++) {

				try {
					
	            	File destFile = new File(path);
	            	
	                FileUtils.copyInputStreamToFile(files[i].getInputStream(), destFile);// 复制临时文件到指定目录下
	            } catch (IOException e) {
	                e.printStackTrace();
		        }
			}
		}
	}
	
}
