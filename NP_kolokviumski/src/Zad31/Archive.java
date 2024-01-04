package Zad31;

import java.time.LocalDate;
public abstract class Archive {
    int id;
    LocalDate dateArchived;

    public abstract LocalDate Open(LocalDate ld) throws InvalidArchiveOpenException;

    public void archive(LocalDate date){
        dateArchived= date;
    }
}
