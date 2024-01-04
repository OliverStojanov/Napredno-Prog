package Zad28;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChatRoom {

    String name;
    Set<String>roomNamesSet;
    public ChatRoom(String name) {
        roomNamesSet= new TreeSet<>();
        this.name = name;
    }

    public void addUser(String username) {
        roomNamesSet.add(username);
    }

    public void removeUser(String username) {
        roomNamesSet.remove(username);
    }

    public boolean hasUser(String username) {
        return roomNamesSet.contains(username);
    }

    public int numUsers(){
        return roomNamesSet.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\n", name));
        for (String user : roomNamesSet) {
            sb.append(String.format("%s\n", user));
        }
        return sb.toString();
    }
}
