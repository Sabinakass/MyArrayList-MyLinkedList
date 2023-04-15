import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private int size;
    private Object[] arr;

    public MyArrayList(){
        this(5);
    }

    public MyArrayList(int initialCapacity){
        arr=new Object[initialCapacity];
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
