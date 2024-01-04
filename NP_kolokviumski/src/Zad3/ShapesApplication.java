package Zad3;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class ShapesApplication {
        HashMap<String, ArrayList<Integer>> shapes;

    public ShapesApplication() {
        shapes = new HashMap<>();
    }

    public int readCanvases(InputStream in) {
        Scanner scanner = new Scanner(in);
        ArrayList<Integer> sides = new ArrayList<>();
        int side=0;
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String []parts = line.split(" ");
            sides = new ArrayList<>();
            for(int i=1; i< parts.length; i++){
                sides.add(Integer.parseInt(parts[i]));
                side++;
            }
            shapes.put(parts[0], sides);
        }
        return side;
    }

    public void printLargestCanvasTo(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        Iterator<Map.Entry<String,ArrayList<Integer>>> iterator = shapes.entrySet().iterator();
        String keyy = "";
        int max = 0;
        int count = 0;
        while (iterator.hasNext()){
            Map.Entry<String,ArrayList<Integer>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<Integer> values = entry.getValue();
            int sum = 0;
            for(int i=0; i<values.size(); i++){
                sum += values.get(i)*4;
            }
            if (max<sum){
                keyy = key;
                max = sum;
                count = values.size();
            }

        }
        printWriter.printf("%s %d %d", keyy, count, max);
        printWriter.close();
    }

}
