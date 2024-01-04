package Zad_Juni.Zad3;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizProcessor {

    public static Map<String, Double> processAnswers(InputStream in) throws QuizMustHaveSameNumberOfAnswers {
        Scanner scanner = new Scanner(in);
        Map<String,Double> statistics = new LinkedHashMap<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            double points = 0;
            String[] keys = line.split(";");
            String key = keys[0];
            String []correctAnswers = keys[1].split(", ");
            String []studentAnswers = keys[2].split(", ");
            try {
                correctAnswers(correctAnswers.length, studentAnswers.length);
                for(int i=0; i< correctAnswers.length; i++){
                    if(correctAnswers[i].equals(studentAnswers[i])){
                        points+=1;
                    }
                    else {
                        points-=0.25;
                    }
                }
                statistics.put(key,points);
            }catch (QuizMustHaveSameNumberOfAnswers e){
                System.out.println(e.getMessage());
            }
        }
        return statistics;
    }

    private static void correctAnswers(int length, int length1) throws QuizMustHaveSameNumberOfAnswers {
        if(length!= length1){
            throw new QuizMustHaveSameNumberOfAnswers();
        }
    }
}
