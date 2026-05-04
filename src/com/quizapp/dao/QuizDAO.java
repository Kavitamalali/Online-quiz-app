package com.quizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuizDAO {

    // Add Quiz
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

    // Add Question
    public static void addQuestion(int quizId, String question,
                                   String op1, String op2,
                                   String op3, String op4,
                                   int correctAns) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO questions (quiz_id, question, option1, option2, option3, option4, correct_answer) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, quizId);
            ps.setString(2, question);
            ps.setString(3, op1);
            ps.setString(4, op2);
            ps.setString(5, op3);
            ps.setString(6, op4);
            ps.setInt(7, correctAns);

            ps.executeUpdate();

            System.out.println("Question added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Take Quiz
    public static void takeQuiz(int quizId, String username) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM questions WHERE quiz_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, quizId);

            ResultSet rs = ps.executeQuery();

            int score = 0;
            int total = 0;

            java.util.Scanner sc = new java.util.Scanner(System.in);

            while (rs.next()) {
                total++;

                System.out.println("\nQuestion: " + rs.getString("question"));
                System.out.println("1. " + rs.getString("option1"));
                System.out.println("2. " + rs.getString("option2"));
                System.out.println("3. " + rs.getString("option3"));
                System.out.println("4. " + rs.getString("option4"));

                System.out.print("Enter your answer: ");
                int userAns = sc.nextInt();

                int correct = rs.getInt("correct_answer");

                if (userAns == correct) {
                    System.out.println("Correct ✅");
                    score++;
                } else {
                    System.out.println("Wrong ❌");
                }
            }

            System.out.println("\nYour Score: " + score + "/" + total);
            
            String insert = "INSERT INTO results (username, quiz_id, score) VALUES (?, ?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(insert);

            ps2.setString(1, username);
            ps2.setInt(2, quizId);
            ps2.setInt(3, score);

            ps2.executeUpdate();

            System.out.println("Score saved successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}