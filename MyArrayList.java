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
    private void increaseArray(){
        int moreSpace= (int)(arr.length*1.5);
        Object[] temp=new Object[moreSpace];
        for(int i=0;i< arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }

    @Override
    public void add(T item) {
        if(size==arr.length){
            increaseArray();
        }
        arr[size++]=item;
    }

    @Override
    public void add(T item, int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for inserting! Try again!");
        }
        if(size== arr.length){
            increaseArray();
        }
       for(int i=size;i>index;i--){
           arr[i]=arr[i-1];
       }
        arr[index]=item;
        size++;
    }

    @Override
    public boolean remove(T item) {
        for(int i=0;i<size;i++){
            if(arr[i].equals(item)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for inserting! Try again!");
        }
        T element=(T)arr[index];
        for(int i=index;i<size-1;i++){
            arr[i]=arr[i+1];
        }
        arr[size--]=null;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        arr=new Object[5];
        size=0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(arr[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for inserting! Try again!");
        }
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for(int i=0;i<size;i++){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i=size-1;i>=0;i--){
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        private int cursor;
        @Override
        public boolean hasNext() {
            return cursor<size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }
}
