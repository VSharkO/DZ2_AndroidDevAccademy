package com.ada.dz2.vsharko;



import java.util.*;


public class dbWannabe {
    List<String> categoryList = new LinkedList<>();
    List<String> authorList = new LinkedList<>();
    List<News> newsList = new LinkedList<>();

//setters/creators
    public void createAuthor(String author) {


        if (!authorList.contains(author)){
            this.authorList.add(author);
        }

    }

    public void createCategory(String category){

        if(!categoryList.contains(category)){
            this.categoryList.add(category);
        }

    }

    public void createNews(String text,String author, List<String> category){

        List<String> instanceCategoryes = new LinkedList<>();
        for (String cg:category) {

            if(!categoryList.contains(cg)){
                this.categoryList.add(cg);
            }
            instanceCategoryes.add(cg);
        }
        createAuthor(author);
        this.newsList.add(new News(text,instanceCategoryes,author));
    }

//getters
    public void getAuthors(){
        int i=1;

        for (String element : authorList) {

            System.out.println(i+". "+element);
            i++;

        }
    }

    public void getCategories(){
        int i=1;
        for (String element : categoryList) {

            System.out.println(i+". "+element);
            i++;

        }
    }

    public void getNews(){
        int i=1;
        for (News element : newsList) {

            System.out.println(i+". "+element);
            i++;

        }
    }

    public void deleteCategory(int index){
        if(index<=categoryList.size()&&index>0) {
            List<News> deleteList = new LinkedList<>();
            for (News news : newsList) {
                List<String> thisCategories = new LinkedList<>();
                String[] tokens = news.getCategory().split(",");
                Collections.addAll(thisCategories, tokens);
                if (thisCategories.size() == 1 && categoryList.get(index-1).equals(thisCategories.get(0))) {
                    deleteList.add(news);
                }

                if (thisCategories.contains(categoryList.get(index-1))) {
                    thisCategories.remove(categoryList.get(index-1));
                    news.setCategory(thisCategories);
                    }

                }
                newsList.removeAll(deleteList);
                categoryList.remove(index-1);
            }else{

            System.out.println("There is no Category with that index, try again!");

        }
    }

    public void deleteNews(int index){
        if(index<=newsList.size() && index>0) {
            newsList.remove(index - 1);
        }else{
            System.out.println("There is no News with that index, try again!");
        }
    }

    public void deleteAuthor(int index){
        List<News> deleteNews = new LinkedList<>();
        if(index<=authorList.size() && index>0) {
            for (News news : newsList) {
                if (news.getAuthor().equals(authorList.get(index - 1))) {
                    deleteNews.add(news);
                }
            }
            authorList.remove(index - 1);
            newsList.removeAll(deleteNews);
        }else{

            System.out.println("There is no Author with that index, try again!");

        }
    }

}




