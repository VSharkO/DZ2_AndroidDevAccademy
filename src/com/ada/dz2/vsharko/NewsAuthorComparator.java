package com.ada.dz2.vsharko;

import java.util.Comparator;

public class NewsAuthorComparator implements Comparator<News> {
    @Override
    public int compare(News o1, News o2) {
        return o1.getAuthor().getName().compareTo(o2.getAuthor().getName());
    }
}
