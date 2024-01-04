package Zad59;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FrontPage {
    List<NewsItem> newsItems;
    Category[] categories;
    public FrontPage(Category[] categories) {
        this.categories = new Category[categories.length];
        for (int i=0; i< categories.length; i++) {
            this.categories[i] = categories[i];
        }
        newsItems = new ArrayList<>();
    }

    public void addNewsItem(NewsItem newsItem) {
        newsItems.add(newsItem);
    }

    public Collection<NewsItem> listByCategory(Category c) {
        return newsItems.stream()
                .filter(newsItem -> newsItem.category.equals(c))
                .collect(Collectors.toList());
    }

    public Collection<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
        int index=-1;
        for(int i=0; i< categories.length; i++){
            if(categories[i].name.equals(category)){
                index = i;
                break;
            }
        }
        if(index == -1){
            throw  new CategoryNotFoundException(category);
        }
        return listByCategory(categories[index]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NewsItem news: newsItems) {
            sb.append(news.getTeaser());
        }
        return sb.toString();
    }
}
