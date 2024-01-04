package Zad60;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ArrayReader {
    public static IntegerArray readIntegerArray(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for(int i=0;i<n; i++){
            array[i] = scanner.nextInt();
        }
        scanner.close();
        return  new IntegerArray(array);
    }
}
