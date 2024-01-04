package Zad29;

public class Flights implements Comparable<Flights>{
    String from;
    String to;
    int time;
    int duration;

    public Flights(String from, String to, int time, int duration) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.duration = duration;
    }

    @Override
    public String toString() {
        int end = time+ duration;
        int day = end/(24*60);
        end %= (24*60);
        return String.format("%s-%s %02d:%02d-%02d:%02d%s %dh%02dm", from, to, time / 60, time % 60,
                end / 60, end % 60, day > 0 ? " +1d" : "", duration / 60, duration % 60);
    }

    @Override
    public int compareTo(Flights o) {
        int res = Integer.compare(this.time , o.time);
        if (res==0){
            return this.from.compareTo(o.from);
        }return res;
    }
}
