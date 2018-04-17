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
        String inputCREATE="";
        String inputREAD="";
        String inputDELETE="";

        //CRUD while
        while(true) {

            System.out.println("\n\nINSTRUCTION: Type \"STOP\" when your done with task\n\n " +
                    "Press:\tc to create\n\t\tr to read\n\t\tu to update\n\t\td to delete");
            inputCRUD = sc.nextLine();

            if(inputCRUD.equals("STOP"))break;

            //Create while
            if (inputCRUD.equals("c")) {

                while (inputCREATE.equals("")) {
                    System.out.println("What would you like to create\n\nPress:\tc for category\n\t\tn to News\n\t\ta to Author");
                    inputCREATE = sc.nextLine();


                    //create news while
                    if (inputCREATE.equals("n")){
                        while (true){

                            String text = "";
                            List<String> category = new LinkedList<>();
                            String author;

                            System.out.println("Enter News text: ");
                            text = sc.nextLine();
                            if (text.equals("STOP")) break;
                            System.out.println("Enter Categories separated with one column");
                            String[] tokens = sc.nextLine().split(",");
                            Collections.addAll(category,tokens);
                            System.out.println("Enter Author: ");
                            author = sc.nextLine();
                            database.createNews(text, author,category);

                        }

                        //create category while
                    }else if (inputCREATE.equals("a")){

                        while (true){

                            String author;
                            System.out.println("Enter Author: ");
                            author = sc.nextLine();
                            if (author.equals("STOP")) break;
                            database.createAuthor(author);

                        }

                        //create author while
                    }else if (inputCREATE.equals("c")){

                        while (true) {

                            String category;
                            System.out.println("Enter Category: ");
                            category = sc.nextLine();
                            if (category.equals("STOP")) break;
                            database.createCategory(category);

                        }

                    }else{
                        break;

                    }

                }
            }
            if (inputCRUD.equals("r")) {

                while (true) {

                    System.out.println("What you would like to read\n\nPress:\tc for categorys\n\t\tn to News\n\t\ta to Authors");
                    inputREAD = sc.nextLine();
                    if(inputREAD.equals("c")){

                        database.getCategories();
                        break;

                    }else if(inputREAD.equals("n")){

                        database.getNews();
                        break;

                    }else if(inputREAD.equals("a")){

                        database.getAuthors();
                        break;

                    }else{

                        System.out.println("Wrong input! try again");
                        break;

                    }

                }

            }

            if (inputCRUD.equals("d")) {

                while (true) {

                    System.out.println("What would you like to delete\n\nPress:\tc for categorys\n\t\tn to News\n\t\ta to Authors");
                    inputDELETE = sc.nextLine();
                    if(inputDELETE.equals("c")){

                        database.getCategories();
                        while (true){

                            System.out.println("Enter index of category to delete");
                            inputDELETE = sc.nextLine();
                            if (inputDELETE.equals("STOP"))break;

                            if (inputDELETE.matches("\\d")){
                                database.deleteCategory(Integer.parseInt(inputDELETE));
                                break;
                            }else{
                                System.out.println("You need to enter a number, or STOP to go back.");
                            }

                        }

                    }else if(inputREAD.equals("n")){

                        database.getNews();
                        break;

                    }else if(inputREAD.equals("a")){

                        database.getAuthors();
                        break;

                    }else{

                        System.out.println("Wrong input! try again");
                        break;

                    }

                }

            }

            inputCREATE="";
            //inputCRUD="";
            inputREAD="";

        }

    }
}
