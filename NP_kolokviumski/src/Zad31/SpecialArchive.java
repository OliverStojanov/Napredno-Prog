package Zad31;

import java.time.LocalDate;

public class SpecialArchive extends Archive{
    int maxOpen;
    int count;
    public SpecialArchive(int id, int maxOpen) {
        this.id = id;
        count = 0;
        this.maxOpen = maxOpen;
    }

    @Override
    public LocalDate Open(LocalDate ld) throws InvalidArchiveOpenException {
        if(count>=maxOpen){
            throw new InvalidArchiveOpenException(String.format(" Item %d cannot be opened more than %d times",id, maxOpen));
        }
        ++count;
        return ld;
    }
}
