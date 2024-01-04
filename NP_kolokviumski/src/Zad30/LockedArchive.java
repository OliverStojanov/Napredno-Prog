package Zad30;

import java.util.Date;

public class LockedArchive extends Archive{
    Date dateToOpen;
    public LockedArchive(int id, Date dateToOpen) {
        this.id = id;
        this.dateToOpen = dateToOpen;
    }

    @Override
    public Date open(Date date) throws InvalidArchiveOpenException {
        if(date.before(dateToOpen)){
            throw new InvalidArchiveOpenException(String.format("Item %d cannot be opened before %s", id , dateToOpen));
        }
        return date;
    }
}
