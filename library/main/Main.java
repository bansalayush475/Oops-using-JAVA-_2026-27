package com.library.main;

import java.util.Scanner;
import com.library.service.LibraryService;
import com.library.exception.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        int choice;

        do {

            System.out.println("\n1 Add Book");
            System.out.println("2 View Books");
            System.out.println("3 Issue Book");
            System.out.println("4 Return Book");
            System.out.println("5 Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Copies: ");
                        int copies = sc.nextInt();

                        service.addBook(id, title, author, copies);
                        break;

                    case 2:
                        service.viewBooks();
                        break;

                    case 3:

                        System.out.print("Enter Book ID to Issue: ");
                        int issue = sc.nextInt();

                        service.issueBook(issue);
                        break;

                    case 4:

                        System.out.print("Enter Book ID to Return: ");
                        int ret = sc.nextInt();

                        service.returnBook(ret);
                        break;

                }

            } catch (BookNotFoundException | BookNotAvailableException e) {

                System.out.println(e.getMessage());
            }

        } while (choice != 5);

        sc.close();
    }
}