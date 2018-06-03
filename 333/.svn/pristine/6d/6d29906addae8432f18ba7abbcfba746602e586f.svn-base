package com.gcfd.common.util.Excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
	
	public static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	
	public enum pStyle{
		/**
		 * 处理错误
		 */
		DoError,
		/**
		 * 不处理错误
		 */
		NoDoError;
	}
	
	private int sheet;					//指定sheet块
	private boolean pType; 				//cellNum或cellName对应标识（true :cellNums false:cellName）
	private pStyle style;				//错误处理标识
	
	
	public ExcelUtil(){}
	/*
	 * 指定sheet
	 */
	public ExcelUtil(int sheet,pStyle pstyle){
		this.sheet = sheet;
		this.pType = true;
		this.style = pstyle;
	}
	/*
	 * 指定对应方式（cellNums/cellName）
	 */
	public ExcelUtil(boolean pType,pStyle pstyle){
		this.sheet = 0;
		this.pType = pType;
		this.style = pstyle;
	}
	/*
	 * 指定sheet,对应方式
	 */
	public ExcelUtil(int sheet,boolean pType,pStyle pstyle){
		this.sheet = sheet;
		this.pType = pType;
		this.style = pstyle;
	}
	/**
	 * @描述 指定sheet,默认cellNums处理
	 * @日期 2016年8月22日 下午4:06:06
	 * @version 1.0
	 * @param sheet
	 * @param pstyle
	 * @return
	 */
	public static ExcelUtil init(int sheet, pStyle pstyle){
		return new ExcelUtil(sheet,pstyle);
	}
	/**
	 * @描述 指定处理方式cellNums(true)/cellName(false),默认sheet 0
	 * @日期 2016年8月22日 下午4:06:06
	 * @version 1.0
	 * @param pType
	 * @param pstyle
	 * @return
	 */
	public static ExcelUtil init(boolean pType, pStyle pstyle){
		return new ExcelUtil(pType,pstyle);
	}
	/**
	 * @描述 指定sheet,指定处理方式cellNums(true)/cellName(false)
	 * @日期 2016年8月22日 下午4:11:08
	 * @version 1.0
	 * @param sheet
	 * @param pType
	 * @param pstyle
	 * @return
	 */
	public static ExcelUtil init(int sheet, boolean pType, pStyle pstyle){
		return new ExcelUtil(sheet,pType,pstyle);
	}
	
	/**
	 * @描述 指定开始行，默认至最后一行，第一列至最后一列-- XLS
	 * @日期 2016年8月22日 下午5:34:40
	 * @version 1.0
	 * @param is
	 * @param startRow
	 * @param clazz
	 * @return
	 */
	public <T> List<T> parseExcelXLS(InputStream is,int startRow,Class<T> clazz){
		List<T> list = new ArrayList<T>();
		try {
			Workbook wb = new HSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(this.sheet);
			list = parseExcel(sheet,startRow,-1,clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @描述 指定开始行，默认至最后一行，第一列至指定列 --XLS
	 * @日期 2016年8月22日 下午5:35:03
	 * @version 1.0
	 * @param is
	 * @param startRow
	 * @param endCol
	 * @param clazz
	 * @return
	 */
	public <T> List<T> parseExcelXLS(InputStream is,int startRow, int endCol,Class<T> clazz){
		List<T> list = new ArrayList<T>();
		try {
			Workbook wb = new HSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(this.sheet);
			list = parseExcel(sheet,startRow,endCol,clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @描述 指定开始行，默认至最后一行，第一列至最后一列-- XLSX
	 * @日期 2016年8月22日 下午5:35:37
	 * @version 1.0
	 * @param is
	 * @param startRow
	 * @param clazz
	 * @return
	 */
	public <T> List<T> parseExcelXLSX(InputStream is,int startRow,Class<T> clazz){
		List<T> list = new ArrayList<T>();
		try {
			Workbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(this.sheet);
			list = parseExcel(sheet,startRow,-1,clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * @描述 指定开始行，默认至最后一行，第一列至指定列 --XLSX
	 * @日期 2016年8月22日 下午5:35:03
	 * @version 1.0
	 * @param is
	 * @param startRow
	 * @param endCol
	 * @param clazz
	 * @return
	 */
	public <T> List<T> parseExcelXLSX(InputStream is,int startRow, int endCol,Class<T> clazz){
		List<T> list = new ArrayList<T>();
		try {
			Workbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(this.sheet);
			list = parseExcel(sheet,startRow,endCol,clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * @描述 通用Excel解析类（被调用方法）
	 * @日期 2016年8月22日 下午5:37:33
	 * @version 1.0
	 * @param sheet
	 * @param startRow
	 * @param endCol
	 * @param clazz
	 * @return
	 */
	private <T> List<T> parseExcel(Sheet sheet,int startRow, int endCol, Class<T> clazz){
		List<T> list = new ArrayList<T>();
		Row row = null;
		Cell cell = null;
		T obj = null;
		// 开始行
		startRow = startRow == -1 ? sheet.getFirstRowNum() + 1 : startRow;
		for(int i = startRow; i <= sheet.getLastRowNum(); i++){
			try{
				obj = clazz.newInstance();
				row = sheet.getRow(i);
				if (null != row){
					//结束列
					endCol = endCol == -1 ? row.getPhysicalNumberOfCells() : endCol;
					for(int j=0;j<endCol;j++){
						cell = row.getCell(j);
						setEntity(startRow,obj,cell);
					}
				}
				list.add(obj);
			}catch (Exception e){
				switch(style){
				case DoError:
					return list;
				case NoDoError:
					return null;
				}
				logger.error("--------------数据解析失败----------------");
			}
		}
		return list;
	}
	
	/**
	 * @描述 实体赋值
	 * @日期 2016年8月22日 下午5:38:36
	 * @version 1.0
	 * @param startRow
	 * @param entity
	 * @param cell
	 * @throws Exception
	 */
	private void setEntity(int startRow,Object entity,Cell cell) throws Exception{
		Field[] fields = Class.forName(entity.getClass().getName()).getDeclaredFields();
		if(null != cell){
			try{
				String value = null;
				String titlename = cell.getSheet().getRow(startRow-1).getCell(cell.getColumnIndex()).getStringCellValue();
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && HSSFDateUtil.isCellDateFormatted(cell)){
					value = cell.getDateCellValue().getTime() + "";
				}else{
					cell.setCellType(Cell.CELL_TYPE_STRING);
					value = cell.getStringCellValue();
				}
				if(null != value || !"".equals(value)){
					for (Field field : fields){
						// 设置属性可以修改
						field.setAccessible(true);
						if(field.isAnnotationPresent(Excel.class)){
							Excel excel = field.getAnnotation(Excel.class);
							if(pType){
								if(cell.getColumnIndex() == excel.cellNums()){
									field.set(entity, value);
								}
							}else{
								if(titlename.equals(excel.cellName())){
									field.set(entity, value);
								}
							}
						}
					}
				}
			}catch (Exception e){
				logger.error("--------------数据解析错误----------------");
			}
		}
	}
}