package com.lord.advertis.utils;

import java.util.UUID;

/**
 * UUID
 * @author WangShiCong
 * @since 2017-11-8
 * @version 1.0
 */
public class UUIDUtil{
    
	public static String generate(){
		String uuidString = UUID.randomUUID().toString();
		String idString = uuidString.replace("-","");
		return idString;
	}
}
