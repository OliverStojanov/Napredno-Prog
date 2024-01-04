package Zad_Juni.Zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {
    String id;
    String name;
    Map<String,Address> addresses;
    float spent;
    int numOfOrders;
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.addresses = new TreeMap<>();
        this.spent = 0;
        numOfOrders = 0;
    }

    public String getId() {
        return id;
    }

    public void setAddresses(String name, Location location) {
        this.addresses.put(name,new Address(name, location));
    }

    public float getSpent() {
        return spent;
    }

    public void setSpent(float spent) {
        this.spent += spent;
        numOfOrders+=1;
    }

    @Override
    public String toString() {
        return String.format("ID: %s Name: %s Total orders: %d Total amount spent: %.2f Average amount spent: %.2f",
                id,name,numOfOrders,spent,numOfOrders==0?0:spent/numOfOrders);
    }
}
