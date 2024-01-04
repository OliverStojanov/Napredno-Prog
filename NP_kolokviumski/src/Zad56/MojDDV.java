package Zad56;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MojDDV {
    List<Record> records;

    public MojDDV() {
        records = new ArrayList<>();
    }

    public void readRecords(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        records = reader.lines().map(line -> {
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

        records.stream().forEach(record -> {
            pw.printf("%s %d %.2f\n", record.id, record.sum(), record.taxReturn());
        });
        pw.flush();
    }
}
