import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    private class MyNode{
    private final T data;
    private MyNode next;
    private MyNode prev;

    public MyNode(T data) {
        this.data = data;
    }

    private MyNode head;
    private MyNode tail;
    private int size;
    }
    @Override
    public void add(T item) {

    }

    @Override
    public void add(T item, int index) {

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
