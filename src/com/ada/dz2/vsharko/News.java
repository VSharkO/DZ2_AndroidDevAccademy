package com.ada.dz2.vsharko;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class News {

    private String text;
    private List<String> category;
    private String author;
    private String date;

    public News(String text, List<String> category, String autor) {

        this.text = text;
        this.category = category;
        this.author = autor;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date thisDate = new Date();
        date=dateFormat.format(thisDate);

    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<category.size();i++) {
            sb.append(category.get(i));
            if (i<category.size()-1)
            sb.append(",");
        }

        return sb.toString();
    }


    public String toString(){


        return ("\n\t\t"+getAuthor() + "\t\t" + getCategory() + "\t\t"+ getDate());
    }
}
