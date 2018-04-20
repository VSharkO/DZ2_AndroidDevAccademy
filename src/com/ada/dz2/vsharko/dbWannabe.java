package com.ada.dz2.vsharko;

import java.util.*;

public class dbWannabe {

    private Set<String> authors = new HashSet<>();
    private List<News> news = new LinkedList<>();
    private Set<String> categories = new HashSet<>();


    public void createCategory(Category category){

        this.categories.add(category.getName());
    }

    public void createAuthor(Author author){
        this.authors.add(author.getName());
    }

    public void createNews(News news) {
        this.news.add(news);
    }

    public void readCategories(){
        int i=1;
        for (String element : categories) {

            System.out.println(i+". "+element);
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

        for (String element : authors) {

            System.out.println(i+". "+element);
            i++;

        }
    }

    public void deleteCategory(String categoryName){
        if(this.categories.contains(categoryName)) {
            boolean isOnlyThatCategory=false;
            List<News> newsToDelete = new LinkedList<>();
            List<String> newCategories;
            for (News item: news) {
                //if in news there is only one category and that category we want to delete,
                // then delete (that)news.
                if (item.getNameCategories().size() == 1 && item.getNameCategories().contains(categoryName)) {
                    isOnlyThatCategory = true;
                    newsToDelete.add(item);
                }
                //delete category from categoriesList
                if (this.categories.contains(categoryName)) {
                    this.categories.remove(categoryName);

                }
                //if its not the only chategory in news, delete that category.
                newCategories = item.getNameCategories();
                newCategories.remove(categoryName);
                item.setCategoriesNames(newCategories);
            }
            if(isOnlyThatCategory){
                news.removeAll(newsToDelete);
            }

        }else{
            System.out.println("There is no Category with that Name, try again!");
        }
    }

    public void deleteAuthor(String authorName){

        List<News> newsToDelete = new LinkedList<>();
        for (News item: news) {

            if (item.getAuthor().getName().equals(authorName)) {
                newsToDelete.add(item);
            }


            this.authors.remove(authorName);
        }
        this.news.removeAll(newsToDelete);

    }

    public void deleteNews(int index){

        this.news.remove(index-1);

    }

    public List<News> getNews(){
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public void updateCategory(String category, String newCategory) {
        List<String> newCategories;

        if(this.categories.contains(category)) {
            this.categories.add(newCategory);

            for (News item: news) {
                //if in news there is only one category and that category we want to delete,
                // then delete (that)news.
                if (item.getNameCategories().contains(category)) {
                    newCategories = item.getNameCategories();
                    newCategories.remove(category);
                    newCategories.add(newCategory);
                    item.setCategoriesNames(newCategories);
                }
            }
            deleteCategory(category);

        }else{
            System.out.println("There is no Category with that Name, try again!");
        }
    }

    public void updateAuthor(String author, String newAuthor) {

        if(this.authors.contains(author)) {
            this.authors.add(newAuthor);


            for (News item: news) {
                //if in news there is only one category and that category we want to delete,
                // then delete (that)news.
                if (item.getAuthor().getName().equals(author)) {
                    item.getAuthor().setName(newAuthor);
                }
            }
            deleteAuthor(author);
        }else{
            System.out.println("There is no Category with that Name, try again!");
        }
    }
}
