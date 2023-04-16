import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{// T extending Comparable let us compare this Ts
    private MyNode head;//reference to first elem
    private MyNode tail;//reference to last elem
    private int size;

    private class MyNode {//class MyNode which keeps reference to prev, next and some data
        T data;
        MyNode prev;
        MyNode next;

        MyNode(T data) {
            this.data = data;
        }
    }
    public void addFirst(T item){//Adds node at first position by changing references
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
    public void addLast(T item){//Adds node at last position by changing references
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
    public void add(T item) {//Adds node to the end by calling addLast method
        addLast(item);
    }

    @Override
    public void add(T item, int index) {//Adds node at certain position with usage of Binary Sort and changing references
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

    public void removeFirst(){// Removes first node by changing references
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
    public void removeLast(){// Removes last node by changing references
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
    public boolean remove(T item) {//checks success of removal
        if(indexOf(item)!=-1){
            remove(indexOf(item));
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {//Removes node at certain position with usage of Binary Sort and changing references
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for deleting! Try again!");
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
    public int size() {// returns size of MyLinkedList
        return size;
    }

    @Override
    public void clear() {//clears MyLinked List by nulling head and tail references
        head =null;
        tail=null;
        size=0;
    }

    @Override
    public boolean contains(Object o) {//returns true if result of indexOf method is not -1, which means there is no such element
        return indexOf(o)!=-1;
    }

    @Override
    public T get(int index) {// returns node's data with usage of Binary search
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Oops! Given index is not appropriate for getting! Try again!");
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
    public int indexOf(Object o) {//returns index of element if no such returns -1
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
    public int lastIndexOf(Object o) {//returns last index of element if no such returns -1
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
    public void sort() {// Bubble sort in ascending order of MyLinked List
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            MyNode curr = head;
            while (curr.next != null) {
                if (curr.data.compareTo(curr.next.data) > 0) {
                    MyNode temp = curr.next;
                    curr.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = curr;
                    }
                    temp.prev = curr.prev;
                    if (curr.prev != null) {
                        curr.prev.next = temp;
                    } else {
                        head = temp;
                    }
                    curr.prev = temp;
                    temp.next = curr;
                    curr = temp;
                    sorted = false;
                }
                else {
                    curr = curr.next;
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {// Enables usage of foreach in MyLinkedList
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
