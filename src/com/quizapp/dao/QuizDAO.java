package com.quizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuizDAO {

    public static void addQuiz(String title) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO quiz (title) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, title);
            ps.executeUpdate();

            System.out.println("Quiz added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}