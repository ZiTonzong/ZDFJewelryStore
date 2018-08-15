package com.ZDF.utils;

import java.sql.*;
import java.util.UUID;
/*
 * ��װһ���࣬�����������ݿ�
 */
public class Basedao {
	private static String driver = "com.mysql.jdbc.Driver";	//���ݿ�����
	private static String url = "jdbc:mysql://localhost:3306/zdfjewelrystore";		//���ݿ�·�����ҵ���Ӧ�����ݿ�
	private static String user = "root";		//���ݿ��˺�
	private static String password = "12345678";	//���ݿ�����
	
	/*
	 * �������ݿ�ķ���
	 */
	public static Connection getCon() {
		Connection conn = null;
		try {
			Class.forName(driver);		//�������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("�������ݿ���سɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������ʧ��");
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
		} 		
		return conn;
	}
	
	/*
	 *�ر����ݿ�ķ��� 
	 */
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		if (rs != null) {	//�ر���Դ����������쳣
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
	 * ͼƬ�ϴ��ķ���
	 */
	/*public String picName() {
		// ͼƬ�ϴ�
		// ����ͼƬ���ƣ������ظ�������ʹ��uuid
		String picName = UUID.randomUUID().toString();
		// ��ȡ�ļ���
		String oriName = pictureFile.getOriginalFilename();
		// ��ȡͼƬ��׺
		String extName = oriName.substring(oriName.lastIndexOf("."));

		// ��ʼ�ϴ�
		pictureFile.transferTo(new File("C:/upload/image/" + picName + extName));
		
	}*/
}
