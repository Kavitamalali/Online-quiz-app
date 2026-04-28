package com.quizapp.dao;

import com.quizapp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
}