package Zad46;

import java.util.ArrayList;
import java.util.List;

public class Contact implements Comparable<Contact>{
    String name;
    String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public List<String> getPhoneKeys(){
        List<String> keys = new ArrayList<>();
        for (int i=0; i<=number.length()-3; i++){
            for(int j=3+i; j<=number.length(); j++){
                String key = number.substring(i,j);
                keys.add(key);
            }
        }
        return keys;
    }

    @Override
    public int compareTo(Contact o) {
        int res= name.compareTo(o.name);
        if(name.equals(o.name)){
            return number.compareTo(o.number);
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("%s %s", name, number);
    }
}
