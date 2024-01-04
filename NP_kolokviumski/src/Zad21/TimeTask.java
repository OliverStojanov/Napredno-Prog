package Zad21;

import java.time.LocalDateTime;

public class TimeTask extends Task{
    LocalDateTime deadline;
    public TimeTask(String category, String name, String description, LocalDateTime deadline) {
        super(category, name, description);
        this.deadline = deadline;
    }

    @Override
    public LocalDateTime getDeadline() {
        return deadline;
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
        return "TimeTask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
