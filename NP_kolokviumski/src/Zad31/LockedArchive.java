package Zad31;

import java.time.LocalDate;

public class LockedArchive extends Archive {
    LocalDate dateToOpen;
    public LockedArchive(int id, LocalDate dateToOpen) {
        this.dateToOpen = dateToOpen;
        this.id = id;
    }

    @Override
    public LocalDate Open(LocalDate ld) throws InvalidArchiveOpenException {
        if(ld.isBefore(dateToOpen)){
            throw new InvalidArchiveOpenException(String.format("Item %d cannot be opened before %s",id, dateToOpen));
        }
        return ld;
    }
}
