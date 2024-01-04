package Zad21;

import java.time.LocalDateTime;

public class PriorityTask extends Task{
    public int priority;
    public PriorityTask(String category, String name, String description, int priority) {
        super(category, name, description);
        this.priority = priority;
    }

    @Override
    public LocalDateTime getDeadline() {
        return LocalDateTime.MAX;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "PriorityTask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
