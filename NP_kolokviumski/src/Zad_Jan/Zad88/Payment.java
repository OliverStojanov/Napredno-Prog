package Zad_Jan.Zad88;

public class Payment{
    String itemName;
    int price;

    public Payment(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
