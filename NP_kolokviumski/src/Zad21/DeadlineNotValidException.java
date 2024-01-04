package Zad21;

import java.time.LocalDateTime;

public class DeadlineNotValidException extends Throwable {
    public DeadlineNotValidException(LocalDateTime deadline) {
        super(String.format("The deadline %s has already passed",deadline));
    }
}
