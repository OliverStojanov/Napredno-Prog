package Zad15;

import java.util.Comparator;

public class HourlyEmployee extends Employee{
    public double hours;
    public double regular;
    public double overtime;

    public HourlyEmployee(String ID, String level, double rate, double hours) {
        super(ID, level, rate);
        this.hours = hours;
        overtime = Math.max(0,hours-40);
        regular = hours - overtime;
    }

    @Override
    public double CalculateSalary() {
        return regular * rate + overtime * rate * 1.5;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Regular hours: %.2f Overtime hours: %.2f", regular, overtime);
    }

    @Override
    public int compareTo(Employee o) {
        return Comparator.comparing(Employee::CalculateSalary).thenComparing(Employee::getLevel).reversed().compare(this,o);
    }
}
