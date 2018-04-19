package com.ada.dz2.vsharko;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Controller {
    Scanner sc;
    dbWannabe database;

    public void createCategory() {
        sc = new Scanner(System.in);
        String category;
        while (true) {
            System.out.println("Enter Category: ");
            category = sc.nextLine();
            if (category.equals("STOP")) break;

            database.createCategory(new Category(category));

        }
    }

    public void createAuthor() {
        while (true) {
            sc = new Scanner(System.in);
            String author;
            System.out.println("Enter Author: ");
            author = sc.nextLine();
            if (author.equals("STOP")) break;

            database.createAuthor(new Author(author));
        }
    }

    public void createNews() {
        while (true) {

            String text = "";
            Set<Category> category = new HashSet<>();
            Author author;

            System.out.println("Enter News text: ");
            text = sc.nextLine();
            if (text.equals("STOP")) break;

            System.out.println("Enter Category separated with one column");
            String categoryText = sc.nextLine();
            String[] tokens = categoryText.split(",");
            for (String token : tokens) {
                category.add(new Category(token));
                database.createCategory(new Category(token));
            }

            System.out.println("Enter Author: ");
            author = new Author(sc.nextLine());
            News news = new News(text, author, category);
            database.createAuthor(author);
            database.createNews(news);
        }
    }

    public void deleteCategory() {
        sc = new Scanner(System.in);
        readCategory();
        System.out.print("Enter the name of category that u want to delete: ");
        database.deleteCategory(sc.nextLine());
    }

    public void deleteAuthor() {
        sc = new Scanner(System.in);
        readAuthor();
        System.out.print("Enter the name of Author that u want to delete: ");
        database.deleteAuthor(sc.nextLine());
    }

    public void deleteNews() {
        sc = new Scanner(System.in);
        readNews();
        String inputDELETE = "";
        System.out.print("Enter the index of News that u want to delete: ");
        inputDELETE = sc.nextLine();
        if (inputDELETE.matches("\\d") && Integer.parseInt(inputDELETE)>0) {
            database.deleteNews(Integer.parseInt(inputDELETE));
        }else{
            System.out.println("Wrong input! Try again!");
        }
    }

    public void readCategory() {
        database.readCategories();
    }

    public void readAuthor() {
        database.readAuthor();
    }

    public void readNews() {
        database.readNews();
    }



}
