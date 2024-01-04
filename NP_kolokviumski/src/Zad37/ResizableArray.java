package Zad37;

import java.util.Arrays;

public class ResizableArray<T> {
    private T []elements;
    int size;

    public ResizableArray() {
        elements = (T[])new Object[1];
        size = 0;
    }

    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src){
        int count = src.count();
        for (int i=0; i<count; i++){
            dest.addElement(src.elementAt(i));
        }
    }
    public int count() {
        return size;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public Object[] toArray(){
        return elements;
    }
    public void addElement(T first) {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, size+1);
        }
        elements[size++] = first;
    }

    public boolean removeElement(T element){
        int idx = find(element);
        if ( idx == -1 ) return false;
        elements[idx] = elements[--size];
        if ( size<<2 <= elements.length ) elements = Arrays.copyOf(elements, size<<1>0?size<<1:1);
        return true;
    }

    private int find(T element) {
        for ( int i = 0 ; i < size ; ++i )
            if ( element.equals(elements[i]) ) return i;
        return -1;
    }

    public boolean contains(T element) {
        return find(element) != -1;
    }

    public T elementAt(int idx){
        return elements[idx];
    }
}
