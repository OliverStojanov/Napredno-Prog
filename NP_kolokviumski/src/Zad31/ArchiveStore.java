package Zad31;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArchiveStore {
    StringBuilder logs;
    ArrayList<Archive> archives;

    public ArchiveStore() {
        logs = new StringBuilder();
        archives = new ArrayList<>();
    }

    public void archiveItem(Archive archive, LocalDate date) {
        archives.add(archive);
        archive.archive(date);
        logs.append(String.format("Item %d archived at %s\n", archive.id, date.toString()));
    }

    public void openItem(int id, LocalDate date) throws NonExistingItemException {
        for (Archive item: archives) {
            if(item.id == id){
                try{
                    item.Open(date);
                }catch (InvalidArchiveOpenException e){
                    logs.append(e.getMessage());
                    logs.append("\n");
                    return;
                }
                logs.append(String.format("Item %d opened at %s\n", id, date));
                return;
            }
        }
        throw new NonExistingItemException(id);
    }

    public String getLog() {
        return logs.toString();
    }
}
