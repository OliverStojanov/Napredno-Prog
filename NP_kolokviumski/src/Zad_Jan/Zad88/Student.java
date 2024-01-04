package Zad_Jan.Zad88;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student {
    String index;
    List<Payment> payments;

    public Student(String index) {
        this.index = index;
        payments = new ArrayList<>();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public int calculateSum(){
        int sum = 0;
        for (Payment payment: payments) {
            sum+= payment.price;
        }
        return sum;
    }

    public double calculateFee(){
        double fee = Math.round(calculateSum() * 0.0114);
        if(fee<3){
            return 3;
        }
        if (fee>300){
            return 300;
        }
        return  fee;
    }

    public void addPayments(Payment payments) {
        this.payments.add(payments);
    }
//   1. Школарина за летен семестар 2022/2023 12300↩
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        payments.sort(Comparator.comparing(Payment::getPrice).reversed());
        for (int i=0; i< payments.size(); i++){
            Payment payment = payments.get(i);
            sb.append(String.format("%d. %s %d", i+1,payment.itemName,payment.price ));
            sb.append(i==payments.size()-1 ? "": "\n");
        }
        return sb.toString();
    }
}
