import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode {
        T data;
        MyNode prev;
        MyNode next;

        MyNode(T data) {
            this.data = data;
        }
    }
    public void addFirst(T item){
        MyNode newNode=new MyNode(item);
        if(head==null){
            head=tail=newNode;
        }
        else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        size++;
    }
    public void addLast(T item){
        MyNode newNode=new MyNode(item);
        if(tail==null){
            head=tail=newNode;
        }
        else{
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void add(T item, int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for inserting! Try again!");
        }
        MyNode newNode=new MyNode(item);
        if(index==0){
            addFirst(item);
        }
        else if(index==size){
           add(item);
        }
        else{
            MyNode current;
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }
            newNode.next=current.next;
            newNode.prev=current;
            current.next.prev=newNode;
            current.next=newNode;
        }
        size++;
    }

    public void removeFirst(){
        if(head==null){
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        else if(head==tail){
            head=null;
            tail=null;
        }
        else{
            head=head.next;
            head.prev=null;
        }
        size--;
    }
    public void removeLast(){
        if(tail==null){
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        else if(head==tail){
            head=null;
            tail=null;
        }
        else{
            tail=tail.prev;
            tail.next=null;
        }
        size--;
    }
    @Override
    public boolean remove(T item) {
        if(indexOf(item)!=-1){
            remove(indexOf(item));
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        T removedElement = current.data;
        if (current == head) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current == tail) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        size--;

        return removedElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head =null;
        tail=null;
        size=0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)!=-1;
    }

    @Override
    public T get(int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for inserting! Try again!");
        }
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.data;
       }



    @Override
    public int indexOf(Object o) {
        int index=0;
        MyNode temp=head;
        while(temp.next!=null){
            if(temp.data.equals(o)){
                return index;
            }
            index++;
            temp=temp.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=size-1;
        MyNode temp=tail;
        while(temp.prev!=null){
            if(temp.data.equals(o)){
                return index;
            }
            index--;
            temp=temp.prev;
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
    private class MyIterator implements Iterator<T> {
        private MyNode cursor=head;
        @Override
        public boolean hasNext() {
            return cursor!=null;
        }

        @Override
        public T next() {
            T data = cursor.data;
            cursor = cursor.next;
            return data;
        }
    }
}
