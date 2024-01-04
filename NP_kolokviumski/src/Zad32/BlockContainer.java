package Zad32;

import java.util.*;

public class BlockContainer<T extends Comparable> {
    List<Set<T>> elements;
    int N;
    public BlockContainer(int size) {
        this.N = size;
        elements = new ArrayList<>();
    }

    public void add(T element) {
        if(elements.size() == 0){
            Set<T> set = new HashSet<>();
            set.add(element);
            elements.add(set);
        }else{
            Set<T> set = elements.get(elements.size()-1);
            if(set.size()<N){
                set.add(element);
            }else{
                set = new HashSet<>();
                set.add(element);
                elements.add(set);
            }
        }
    }

    public void remove(T lastInteger) {
        if(elements.size() > 0){
            Set<T> set = elements.get(elements.size()-1);
            set.remove(lastInteger);

            if(set.size()==0){
                elements.remove(elements.size()-1);
            }
        }
    }

    public void sort() {
        List<T> all = new ArrayList<>();
        for (int i=0; i< elements.size(); i++){
            Iterator<T> it = elements.get(i).iterator();
            while (it.hasNext()){
                all.add(it.next());
            }
        }
        Collections.sort(all);
        elements = new ArrayList<Set<T>>();
        for (T element : all) {
            add(element);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i=0;
        for (Set<T> element: elements) {
            sb.append(element.toString());
            if(i<elements.size()-1){
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }
}
