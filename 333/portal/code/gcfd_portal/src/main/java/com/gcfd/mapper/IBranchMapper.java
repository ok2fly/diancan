package com.gcfd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gcfd.model.Branch;
import com.gcfd.util.PageBean;

public interface IBranchMapper {

	public List<Branch> getBranchs(@Param("page")PageBean page, @Param("branch_name")String branch_name);

	public void updateBranch(Branch branch);

	public void deleteBranchById(Long id);

	public void addBranch(Branch branch);

	public Branch getBranchByName(String branch_name);

	public Integer getCounts();

}
