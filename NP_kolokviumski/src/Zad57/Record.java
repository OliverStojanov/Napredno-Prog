package Zad57;

import java.util.ArrayList;
import java.util.List;

public class Record {
    String id;
    List<Item> items;

    public Record(String id, List<Item> items) throws AmountNotAllowedException {
        this.id = id;
        int sum = items.stream().mapToInt(item -> item.price).sum();
        if(sum> 30000){
            throw new AmountNotAllowedException(sum);
        }
        this.items = items;
    }

    public static Record createRecord(String line) throws AmountNotAllowedException {
        String[] parts = line.split("\\s+");
        String idd = parts[0];
        List<Item> list = new ArrayList<>();
        for (int i=1; i< parts.length; i+=2){
            list.add(new Item(Integer.parseInt(parts[i]),TYPE.valueOf(parts[i+1])));
        }
        return new Record(idd,list);
    }

    public int sum(){
        return items.stream().mapToInt(item -> item.price).sum();
    }

    public double getTaxReturn(){
        return items.stream().mapToDouble(item -> item.getTaxReturn()).sum();
    }
}
