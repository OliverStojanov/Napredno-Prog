package Zad_Juni.Zad3;

public class QuizMustHaveSameNumberOfAnswers extends Exception {
    public QuizMustHaveSameNumberOfAnswers() {
        super("A quiz must have same number of correct and selected answers");
    }
}
