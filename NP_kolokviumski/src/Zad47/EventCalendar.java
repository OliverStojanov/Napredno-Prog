package Zad47;

import java.util.*;

public class EventCalendar {
    int year;
    Map<Integer, Set<Event>> events;
    Map<Integer, Integer> months;
    public EventCalendar(int year) {
        this.year = year;
        this.events = new HashMap<>();
        this.months = new HashMap<>();
    }

    public void addEvent(String name, String location, Date date) throws WrongDateException{
        if(getYear(date) != year)
            throw  new WrongDateException(date);
        Event event = new Event(name, location, date);
        int day = getDayOfYear(date);
        Set<Event> set = events.computeIfAbsent(day, k -> new TreeSet<>());
        set.add(event);
        events.put(day, set);

        int monthKey = getMonth(date);
        Integer count = months.get(monthKey);
        if(count == null)
            count = 0;
        ++count;
        months.put(monthKey,count);
    }

    public int getDayOfYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return  calendar.get(Calendar.DAY_OF_YEAR);
    }

    public int getYear(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return  calendar.get(Calendar.YEAR);
    }

    public int getMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return  calendar.get(Calendar.MONTH);
    }

    public void listEvents(Date date) {
        int day = getDayOfYear(date);
        Set<Event> set = events.get(day);
        if(set!= null){
            for(Event e : set){
                System.out.println(e);
            }
        }else
            System.out.println("No events on this day!");
    }

    public void listByMonth() {
        for (int i=0; i<12; ++i) {
            System.out.printf("%d : %d\n", i+1, months.get(i) == null? 0 : months.get(i));
        }
    }
}
