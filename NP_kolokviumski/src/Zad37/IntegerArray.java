package Zad37;

import java.util.Arrays;

public class IntegerArray extends ResizableArray<Integer>{

    public IntegerArray() {
        super();
    }

    public double sum() {
        double sum=0;
        Object []el = toArray();
        for (int i=0; i< el.length; i++){
            sum+= (double)el[i];
        }
        return sum;
    }

    public double mean() {
        return sum()/count();
    }

    public int countNonZero() {
        int count=0;
        Object[] el = toArray();
        for (int i=0; i<el.length; i++){
            count+=(Integer) el[i]!=0 ? 1 : 0;
        }
        return count;
    }

    public IntegerArray distinct() {
        IntegerArray integerArray = new IntegerArray();
        Object [] objects = toArray();
        Arrays.sort(objects);
        for (int i=0;i< objects.length; i++){
            while (i < objects.length-1&&objects[i] == objects[i+1]){
                ++i;
            }
            integerArray.addElement((int)objects[i]);
        }
        return integerArray;
    }

    public IntegerArray increment(int k) {
        IntegerArray integerArray = new IntegerArray();
        Object [] objects = toArray();
        for (int i=0;i< objects.length; i++){
            integerArray.addElement((int)objects[i]+k);
        }
        return integerArray;
    }
}
