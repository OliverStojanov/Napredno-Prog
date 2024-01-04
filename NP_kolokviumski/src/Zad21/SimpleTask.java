package Zad21;

import java.time.LocalDateTime;

public class SimpleTask extends Task{
    public SimpleTask(String category, String name, String description) {
        super(category, name, description);
    }

    @Override
    public LocalDateTime getDeadline() {
        return LocalDateTime.MAX;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "SimpleTask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
