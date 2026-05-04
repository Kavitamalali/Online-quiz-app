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
        System.out.println("4. Add Question");
        System.out.println("5. Take Quiz");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.println("Enter username:");
            String username = sc.nextLine();

            System.out.println("Enter password:");
            String password = sc.nextLine();

            User user = new User(username, password);
            UserDAO.registerUser(user);

        } 
        else if (choice == 2) {
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
        } 
        else if (choice == 3) {
            System.out.println("Enter quiz title:");
            String title = sc.nextLine();

            QuizDAO.addQuiz(title);
        } 
        else if (choice == 4) {
            System.out.println("Enter quiz ID:");
            int quizId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter question:");
            String question = sc.nextLine();

            System.out.println("Option 1:");
            String op1 = sc.nextLine();

            System.out.println("Option 2:");
            String op2 = sc.nextLine();

            System.out.println("Option 3:");
            String op3 = sc.nextLine();

            System.out.println("Option 4:");
            String op4 = sc.nextLine();

            System.out.println("Correct answer (1-4):");
            int ans = sc.nextInt();

            QuizDAO.addQuestion(quizId, question, op1, op2, op3, op4, ans);
        } 
        else if (choice == 5) {
        	System.out.println("Enter username:");
        	String username = sc.nextLine();
        	
        	System.out.println("Enter quiz ID:");
        	int quizId = sc.nextInt();
        	
        	QuizDAO.takeQuiz(quizId, username);
        }
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}