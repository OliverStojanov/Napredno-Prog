package Zad63;

public class OrderItem {
    Item item;
    int num;

    public OrderItem(Item item, int num) {
        this.item = item;
        this.num = num;
    }

    public Item getItem() {
        return item;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() throws InvalidExtraTypeException, InvalidPizzaTypeException {
        return item.getPrice()*num;
    }
}
