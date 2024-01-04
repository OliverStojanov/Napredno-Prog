package Zad43;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DailyTemperatures {
    List<DailyTemperature> temperatures;

    public DailyTemperatures() {
        temperatures = new ArrayList<>();
    }

    public void readTemperatures(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        temperatures = reader.lines()
                .map(DailyTemperature::fromString)
                .collect(Collectors.toList());
    }

    public void writeDailyStats(PrintStream out, char c) {
        PrintWriter pw = new PrintWriter(out);
        temperatures.stream()
                .sorted(Comparator.comparing(DailyTemperature::getDay))
                .forEach(temp -> pw.println(String.format("%3s: %s", temp.toString(), temp.summary(c))));
        pw.flush();
    }
}
