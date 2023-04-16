# MyArrayList-MyLinkedList
Implementation of two data structures
## MyList
The MyList interface is a generic interface that defines a set of methods for manipulating a list of elements.It extends Iterable interface and 

### Methods
void add(T item)
Adds the specified element to the end of the list.

void add(T item, int index)
Inserts the specified element at the specified position in the list.

boolean remove(T item)
Removes the first occurrence of the specified element from the list, if it is present.

T remove(int index)
Removes the element at the specified position in the list.

int size()
Returns the number of elements in the list.

void clear()
Removes all elements from the list.

boolean contains(Object o)
Returns true if the list contains the specified element.

T get(int index)
Returns the element at the specified position in the list.

int indexOf(Object o)
Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.

int lastIndexOf(Object o)
Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.

void sort()
Sorts the elements in the list in natural order. The elements must implement the Comparable interface.

## MyArraylist

MyArrayList is a resizable array implementation of the MyList interface. It stores elements in contiguous memory locations, which makes it efficient for random access of elements. The size of the array is doubled whenever it becomes full, in order to allow the addition of new elements. Similarly, the size of the array is halved whenever it becomes less than one-fourth full, in order to save memory.

## MyLinkedList
MyLinkedList is a doubly linked list implementation of the MyList interface. It stores elements as nodes, each of which has a reference to its previous and next nodes. This makes it efficient for adding or removing elements from the middle of the list. The list is also resizable.

### Inner Class
MyNode: This is the inner class of MyLinkedList. It stores the data of the node as well as references to its previous and next nodes.
