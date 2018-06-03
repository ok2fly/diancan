package com.gcfd.service;

import java.util.List;

import com.gcfd.model.Scence;
import com.gcfd.util.PageBean;

public interface ScenceService {

	public List<Scence> getScences(PageBean pageUtil, String string);

	public int getCounts();
	
	public String onlyByScenceName(String scence_name);
	
	public void add(Scence scence);
	
	public void update(Scence scence);
	
	public void delete(Long id);
}
