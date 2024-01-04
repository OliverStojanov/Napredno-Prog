package Zad4;


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ShapesApplication {

    List<Canvas> canvas;
    public int Max_Size;
    public ShapesApplication(int i) {
        Max_Size = i;
        canvas = new ArrayList<>();
    }

    public void readCanvases(InputStream in) {
        canvas = new BufferedReader(new InputStreamReader(in))
                .lines()
                .map(line -> {
                    try {
                        return Canvas.createCanvas(line, Max_Size);
                    }catch (IrregularCanvasException e){
                        System.out.println(e.getMessage());
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public void printCanvases(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        canvas.stream().sorted(Comparator.reverseOrder()).forEach(printWriter::println);
        printWriter.close();
    }
}
