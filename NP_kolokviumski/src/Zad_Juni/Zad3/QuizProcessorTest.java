package Zad_Juni.Zad3;

import java.util.*;

public class QuizProcessorTest {
    public static void main(String[] args) throws QuizMustHaveSameNumberOfAnswers {
            QuizProcessor.processAnswers(System.in).forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v));
    }
}
