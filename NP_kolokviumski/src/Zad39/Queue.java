package Zad39;

public class Queue<T> {
    Node<T> head, tail;
    int count;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        if(head == null){
            return true;
        }return  false;
    }

    public int count() {
        return count;
    }

    public void enqueue(T t) {
        Node<T> node = new Node<>(t,null);
        if(isEmpty()){
            head = node;
            tail = node;
        }else {
            tail.setNext(node);
            tail = node;
        }
        ++count;
    }

    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        T res = head.getElement();
        head = head.getNext();
        --count;
        return res;
    }

    public T inspect() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return tail.element;
    }

    public T peek() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return head.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        for(int i=0; i<count; i++){
            sb.append(node);
            sb.append("\n");
            node = node.getNext();
        }
        return sb.toString();
    }
}
