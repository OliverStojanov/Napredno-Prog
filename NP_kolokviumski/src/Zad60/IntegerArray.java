package Zad60;

import java.util.Arrays;

public class IntegerArray {
    final int [] array;
    public IntegerArray(int[] ints) {
        array = Arrays.copyOf(ints,ints.length);
    }

    public IntegerArray getSorted() {
        int[] arr = Arrays.copyOf(array, array.length);
        Arrays.sort(arr);
        return new IntegerArray(arr);
    }

    public IntegerArray concat(IntegerArray array2) {
        int[] result = new int[array.length+array2.array.length];
        System.arraycopy(array,0,result,0,array.length);
        System.arraycopy(array2.array,0,result,array.length,array2.array.length);
        return new IntegerArray(result);
    }

    public int sum() {
        return Arrays.stream(array).sum();
    }

    public double average() {
        return Arrays.stream(array).sum()/ (double)length();
    }

    public int length() {
        return array.length;
    }

    public int getElementAt(int i) {
        return array[i];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        StringBuilder joiner = new StringBuilder();
        joiner.append("[");
        for (int i=0; i<array.length; i++) {
            joiner.append(array[i]);
            if(i!=array.length-1)
                joiner.append(",");
        }
        joiner.append("]");
        return joiner.toString();
    }
}
