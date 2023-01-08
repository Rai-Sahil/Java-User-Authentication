package org.example;

import org.bson.Document;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String name, password, email;
        System.out.println("Please Type Your Name...");
        name = scan.nextLine();
        System.out.println("Please Type Your Email...");
        email = scan.nextLine();
        System.out.println("Please Type Your Password...");
        password = scan.nextLine();

        DatabaseConnection db = new DatabaseConnection(name, email, password);
        db.connect();




        System.out.println("Hello");
    }
}
