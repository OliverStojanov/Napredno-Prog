package Zad59;

import java.util.Date;

public abstract class NewsItem {
    String title;
    Date date;
    Category category;

    public NewsItem(String title, Date date, Category category) {
        this.title = title;
        this.date = date;
        this.category = category;
    }
    public int when(){
        Date dateNow = new Date();
        return (int)(dateNow.getTime()-date.getTime())/1000/60;
    }
    public abstract String getTeaser();
}
