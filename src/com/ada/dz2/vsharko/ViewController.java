package com.ada.dz2.vsharko;

import java.util.*;

public class ViewController {

    private Scanner sc;
    private Controller controller;

    public void startFunction(){
        sc = new Scanner(System.in);
        controller = new Controller();

        String inputCRUD;

        //Create while
        while (true) {

            System.out.println("\n\nINSTRUCTION: Type \"STOP\" when your done with task\n\n " +
                    "Press:\tc to create\n\t\tr to read\n\t\tu to update\n\t\td to delete");

            inputCRUD = sc.nextLine();
            if (inputCRUD.equals("STOP")) break;

            switch (inputCRUD){
                case "c" : createFunction();
                    break;
                case "r" : readFunction();
                    break;
                case "u" : updateFunction();
                break;
                case "d" : deleteFunction();
                    break;
                default: System.out.print("Wrong input key, try again!");
            }


        }
    }

    public void createFunction() {

        while (true) {
            String inputCREATE = "";
            System.out.println("What would you like to create\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
            inputCREATE = sc.nextLine();
            if (inputCREATE.equals("STOP")) break;

            switch (inputCREATE) {
                case "c":
                    controller.createCategory();
                    break;
                case "a":
                    controller.createAuthor();
                    break;
                case "n":
                    controller.createNews();
            }
        }
    }

    public void readFunction() {
        while (true) {
            String inputREAD = "";
            System.out.println("What would you like to read?\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
            inputREAD = sc.nextLine();
            if (inputREAD.equals("STOP")) break;

            switch (inputREAD) {
                case "c":
                    controller.readCategory();
                    break;
                case "a":
                    controller.readAuthor();
                    break;
                case "n":
                    controller.readNews();
                    break;
                default:
                    System.out.print("Wrong input key, try again!");
            }
        }
    }


    public void deleteFunction() {
        sc = new Scanner(System.in);
        while (true) {
            String inputDELETE = "";
            System.out.println("What would you like to delete\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
            inputDELETE = sc.nextLine();
            if (inputDELETE.equals("STOP")) break;

            switch (inputDELETE) {

                case "c":
                    controller.deleteCategory();
                    break;
                case "a":
                    controller.deleteAuthor();
                    break;
                case "n":
                    controller.deleteNews();
                    break;
                default:
                    System.out.print("Wrong input key, try again!");

            }
        }
    }

    public void updateFunction() {

        while (true) {
            String inputUPDATE= "";
            System.out.println("What would you like to update\n\nPress:\tc for Category\n\t\tn to News\n\t\ta to Author");
            inputUPDATE = sc.nextLine();
            if (inputUPDATE.equals("STOP")) break;

            switch (inputUPDATE) {
                case "c":
                    controller.updateCategory();
                    break;
                case "a":
                    controller.updateAuthor();
                    break;
                case "n":
                    controller.updateNews();
            }
        }
    }
}
//još update komplet funkcijonalnost, sortiranje za izlistavanje i to je to.
