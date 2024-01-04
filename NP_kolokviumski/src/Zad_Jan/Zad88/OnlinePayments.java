package Zad_Jan.Zad88;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class OnlinePayments {

    Map<String, Student> students;

    public OnlinePayments() {
        students = new TreeMap<>();
    }

    public void readItems(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            String index = parts[0];
            String itemName = parts[1];
            int price = Integer.parseInt(parts[2]);
            Payment payment = new Payment(itemName,price);
            Student student;
            if(students.containsKey(index)){
                student = students.get(index);
            }else{
                student = new Student(index);
                students.put(index,student);
            }
            student.addPayments(payment);
        }
    }

    public void printStudentReport(String id, PrintStream out) throws StudentNotFoundException {
        PrintWriter pw = new PrintWriter(out);
        if(!students.containsKey(id)){
            throw new StudentNotFoundException(id);
        }

//        Student: 151020 Net: 13050 Fee: 149 Total: 13199↩
//        Items:↩
//        1. Школарина за летен семестар 2022/2023 12300↩
//        2. Административно-материјални трошоци и осигурување 750
        students.entrySet().stream()
                        .filter(entry -> entry.getKey().equals(id))
                                .forEach(entry ->{
                                    Student student = entry.getValue();
                                    pw.printf("Student: %s Net: %d Fee: %d Total: %d",
                                            student.index, student.calculateSum(),(int)student.calculateFee(),
                                            student.calculateSum()+(int)student.calculateFee());
                                    pw.println(student);
                                });
        pw.flush();
    }
}
