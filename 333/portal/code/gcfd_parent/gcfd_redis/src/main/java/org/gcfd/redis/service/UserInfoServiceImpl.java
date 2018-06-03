package org.gcfd.redis.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.gcfd.redis.model.RedisObject;
import com.gcfd.redis.model.UserInfo;

@Service("userInfoService")
public class UserInfoServiceImpl {

	@Autowired
    protected RedisTemplate<Serializable, Serializable> redisTemplate;
	/**
	 * @author LIUFEI
	 * @category 根据key：token值删除redis中的数据
	 * @param token
	 */
	public void delObject(String token) {
		redisTemplate.delete(token );
	}
	/**
	 * @author LIUFEI
	 * @category 根据UserInfo中的Token作为key保存该UserInfo对象到Redis中
	 * @param userInfo
	 */
	public void saveUserInfo(UserInfo userInfo) {
		final UserInfo ui = userInfo;
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
            	ValueOperations<Serializable, Serializable> valueOper =redisTemplate.opsForValue();
            	valueOper.set(ui.getToken(),ui);
            	return null;
            }
        });
    }
	/**
	 * @author LIUFEI
	 * @category 扩展saveUserInfo
	 * @param robject
	 */
	public void saveObject(RedisObject robject) {
		if(null == robject)
			return;
		final String k = robject.getKey();
		final RedisObject val = robject;
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				ValueOperations<Serializable, Serializable> valueOper =redisTemplate.opsForValue();
				valueOper.set(k,val);
				return null;
			}
		});
	}

	/**
	 * @author LIUFEI
	 * @category 根据token值获取Redis中的UserInfo对象
	 * @param token
	 * @return
	 */
    public UserInfo getUserInfo(String token) {
    	if(null == token || token.trim().length() == 0)
    		return null;
    	final String tk = token;
        return redisTemplate.execute(new RedisCallback<UserInfo>() {
            @Override
            public UserInfo doInRedis(RedisConnection connection) throws DataAccessException {
            	ValueOperations<Serializable, Serializable> valueOper =redisTemplate.opsForValue();
            	Object obj = valueOper.get(tk);
            	if(null != obj)
            		return (UserInfo)obj;
                return null;
            }
        });
    }
    /**
     * @author LIUFEI
     * @category 扩展getUserInfo 
     * @param token
     * @return
     */
    public Object getObject(String token) {
    	if(null == token || token.trim().length() == 0)
    		return null;
    	final String tk = token;
    	return redisTemplate.execute(new RedisCallback<Object>() {
    		public Object doInRedis(RedisConnection connection) throws DataAccessException {
    			ValueOperations<Serializable, Serializable> valueOper =redisTemplate.opsForValue();
    			return valueOper.get(tk);
    		}
    	});
    }
}
