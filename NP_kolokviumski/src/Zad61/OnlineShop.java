package Zad61;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OnlineShop {
    Map<String,List<Product>> productsByCategory;
    Map<String,Product> productById;
    OnlineShop() {
        productsByCategory = new HashMap<>();
        productById = new HashMap<>();
    }

    void addProduct(String category, String id, String name, LocalDateTime createdAt, double price) {
        Product product = new Product(category, id, name, createdAt, price);
        productById.put(id, product);
        productsByCategory.putIfAbsent(category,new ArrayList<>());
        productsByCategory.computeIfPresent(category,(k,v) ->{
            v.add(product);
            return v;
        });
    }

    double buyProduct(String id, int quantity) throws ProductNotFoundException {
        if(!productById.containsKey(id)){
            throw new ProductNotFoundException(String.format("Product with id %s does not exist in the online shop!", id));
        }
        return productById.get(id).buy(quantity);
    }

    List<List<Product>> listProducts(String category, COMPARATOR_TYPE comparatorType, int pageSize) {
        List<Product> products = (category==null) ? new ArrayList<>(productById.values()) : productsByCategory.get(category);
        Comparator<Product> comparator = ProductComparator.crateComparator(comparatorType);

        products.sort(comparator);
        List<List<Product>> result = new ArrayList<>();
        if(pageSize > products.size())
            result.add(products);
        else {
            int ratio =(int) Math.ceil(products.size()*1.0/pageSize);
            List<Integer> starts = IntStream.range(0,ratio)
                    .map(i -> i*pageSize)
                    .boxed()
                    .collect(Collectors.toList());
            starts.forEach(i -> result.add(products.subList(i,Math.min(i+pageSize, products.size()))));
        }
        return result;
    }

}
