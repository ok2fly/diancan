package com.gcfd.service;

import java.util.List;

import com.gcfd.model.Branch;
import com.gcfd.util.PageBean;

public interface BranchService {

	public List<Branch> getBranchs(PageBean page, String branch_name);
	
	public Branch getBranchByName( String branch_name );
	
	public void addBranch( Branch branch ) throws Exception;
	
	public void deleteBranchById( Long id ) throws Exception;
	
	public void updateBranch( Branch branch ) throws Exception ;

	public Integer getCounts();

}
