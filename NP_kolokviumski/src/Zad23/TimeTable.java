package Zad23;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TimeTable {

    List<Time> times;

    public TimeTable() {
        times = new ArrayList<Time>();
    }

    public void readTimes(InputStream in) throws UnsupportedFormatException, InvalidTimeException {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] time = line.split(" ");
            for (String t : time) {
                String[] parts = t.split("\\.");
                if (parts.length == 1) {
                    parts = t.split(":");
                }
                if (parts.length == 1) {
                    throw new UnsupportedFormatException(t);
                }
                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt((parts[1]));
                if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0) {
                    throw new InvalidTimeException(t);
                }
                times.add(new Time(hours, minutes));
//            Time tim = new Time(t);
//            times.add(tim);
            }
        }
    }

    public void writeTimes(OutputStream out, TimeFormat format) {
        PrintWriter printWriter = new PrintWriter(out);
        Collections.sort(times);
        for (Time time : times) {
            if (format == TimeFormat.FORMAT_24) {
                printWriter.println(time);
            } else {
                printWriter.println(time.toStringAMPM());
            }
        }
        printWriter.flush();
    }

}
