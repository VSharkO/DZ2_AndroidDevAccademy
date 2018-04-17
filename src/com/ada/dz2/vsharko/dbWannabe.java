package com.ada.dz2.vsharko;



import java.util.*;


public class dbWannabe {
    List<String> categoryList = new LinkedList<>();
    List<String> authorList = new LinkedList<>();
    List<News> newsList = new LinkedList<>();

//setters/creators
    public void createAuthor(String author) {

        boolean flag = false;
        List<String> temp=new LinkedList<>();
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
        List<String> thisList;
        thisList=this.authorList;
        Collections.sort(thisList);
        for (String element : thisList) {

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
        for (News element : newsList) {

            System.out.println(element.toString());

        }
    }

    public void deleteCategory(int index){
        if(index<categoryList.size()&&index>0) {
            int i = 0;
            for (News news : newsList) {
                List<String> c = new LinkedList<>();
                String[] tokens = news.getCategory().split(",");
                Collections.addAll(c, tokens);

                if (c.size() == 1 && categoryList.get(index-1).equals(c.get(0))) {
                    newsList.remove(i);
                    break;
                }

                if (c.contains(categoryList.get(index-1))) {
                    c.remove(categoryList.get(index-1));
                    news.setCategory(c);
                    }
                i++;
                }
            categoryList.remove(index-1);
            }else{

            System.out.println("There is no category with that index, try again!");

        }

    }


}




