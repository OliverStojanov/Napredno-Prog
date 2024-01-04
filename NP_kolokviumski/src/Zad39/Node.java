package Zad39;

public class Node<T>{
    T element;
    Node<T> next;
    Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }
    public T getElement(){
        return element;
    }
    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }

}
