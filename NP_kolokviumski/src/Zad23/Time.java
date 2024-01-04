package Zad23;

public class Time implements Comparable<Time>{
    public int hours;
    public int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

//    public Time(String time) throws UnsupportedFormatException,
//            InvalidTimeException {
//        String[] parts = time.split("\\.");
//        if (parts.length == 1) {
//            parts = time.split(":");
//        }
//        if (parts.length == 1)
//            throw new UnsupportedFormatException(time);
//        this.hours = Integer.parseInt(parts[0]);
//        this.minutes = Integer.parseInt(parts[1]);
//        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59)
//            throw new InvalidTimeException(time);
//    }

    public  String toStringAMPM(){
        String part = "AM";
        int hour = hours;
        if(hour == 0){
            hour+=12;
        } else if (hour == 12) {
            part = "PM";
        } else if (hour > 12) {
            part = "PM";
            hour -= 12;
        }
        return String.format("%2d:%02d %s", hour, minutes, part);
    }

    @Override
    public String toString() {
        return String.format("%d:%d",hours,minutes);
    }

    @Override
    public int compareTo(Time o) {
        if (hours == o.hours)
            return minutes - o.minutes;
        else
            return hours - o.hours;
    }
}
