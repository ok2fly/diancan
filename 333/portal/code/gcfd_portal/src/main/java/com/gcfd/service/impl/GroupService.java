package com.gcfd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcfd.mapper.IGroupMapper;
import com.gcfd.model.Group;
import com.gcfd.model.User;
import com.gcfd.service.IGroupService;
import com.gcfd.util.PageBean;

@Service
public class GroupService implements IGroupService{

	@Autowired
	private IGroupMapper groupMapper;

	@Override
	public List<Group> getGroups(PageBean page, String group_name) {
		return groupMapper.getGroups(page,group_name);
	}

	@Override
	public void addGroup(Group group) throws Exception {
		groupMapper.addGroup(group);
	}

	@Override
	public void updateGroup(Group group) throws Exception {
		groupMapper.updateGroup(group);
	}

	@Override
	public void deleteGroupById(Long id) throws Exception {
		groupMapper.deleteGroupById(id);
	}
	public void deleteGroupAndRelateById(Map param) throws Exception {
		groupMapper.deleteGroupAndRelateById(param);
	}

	@Override
	public int getCounts( Long group_id ) {
		if( group_id == null ){
			return groupMapper.getCounts() ;
		}else{
			return groupMapper.getCountsById(group_id) ;
		}
	}

	@Override
	public Group onlyByGroupName(String group_name) {
		return groupMapper.onlyByGroupName(group_name);
	}

	@Override
	public void addGroupRel(Map<String, Object> map) throws Exception {

		Long group_id = Long.valueOf((Integer) map.get("group_id"));


		//根据组group_id 删除 所有授权
		groupMapper.deleteGroupRelById(group_id);

		List<Integer> authGroupids = (List<Integer>) map.get("groupids");
		if(authGroupids.size()>0)
		{
			List<Map<String,Long>> groupids = new ArrayList<Map<String,Long>>();
			if( authGroupids.size() == 0){
				
				List<Group> groups = groupMapper.getGroupRel(null,null);
				
				for (Group group : groups) {
					Map<String,Long> m = new HashMap<String, Long> ();
					m.put("groupid", group_id);
					m.put("authid", group.getGroup_id());
					groupids.add(m); 
				}
			}else{
				for (Integer id : authGroupids) {
					Map<String,Long> m = new HashMap<String, Long> ();
					m.put("groupid", group_id);
					m.put("authid", id.longValue());
					groupids.add(m); 
				}
			}
			
			groupMapper.addGroupRel(groupids );
		}
	}

	/*@Override
	public void groupAuth(Map<String, Object> map) throws Exception {

		Long group_id = Long.valueOf((Integer) map.get("group_id"));
		//先删除表格内的数据

		groupMapper.deleteAuthByGroupId(group_id);

		List<Integer> appIds = (List<Integer>) map.get("appIds");
		List<Integer> apiIds = (List<Integer>) map.get("apiIds");
		List<Map<String,Long>> groupids = new ArrayList<Map<String,Long>>();
		for (Integer appid : appIds) {
			Map<String,Long> m = new HashMap<String, Long> ();
			m.put("groupid", group_id);
			m.put("appid", appid.longValue());
			for (Integer apiid : apiIds) {
				Map<String,Long> mm = new HashMap<String, Long> ();
				mm.putAll(m);
				mm.put("apiid", apiid.longValue() );
				groupids.add(mm); 
			}
		}
		groupMapper.groupAuth(groupids );
	}*/


	@Override
	public void groupAuth(Map<String, Object> map) throws Exception {

		//Long group_id = Long.valueOf((Integer) map.get("group_id"));
		Long group_id = Long.parseLong(map.get("group_id").toString());
		Long appid = Long.parseLong(map.get("appId").toString());
		//Long appid = Long.valueOf((Integer) map.get("appId"));
		//先删除表格内的数据
//		groupMapper.deleteAuthByGroupId(group_id);
		
		Map<String,Long> param = new HashMap<String,Long>();
		param.put("group_id", group_id);
		param.put("app_id", appid);
		groupMapper.deleteAuthByGroupAPP(param);

		List<Integer> apiIds = (List<Integer>) map.get("apiIds");
		if(apiIds.size()>0)
		{
			List<Map<String,Long>> groupids = new ArrayList<Map<String,Long>>();
			Map<String,Long> m = new HashMap<String, Long> ();
			m.put("groupid", group_id);
			m.put("appid", appid);
			Map<String,Long> mm = null;
			for (Integer apiid : apiIds) {
				mm = new HashMap<String, Long> ();
				mm.putAll(m);
				mm.put("apiid", apiid.longValue() );
				groupids.add(mm); 
			}
			groupMapper.groupAuth(groupids );
		}
	}

	@Override
	public List<Group> getGroups( User user) {

		List<Group> groups = new ArrayList<Group>();

		List<Group> tGs = groupMapper.getGroups(null, null);

		Set<Group> ckGs = groupMapper.getGroupByUser(user.getUser_id() );

		for (Group tg : tGs) {
			if(ckGs.contains(tg) ){
				tg.setLAY_CHECKED(true);
			}
			groups.add(tg);
		}

		return groups;
	}

	@Override
	public List<Group> getGroups(PageBean page, Group group) {

		List<Group> groups = new ArrayList<Group>();

		List<Group> allGroups = groupMapper.getGroups(page,null);

		//不能再授权的组了
		List<Group> alreadyRelGroups = groupMapper.getMayGroupRel(page,group.getGroup_id());


		//已经授权的组
		List<Group> relGroups = groupMapper.getGroupRel(page,group.getGroup_id());

		for (Group g : allGroups) {
			if( relGroups.contains(g) ){
				//回显
				g.setLAY_CHECKED(true);
			}else if( g.equals(group) ){
				//本身选中不可用
				g.setDISABLED(true);
			}else if( alreadyRelGroups.contains(g) ){
				g.setDISABLED(true);
			}
			groups.add(g);
		}


		return groups;
	}

}
