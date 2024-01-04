package Zad16;

import java.util.*;
import java.util.stream.Collectors;

public class PayrollSystem {
    Map<String, Double> hourlyRateByLevel;
    Map<String, Double> ticketRateByLevel;
    List<Employee> employees;
    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this.hourlyRateByLevel = hourlyRateByLevel;
        this.ticketRateByLevel = ticketRateByLevel;
        employees = new ArrayList<>();
    }

    public Employee createEmployee(String nextLine) throws BonusNotAllowedException {
        String []spaceParts = nextLine.split("\\s+");

        Employee employee = createNormalEmployee(spaceParts[0]);

        if(spaceParts.length > 1){
            if (spaceParts[1].contains("%")){
                double percent = Double.parseDouble(spaceParts[1].substring(0,spaceParts[1].length()-1));
                if(percent>20){
                    throw new BonusNotAllowedException(spaceParts[1]);
                }
                employee.setBonus(employee.CalculateSalary()*percent/100);
            }else{
                if(Double.parseDouble(spaceParts[1])>1000){
                    throw new BonusNotAllowedException(spaceParts[1] + "$");
                }
                employee.setBonus(Double.parseDouble(spaceParts[1]));
            }
        }
        employees.add(employee);
        return employee;
    }
    public Employee createNormalEmployee(String line){
        String []parts = line.split(";");
        String name = parts[1];
        String level = parts[2];
        if(parts[0].equalsIgnoreCase("H")){
            return new HourlyEmployee(name,level,hourlyRateByLevel.get(level),Double.parseDouble(parts[3]));
        }else {
            List<Integer> list = Arrays.stream(parts).skip(3)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return  new FreelanceEmployee(name, level, ticketRateByLevel.get(level), list);
        }
    }
    public Map<String, Double> getOvertimeSalaryForLevels() {
        Map<String,Double> map = employees.stream().collect(Collectors.groupingBy(
                Employee::getLevel,
                Collectors.summingDouble(Employee::getOvertime)
        ));
        List<String> list = map.keySet().stream().filter(key -> map.get(key) == -1).collect(Collectors.toList());

        list.forEach(map::remove);
        return map;
    }

    public void printStatisticsForOvertimeSalary() {
        DoubleSummaryStatistics dss = employees.stream()
                .filter(e -> e.getOvertime() != -1)
                .mapToDouble(Employee::getOvertime)
                .summaryStatistics();
        System.out.printf("Statistics for overtime salary: Min: %.2f Average: %.2f Max: %.2f Sum: %.2f",
                            dss.getMin(), dss.getAverage(), dss.getMax(), dss.getSum());
    }

    public Map<String, Integer> ticketsDoneByLevel() {
        Map<String,Integer> map = employees.stream().filter(key -> key.getTickets() != -1)
                .collect(Collectors.groupingBy(
                Employee::getLevel,
                Collectors.summingInt(Employee::getTickets)
        ));
        return map;
    }

    public Collection<Employee> getFirstNEmployeesByBonus(int parseInt) {
        return employees.stream().sorted(Comparator.comparing(Employee::getBonus).reversed())
                .limit(parseInt)
                .collect(Collectors.toList());
    }
}
