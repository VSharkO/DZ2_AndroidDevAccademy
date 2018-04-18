package com.ada.dz2new.vsharko;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class dbWannabe {
    private Set<Author> authors = new HashSet<>();
    private List<News> news = new LinkedList<>();
    private Set<Category> categories = new HashSet<>();

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public List<News> getNews(){
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void createCategory(Category category){

        this.categories.add(category);
    }
    public void createAuthor(Author author){
        this.authors.add(author);
    }
    public void createNews(News news) {
        this.news.add(news);
    }
    public void readCategories(){
        int i=1;
        for (Category element : categories) {

            System.out.println(i+". "+element.getName());
            i++;

        }
    }
    public void readNews(){
        int i=1;
        for (News element : news) {
            String ovaj = element.toString();
            System.out.println(i+". "+ovaj);
            i++;

        }
    }
    public void readAuthor(){
        int i=1;

        for (Author element : authors) {

            System.out.println(i+". "+element.getName());
            i++;

        }
    }
}
