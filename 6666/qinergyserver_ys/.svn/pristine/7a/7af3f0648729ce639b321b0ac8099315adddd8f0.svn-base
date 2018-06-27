package com.qinergy.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
@Service 
public class ExcelUtils {
	/** 
	private static Logger log = Logger.getLogger(ExcelUtils.class);
     * 根据模板生成Excel文件. 
     * @param templateFileName 模板文件. 
     * @param list 模板中存放的数据. 
     * @param resultFileName 生成的文件. 
     */  
    public void createExcel(String templateFileName, List<?> list, List<?> title, String resultFileName){  
        //创建XLSTransformer对象  
        XLSTransformer transformer = new XLSTransformer();  
        //获取java项目编译后根路径  
//        URL url = this.getClass().getClassLoader().getResource("");  
        
        String path = this.getClass().getClassLoader().getResource("../../").getPath();
        try {
			path = URLDecoder.decode(path, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //得到模板文件路径  
//        String srcFilePath = url.getPath() + templateFileName;  
        String srcFilePath = path + templateFileName;  
        Map<String,Object> beanParams = new HashMap<String,Object>();  
        beanParams.put("list", list);  
        beanParams.put("title", title);
//        String destFilePath = url.getPath() + resultFileName;  
        String destFilePath = path + resultFileName;
        //log.debug("==============srcFilePath==" + srcFilePath);
       // log.debug("==============destFilePath==" + destFilePath);
        try {  
            //生成Excel文件
            transformer.transformXLS(srcFilePath, beanParams, destFilePath);
        } catch (Exception e) {  
        //    log.debug("create excel exception"+e);
        }  
    }
    
    /**
     * 
     * @param templateName  电子表格模板名称
     * @param dataList  数据源
     * @param excelTitle  电子表格抬头
     * @param response
     * @throws Exception 
     * @throws Exception
     */
    public void downloadExcel(String templateName, List<?> dataList, String excelTitle, HttpServletResponse response){
		//	随机生成一个不重复的字符串
		String name = UUID.randomUUID().toString();
		
		//	生成相应的execl文件
        String templateFileName = "commons/execltemplate/reportTemplate_" + templateName + ".xls";
        String resultFileName = "commons/execltemplate/" + name + "_out.xls";  
        
		//	生成title
		//	title格式：2014-08-05 18:22:05_excelTitle
		/*Calendar calendar = new GregorianCalendar();
		String title = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "  " + calendar.get(Calendar.HOUR_OF_DAY) + ":" +calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + "_" + excelTitle;*/
        
        List<String> list_title = new ArrayList<String>();
		list_title.add(excelTitle);
        createExcel(templateFileName,dataList, list_title, resultFileName);
        String dir=this.getClass().getClassLoader().getResource("../../").getPath();
        try {
			dir = URLDecoder.decode(dir, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path = dir + "/commons/execltemplate/" + name + "_out.xls";
        // path是指欲下载的文件的路径。
        File file = new File(path);
        // 取得文件名。
        String filename = file.getName();
        //	更改文件名
        Calendar calendar2 = new GregorianCalendar();
        filename = excelTitle + "_" + calendar2.get(Calendar.YEAR) + "-" + (calendar2.get(Calendar.MONTH) + 1) + "-" + calendar2.get(Calendar.DAY_OF_MONTH) + ".xls";
     // 以流的形式下载文件。
        BufferedInputStream fis=null;
        OutputStream toClient = null;
        try {
			//filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
			fis = new BufferedInputStream(new FileInputStream(path));
			byte[] buffer= new byte[fis.available()];
			fis.read(buffer);
	        fis.close();
	        if(response!=null){
	        	 response.reset();// 清空response	
	        }
	       
	        //设置response的Header
	        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
	        response.addHeader("Content-Length", "" + file.length());
	        toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
		}catch (Exception e) {
			//log.debug("excel export exception :"+e);
		}finally{
			try {
				if(fis!=null){
					fis.close();
				}
				if(toClient!=null){
					toClient.close();
				}
			} catch (IOException e) {
				//log.debug("stream closed exception "+e);
			}
			
		}
        //	将相应的文件删除
        /*File excelFile = new File(path);
        if(excelFile.exists()) {
        	excelFile.delete();
        }*/
    }
    
    /**
     * 
     * @param list
     * @param filename
     * @param contenttitle
     * @param colmons
     * @param response
     * @throws IOException
     */
    public void downExcelPoi(List<Map<String,Object>> list,String filename,String contenttitle,String colmons,HttpServletResponse response) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        // 第一行标头
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillPattern(XSSFCellStyle.LEAST_DOTS);
        // 设置Excel中的边框(表头的边框)
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        // 设置字体
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 20); // 字体高度
        font.setFontName("微软雅黑"); // 字体
        style.setFont(font);

        // 第二行表头
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillPattern(XSSFCellStyle.LEAST_DOTS);
        // 设置Excel中的边框(表头的边框)
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
        style2.setFillForegroundColor(HSSFColor.YELLOW.index);
        style2.setFillBackgroundColor(HSSFColor.YELLOW.index);
        // 设置字体
        XSSFFont font2 = workbook.createFont();
        font2.setFontHeightInPoints((short) 14); // 字体高度
        font2.setFontName("微软雅黑"); // 字体
        style2.setFont(font2);
        style2.setWrapText(true);//自动换行
        
        // 数据居中
        XSSFCellStyle style3 = workbook.createCellStyle();
        style3.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 设置字体
        XSSFFont font3 = workbook.createFont();
        font3.setFontHeightInPoints((short) 12); // 字体高度
        font3.setFontName("微软雅黑"); // 字体
        style3.setFont(font3);
        
        XSSFRow row = sheet.createRow((short) 0);
        sheet.setColumnWidth(0, 5766);
        row.setHeight((short) 600);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
        // 生成Excel头 写入数据
        XSSFCell cell = row.createCell(0);
        // 设置Excel中的背景
        style.setFillForegroundColor(HSSFColor.YELLOW.index);
        style.setFillBackgroundColor(HSSFColor.YELLOW.index);
        cell.setCellValue(new XSSFRichTextString(contenttitle));
        cell.setCellStyle(style);

        int countOne = 1;
        row = sheet.createRow((short) countOne);
        
        String[] colmon = colmons.split(",");
        for(int i = 0; i< colmon.length; i++){
        	cell = row.createCell(i);
        	sheet.setColumnWidth(i, 3766);
        	cell.setCellValue(new XSSFRichTextString(colmon[i]));
        	cell.setCellStyle(style2);
        }

    	for(int j=0;j<list.size();j++){
    		row = sheet.createRow(j+2);//从第三行开始
			//获取每行数据
			Map<String,Object> map = list.get(j);
			Set<Entry<String,Object>> set = map.entrySet();
			Iterator<Entry<String,Object>> it = set.iterator();
			int index = 0;
			while(it.hasNext()){
				Entry<String,Object> entry = it.next();
				cell = row.createCell(index);
    			cell.setCellValue(new XSSFRichTextString(entry.getValue().toString()));
    			cell.setCellStyle(style3);
				index++;
			}
		}
    	
        filename = URLEncoder.encode(filename, "utf-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream ouputStream = response.getOutputStream();
        workbook.write(ouputStream);
	}
    
}
