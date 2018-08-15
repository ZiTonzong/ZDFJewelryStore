package com.ZDF.utils;

import java.sql.*;
import java.util.UUID;
/*
 * 封装一个类，用于连接数据库
 */
public class Basedao {
	private static String driver = "com.mysql.jdbc.Driver";	//数据库驱动
	private static String url = "jdbc:mysql://localhost:3306/zdfjewelrystore";		//数据库路径，找到对应的数据库
	private static String user = "root";		//数据库账号
	private static String password = "12345678";	//数据库密码
	
	/*
	 * 连接数据库的方法
	 */
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName(driver);		//加载数据库驱动
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("测试数据库加载成功");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败");
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		} 		
		return conn;
	}
	
	/*
	 *关闭数据库的方法 
	 */
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if (rs != null) {	//关闭资源，避免出现异常
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 图片上传的方法
	 */
	/*public String picName() {
		// 图片上传
		// 设置图片名称，不能重复，可以使用uuid
		String picName = UUID.randomUUID().toString();
		// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// 开始上传
		pictureFile.transferTo(new File("C:/upload/image/" + picName + extName));
		
	}*/
}
