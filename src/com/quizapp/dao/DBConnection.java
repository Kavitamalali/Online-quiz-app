package com.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:quiz.db");
            System.out.println("Connected to database");

            // Create tables
            Statement stmt = conn.createStatement();

            // Users table
            String usersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT, " +
                    "password TEXT)";

            stmt.execute(usersTable);

            // Quiz table
            String quizTable = "CREATE TABLE IF NOT EXISTS quiz (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "title TEXT)";

            stmt.execute(quizTable);
            
            // Question Table
            String questionTable = "CREATE TABLE IF NOT EXISTS questions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "quiz_id INTEGER, " +
                    "question TEXT, " +
                    "option1 TEXT, " +
                    "option2 TEXT, " +
                    "option3 TEXT, " +
                    "option4 TEXT, " +
                    "correct_answer INTEGER)";

            stmt.execute(questionTable);
            
            // Result Table
            String resultTable = "CREATE TABLE IF NOT EXISTS results (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT, " +
                    "quiz_id INTEGER, " +
                    "score INTEGER)";

            stmt.execute(resultTable);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}