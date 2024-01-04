package Zad57;

public class Item {
    int price;
    TYPE type;

    public Item(int price, TYPE type) {
        this.price = price;
        this.type = type;
    }

    public double getTaxReturn(){
        switch (type){
            case A: return price*0.18*0.15;
            case B: return price*0.05*0.15;
            default: return 0;
        }
    }
}
