package Zad6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalLong;

public class Folder extends File implements IFile{
    public String name;
    public long size;
    List<IFile> files = new ArrayList<>();
    public Folder(String name) {
        super(name);
        this.name = name;
        files = new ArrayList<>();
    }

    @Override
    public String getFileName() {
        return this.name;
    }

    @Override
    public long getFileSize() {
        return files.stream().mapToLong(IFile::getFileSize).sum();
    }

    @Override
    public String getFileInfo(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%sFolder name: %10s Folder size: %10d\n",IndentPrinter.printIndent(indent),name,getFileSize()));
        files.stream().forEach(file -> sb.append(file.getFileInfo(indent+1)));
        return sb.toString();
    }

    @Override
    public void sortBySize() {
        Comparator<IFile> comparator = Comparator.comparingLong(IFile::getFileSize);
        files.sort(comparator);
        files.forEach(IFile::sortBySize);
       //files.sort(Comparator.comparingLong(IFile::getFileSize)).forEach(IFile::sortBySize);
    }

    @Override
    public long findLargestFile() {
        OptionalLong optionalLong = files.stream().mapToLong(IFile::findLargestFile).max();
        if(optionalLong.isPresent()){
            return optionalLong.getAsLong();
        }
        return 0L;
    }

    public void addFile(IFile file) throws FileNameExistsException {
        if(files.stream().map(IFile::getFileName).anyMatch(name -> name.equals(file.getFileName()))){
            throw new FileNameExistsException(file.getFileName(),name);
        }
        files.add(file);
    }
}
