package com.ustglobal.phonesimulatorapp.phonesimulator_db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Phone_Db {
private  static Connection conn = null;
private static String url = "jdbc:mysql://localhost:3306/contactfile?user=root&password=reshu";
public static Connection getDbConnection() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(url);
	return conn;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
}
