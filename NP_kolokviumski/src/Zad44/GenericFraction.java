package Zad44;

public class GenericFraction<T extends Number, U extends Number> {
    T numerator;
    U denominator;
    public GenericFraction(T numerator, U denominator) throws ZeroDenominatorException {
        if(denominator.doubleValue() == 0){
            throw  new ZeroDenominatorException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double toDouble() {
        return this.numerator.doubleValue()/this.denominator.doubleValue();
    }

    static double gcd(double a, double b) {
        if (b == 0)
            return a;
        if (a < b)
            return gcd(a, b - a);
        else
            return gcd(b, a - b);
    }

    public double gcd() {
        return gcd(this.numerator.doubleValue(), this.denominator.doubleValue());
    }

    public GenericFraction<Double, Double> add(GenericFraction<? extends Number,? extends Number> gf) throws ZeroDenominatorException {
        return new GenericFraction<>(this.numerator.doubleValue()*gf.denominator.doubleValue() +
                this.denominator.doubleValue()* gf.numerator.doubleValue()
                ,this.denominator.doubleValue()*gf.denominator.doubleValue());
    }

    @Override
    public String toString() {
        double gcd = gcd();
        return String.format("%.2f / %.2f",numerator.doubleValue()/gcd, denominator.doubleValue()/gcd);
    }
}
