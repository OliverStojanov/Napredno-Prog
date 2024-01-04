package Zad20;

import java.time.Duration;

public class LocationUtils {
    public static double distanceBetween(ILocation location1, ILocation location2) {
        return Math.sqrt(Math.pow(location1.getLatitude() - location2.getLatitude(), 2)
                + Math.pow(location1.getLongitude() - location2.getLongitude(), 2));
    }

    public static double timeBetweenInSeconds(ILocation location1, ILocation location2) {
        return Math.abs(Duration.between(location1.getTimestamp(), location2.getTimestamp()).getSeconds());
    }
    public static boolean isDanger(ILocation location1, ILocation location2) {
        return distanceBetween(location1, location2) <= 2.0&&timeBetweenInSeconds(location1, location2) <= 300;
    }

    public static int dangerContactsBetween(User u1, User u2) {
        int counter = 0;
        for (ILocation iLocation : u1.locations) {
            for (ILocation iLocation1 : u2.locations) {
                if (isDanger(iLocation, iLocation1))
                    ++counter;
            }
        }

        return counter;
    }
}
