package Zad56;

import java.util.ArrayList;
import java.util.List;

public class Record {
    String id;
    List<Item> items;

    public Record(String id, List<Item> items) throws AmountNotAllowedException {
        this.id = id;
        int sum = items.stream().mapToInt(item->item.price).sum();
        if(sum>30000){
            throw new AmountNotAllowedException(sum);
        }
        this.items = items;
    }

    public static Record createRecord(String line) throws AmountNotAllowedException {
        String[] parts = line.split("\\s+");
        String id = parts[0];
        List<Item> list = new ArrayList<>();
        for (int i=1; i< parts.length; i+=2){
            Item item = new Item(Integer.parseInt(parts[i]),TYPE.valueOf(parts[i+1]));
            list.add(item);
        }
        return new Record(id,list);
    }

    public int sum(){
        return items.stream().mapToInt(item -> item.getPrice()).sum();
    }

    public double taxReturn(){
        return items.stream().mapToDouble(item -> item.getTaxReturn()).sum();
    }
}
