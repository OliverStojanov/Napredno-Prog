package Zad_Jan.Zad1Vlezna;

import java.util.Objects;

public class Participant implements Comparable<Participant>{
    String city;
    String code;
    String name;
    int age;

    public Participant(String city, String code, String name, int age) {
        this.city = city;
        this.code = code;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", code, name, age);
    }

    @Override
    public int compareTo(Participant o) {
        int res = this.name.compareTo(o.name);
        if(res==0){
            if(Integer.compare(this.age,o.age)==0){
                return this.code.compareTo(o.code);
            }
            return Integer.compare(this.age,o.age);
        }
        return res;
    }
}
