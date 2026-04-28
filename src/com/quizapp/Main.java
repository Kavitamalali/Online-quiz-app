package com.quizapp;

import com.quizapp.dao.UserDAO;
import com.quizapp.model.User;

public class Main {
    public static void main(String[] args) {

        User user = new User("testuser", "pass");
        UserDAO.registerUser(user);

    }
}