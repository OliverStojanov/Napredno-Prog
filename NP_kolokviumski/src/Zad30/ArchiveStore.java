package Zad30;

import java.util.ArrayList;
import java.util.Date;

public class ArchiveStore {
    ArrayList<Archive> archives;
    StringBuilder logs;
    public ArchiveStore() {
        archives = new ArrayList<>();
        logs = new StringBuilder();
    }

    public void archiveItem(Archive item, Date date) {
        item.archive(date);
        archives.add(item);
        logs.append(String.format("Item %d archived at %s\n", item.id, date));
    }

    public Archive openItem(int id, Date date) throws NonExistingItemException {
        for (Archive item: archives) {
            if(item.getId() == id){
                try {
                    item.open(date);
                }catch (InvalidArchiveOpenException e){
                    logs.append(e.getMessage());
                    logs.append("\n");
                    return item;
                }
                logs.append(String.format("Item %d opened at %s",id, date));
                return item;
            }
        }
        throw new NonExistingItemException(id);
    }

    public String getLog() {
        return logs.toString();
    }
}
