package Zad53;

import java.util.*;

public class IntegerList {

    private LinkedList<Integer> list;

    public IntegerList() {
        list = new LinkedList<Integer>();
    }

    public IntegerList( Integer... numbers ) {
        this();
        list.addAll(Arrays.asList(numbers));
    }

    public void add(Integer el , int idx) {
        while ( idx > list.size() ) {
            list.add(0);
        }
        list.add(idx,el);
    }

    public int remove( int idx) {
        return list.remove(idx);
    }

    public void set(int el , int idx ) {
        list.set(idx, el);
    }

    public int get( int idx ) {
        return list.get(idx);
    }

    public int count(int el){
        int counter = 0;
        for ( int e : list ) if ( e == el ) ++counter;
        return counter;
    }

    public void removeDuplicates() {
        TreeSet<Integer> to_remove = new TreeSet<Integer>();
        for ( Iterator<Integer> it = list.descendingIterator(); it.hasNext() ; ) {
            int k = it.next();
            if ( to_remove.contains(k) ) it.remove();
            else if ( count(k) >= 2 ) to_remove.add(k);
        }
    }

    public int sumFirst(int k) {
        int result = 0;
        for ( Iterator<Integer> it = list.iterator(); it.hasNext()&&k > 0 ; --k )
            result += it.next();
        return result;
    }

    public int sumLast(int k) {
        int result = 0;
        for ( Iterator<Integer> it = list.descendingIterator(); it.hasNext()&&k > 0 ; --k )
            result += it.next();
        return result;
    }

    public IntegerList addValue ( int value ) {
        IntegerList result = new IntegerList();int k = 0;
        for ( Iterator<Integer> it = list.iterator();it.hasNext(); ++k )
            result.add(it.next()+value,k);
        return result;
    }

    public void shiftRight( int idx , int k ) {
        shift(idx,k);
    }

    public void shiftLeft( int idx , int k ) {
        shift(idx,-k);
    }

    private void shift( int idx , int k ) {
        int new_pos = ((idx+k)%list.size()+list.size())%list.size();
        add(remove(idx),new_pos);
    }

    public int size() {
        return list.size();
    }

}