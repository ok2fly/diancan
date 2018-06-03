package com.gcfd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gcfd.model.DataSource;
import com.gcfd.util.PageBean;

public interface IDataSourceMapper {
	public int getCounts();

	public List<DataSource> getDataSource(@Param("page") PageBean page,@Param("data_source_url") String data_source_url);

	public void addDataSource(DataSource model) throws Exception;

	public void updateDataSource(DataSource model) throws Exception;

	public void deleteDataSourceById(Long id) throws Exception;

}
