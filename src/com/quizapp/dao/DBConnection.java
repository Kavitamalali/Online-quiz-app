package com.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:quiz.db");
			System.out.println("Connected to databasse");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
