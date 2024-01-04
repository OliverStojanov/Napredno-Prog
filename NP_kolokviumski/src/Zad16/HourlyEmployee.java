package Zad16;

public class HourlyEmployee extends Employee{
    public double hours;
    public double overtime;
    public double regular;

    public HourlyEmployee(String name, String level, double rate,double hours) {
        super(name, level, rate);
        this.hours = hours;
        this.overtime = Math.max(0,hours-40);
        this.regular = hours - overtime;
    }

    @Override
    public double CalculateSalary() {
        return regular * rate + overtime * rate * 1.5;
    }

    @Override
    public double getOvertime() {
        return overtime * rate * 1.5;
    }

    @Override
    public int getTickets() {
        return -1;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Regular hours: %.2f Overtime hours: %.2f Bonus: %.2f",regular, overtime, bonus);
    }
}
