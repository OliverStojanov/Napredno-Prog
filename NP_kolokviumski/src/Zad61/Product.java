package Zad61;
import java.time.LocalDateTime;
public class Product {
    String category;
    String id;
    String name;
    LocalDateTime createdAt;
    double price;
    int mostSold = 0;

    public Product(String category, String id, String name, LocalDateTime createdAt, double price) {
        this.category = category;
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.price = price;
    }

    public double buy(int quantity){
        this.mostSold+= quantity;
        return price * quantity;
    }

    public int getMostSold() {
        return mostSold;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", quantitySold=" + mostSold +
                '}';
    }
}
