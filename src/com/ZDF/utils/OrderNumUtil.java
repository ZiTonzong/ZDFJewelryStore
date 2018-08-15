package com.ZDF.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 生成订单编号工具类
 * 生成规则为：年月日时分秒+用户ID的前两位+2位随机码
 * @author cdk
 * @date 2018年8月6日
 */
public class OrderNumUtil {
	public static String getOrderNum(String userId){
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		//System.out.println(df.format(day));  
		if(userId.length()==1){
			userId = "0" + userId;
		}
		if(userId.length()>2){
			userId = userId.substring(0, 2);//如果用户id长度大于两位就截取前两位
		}
		//生成两位随机码
		int randomCode = (int)(Math.random()*99);
		while(true){
			if(randomCode>=0 && randomCode<=9)
				  randomCode = (int)(Math.random()*99);//生成0-99之间的随机整数
			else
				break;
		}
		return df.format(day)+userId+randomCode;
	}
}
