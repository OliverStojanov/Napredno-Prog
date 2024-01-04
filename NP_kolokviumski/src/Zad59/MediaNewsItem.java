package Zad59;

import java.util.Date;

public class MediaNewsItem extends NewsItem{
    String url;
    int views;
    public MediaNewsItem(String title, Date date, Category category, String url, int views) {
        super(title, date, category);
        this.url = url;
        this.views = views;
    }

    @Override
    public String getTeaser() {
        return String.format("%s\n%d\n%s\n%d\n", title,when(),url,views);
    }
}
