package com.ada.dz2.vsharko;

import java.util.Comparator;

public class NewsCategoryComparator implements Comparator<News> {

    @Override
    public int compare(News o1, News o2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String cat:o1.getNameCategories()) {
            sb1.append(cat);
        }
        for (String cat:o2.getNameCategories()) {
            sb2.append(cat);
        }
        return sb1.toString().compareTo(sb2.toString());
    }
}