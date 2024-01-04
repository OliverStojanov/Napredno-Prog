package Zad29;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Airports {
    Map<String, Airport> airports;

    public Airports() {
        airports = new TreeMap<>();
    }

    public void addAirport(String name, String country, String code, int passengers) {
        airports.put(code, new Airport(name, country, code, passengers));
    }

    public void addFlights(String from, String to, int time, int duration) {
        Airport airport = airports.get(from);
        airport.addFlights(from, to, time, duration);
    }

    public void showFlightsFromAirport(String from) {
        Airport airport = airports.get(from);
        System.out.println(airport);
        int i=1;
        for (String code: airport.flights.keySet()) {
            Set<Flights> flights = airport.flights.get(code);
            for (Flights flight: flights) {
                System.out.println(String.format("%d. %s", i++, flight));
            }
        }
    }

    public void showDirectFlightsFromTo(String from, String to) {
        Airport airport = airports.get(from);
        Set<Flights> flights = airport.flights.get(to);
        if(flights == null){
            System.out.printf("No flights from %s to %s\n", from, to);
            return;
        }
        for (Flights flight: flights) {
            System.out.println(flight);
        }

    }

    public void showDirectFlightsTo(String to) {
//        for (Airport airport: airports.values()) {
//            Set<Flights> flights = airport.flights.get(to);
//            if(flights != null) {
//                for (Flights flight : flights) {
//                    System.out.println(flight);
//                }
//            }
//        }
        Set<Flights> flightsTo = new TreeSet<>();
        for (Airport airport: airports.values()) {
            Set<Flights> flights = airport.flights.get(to);
            if (flights != null) {
                flightsTo.addAll(flights);
            }
        }
        for (Flights flight : flightsTo) {
            System.out.println(flight);
        }
    }
}
