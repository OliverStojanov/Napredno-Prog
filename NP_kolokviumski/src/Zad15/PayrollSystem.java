package Zad15;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class PayrollSystem {
    public Map<String, Double> hourlyRateByLevel;
    public Map<String, Double> ticketRateByLevel;
    public List<Employee> employees;
    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this.hourlyRateByLevel = hourlyRateByLevel;
        this.ticketRateByLevel = ticketRateByLevel;
        employees = new ArrayList<>();
    }
    public static Employee createEmployee(String line, Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel){
        String []parts = line.split(";");
        String id = parts[1];
        String level = parts[2];
        if(parts[0].equalsIgnoreCase("H")){
            double hours = Double.parseDouble(parts[3]);
            return new HourlyEmployee(id,level,hourlyRateByLevel.get(level),hours);
        }else {
            List<Integer> tickets =  Arrays.stream(parts).skip(3)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return  new FreelanceEmployee(id,level, ticketRateByLevel.get(level),tickets);
        }
    }
    public void readEmployees(InputStream in) {
        employees = new BufferedReader(new InputStreamReader(in)).lines()
                .map(line -> PayrollSystem.createEmployee(line,hourlyRateByLevel,ticketRateByLevel))
                .collect(Collectors.toList());
    }

    public Map<String, Set<Employee>> printEmployeesByLevels(PrintStream out, Set<String> levels) {
        Map<String, Set<Employee>> employee = employees.stream().collect(Collectors.groupingBy(
                Employee::getLevel,
                TreeMap::new,
                Collectors.toCollection(TreeSet::new)
                ));
        Set<String> keys = new HashSet<>(employee.keySet());
        keys.stream()
                .filter(k -> !levels.contains(k))
                .forEach(employee::remove);
        return employee;
    }
}
