package com.gcfd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mapper.IBranchMapper;
import com.gcfd.model.Branch;
import com.gcfd.service.BranchService;
import com.gcfd.util.PageBean;

@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private IBranchMapper branchMapper;

	@Override
	public List<Branch> getBranchs(PageBean page, String branch_name) {
		return branchMapper.getBranchs(page, branch_name);
	}

	@Override
	public Branch getBranchByName(String branch_name) {
		return branchMapper.getBranchByName(branch_name);
	}

	@Override
	public void addBranch(Branch branch) throws Exception {
		branchMapper.addBranch( branch );
	}

	@Override
	public void deleteBranchById(Long id) throws Exception {
		branchMapper.deleteBranchById(id);
	}

	@Override
	public void updateBranch(Branch branch) throws Exception {
		branchMapper.updateBranch(branch);
	}

	@Override
	public Integer getCounts() {
		return branchMapper.getCounts();
	}


}
