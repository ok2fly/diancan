package com.gcfd.common.util;

import com.alibaba.fastjson.JSON;
import com.gcfd.common.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.sql.SQLException;
import java.util.*;

/**
 * @类名：JedisUtil.java
 * @作者：one
 * @时间：2016年4月1日 下午6:55:33
 * @版权：pengkaione@icloud.com
 * @描述： 
 */

public class JedisUtil {
	 private static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);
	 
	 private static JedisPool jedisPool;
	 private static ApplicationContext ct;
	 
	  /**
		 * <p> 加载 spring xml 以取得redis 连接池
		 * <p> 建议只在项目开发中测试使用 
		 * <p> 方便 main 方法内使用
		 * @return
		 * @throws SQLException
		 */
	    @Deprecated
		public static Jedis getJedisConnectionXml(int index){
			if(ct==null)ct = new ClassPathXmlApplicationContext("classpath:/com/sys/applicationContext.xml");
			if(jedisPool==null)jedisPool = (JedisPool)ct.getBean("jedisPool");
			Jedis jedis = jedisPool.getResource();
			jedis.select(index);
			return jedis;
		}
	   /**
	     * <p> 获取Jedis实例
	     * @return
	     */
	    public static Jedis getJedisConnection(int index) {
		 if (jedisPool == null) jedisPool=(JedisPool) SpringUtil.getBean("jedisPool");
		 Jedis jedis = jedisPool.getResource();
		 jedis.select(index);
		return jedis;
		}
	    
	    /**
	     * 回收Jedis
	     * @param Jedis
	     */
	    public static void returnJedis(Jedis Jedis) {
	    	try{
	    	if(Jedis!=null)Jedis.close();
	    	}catch(Exception e){
	    		 logger.error("JedisUtil ------ returnJedis(Jedis Jedis) ------ 严重异常，redis 连接关闭失败！\n："+e.getMessage());
	    	}
	     }
	    
	    
	    /**
	     * <p>通过key获取储存在redis中的value</p>
	     * <p>并释放连接</p>
	     * @param key
	     * @return 成功返回value 失败返回null
	     */
	    public static String getString(String key){
	      try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	        return Jedis.get(key);
	      } catch (Exception e) {
	    	  logger.error("JedisUtil ------ getString(String key) ------ 异常："+e.getMessage());
	      }
	      return null;
	    }
	    
	    
	    /**
	     * <p>通过key获取储存在redis中的value</p>
	     * <p>并释放连接</p>
	     * @param key
	     * @return 成功返回value 失败返回null
	     */
	    public static String getString(String key,int db){
	      if(null == key || db < 0){
	    	  return null;
	      }
	      try(Jedis Jedis = getJedisConnection(db)){
	        return Jedis.get(key);
	      } catch (Exception e) {
	    	  logger.error("JedisUtil ------ getString(String key) ------ 异常："+e.getMessage());
	      }
	      return null;
	    }
	    /**
	     * <p>通过key获取储存在redis中的value</p>
	     * <p>并释放连接</p>
	     * @param keys
	     * @return 成功返回value 失败返回null
	     */
	    public static List<String> getString(String[] keys){
	      if(keys==null||keys.length<=0)return null;
	      try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    	  List<String> list = new ArrayList<String>(keys.length);
	    	  for (String key : keys) {
	    		  list.add(Jedis.get(key));
			}
	        return list;
	      } catch (Exception e) {
	    	  logger.error("JedisUtil ------ getString(String[] keys) ------ 异常："+e.getMessage());
	      }
	      return null;
	    }
	    
	    /**
		 * 取得 json 序列化对象 
		 * @param key
		 * @param clazz
		 * @return
		 */
		public static <T> List<T> getObjectList(String key,Class<T> clazz){
			try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
				return JSON.parseArray(Jedis.get(key), clazz);
			}catch(Exception e){
				logger.error("JedisUtil ------ getObjectList(String key,Class<T> clazz) ------ 异常："+e.getMessage());
			}
			return null;
		}
	    /**
	     * 取得 json 序列化对象 
	     * @param key
	     * @param clazz
	     * @return null 为失败 有值为成功
	     */
		public static <T> T getObject(String key,Class<T> clazz) {
			try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
				return JSON.parseObject(Jedis.get(key), clazz);
			}catch(Exception e){
				logger.error("JedisUtil ------  getObject(String key,Class<T> clazz)------ 异常："+e.getMessage());
			}
			return null;
		}
		/**
	     * 把 string 存redis 
	     * @param key
	     * @param string
	     * @param seconds 有效时间，默认永久有效
	     * @return 0 失败
	     */
	    public static String setString(String key,String string,int...seconds){
			try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
				if(seconds!=null && seconds.length>0 && seconds[0] > 0) return Jedis.setex(key, seconds[0], string);
				return Jedis.set(key,string);
			}catch(Exception e){
				logger.error("JedisUtil ------ setString(String key,String string,int...seconds) ------ 异常："+e.getMessage());
			} 
	    	return "0";
	    }
	    /**
	     * 把对象序列化json 存redis 
	     * @param <T>
	     * @param key
	     * @param object
	     * @return
	     */
	    public static <T>String setObject(String key,T object,int...seconds){
			try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
				if(seconds!=null && seconds.length>0 && seconds[0] > 0) return Jedis.setex(key, seconds[0], JSON.toJSONString(object));
				return Jedis.set(key,JSON.toJSONString(object));
			}catch(Exception e){
				logger.error("JedisUtil ------ setObject(String key,T object,int...seconds) ------ 异常："+e.getMessage());
			}
	    	return "0";
	    }
	  
	    /**
	     * 把对象序列化json 存redis 
	     * @param key
	     * @param list
	     * @return 0 失败  
	     */
	    public static <T>String setObjectList(String key,List<T> list,int...seconds){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
				if(seconds!=null && seconds.length>0 && seconds[0] > 0) return Jedis.setex(key, seconds[0], JSON.toJSONString(list));
				return Jedis.set(key,JSON.toJSONString(list));
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------ setObjectList(String key,List<T> list,int...seconds) ------ 异常："+e.getMessage());
			}
	    	return "0";
	    }
	    
	    /**
	     * 删除  Key
	     * @param key
	     * @return 1 成功 0 失败
	     */
	    public static Long delKey(String key) {
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
				return Jedis.del(key);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------ delKey(String key) ------ 异常："+e.getMessage());
			}
			return 0L;
	    }
	    
	    /**
	     * 删除指定db下的 Key
	     * @param key
	     * @return 1 成功 0 失败
	     */
	    public static Long delKey(String key,int db) {
	    	try(Jedis Jedis = getJedisConnection(db)){
				return Jedis.del(key);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------ delKey(String key,int db) ------ 异常："+e.getMessage());
			}
			return 0L;
	    }
	    /**
	     * 存入一个hashMap
	     * 追加一个hashMap 相同的键会被覆盖
	     * @return
	     */
	    public static String setHashMap(String key,HashMap<String, String> hashMap){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.hmset(key, hashMap);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------ setHashMap(String key,HashMap<String, String> hashMap) ------ 异常："+e.getMessage());
			}
	    	return "0";
	    	
	    }  
	    /**
	     * 追加一个hashMap 键值对 相同的键会被覆盖
	     * @return
	     */
	    public static String setHashMap(String key,String hashKey, String hashValue){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		Map<String, String> hashmap= new HashMap<String,String>();
	    		hashmap.put(hashKey, hashValue);
	    		return Jedis.hmset(key,hashmap);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------ setHashMap(String key,String hashKey, String hashValue) ------ 异常："+e.getMessage());
			}
	    	return "0";
	    }  
	    /**
	     * 获取一个 hashMap 指定键的值
	     * @param key
	     * @param hashKey
	     * @return
	     */
	    public static String getHash(String key,String hashKey){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.hget(key, hashKey);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------  getHash(String key,String hashKey) ------ 异常："+e.getMessage());
			}
	    	return null;
	    }
	    /**
	     * 获取 hashMap 指定键的值
	     * @param key
	     * @param hashKey
	     * @return
	     */
	    public static List<String> getHash(String key,String[] hashKey){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.hmget(key, hashKey);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------  getHash(String key,String[] hashKey) ------ 异常："+e.getMessage());
			}
	    	return null;
	    }
	    
	    /**
	     * 获取 hashMap 指定键的值
	     * @param key
	     * @param hashKey
	     * @return
	     */
	    public static List<String> getLikekey(String key,String[] hashKey){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.hmget(key, hashKey);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------  getHash(String key,String[] hashKey) ------ 异常："+e.getMessage());
			}
	    	return null;
	    }   
	    
	    
	    /**
	     * 获取真个hashMap 
	     * @param key
	     * @return
	     */
	    public static Map<String, String> getHash(String key){
	    	try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.hgetAll(key);
	    	}catch (Exception e) {
	    		logger.error("JedisUtil ------ getHash(String key) ------ 异常："+e.getMessage());
			}
	    	return null;
	    }
	    
	    /**
	     * 累计 1 key 
	     * @param key
	     * @return
	     */
	     public static Long incr(String key){
	    	 try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.incr(key);
	    	 }catch (Exception e) {
		    		logger.error("JedisUtil ------ incr(String key) ------ 异常："+e.getMessage());
				}
	    	 return 0L;
	     }
	     /**
	      * 累减 1 key (该方法由sever 端执行，所有可以分布式使用)
	      * @param key
	      * @return
	      */
	     public static Long decr(String key){
	    	 try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return Jedis.decr(key);
	    	 }catch (Exception e) {
		    		logger.error("JedisUtil ------ decr(String key) ------ 异常："+e.getMessage());
				}
	    	 return 0L;
	     }
	     /**
	      * 累计 减去指定数
	      * @param key
	      * @param v
	      * @return
	      */
	     public static Long decrby(String key,Integer v){
	    	 try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
	    		return  Jedis.decrBy(key, v);
	    	 }catch (Exception e) {
		    		logger.error("JedisUtil ------ decrby(String key,Integer v) ------ 异常："+e.getMessage());
				}
	    	 return 0L;
	     }
	     /**
	      * 累计 加去指定数
	      * @param key
	      * @param v
	      * @return
	      */
	     public static Long incrBy(String key,Integer v){
	    	 try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
		    		return  Jedis.incrBy(key, v);
	    	 }catch (Exception e) {
		    		logger.error("JedisUtil ------ incrBy(String key,Integer v) ------ 异常："+e.getMessage());
				}
    	 return 0L;
     }  
     /**
      * 分布式开发 redis 锁机制实现
      * 该锁的有效时间为10秒
      * @param key
      * @param timeout
      * @return
      */
     public static boolean lock(String key, int timeout) {
 		boolean lockSuccess = false;
 		try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
 			long start = System.currentTimeMillis();
 			String lockKey = "lock_"+key;
 			do{
 				if(Jedis.setnx(lockKey, Long.toString(System.currentTimeMillis())) == 1){
 					lockSuccess = true;
 					break;
 				}else{
 					String lockTimeStr = Jedis.get(lockKey);
 					if(lockTimeStr!=null && !"".equals(lockTimeStr)){//如果key存在，锁存在
 						long lockTime = Long.valueOf(lockTimeStr);
 						if(lockTime < System.currentTimeMillis()){//锁已过期
 							String originStr = Jedis.getSet(lockKey, Long.toString(System.currentTimeMillis()+10000));
 							if(originStr!=null && !"".equals(originStr)){//表明锁由该线程获得
 								lockSuccess = true;
 								break;
 							}
 						}
 					}
 				}
 				//如果不等待，则直接返回
 				if(timeout == 0){
 					break;
 				}
 				//等待200ms继续加锁
 				Thread.sleep(200);
 			}while((System.currentTimeMillis()-start) < timeout);

 		}catch(Exception e){
 			logger.error("JedisUtil ------ lock(String key, int timeout) ------ 异常："+e.getMessage());
 		}
 		return lockSuccess;
 	}
     
    /**
     * 解除锁
     * @param key
     * @return
     */
 	public static long unLock(String key) {
 		try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
 			String lockKey = "lock_"+key;
 			return Jedis.del(lockKey);
 		}catch(Exception e){
 			logger.error("JedisUtil ------  unLock(String key) ------ 异常："+e.getMessage());
 		}
 		return 0L;
 	}
 	
 	/**
 	 * 清空指定 redis 的全部【 这个方法慎用 】
 	 * @param indexDb
 	 * @return
 	 */
 	public static String flushDB(int indexDb){
 		try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
 			if(indexDb!=-1){
 				return Jedis.flushDB();
 			}
 			return Jedis.flushAll();
 		}catch (Exception e) {
			// TODO: handle exception
 			logger.error("JedisUtil ------  flushDB(int indexDb) ------ 异常："+e.getMessage());
		}
 		return null;
 	}
 	
 	/**
 	 * 给一个key设定有效时间
 	 * @param key
 	 * @param seconds
 	 * @return
 	 */
 	public static long setExpire(String key,int seconds){
 		try(Jedis Jedis = getJedisConnection(Constant.DF_CACHE_DB)){
 			return Jedis.expire(key, seconds);
 		}catch (Exception e) {
			// TODO: handle exception
 			logger.error("JedisUtil ------  flushDB(int indexDb) ------ 异常："+e.getMessage());
		}
 		return 0L;
 	}
 	
 	
 	/**
 	 * 查询
 	 * @param keyLike
 	 * @param db
 	 * @return
 	 */
 	public static Set<String> getKeyCount(String keyLike,int db){
 		try(Jedis jedis = getJedisConnection(db)){
 			Set<String> all = jedis.keys(keyLike);
 			return all;
 		}catch (Exception e) {
			// TODO: handle exception
 			logger.error("JedisUtil ------  getKeyCount(String key,int db) ------ 异常："+e.getMessage());
		}
 		return null;
 	}
 	
 	/**
 	 * 查询
 	 * @param keySet
 	 * @param db
 	 * @return
 	 */
 	public static List<String> getKeyCount(Set<String> keySet,int db){
 		try(Jedis jedis = getJedisConnection(db)){
 			List<String> list = jedis.mget(keySet.toArray(new String[0]));
 			return list;
 		}catch (Exception e) {
			// TODO: handle exception
 			logger.error("JedisUtil ------  getKeyCount(String key,int db) ------ 异常："+e.getMessage());
		}
 		return null;
 	}
 	
 	public static void main(String[] args) {
 		Jedis jedis = getJedisConnectionXml(0);
 		String ss = jedis.get("abc");
 		System.out.println(ss);
	}
}
