package com.ada.dz2.vsharko;


//Create a CMS using console interface. Types used: Author, Category, News.
//Program enables CRUD on each type, list news by categories, authors and dates of news.
//One news can be in many categories.

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);

        String inputCRUD;

        //Create while
        while (true) {

            System.out.println("\n\nINSTRUCTION: Type \"STOP\" when your done with task\n\n " +
                    "Press:\tc to create\n\t\tr to read\n\t\tu to update\n\t\td to delete");

            inputCRUD = sc.nextLine();
            if (inputCRUD.equals("STOP")) break;

            switch (inputCRUD){
                case "c" : controller.createFunction();
                break;
                case "r" : controller.readFunction();
                break;
                /*case "u" : controller.updateFunction();
                break;*/
                case "d" : controller.deleteFunction();
                break;
                default: System.out.print("Wrong input key, try again!");
            }


        }
    }
}
