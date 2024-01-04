package Zad16;

import java.util.List;

public class FreelanceEmployee extends Employee{
    public List<Integer> tickets;

    public FreelanceEmployee(String name, String level, double rate, List<Integer> tickets) {
        super(name, level, rate);
        this.tickets = tickets;
    }

    @Override
    public double CalculateSalary() {
        return tickets.stream().mapToInt(ticket -> ticket).sum() * rate;
    }

    @Override
    public double getOvertime() {
        return -1;
    }

    @Override
    public int getTickets() {
        return tickets.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format(" Tickets count: %d Tickets points: %d", tickets.size(), tickets.stream().mapToInt(key ->key).sum()));
        if(getBonus()!= 0){
            sb.append(String.format(" Bonus: %.2f", getBonus()));
        }
        return sb.toString();
    }
}
