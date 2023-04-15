public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void add(T item, int index);
    boolean remove(T item);
    T remove(int index);
    int size();
    void clear();
    boolean contains(Object o);
    T get(int index);
    int indexOf(Object o);
    int lastIndexOf(Object o);
    void sort();
}
