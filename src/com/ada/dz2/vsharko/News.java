package com.ada.dz2.vsharko;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class News{

    private String text;
    private Author author;
    private Set<Category> categories;
    private String date;


    public News(String text, Author author, Set<Category> categories){

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date thisDate = new Date();
        date=dateFormat.format(thisDate);
        this.text = text;
        this.author = author;
        this.categories = categories;

    }

    public List<String> getNameCategories() {

        List<String> categoriesNames = new LinkedList<>();
        for (Category element:categories) {

            categoriesNames.add(element.getName());

        }
        return categoriesNames;

    }

    public void setCategoriesNames(List<String> categories) {

        Set<Category> cat= new HashSet<>();
        for (String name:categories) {

            Category nameCat = new Category(name);
            cat.add(nameCat);
            this.categories = cat;

        }

    }

    @Override
    public String toString(){

        String newsToString;
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (Category element:categories) {

            sb.append(element.getName());
            if(i<categories.size()-1)sb.append(",");
                i++;

        }
        newsToString="AUTHOR: "+this.author.getName()+"\t\tCATEGORY: "+sb.toString()+"\t\tDATE: "+this.date+"\t\tNEWS: "+this.text;
        return newsToString;

    }

    public Author getAuthor() {
        return author;
    }

}
