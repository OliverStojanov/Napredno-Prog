package Zad55;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class WeatherStation {
    Set<Measurment> measurments;
    int days;
    public WeatherStation(int days) {
        measurments = new TreeSet<>();
        this.days = days;
    }

    public void addMeasurment(float temp, float wind, float hum, float vis, Date date) {
        Measurment measurment = new Measurment(temp, wind, hum, vis, date);
        long time = measurment.date.getTime();
        Iterator<Measurment> iterator = measurments.iterator();
        if(iterator.hasNext()){
            Measurment m = iterator.next();
            long d = time - m.date.getTime();
            if(d> days*24*60*60*1000){
                iterator.remove();
            }
        }
        measurments.add(measurment);
    }

    public int total() {
        return measurments.size();
    }

    public void status(Date from, Date to) {
        float sum = 0;
        int i=0;
        Iterator<Measurment> iterator = measurments.iterator();
        while (iterator.hasNext()){
            Measurment m = iterator.next();
            if(m.date.compareTo(from) >=0 && m.date.compareTo(to) <=0){
                System.out.println(m);
                sum+= m.temp;
                i++;
            }
        }
        if(i==0){
            throw new RuntimeException();
        }
        System.out.printf("Average temperature: %.2f\n",sum/i);
    }
}
