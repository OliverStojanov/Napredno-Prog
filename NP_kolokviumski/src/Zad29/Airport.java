package Zad29;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Airport {
    String name;
    String country;
    String code;
    int passengers;

    Map<String, Set<Flights>> flights;

    public Airport(String name, String country, String code, int passengers) {
        this.name = name;
        this.country = country;
        this.code = code;
        this.passengers = passengers;
        flights = new TreeMap<>();
    }

    public void addFlights(String from, String to, int time, int duration) {
        Flights flight = new Flights(from,to,time,duration);
        Set<Flights> flightSet = flights.get(to);
        if (flightSet == null){
            flightSet = new TreeSet<>();
            flights.put(to, flightSet);
        }
        flightSet.add(flight);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)\n%s\n%d", name, code, country, passengers);
    }
}
