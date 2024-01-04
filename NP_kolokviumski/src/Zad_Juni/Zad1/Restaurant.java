package Zad_Juni.Zad1;

public class Restaurant {
    String id;
    String name;
    Location location;
    float earnings;
    int orders;

    public Restaurant(String id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
        earnings = 0;
        orders = 0;
    }

    public String getId() {
        return id;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings += earnings;
        setOrders();
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders() {
        this.orders += 1;
    }
    public double average(){
        return  earnings/orders;
    }

    @Override
    public String toString() {
        return String.format("ID: %s Name: %s Total orders: %d Total amount earned: %.2f Average amount earned: %.2f",
                id,name,orders,earnings,average());
    }
}
