package Zad33;

public interface Subject {
    void register(Updatable o);
    void remove(Updatable o);
    void notifyUpdatable();
}
