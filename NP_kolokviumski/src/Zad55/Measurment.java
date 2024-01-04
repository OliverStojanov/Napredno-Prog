package Zad55;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Measurment implements Comparable<Measurment>{
    float temp;
    float wind;
    float hum;
    float vis;
    Date date;

    public Measurment(float temp, float wind, float hum, float vis, Date date) {
        this.temp = temp;
        this.wind = wind;
        this.hum = hum;
        this.vis = vis;
        this.date = date;
    }


    @Override
    public int compareTo(Measurment o) {
        long t1 = this.date.getTime();
        long t2 = o.date.getTime();
        if(Math.abs(t1-t2)< 150*1000){
            return 0;
        }
        return this.date.compareTo(o.date);
    }

    @Override
    public String toString() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//        String formattedDate = dateFormat.format(date);
        return String.format("%.1f %.1f km/h %.1f%% %.1f km %s", temp,wind,hum,vis,date);
    }
}
