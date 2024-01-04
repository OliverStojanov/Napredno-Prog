package Zad1;

public class Participant implements Comparable<Participant>{

    public String city;
    public String code;
    public String name;
    public int age;

    public Participant(String city, String code, String name, int age) {
        this.city = city;
        this.code = code;
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object obj) {
        Participant p = (Participant) obj;
        return code.equals(p.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
    @Override
    public String toString() {
        return String.format("%s %s %d",code , name , age);
    }

    @Override
    public int compareTo(Participant o) {
        int x = name.compareTo(o.name);
        if(x==0){
            int y = Integer.compare(age, o.age);
            if(y == 0){
                return code.compareTo(o.code);
            }
            return y;
        }
        return x;
    }
}
