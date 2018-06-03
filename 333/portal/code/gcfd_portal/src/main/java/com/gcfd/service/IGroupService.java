package com.gcfd.service;

import java.util.List;
import java.util.Map;

import com.gcfd.model.Group;
import com.gcfd.model.User;
import com.gcfd.util.PageBean;

public interface IGroupService {
	public List<Group> getGroups(PageBean page, String group_name);
	public List< Group> getGroups(User user);
	public void addGroup( Group group ) throws Exception;
	public void updateGroup(Group group) throws Exception;
	public void deleteGroupById(Long id ) throws Exception;
	public void deleteGroupAndRelateById(Map param) throws Exception;
	public int getCounts( Long group_id );
	public Group onlyByGroupName(String group_name);
	public void addGroupRel(Map<String, Object> map)throws Exception;
	public void groupAuth(Map<String, Object> map) throws Exception;
	public List<Group> getGroups(PageBean pageUtil, Group group);
}
