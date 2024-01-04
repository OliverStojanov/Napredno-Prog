package Zad13;

public class MinMax<T extends Comparable<T>> {
    public T min;
    public T max;
    public int count;
    public int minCount;
    public int maxCount;

    public MinMax() {
        count = 0;
        minCount = 0;
        maxCount = 0;
    }

    public T max() {
        return max;
    }

    public T min() {
        return min;
    }

    public void update(T element) {
        if (count == 0) {
            min = element;
            max = element;
        }
        ++count;
        if (element.compareTo(min) < 0) {
            minCount = 1;
            min = element;
        } else {
            if (element.compareTo(min) == 0) {
                minCount++;
            }
        }
        if (element.compareTo(max) > 0) {
            maxCount = 1;
            max = element;
        } else {
            if (element.compareTo(max) == 0) {
                maxCount++;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %d\n",min(),max(),count - (maxCount+minCount));
    }
}
