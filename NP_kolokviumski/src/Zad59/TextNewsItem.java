package Zad59;

import java.util.Date;

public class TextNewsItem extends NewsItem{
    String text;
    public TextNewsItem(String title, Date date, Category category, String text) {
        super(title, date, category);
        this.text = text;
    }

    @Override
    public String getTeaser() {
        return String.format("%s\n%d\n%s\n", title,when(),text.length()>80 ?text.substring(0,80): text);
    }
}
