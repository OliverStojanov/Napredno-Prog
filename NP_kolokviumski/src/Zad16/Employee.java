package Zad16;

import java.util.Comparator;

public abstract class Employee implements Comparator<Employee> {
    public String name;
    public String level;
    public double rate;
    public double bonus;

    public Employee(String name, String level, double rate) {
        this.name = name;
        this.level = level;
        this.rate = rate;
        this.bonus = 0.0;
    }

    public abstract double CalculateSalary();

    public String getLevel() {
        return level;
    }

    public double getBonus() {
        return bonus;
    }
    public abstract double getOvertime();

    public abstract int getTickets();
    public void setBonus(double bonus) {
        this.bonus += bonus;
    }

    @Override
    public String toString() {
        return String.format("Employee ID: %s Level: %s Salary: %.2f",name,level, CalculateSalary()+bonus);
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return Comparator.comparing(Employee::getBonus).thenComparing(Employee::getLevel).compare(o1,o2);
    }
}
