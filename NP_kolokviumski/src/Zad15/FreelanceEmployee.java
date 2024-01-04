package Zad15;

import java.util.Comparator;
import java.util.List;

public class FreelanceEmployee extends Employee{
    List<Integer> tickets;

    public FreelanceEmployee(String ID, String level, double rate, List<Integer> tickets) {
        super(ID, level, rate);
        this.tickets = tickets;
    }

    @Override
    public double CalculateSalary() {
        return tickets.stream().mapToInt(hours -> hours).sum() * rate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Tickets count: %d Tickets points: %d", tickets.size(),
                                                tickets.stream().mapToInt(hours -> hours).sum());
    }

    @Override
    public int compareTo(Employee o) {
        return Comparator.comparing(Employee::CalculateSalary).thenComparing(Employee::getLevel).reversed().compare(this,o);
    }
}
