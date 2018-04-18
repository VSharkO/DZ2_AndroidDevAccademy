package com.ada.dz2.vsharko;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Create a CMS using console interface. Types used: Author, Category, News.
//Program enables CRUD on each type, list news by categories, authors and dates of news.
//One news can be in many categories.

public class Test {
    public static void main(String[] args) {

        dbWannabe database = new dbWannabe();
        Scanner sc = new Scanner(System.in);
        String inputCRUD;
        String inputCREATE = "";
        String inputREAD = "";
        String inputUPDATE = "";
        String inputDELETE = "";

        //CRUD while
        while (true) {

            System.out.println("\n\nINSTRUCTION: Type \"STOP\" when your done with task\n\n " +
                    "Press:\tc to create\n\t\tr to read\n\t\tu to update\n\t\td to delete");

            inputCRUD = sc.nextLine();
            if (inputCRUD.equals("STOP")) break;

            //Create while
            if (inputCRUD.equals("c")) {
                while (true) {

                    System.out.println("What would you like to create\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
                    inputCREATE = sc.nextLine();
                    if (inputCREATE.equals("STOP")) break;

                    //create news while
                    if (inputCREATE.equals("n")) {
                        while (true) {

                            String text = "";
                            List<String> category = new LinkedList<>();
                            String author="";

                            System.out.println("Enter News text: ");
                            text = sc.nextLine();
                            if (text.equals("STOP")) break;

                            System.out.println("Enter Category separated with one column");
                            String categoryText = sc.nextLine();

                            if(categoryText.contains(",")) {
                                String[] tokens = categoryText.split(",");
                                Collections.addAll(category, tokens);
                            }else {
                                category.add(categoryText);
                            }
                            System.out.println("Enter Author: ");
                            author = sc.nextLine();

                            database.createNews(text, author, category);

                        }

                        //create category while
                    } else if (inputCREATE.equals("a")) {

                        while (true) {

                            String author;
                            System.out.println("Enter Author: ");
                            author = sc.nextLine();
                            if (author.equals("STOP")) break;

                            database.createAuthor(author);

                        }

                        //create author while
                    } else if (inputCREATE.equals("c")) {

                        while (true) {

                            String category;
                            System.out.println("Enter Category: ");
                            category = sc.nextLine();
                            if (category.equals("STOP")) break;

                            database.createCategory(category);

                        }

                    } else break;

                }
            }
            if (inputCRUD.equals("r")) {

                while (true) {

                    System.out.println("What you would like to read\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
                    inputREAD = sc.nextLine();
                    if(inputREAD.equals("STOP"))break;

                    if (inputREAD.equals("c")) {

                        database.getCategories();

                    } else if (inputREAD.equals("n")) {

                        database.getNews();

                        while (true){

                            System.out.println("Which news you want to read?");
                            inputREAD = sc.nextLine();
                            if (inputREAD.equals("STOP")) break;

                            database.getNewsText(Integer.parseInt(inputREAD));

                        }
                    } else if (inputREAD.equals("a")) {

                        database.getAuthors();

                    } else {

                        System.out.println("Wrong input! try again");
                    }

                }

            }

            if (inputCRUD.equals("d")) {

                while (true) {

                    System.out.println("What would you like to delete\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
                    inputDELETE = sc.nextLine();
                    if (inputDELETE.equals("STOP"))break;

                    if (inputDELETE.equals("c")) {
                        database.getCategories();
                        while (true) {

                            System.out.println("Enter index of category to delete");
                            inputDELETE = sc.nextLine();
                            if (inputDELETE.equals("STOP")) break;

                            if (inputDELETE.matches("\\d")) {
                                database.deleteCategory(Integer.parseInt(inputDELETE));
                            } else {
                                System.out.println("You need to enter a number, or STOP to go back.");
                            }

                        }

                    } else if (inputDELETE.equals("n")) {

                        database.getNews();
                        while (true) {

                            System.out.println("Enter index of News to delete");
                            inputDELETE = sc.nextLine();
                            if (inputDELETE.equals("STOP")) break;

                            if (inputDELETE.matches("\\d")) {
                                database.deleteNews(Integer.parseInt(inputDELETE));
                            } else {
                                System.out.println("You need to enter a number, or STOP to go back.");
                            }

                        }

                    } else if (inputDELETE.equals("a")) {

                        database.getAuthors();
                        while (true) {

                            System.out.println("Enter index of Author to delete");
                            inputDELETE = sc.nextLine();
                            if (inputDELETE.equals("STOP")) break;

                            if (inputDELETE.matches("\\d")) {
                                database.deleteAuthor(Integer.parseInt(inputDELETE));

                            } else {
                                System.out.println("You need to enter a number, or STOP to go back.");
                            }
                        }


                    }

                }


            }

        }
    }
}