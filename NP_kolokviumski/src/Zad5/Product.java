package Zad5;

public class Product {
    public int price;
    public int discountPrice;
    public Product(int discountPrice, int price) {
        this.discountPrice = discountPrice;
        this.price = price;
    }

    public static Product ofString(String s) {
        String []parts = s.split(":");
        return new Product(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

    }

    public double Discount(){
        return (price - discountPrice) * 100/price;
    }

    public int AbsoluteDiscount(){
        return  price - discountPrice;
    }

    @Override
    public String toString() {
        return String.format("%2.0f%% %d/%d", Discount(), discountPrice, price);
    }
}
