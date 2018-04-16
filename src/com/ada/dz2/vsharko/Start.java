/*package com.ada.dz2.vsharko;

import java.util.*;


public class Start {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> categoryList = new LinkedList<>();
        List<String> authorList = new LinkedList<>();
        List<News> newsList = new LinkedList<>();
        String inputCRUD="";
        String inputCREATE="";
        categoryList.clear();
        authorList.clear();
        newsList.clear();

        //CRUD while
        while(true) {
            System.out.println("\n\nPress:\tc to create\n\t\tr to read\n\t\tu to update\n\t\td to delete");
            inputCRUD = sc.nextLine();
            if(inputCRUD.equals("STOP"))break;
            //Create while
            if (inputCRUD.equals("c")) {
                while (inputCREATE.equals("")) {
                    System.out.println("What you would like to create\n\nPress:\tc for category\n\t\tn to News\n\t\ta to Author");
                    inputCREATE = sc.nextLine();
                    //create news while
                    if (inputCREATE.equals("n")) {
                        while (true){

                            String text = "";
                            List<String> category = new LinkedList<>();
                            String author;

                            System.out.println("Enter News text: ");
                            text = sc.nextLine();
                            if (text.equals("STOP")) break;
                            System.out.println("Enter Categories separated with one column");
                            String[] tokens = sc.nextLine().split(",");
                            for (String token : tokens) {
                                category.add(token);
                                if (!categoryList.contains(token)) {
                                    categoryList.add(token);
                                }
                            }

                            System.out.println("Enter Author: ");
                            author = sc.nextLine();
                            String thisAuthor = author;
                            if (!authorList.contains(thisAuthor)) {
                                authorList.add(thisAuthor);
                            }


                            newsList.add(new News(text, category, author));

                        }
                    //create category while
                    }else if (inputCREATE.equals("c")){

                    //create author while
                    }else if (inputCREATE.equals("a")){

                    }else{
                        System.out.println("Wrong input!");
                    }
                    break;
                }
            }
            if (inputCRUD.equals("r")) {
                    System.out.println("\n\t\t\tAuthor\t\t\tCategory\t\t\tDate");
                for (News element : newsList) {
                    System.out.println(element.toString());
                }
            }
        }
    }
}
*/

