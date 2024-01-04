package Zad34;

import java.util.DoubleSummaryStatistics;

public class Triple<T extends Number> {
    T a,b,c;

    public Triple(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double max() {
        double max = a.doubleValue();
        if(b.doubleValue() > max){
            max = b.doubleValue();
        }
        if(c.doubleValue()> max){
            max = c.doubleValue();
        }
        return max;
    }

    public double avarage() {
        return (a.doubleValue()+b.doubleValue()+c.doubleValue())/3;
    }

    public void sort() {
        if(a.doubleValue()>b.doubleValue()){
            T tmp = a;
            a = b;
            b = tmp;
        }
        if(b.doubleValue() > c.doubleValue()){
            T tmp = b;
            b = c;
            c = tmp;
        }
        if(a.doubleValue()>b.doubleValue()){
            T tmp = a;
            a = b;
            b = tmp;
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f %.2f",a.doubleValue(),b.doubleValue(),c.doubleValue());
    }
}
