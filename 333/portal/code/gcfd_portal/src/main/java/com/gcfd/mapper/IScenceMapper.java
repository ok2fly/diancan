package com.gcfd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gcfd.model.Scence;
import com.gcfd.util.PageBean;


public interface IScenceMapper {

	public List<Scence> getScences( @Param("page") PageBean page, @Param("scence_name") String scence_name);

	public int getCounts();
	
	public String onlyByScenceName(String scence_name);
	
	public void add(Scence scence);
	
	public void update(Scence scence);
	
	public void delete(Long id);
}
