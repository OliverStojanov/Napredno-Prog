package Zad63;

public class ExtraItem implements Item {
    String type;
    public ExtraItem(String type) {
        super();
        this.type = type;
    }

    @Override
    public int getPrice() throws InvalidExtraTypeException {
        switch (type){
            case "Coke": return 5;
            case "Ketchup": return 3;
            default:
                throw new InvalidExtraTypeException();
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
