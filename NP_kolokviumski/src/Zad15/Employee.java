package Zad15;

public abstract class Employee implements Comparable<Employee> {
    public String ID, level;
    public double rate;

    public Employee(String ID, String level, double rate) {
        this.ID = ID;
        this.level = level;
        this.rate = rate;
    }

    public String getLevel() {
        return level;
    }

    public abstract double CalculateSalary();

    @Override
    public String toString() {
        return String.format("Employee ID: %s Level: %s Salary: %.2f", ID, level, CalculateSalary());
    }
}
