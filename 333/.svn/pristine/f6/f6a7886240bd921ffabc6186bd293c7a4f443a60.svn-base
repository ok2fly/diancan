package com.gcfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mapper.IDataSourceMapper;
import com.gcfd.model.DataSource;
import com.gcfd.service.IDataSourceService;
import com.gcfd.util.PageBean;

@Service
public class DataSourceService implements IDataSourceService{

	@Autowired
	private IDataSourceMapper dataSourceMapper;
	
	@Override
	public int getCounts() {
		return dataSourceMapper.getCounts();
	}

	@Override
	public List<DataSource> getDataSource(PageBean pageUtil, String data_source_url) {
		return dataSourceMapper.getDataSource(pageUtil, data_source_url);
	}

	@Override
	public void addDataSource(DataSource model) throws Exception {
		dataSourceMapper.addDataSource(model);		
	}

	@Override
	public void updateDataSource(DataSource model) throws Exception {
		dataSourceMapper.updateDataSource(model);		
	}

	@Override
	public void deleteDataSourceById(Long id) throws Exception {
		dataSourceMapper.deleteDataSourceById(id);		
	}
	
}
