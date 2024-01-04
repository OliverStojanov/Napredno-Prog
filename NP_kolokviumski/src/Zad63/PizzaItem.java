package Zad63;

public class PizzaItem implements Item {
    String type;
    public PizzaItem(String type) {
        super();
        this.type = type;
    }

    @Override
    public int getPrice() throws InvalidPizzaTypeException {
        switch (type){
            case "Standard": return 10;
            case "Pepperoni": return 12;
            case "Vegetarian": return 8;
            default:
                throw new InvalidPizzaTypeException();
        }
    }

    @Override
    public Item getItem() {
        return this;
    }

    @Override
    public String getType() {
        return type;
    }
}
