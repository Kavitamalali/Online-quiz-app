package com.quizapp;

import java.util.Scanner;
import com.quizapp.dao.UserDAO;
import com.quizapp.model.User;
import com.quizapp.dao.QuizDAO;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Create Quiz");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Enter username:");
            String username = sc.nextLine();

            System.out.println("Enter password:");
            String password = sc.nextLine();

            User user = new User(username, password);
            UserDAO.registerUser(user);

        } else if (choice == 2) {
            System.out.println("Enter username:");
            String username = sc.nextLine();

            System.out.println("Enter password:");
            String password = sc.nextLine();

            boolean result = UserDAO.loginUser(username, password);

            if (result) {
                System.out.println("Welcome " + username);
                
            } else { 
            	System.out.println("Login failed");
            }
        } else if (choice == 3) {
        	System.out.println("Enter quiz title:");
            String title = sc.nextLine();

            QuizDAO.addQuiz(title);
           } else {
                System.out.println("Invalid choice");
           }
    }
}
          