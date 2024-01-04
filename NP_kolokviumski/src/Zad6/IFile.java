package Zad6;

public interface IFile extends Comparable<IFile>{
    public String getFileName();
    public long getFileSize();
    public String getFileInfo(int indent);
    public void sortBySize();
    public long findLargestFile();
}
