package com.ZDF.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ���ɶ�����Ź�����
 * ���ɹ���Ϊ��������ʱ����+�û�ID��ǰ��λ+2λ�����
 * @author cdk
 * @date 2018��8��6��
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
			userId = userId.substring(0, 2);//����û�id���ȴ�����λ�ͽ�ȡǰ��λ
		}
		//������λ�����
		int randomCode = (int)(Math.random()*99);
		while(true){
			if(randomCode>=0 && randomCode<=9)
				  randomCode = (int)(Math.random()*99);//����0-99֮����������
			else
				break;
		}
		return df.format(day)+userId+randomCode;
	}
}
