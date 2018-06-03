package com.gcfd.service;

import java.util.List;
import java.util.Map;

import com.gcfd.model.App;
import com.gcfd.model.User;
import com.gcfd.util.PageBean;

public interface IUserService {
	

	public List<User> getUsers(PageBean page, String user_name);

	public void addUser( User user) throws Exception;

	public void updateUser(User user) throws Exception;
	public void updateUserPwd(User user) throws Exception;

	public void deleteUserById(String user_id) throws Exception;

	/**
	 * 把人员分配到组
	 * @param map {user_id, list[group_id]}
	 */
	public void addUserGroup(Map<String, Object> map)throws Exception;

	/**
	 * 验证id 唯一性
	 * @param user_id
	 * @return
	 */
	public User onlyByUserName(String user_name);

	/**
	 * 分页总条数
	 * @return
	 */
	public int getCounts();

	/**
	 * login
	 * @param model
	 * @return
	 */
	public User Login(User user);
	


}
