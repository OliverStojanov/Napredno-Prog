package Zad6;

public class FileNameExistsException extends Throwable{
    public FileNameExistsException(String name, String folderName) {
        super(String.format("There is already a file named %s in the folder %s",name , folderName));
    }
}
