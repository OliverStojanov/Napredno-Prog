package Zad35;

public class IEvaluatorsBUilder {
    public static <T extends Comparable<T>> IEvaluator<T> build(String operator) {
        switch (operator) {
            case "==":
                return (l, r) -> l.compareTo(r) == 0;
            case "<":
                return (l, r) -> l.compareTo(r) < 0;
            case ">":
                return (l, r) -> l.compareTo(r) > 0;
            case "!=":
                return (l, r) -> l.compareTo(r) != 0;
            default:
                return (l,r) -> false;
        }
    }
}
