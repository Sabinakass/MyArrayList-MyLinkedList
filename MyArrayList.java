import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {// T extending Comparable let us compare this Ts
    private int size;
    private Object[] arr;

    public MyArrayList(){//empty constructor
        this(5);
    }

    public MyArrayList(int initialCapacity){
        arr=new Object[initialCapacity];
    }//constructor with initial capacity
    private void increaseArray(){
        int moreSpace= (int)(arr.length*1.5);
        Object[] temp=new Object[moreSpace];
        for(int i=0;i< arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }


    @Override
    public void add(T item) {//adds element to the end of MyArrayList
        if(size==arr.length){
            increaseArray();
        }
        arr[size++]=item;
    }

    @Override
    public void add(T item, int index) {// Inserts element on certain position
        if(index<0||index>size){//checks index
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
    public boolean remove(T item) {//checks success of removal
        for(int i=0;i<size;i++){
            if(arr[i].equals(item)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) { // removes element with certain index from MyArrayList
        if(index<0||index>size){// check index
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for deleting! Try again!");
        }
        T element=(T)arr[index];
        for(int i=index;i<size-1;i++){
            arr[i]=arr[i+1];
        }
        arr[size--]=null;// Simultaneously decreasing size and assigning to null removed element
        return element;
    }

    @Override
    public int size() {// returns size of array
        return size;
    }

    @Override
    public void clear() {// assigns new array of object with initial capacity to our reference
        arr=new Object[5];
        size=0;
    }

    @Override
    public boolean contains(Object o) {//checking if MyArrayList contains object or not
        return indexOf(o)!=-1;
    }

    @Override
    public T get(int index) {// getting element
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for getting! Try again!");
        }
        return (T)arr[index];
    }

    @Override
    public int indexOf(Object o) {// returning index of the element
        for(int i=0;i<size;i++){// searches from the beginning of array
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {// returning index of last appeared element if there are same elements
        for(int i=size-1;i>=0;i--){// searches from the ending of array
            if(arr[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sort() {// Bubble sort in ascending order
        boolean swapped = true;
        int n = size;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (((T) arr[i - 1]).compareTo((T) arr[i]) > 0) {
                    swap(i - 1, i);
                    swapped = true;
                }
            }
            n--;
        }
    }
    private void swap(int i, int j) {// swaps two elements
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public Iterator<T> iterator() {// iterator for ability using foreach on MyArrayList
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
