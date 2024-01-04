package Zad1;


import java.util.*;

public class Audition {
    public HashMap<String, HashSet<Participant>> participants;

    public Audition() {
        participants = new HashMap<>();
    }

    public void addParticpant(String city, String code, String name, int age) {
        Participant participant = new Participant(city, code, name, age);
        HashSet<Participant> set = participants.get(city);
        if(set == null){
            set = new HashSet<>();
            participants.put(city, set);
        }
        set.add(participant);
    }

    public void listByCity(String city) {
        HashSet<Participant> set = participants.get(city);
        List<Participant> list = new ArrayList<>();
        for(Participant p : set) {
            list.add(p);
        }
        Collections.sort(list);
        for (Participant p : list) {
            System.out.println(p);
        }
    }
}
