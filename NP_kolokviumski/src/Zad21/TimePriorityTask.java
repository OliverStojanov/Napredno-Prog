package Zad21;

import java.time.LocalDateTime;

public class TimePriorityTask extends Task{
    public LocalDateTime deadline;
    public int priority;
    public TimePriorityTask(String category, String name, String description, LocalDateTime deadline, int priority) {
        super(category, name, description);
        this.deadline = deadline;
        this.priority = priority;
    }

    @Override
    public LocalDateTime getDeadline() {
        return deadline;
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
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", priority=" + priority +
                '}';
    }
}
