package Zad30;

import java.util.Date;

public abstract class Archive {
    protected int id;
    protected Date dateArchived;

    public abstract Date open(Date date) throws InvalidArchiveOpenException;

    public void archive(Date date) {
        dateArchived = date;
    }
    @Override
    public boolean equals(Object obj) {
        Archive archive = (Archive) obj;
        return this.id == archive.id;
    }

    public int getId() {
        return id;
    }
}
