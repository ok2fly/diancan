package com.gcfd.common.util;

import org.apache.ibatis.cache.CacheException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @类名：SerializeUtil.java
 * @作者：one
 * @时间：2016年07月09日08:44:30
 * @版权：pengkaione@icloud.com
 * @描述： 
 */
public final class SerializeUtil {

	public static byte[] serialize(Object object) {
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);){
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	public static Object unserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		try(ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);) {
			return ois.readObject();
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

}
