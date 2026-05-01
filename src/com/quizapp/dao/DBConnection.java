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

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}