package Zad19;

import java.util.*;
import java.util.stream.Collectors;

public class Stadium {

    public String name;
    public Map<String,Sector> sectors;
    boolean h = false;
    public Stadium(String name) {
        this.name = name;
        sectors = new HashMap<>();
    }

    public void createSectors(String[] sectorNames, int[] sectorSizes) {
        for(int i=0; i<sectorNames.length; i++){
            Sector sector = new Sector(sectorNames[i], sectorSizes[i]);
            sectors.put(sectorNames[i],sector);
        }
    }

    public void buyTicket(String sectorName, int seat, int type) throws SeatNotAllowedException, SeatTakenException {
        Sector sector = sectors.get(sectorName);
        if(sector.isTaken(seat)){
            throw new SeatTakenException();
        }
        sector.takeSeat(seat,type);
    }

    public void showSectors() {
        List<Sector> sectorList = new ArrayList<>(sectors.values());
        Collections.sort(sectorList);
        for (Sector sector : sectorList) {
            System.out.println(sector);
        }
    }
}
