package com.gcfd.common.util;

import org.apache.commons.fileupload.FileItemStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description 文件上传处理工具
 * @author  王童博
 * @date 2016年8月18日 下午2:24:23
 * @version  1.0
 */
public class UploadFileUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtil.class);
	
	/**
	 * @description 根据上传文件获得Token
	 * @author  王童博
	 * @date 2016年8月18日下午2:27:34
	 * @version 1.0
	 * @param fileItem
	 * @return
	 */
	public static  String getInputValue(FileItemStream fileItem){
		String strRead="";
		byte bs[]=null;
		int no=0;
		try {
		 no = fileItem.openStream().available();
		 bs=new byte[no];
		 fileItem.openStream().read(bs, 0, no);
		 strRead = new String(bs);
		 strRead = String.copyValueOf(strRead.toCharArray(), 0, bs.length);
		} catch (IOException e) {
		 logger.error("==========获取表单元素失败："+e.getMessage());
		}
		 return strRead.substring(0, no);
	}
	public static String uploadFile(HttpServletRequest request, String fileName) {
		return "";
	}
}
