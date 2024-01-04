package Zad_Juni.Zad1;

import java.util.*;

public class DeliveryApp {
    String appName;
    Map<String,User> users;
    Map<String,Restaurant> restaurants;
    Map<String,DeliveryPerson> deliveryPeople;
    public DeliveryApp(String appName) {
        this.appName = appName;
        users = new TreeMap<>();
        restaurants = new TreeMap<>();
        deliveryPeople = new TreeMap<>();
    }

    public void addUser(String id, String name) {
        users.put(id,new User(id, name));
    }

    public void registerDeliveryPerson(String id, String name, Location location) {
        deliveryPeople.put(id,new DeliveryPerson(id, name, location));
    }

    public void addRestaurant(String id, String name, Location location) {
        restaurants.put(id,new Restaurant(id, name, location));
    }

    public void addAddress(String id, String name, Location location) {
        if(users.containsKey(id)){
            users.get(id).setAddresses(name,location);
        }
    }

    public void orderFood(String userId, String userAddressName, String restaurantId, float cost) {
        User user = users.get(userId);
        Address address = user.addresses.get(userAddressName);
        Restaurant restaurant = restaurants.get(restaurantId);
        DeliveryPerson deliveryPerson = findDeliveryPerson(address);
        int earn = 90+restaurant.location.distance(address.location)/10*10;
        deliveryPerson.setEarnings(earn);
        user.setSpent(cost);
        restaurant.setEarnings(cost);
    }

    public DeliveryPerson findDeliveryPerson(Address address){
        List<DeliveryPerson> closest = new ArrayList<>();
        int distance = Integer.MAX_VALUE;
        for (DeliveryPerson dp: deliveryPeople.values()) {
            if (dp.currentLocation.distance(address.location)<=distance){
                if (dp.currentLocation.distance(address.location)==distance){
                    closest.add(dp);
                    distance = dp.currentLocation.distance(address.location);
                }else {
                    closest = new ArrayList<>();
                    closest.add(dp);
                    distance = dp.currentLocation.distance(address.location);
                }
            }
        }
        DeliveryPerson dp = closest.stream()
                .sorted(Comparator.comparing(DeliveryPerson::getNumOfDeliveries))
                .findFirst()
                .orElse(null);

        dp.setCurrentLocation(address.location);
        return dp;
    }

    public void printUsers() {
        users.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(User::getSpent).thenComparing(User::getId).reversed()))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    public void printRestaurants() {
        restaurants.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Restaurant::average).thenComparing(Restaurant::getId).reversed()))
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    public void printDeliveryPeople() {
        deliveryPeople.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(DeliveryPerson::getEarnings).thenComparing(DeliveryPerson::getId).reversed()))
                .forEach(entry -> System.out.println(entry.getValue()));
    }
}
