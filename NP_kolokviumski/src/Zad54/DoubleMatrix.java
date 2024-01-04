package Zad54;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DoubleMatrix {
    double[][] data;
    public DoubleMatrix(double[] a, int m, int n) throws InsufficientElementsException{
        if(a.length < m*n)
            throw new InsufficientElementsException();
        data = new double[m][n];
        int k = a.length - m*n;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                data[i][j] = a[k++];
            }
        }
    }

    public String getDimensions() {
        return String.format("[%d x %d]", data.length, data[0].length);
    }

    public int rows() {
        return data.length;
    }

    public int columns() {
        return data[0].length;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException{
        if(row > data.length || row < 1)
            throw new InvalidRowNumberException();
        return Arrays.stream(data[row-1]).max().orElse(0.0);
    }

    public double maxElementAtColumn(int col) throws InvalidColumnNumberException{
        if(col > data[0].length || col < 1)
            throw new InvalidColumnNumberException();
        return IntStream.range(0,data.length).mapToDouble(i->data[i][col-1]).max().orElse(0.0);
    }

    public double sum() {
        return IntStream.range(0,data.length)
                .mapToDouble(i -> IntStream.range(0,data[i].length)
                        .mapToDouble(j -> data[i][j])
                        .sum())
                .sum();
    }

    public double[] toSortedArray() {
        double[] sorted = Arrays.stream(data)
                .flatMapToDouble(Arrays::stream)
                .sorted()
                .toArray();
        return IntStream.range(0,sorted.length)
                .mapToDouble(i -> sorted[sorted.length-1-i])
                .toArray();
    }

    @Override
    public String toString() {
        return Arrays.stream(data)
                .map(row -> Arrays.stream(row)
                        .mapToObj(x -> String.format("%.2f",x))
                        .collect(Collectors.joining("\t")))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return Arrays.deepEquals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }
}
