package Zad43;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DailyTemperature {
    int day;
    List<Double> temperatures;
    DoubleSummaryStatistics dss;

    public DailyTemperature(int day, List<Double> temps) {
        this.day = day;
        this.temperatures = temps;
        this.dss = temperatures.stream().collect(Collectors.summarizingDouble(x -> x));
    }

    public static double toCelsius(double temp){
        return (temp-32)*5/9;
    }
    public double toFahrenheit(double temp){
        return (temp*9)/5 +32;
    }
    public int getDay() {
        return day;
    }

    public static double tempFromString(String temp){
        double t = Double.parseDouble(temp.substring(0,temp.length()-1));
        if(temp.endsWith("F")){
            return toCelsius(t);
        }
        return t;
    }

    public static DailyTemperature fromString(String line){
        String [] parts = line.split("\\s+");
        int dayy = Integer.parseInt(parts[0]);
        List<Double> list = IntStream.range(1, parts.length)
                .mapToObj(i -> tempFromString(parts[i]))
                .collect(Collectors.toList());
        return new DailyTemperature(dayy,list);
    }
    public String summary(char c){
        double min = dss.getMin();
        double max = dss.getMax();
        double average = dss.getAverage();
        if(c == 'F'){
            min = toFahrenheit(min);
            max = toFahrenheit(max);
            average = toFahrenheit(average);
        }
        return String.format("Count: %3d Min: %6.2f%c Max: %6.2f%c Avg: %6.2f%c", dss.getCount(),min,c,max,c,average,c);
    }
    @Override
    public String toString() {
        return String.format("%d", day);
    }
}
