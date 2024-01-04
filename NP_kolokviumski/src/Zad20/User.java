package Zad20;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User {
    public String name;
    public String id;
    public List<ILocation> locations;
    public LocalDateTime timeInfected;
    public boolean infected;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        locations = new ArrayList<>();
        infected = false;
    }

    public void addLocations(List<ILocation> locations) {
        this.locations.addAll(locations);
    }

    public void setTimeInfected(LocalDateTime timestamp) {
        this.timeInfected = timestamp;
    }

    public LocalDateTime getTimeInfected() {
        return timeInfected != null ? timeInfected : LocalDateTime.MAX;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    String userComplete() {
        return String.format("%s %s %s", name, id, timeInfected);
    }

    String userHidden() {
        return String.format("%s %s***", name, id.substring(0, 4));
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public boolean isInfected(){
        return infected;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
