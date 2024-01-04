package Zad21;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    Map<String, List<ITask>> tasks;

    public TaskManager() {
        tasks = new TreeMap<>();
    }

    public void readTasks(InputStream in) {
        tasks = new BufferedReader(new InputStreamReader(in))
                .lines()
                .map(line ->{
                    try {
                        return createTask(line);
                    }catch (DeadlineNotValidException e){
                        System.out.println(e.getMessage());
                    }
                    return  null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        ITask::getCategory,
                        TreeMap::new,
                        Collectors.toList()
                ));

    }
    public static ITask createTask(String line) throws DeadlineNotValidException {
        String []parts = line.split(",");
        String category = parts[0];
        String name = parts[1];
        String description = parts[2];
        if(parts.length == 3){
            return new SimpleTask(category,name,description);
        } else if (parts.length == 4) {
            try{
                int priority = Integer.parseInt(parts[3]);
                return  new PriorityTask(category,name,description,priority);
            }catch (Exception e){
                LocalDateTime deadline = LocalDateTime.parse(parts[3]);
                if(deadline.isBefore(LocalDateTime.parse("2020-06-02T23:59:59"))){
                    throw new DeadlineNotValidException(deadline);
                }
                return new TimeTask(category,name,description,deadline);
            }
        }else {
            LocalDateTime deadline = LocalDateTime.parse(parts[3]);
            int priority = Integer.parseInt(parts[4]);
            if(deadline.isBefore(LocalDateTime.parse("2020-06-02T23:59:59"))){
                throw new DeadlineNotValidException(deadline);
            }
            return new TimePriorityTask(category,name,description,deadline,priority);
        }
    }
    public void printTasks(PrintStream out, boolean includePriority, boolean includeCategory) {
        PrintWriter printWriter = new PrintWriter(out);
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-02T23:59:59");
        Comparator<ITask> priorityComparator = Comparator.comparing(ITask::getPriority).thenComparing(task -> Duration.between(localDateTime, task.getDeadline()));
        Comparator<ITask> simpleComparator = Comparator.comparing(task -> Duration.between(LocalDateTime.now(), task.getDeadline()));

        if(includeCategory){
            tasks.forEach((category,task) ->{
                printWriter.println(category.toUpperCase());
                task.stream().sorted(includePriority ? priorityComparator : simpleComparator).forEach(printWriter::println);
            });
        }else {
            tasks.values().stream()
                    .flatMap(Collection::stream)
                    .sorted(includePriority? priorityComparator : simpleComparator)
                    .forEach(printWriter::println);
        }
        printWriter.flush();
    }
}
