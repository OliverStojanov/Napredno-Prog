package Zad63;

public interface Item {
    public int getPrice() throws InvalidExtraTypeException, InvalidPizzaTypeException;
    Item getItem();
    String getType();
}
