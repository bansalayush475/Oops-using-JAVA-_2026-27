package com.library.service;

import java.io.*;
import java.util.*;
import com.library.exception.*;

public class LibraryService {

    String file = "books.txt";

    public void addBook(int id, String title, String author, int copies) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            bw.write(id + "," + title + "," + author + "," + copies);
            bw.newLine();

            bw.close();

            System.out.println("Book added successfully");

        } catch (Exception e) {
            System.out.println("File Error");
        }
    }

    public void viewBooks() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                System.out.println("ID: " + data[0] +
                        " Title: " + data[1] +
                        " Author: " + data[2] +
                        " Copies: " + data[3]);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("File Error");
        }
    }

    public void issueBook(int bookId)
            throws BookNotFoundException, BookNotAvailableException {

        List<String> list = new ArrayList<>();
        boolean found = false;

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                int id = Integer.parseInt(data[0]);
                int copies = Integer.parseInt(data[3]);

                if (id == bookId) {

                    found = true;

                    if (copies == 0)
                        throw new BookNotAvailableException("Book not available");

                    copies--;

                    line = id + "," + data[1] + "," + data[2] + "," + copies;

                    System.out.println("Book Issued");
                }

                list.add(line);
            }

            br.close();

            if (!found)
                throw new BookNotFoundException("Book not found");

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }

    public void returnBook(int bookId) throws BookNotFoundException {

        List<String> list = new ArrayList<>();
        boolean found = false;

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                int id = Integer.parseInt(data[0]);
                int copies = Integer.parseInt(data[3]);

                if (id == bookId) {

                    found = true;

                    copies++;

                    line = id + "," + data[1] + "," + data[2] + "," + copies;

                    System.out.println("Book Returned");
                }

                list.add(line);
            }

            br.close();

            if (!found)
                throw new BookNotFoundException("Book not found");

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }
}