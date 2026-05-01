package com.quizapp.dao;

import com.quizapp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static void registerUser(User user) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ps.executeUpdate();

            System.out.println("User registered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Login user
    public static boolean loginUser(String username, String password) {
    	try {
    		Connection conn = DBConnection.getConnection();
    		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1,  username);
    		ps.setString(2,  password);
    		ResultSet rs = ps.executeQuery();
    		if (rs.next()) {
    			System.out.println("Login successful");
    			return true;
    		} else {
    			System.out.println("Invalid credentials");
    			return false;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
}