package com.gcfd.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.gcfd.model.Group;
import com.gcfd.util.PageBean;

public interface IGroupMapper {
	public List<Group> getGroups(@Param("page")PageBean page, @Param("group_name")String group_name);
	public List<Group> getGroupRel(@Param("page")PageBean page,@Param("group_id")Long group_id);
	public void addGroup( Group group ) throws Exception;
	public void updateGroup(Group group) throws Exception;
	public void deleteGroupById(Long id ) throws Exception;
	public void deleteGroupAndRelateById(Map param ) throws Exception;
	public int getCounts();
	public Group onlyByGroupName(String group_name);
	public void addGroupRel(List<Map<String, Long>> groupids);
	public int getCountsById(Long group_id);
	public void groupAuth(List<Map<String, Long>> groupids);
	public void deleteAuthByGroupId(Long group_id) throws Exception;
	public void deleteAuthByGroupAPP(Map prame) throws Exception;
	public Set<Group> getGroupByUser(String user_id);
	public List<Group> getMayGroupRel(@Param("page")PageBean page,@Param("group_id")Long group_id);
	public void deleteGroupRelById(Long group_id) throws Exception;
}
