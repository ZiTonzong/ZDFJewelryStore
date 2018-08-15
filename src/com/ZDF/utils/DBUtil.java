package com.ZDF.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Properties properties = new Properties();
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	static{
		//º”‘ÿ≈‰÷√Œƒº˛
		try {
			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			Class.forName(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(url,username,password);
		return connection;
	}
}
