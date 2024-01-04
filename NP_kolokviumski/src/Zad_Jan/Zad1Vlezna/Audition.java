package Zad_Jan.Zad1Vlezna;

import java.util.*;

public class Audition {
    Map<String, Set<Participant>> participantsByCity;

    public Audition() {
        participantsByCity = new HashMap<>();
    }

    public void addParticpant(String city, String code, String name, int age) {
        participantsByCity.putIfAbsent(city, new HashSet<>());
        Set<Participant> set = participantsByCity.get(city);
        Participant participant = new Participant(city,code,name,age);
        for (Participant par:set) {
            if(par.equals(participant))
                return;
        }
        set.add(participant);
    }

    public void listByCity(String city) {
        participantsByCity.entrySet().stream()
                .filter(entry -> entry.getKey().equals(city))
                .forEach(entry ->{
                    Set<Participant> participants = entry.getValue();
                    List<Participant> part = new ArrayList<>();
                    for (Participant participant:participants){
                        part.add(participant);
                    }
                    Collections.sort(part);
                    for (Participant participant:part){
                        System.out.println(participant);
                    }
                });
    }
}
