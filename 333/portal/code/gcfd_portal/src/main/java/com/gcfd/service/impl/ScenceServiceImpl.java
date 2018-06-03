package com.gcfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mapper.IScenceMapper;
import com.gcfd.model.Scence;
import com.gcfd.service.ScenceService;
import com.gcfd.util.PageBean;

@Service
public class ScenceServiceImpl implements ScenceService{

	@Autowired
	private IScenceMapper scenceMapper;
	
	@Override
	public List<Scence> getScences(PageBean page, String scence_name) {
		return scenceMapper.getScences(page,scence_name);
	}

	@Override
	public int getCounts() {
		return scenceMapper.getCounts();
	}

	@Override
	public String onlyByScenceName(String scence_name) {
		return scenceMapper.onlyByScenceName(scence_name);
	}

	@Override
	public void add(Scence scence) {
		scenceMapper.add(scence);
	}

	@Override
	public void update(Scence scence) {
		scenceMapper.update(scence);
	}

	@Override
	public void delete(Long id) {
		scenceMapper.delete(id);
	}

}
