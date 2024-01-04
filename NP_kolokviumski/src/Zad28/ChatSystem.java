package Zad28;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChatSystem {
    Map<String,ChatRoom> rooms;
    Set<String> users;

    public ChatSystem() {
        rooms = new TreeMap<>();
        users = new TreeSet<>();
    }

    public void addRoom(String roomName){
        rooms.put(roomName, new ChatRoom(roomName));

    }
    public void removeRoom(String roomName){
        rooms.remove(roomName);
    }
    public ChatRoom getRoom(String roomName) throws NoSuchRoomException {
        if(!rooms.containsKey(roomName)){
            throw new NoSuchRoomException(roomName);
        }
        return rooms.get(roomName);
    }

    public void register(String userName){
        users.add(userName);
        ChatRoom minUsers = null;
        int min = Integer.MAX_VALUE;
        for (ChatRoom cr : rooms.values()){
            if(cr.numUsers() < min && cr.numUsers() != min){
                minUsers = cr;
            }
        }
        if(minUsers != null)
            minUsers.addUser(userName);
    }

    public void registerAndJoin(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException {
        users.add(userName);
        joinRoom(userName, roomName);
    }
    public void joinRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException {
        if(!rooms.containsKey(roomName)){
            throw new NoSuchRoomException(roomName);
        } else if (!users.contains(userName)) {
            throw  new NoSuchUserException(userName);
        }
        rooms.get(roomName).addUser(userName);
    }
    public void leaveRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException {
        if(!rooms.containsKey(roomName)){
            throw new NoSuchRoomException(roomName);
        } else if (!users.contains(userName)) {
            throw  new NoSuchUserException(userName);
        }
        rooms.get(roomName).removeUser(userName);
    }

    public void followFriend(String username, String friend_username) throws NoSuchUserException, NoSuchRoomException {
        if (!users.contains(username)) {
            throw  new NoSuchUserException(username);
        } else if (!users.contains(friend_username)) {
            throw  new NoSuchUserException(friend_username);
        }
        for (Map.Entry<String, ChatRoom> cr :rooms.entrySet()) {
            if(cr.getValue().hasUser(friend_username)){
                joinRoom(username, cr.getKey());
            }
        }
    }
}
