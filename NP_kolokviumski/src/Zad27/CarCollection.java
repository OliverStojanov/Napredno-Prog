package Zad27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    List<Car> cars;

    public CarCollection() {
        cars = new ArrayList<>();
    }

    public void sortByPrice(boolean b) {
        Comparator<Car> carPriceComparator = new CarPriceComparator();
        if(!b){
            carPriceComparator = Collections.reverseOrder(carPriceComparator);
        }
        Collections.sort(cars,carPriceComparator);
    }

    public List<Car> getList() {
        return cars;
    }

    public List<Car> filterByManufacturer(String manufacturer) {
        return cars.stream().filter(car -> car.getManufacturer().equalsIgnoreCase(manufacturer))
                .sorted(Comparator.comparing(Car::getModel))
                .collect(Collectors.toList());
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
