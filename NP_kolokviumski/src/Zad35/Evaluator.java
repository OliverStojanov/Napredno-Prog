package Zad35;

public class Evaluator {
    public static<T extends Comparable<T>> boolean evaluateExpression(T left, T right, String operator) {
        IEvaluator<T> evaluator = IEvaluatorsBUilder.build(operator);
        return evaluator.evaluate(left,right);
    }
}
