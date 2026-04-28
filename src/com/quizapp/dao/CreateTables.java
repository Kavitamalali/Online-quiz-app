package com.quizapp.dao;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    public static void createTables() {
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            // Users table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT," +
                    "password TEXT)");

            // Quiz table
            stmt.execute("CREATE TABLE IF NOT EXISTS quiz (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT)");

            // Questions table
            stmt.execute("CREATE TABLE IF NOT EXISTS questions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "quiz_id INTEGER," +
                    "question TEXT," +
                    "option1 TEXT," +
                    "option2 TEXT," +
                    "option3 TEXT," +
                    "option4 TEXT," +
                    "correct_answer INTEGER)");

            // Results table
            stmt.execute("CREATE TABLE IF NOT EXISTS results (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "user_id INTEGER," +
                    "quiz_id INTEGER," +
                    "score INTEGER)");

            System.out.println("Tables created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}