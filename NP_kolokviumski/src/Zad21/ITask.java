package Zad21;

import java.time.LocalDateTime;

public interface ITask {
    public LocalDateTime getDeadline();
    public int getPriority();
    public String getCategory();
}
