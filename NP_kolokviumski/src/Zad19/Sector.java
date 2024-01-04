package Zad19;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Sector implements Comparable<Sector>{
    public String code;
    public int size;
    HashMap<Integer, Integer> taken;
    HashSet<Integer> types;

    public Sector(String code, int size) {
        this.code = code;
        this.size = size;
        taken = new HashMap<>();
        types = new HashSet<>();
    }
    public int free(){
        return size - taken.size();
    }

    public void takeSeat(int seat, int type) throws SeatNotAllowedException {
        if(type == 1){
            if(types.contains(2)){
                throw new SeatNotAllowedException();
            }
        }else if(type == 2){
            if(types.contains(1)){
                throw new SeatNotAllowedException();
            }
        }
        types.add(type);
        taken.put(seat,type);
    }
    public boolean isTaken(int seat){
        return taken.containsKey(seat);
    }

    @Override
    public int compareTo(Sector o) {
        if(this.free()==o.free()){
            return code.compareTo(o.code);
        }return Integer.compare(this.free(),o.free());
    }

    @Override
    public String toString() {
        return String.format("%s\t%d/%d\t%.1f%%", code, free(), size, (size - free()) * 100.0 / size);
    }
}
