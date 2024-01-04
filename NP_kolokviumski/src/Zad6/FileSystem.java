package Zad6;

public class FileSystem {
    Folder root;

    public FileSystem() {
        this.root = new Folder("root");
    }

    public long findLargestFile() {
        return root.findLargestFile();
    }

    public void sortBySize() {
        root.sortBySize();
    }

    public void addFile(IFile file) throws FileNameExistsException {
        root.addFile(file);
    }

    @Override
    public String toString() {
        return root.getFileInfo(0);
    }
}
