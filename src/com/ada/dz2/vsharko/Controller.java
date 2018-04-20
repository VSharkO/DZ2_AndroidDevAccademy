package com.ada.dz2.vsharko;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Controller {
    Scanner sc;
    dbWannabe database;

    public Controller(){
        database = new dbWannabe();
    }

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
        sc = new Scanner(System.in);
        while (true) {

            String author;
            System.out.println("Enter Author: ");
            author = sc.nextLine();
            if (author.equals("STOP")) break;

            database.createAuthor(new Author(author));
        }
    }

    public News createNews() {
        sc = new Scanner(System.in);
        News news=null;
        String text = "";
        Set<Category> category = new HashSet<>();
        Author author;

        System.out.println("Enter News text: ");
        text = sc.nextLine();
        System.out.println("Enter Category separated with one column");
        String categoryText = sc.nextLine();
        String[] tokens = categoryText.split(",");
        for (String token : tokens) {
            category.add(new Category(token));
            database.createCategory(new Category(token));
        }
            System.out.println("Enter Author: ");
            author = new Author(sc.nextLine());

            database.createAuthor(author);

            news = new News(text, author, category);

            database.createNews(news);

        return news;
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
        int index;
        readNews();
        String inputDELETE = "";
        System.out.print("Enter the index of News that u want to delete: ");
        inputDELETE = sc.nextLine();
        index=Integer.parseInt(inputDELETE)-1;
        if (inputDELETE.matches("\\d") && index>0) {
            database.deleteNews(index);
        }else{
            System.out.println("Wrong input! Try again!");
        }

    }

    public void updateCategory() {
        sc = new Scanner(System.in);
        readCategory();
        String inputUPDATE = "";
        String inputNEW = "";
        System.out.print("Enter the name of category that u want to update: ");
        inputUPDATE = sc.nextLine();
        System.out.print("Enter new name of category: ");
        inputNEW = sc.nextLine();
        database.updateCategory(inputUPDATE,inputNEW);
    }



    public void updateAuthor() {
        sc = new Scanner(System.in);
        readAuthor();
        String inputUPDATE = "";
        String inputNEW = "";
        System.out.print("Enter the name of author that u want to update: ");
        inputUPDATE = sc.nextLine();
        System.out.print("Enter new name of author: ");
        inputNEW = sc.nextLine();
        database.updateAuthor(inputUPDATE,inputNEW);
    }

    public void updateNews() {
        sc = new Scanner(System.in);
        int index;
        readNews();
        String inputUPDATE = "";
        System.out.print("Enter the index of News that u want to update: ");
        inputUPDATE = sc.nextLine();
        index=Integer.parseInt(inputUPDATE)-1;
        if (inputUPDATE.matches("\\d") && index>0) {
            News news = createNews();
            database.updateNews(index,news);
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
