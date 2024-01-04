package Zad20;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class StopCoronaApp {
    Map<String,User> users;
    Map<User, Map<User, Integer>> countingMapForNearContacts;
    public StopCoronaApp() {
        users = new HashMap<>();
        countingMapForNearContacts = new TreeMap<>(Comparator.comparing(User::getTimeInfected).thenComparing(us -> us.id));
    }

    public void addUser(String name, String id) throws UserAlreadyExistException {
        if(users.containsKey(id)) {
            throw new UserAlreadyExistException(id);
        }
        users.put(id,new User(name, id));
    }

    public void addLocations(String id, List<ILocation> locations) {
        users.get(id).addLocations(locations);
    }

    public void detectNewCase(String id, LocalDateTime timestamp) {
        User infectedUser = users.get(id);
        infectedUser.setTimeInfected(timestamp);
        infectedUser.setInfected(true);

    }

    public void createReport() {

        for (User u : users.values()) {
            for (User u1 : users.values()) {
                if (!u.equals(u1)) {
                    countingMapForNearContacts.putIfAbsent(u, new TreeMap<>(Comparator.comparing(User::getTimeInfected).thenComparing(us -> us.id)));
                    countingMapForNearContacts.computeIfPresent(u, (k, v) -> {
                        v.putIfAbsent(u1, 0);
                        v.computeIfPresent(u1, (k1, v1) -> {
                            v1 += LocationUtils.dangerContactsBetween(u, u1);
                            return v1;
                        });
                        return v;
                    });
                }
            }
        }

        List<Integer> directContactsCount = new ArrayList<>();
        List<Integer> indirectContactsCount = new ArrayList<>();

        for(User u : countingMapForNearContacts.keySet()){

            if(u.isInfected()){
                System.out.println(u.userComplete());

                System.out.println("Direct contacts:");
                Map<User,Integer> directContact = getDirectContacts(u);
                directContact.entrySet().stream()
                        .sorted(comparingByValue(Comparator.reverseOrder()))
                        .forEach(entry -> System.out.println(String.format("%s %s", entry.getKey().userHidden(),entry.getValue())));
                int count = directContact.values().stream().mapToInt(mp -> mp).sum();
                System.out.println(String.format("Count of direct contacts: %d", count));
                directContactsCount.add(count);

                System.out.println("Indirect contacts:");
                Collection<User> indirectContact = getIndirectContacts(u);
                indirectContact.forEach(user -> System.out.println(user.userHidden()));
                System.out.println(String.format("Count of indirect contacts: %d", indirectContact.size()));
                indirectContactsCount.add(indirectContact.size());
            }
        }
        System.out.println(String.format("Average direct contacts: %.4f", directContactsCount.stream().mapToInt(c -> c).average().getAsDouble()));
        System.out.println(String.format("Average indirect contacts: %.4f", indirectContactsCount.stream().mapToInt(c -> c).average().getAsDouble()));
    }
    public Map<User, Integer> getDirectContacts (User u){
        return countingMapForNearContacts.get(u)
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()!=0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Collection<User> getIndirectContacts (User u){
        Map<User,Integer> directContacts = getDirectContacts(u);
        Set<User> indirectContacts = new TreeSet<>(Comparator.comparing(User::getName).thenComparing(User::getId));

        directContacts.keySet().stream()
                .flatMap(user -> getDirectContacts(user).keySet().stream()
                        .filter(user1 -> !indirectContacts.contains(user1)&& !directContacts.containsKey(user1) && !u.equals(user1)))
                        .forEach(indirectContacts::add);
        return indirectContacts;
    }
}
