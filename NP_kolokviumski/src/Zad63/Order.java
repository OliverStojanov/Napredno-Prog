package Zad63;

import java.util.*;
import java.util.stream.IntStream;

public class Order {
    List<OrderItem> items;
    boolean locked;

    public Order() {
        items = new ArrayList<>();
        locked = false;
    }

    public void addItem(Item item, int i) throws OrderLockedException, ItemOutOfStockException {
        if(locked){
            throw new OrderLockedException();
        }
        if(i>10){
            throw new ItemOutOfStockException(item);
        }
        Optional<OrderItem> orderItem = items.stream()
                        .filter(ite -> ite.getItem().getType().equals(item.getType()))
                        .findFirst();
        if(orderItem.isPresent()){
            orderItem.ifPresent(oi -> oi.setNum(i));
            return;
        }
        items.add(new OrderItem(item,i));
    }

    public void displayOrder() throws InvalidExtraTypeException, InvalidPizzaTypeException {
        IntStream.range(0,items.size())
                .forEach(i ->{
                    OrderItem orderItem = items.get(i);
                    try {
                        System.out.printf("%3d.%-15sx%2d%5d$\n", i + 1, orderItem.getItem().getType(), orderItem.getNum(), orderItem.getPrice());
                    } catch (InvalidExtraTypeException e) {
                        throw new RuntimeException(e);
                    } catch (InvalidPizzaTypeException e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.printf("%-22s%5d$\n", "Total:", getPrice());
    }

    public int getPrice() throws InvalidExtraTypeException, InvalidPizzaTypeException {
        return items.stream().mapToInt(orderItem -> {
            try {
                return orderItem.getPrice();
            } catch (InvalidExtraTypeException e) {
                throw new RuntimeException(e);
            } catch (InvalidPizzaTypeException e) {
                throw new RuntimeException(e);
            }
        }).sum();
    }

    public void removeItem(int idx) {
        if(!locked)
            items.remove(idx);
    }

    public void lock() throws EmptyOrder {
        if(items.size() == 0){
            throw new EmptyOrder();
        }
        locked = true;
    }
}
