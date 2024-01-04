package Zad59;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String name) {
        super(String.format("Category %s was not found",name));
    }
}
