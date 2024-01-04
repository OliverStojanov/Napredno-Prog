package Zad6;

public class File implements IFile{
    public String name;
    public long size;
    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }
    public File(String name) {
        this.name = name;
        this.size = 0L;
    }
    @Override
    public String getFileName() {
        return name;
    }

    @Override
    public long getFileSize() {
        return size;
    }

    @Override
    public String getFileInfo(int indent) {
        return String.format("%sFile name: %10s File size: %10d\n",IndentPrinter.printIndent(indent), name, size);
    }

    @Override
    public void sortBySize() {
        return;
    }

    @Override
    public long findLargestFile() {
        return this.size;
    }
    @Override
    public int compareTo(IFile iFile) {
        return Long.compare(this.getFileSize(),iFile.getFileSize());
    }
}
