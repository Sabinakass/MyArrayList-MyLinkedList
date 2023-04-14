public interface MyList<T> extends Iterable<T> {
    void add(T item);
    int size();
    T get(int index);
}
