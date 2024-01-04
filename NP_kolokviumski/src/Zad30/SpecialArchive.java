package Zad30;

import java.util.Date;

public class SpecialArchive extends Archive {
    int maxOpen;
    int count;
    public SpecialArchive(int id, int maxOpen) {
        this.id = id;
        count = 0;
        this.maxOpen = maxOpen;
    }

    @Override
    public Date open(Date date) throws InvalidArchiveOpenException {
        if(count>maxOpen){
            throw new InvalidArchiveOpenException(String.format("Item %d cannot be opened more than %s", id, maxOpen));
        }
        count++;
        return date;
    }
}
