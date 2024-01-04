package Zad57;

import java.io.*;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MojDDV {

    List<Record> records;

    public MojDDV() {
        records = new ArrayList<>();
    }

    public void readRecords(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        records = reader.lines().map(line ->{
            try {
                return Record.createRecord(line);
            }catch (AmountNotAllowedException e){
                System.out.println(e.getMessage());
                return null;
            }
        })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void printTaxReturns(PrintStream out) {
        PrintWriter pw = new PrintWriter(out);

        records.forEach(record -> {
            pw.printf("%10s\t%10d\t%4.5f\n", record.id, record.sum(), record.getTaxReturn());
        });

        pw.flush();
    }

    public void printStatistics(PrintStream out) {
        DoubleSummaryStatistics dss = records.stream().mapToDouble(record -> record.getTaxReturn()).summaryStatistics();
        PrintWriter pw = new PrintWriter(out);
        pw.printf("min:\t%.3f\nmax:\t%.3f\nsum:\t%.3f\ncount:\t%d\navg:\t%.3f\n",
                    dss.getMin(),dss.getMax(),dss.getSum(), dss.getCount(), dss.getAverage());
        pw.flush();
    }
}
