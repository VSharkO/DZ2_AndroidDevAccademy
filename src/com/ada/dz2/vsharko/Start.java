package com.ada.dz2.vsharko;


//Create a CMS using console interface. Types used: Author, Category, News.
//Program enables CRUD on each type, list news by categories, authors and dates of news.
//One news can be in many categories.

public class Start {
    public static void main(String[] args) {
        ViewController viewController = new ViewController();
        viewController.startFunction();
    }
}
