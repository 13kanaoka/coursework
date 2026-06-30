package LAB02;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
* Implements the Deque interface using a circular array.
* @param <E> the element type
*/
public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>
{
// Data Fields
/** Index of the front of the queue. */
private int front;
/** Index of the rear of the queue. */
private int rear;
/** Current size of the queue. */
private int size;
/** Current capacity of the queue. */
private int capacity;
/** Default capacity of the queue. */
private static final int DEFAULT_CAPACITY = 10;
/** Array to hold the data. */
private E[] theData;
// Constructors
/**
* Construct a queue with the default initial capacity.
*/
public ArrayDeque() {
this(DEFAULT_CAPACITY);
}
/**
* Construct a queue with the specified initial capacity.
* @param initCapacity The initial capacity
*/
@SuppressWarnings("unchecked")
public ArrayDeque(int initCapacity) {
capacity = initCapacity;
theData = (E[]) new Object[capacity];
front = 0;
rear = capacity - 1;
size = 0;
}
/**
* Construct a queue with the contents of a Collection.The initial capacity
* is set to the size of the collection.
* @param c Collection containing initial values.
*/
public ArrayDeque(Collection<E> c) {
this(c.size());
c.forEach(item -> offerLast(item));
}
// Public Methods
/**
* Inserts an item at the rear of the deque.
* postitem is added to the rear of the queue.
* @param item The element to add
* @return true (always successful)
*/
@Override
public boolean offerLast(E item) {
if (size == capacity) {
reallocate();
}
size++;
rear = (rear + 1) % capacity;
theData[rear] = item;
return true;
}
/**
* Inserts an item at the rear of the deque.
* postitem is added to the rear of the queue.
* @param item The element to add
*/
@Override
public void addLast(E item) {
offerLast(item);
}
/**
* Queue method.
* Inserts an item at the rear of the deque.
* postitem is added to the rear of the queue.
* @param item The element to add
* @return true (always successful)
*/
@Override
public boolean offer(E item) {
return offerLast(item);
}
/**
* Queue method.
* Inserts an item at the rear of the deque.
* postitem is added to the rear of the queue.
* @param item The element to add
* @return true (always successful)
*/
@Override
public boolean add(E item) {
return offerLast(item);
}
/**
* Inserts an item at the front of the deque
* postitem is added the front of the queue
* @param item The element to add
*/
@Override
public boolean offerFirst(E item) {
if (size == capacity) {
reallocate();
}
size++;
front = (front - 1 + capacity) % capacity;
theData[front] = item;
return true; // Always succeeds
}
/**
* Inserts an item at the front of the deque
* postitem is added the front of the queue
* @param item The element to add
*/
@Override
public void addFirst(E item) {
offerFirst(item);
}
/**
* Stack method
* Inserts an item at the front of the deque
* postitem is added the front of the queue
* @param item The element to add
*/
@Override
public void push(E item) {
offerFirst(item);
}
/**
* Returns the item at the front of the deque without removing it.
* @return The item at the front of the deque if successful;
* return null if the deque is empty
*/
@Override
public E peekFirst() {
if (size == 0) {
return null;
} else {
return theData[front];
}
}
/**
* Returns the item at the front of the deque without removing it.
* @return The item at the front of the queue if successful;
* @throws NoSuchElementException if the deque is empty
*/
@Override
public E getFirst() {
E item = peekFirst();
if (item == null) {
throw new NoSuchElementException();
}
return item;
}
/**
* Returns the item at the rear of the deque without removing it.
* @return The item at the rear of the deque if successful;
* return null if the deque is empty
*/
@Override
public E peekLast() {
if (size == 0) {
return null;
} else {
return theData[rear];
}
}
/**
* Returns the item at the front of the deque without removing it.
* @return The item at the front of the queue if successful;
* @throws NoSuchElementException if the deque is empty
*/
@Override
public E getLast() {
E item = peekLast();
if (item == null) {
throw new NoSuchElementException();
}
return item;
}
/**
* Queue and Stack method.
* Returns the item at the front of the deque without removing it.
* @return The item at the front of the deque if successful;
* return null if the deque is empty
*/
@Override
public E peek() {
return peekFirst();
}
/**
* Queue method
* Returns the item at the front of the deque without removing it.
* @return The item at the front of the queue if successful;
* @throws NoSuchElementException if the deque is empty
*/
@Override
public E element() {
return getFirst();
}
/**
* Removes the entry at the front of the deque and returns it
* if the queue is not empty.
* postfront references item that was second in the queue.
* @return The item removed if successful or null if not
*/
@Override
public E pollFirst() {
if (size == 0) {
return null;
}
E result = theData[front];
front = (front + 1) % capacity;
size--;
return result;
}
/**
* Removes the entry at the front of the deque and returns it
* if the queue is not empty.
* postfront references item that was second in the queue.
* @return The item removed
* @throws NoSuchElementException if the deque is empty.
*/
@Override
public E removeFirst() {
E result = pollFirst();
if (result == null) {
throw new NoSuchElementException();
}
return result;
}
/**
* Queue method
* Removes the entry at the front of the deque and returns it
* if the queue is not empty.
* postfront references item that was second in the queue.
* @return The item removed if successful or null if not
*/
@Override
public E poll() {
return pollFirst();
}
/**
* Queue method
* Removes the entry at the front of the deque and returns it
* if the queue is not empty.
* postfront references item that was second in the queue.
* @return The item removed
* @throws NoSuchElementException if the deque is empty.
*/
@Override
public E remove() {
return removeFirst();
}
/**
* Stack method
* Removes the entry at the front of the deque and returns it
* if the queue is not empty.
* postfront references item that was second in the queue.
* @return The item removed
* @throws NoSuchElementException if the deque is empty.
*/
@Override
public E pop() {
return removeFirst();
}
/**
* Remove the last item from the deque.
* @return The last item from the deque or null if empty
*/
@Override
public E pollLast() {
if (size == 0) {
return null;
}
E result = theData[rear];
rear = (rear - 1 + capacity) % capacity;
size--;
return result;
}
/**
* Remove the last item from the deque.
* @return The last item from the deque
* @throws NoSuchElementException if the deque is empty
*/
@Override
public E removeLast() {
E result = pollLast();
if (result == null) {
throw new NoSuchElementException();
}
return result;
}
/**
* Return the size of the queue
* @return The number of items in the queue
*/
@Override
public int size() {
return size;
}
/**
* Returns an iterator to the elements in the queue
* @return an iterator to the elements in the queue
*/
@Override
public Iterator<E> iterator() {
return new Iter();
}
// Private Methods
/**
* Double the capacity and reallocate the data.
* prehe array is filled to capacity.
* postThe capacity is doubled and the first half of the
* expanded array is filled with data.
*/
@SuppressWarnings("unchecked")
private void reallocate() {
int newCapacity = 2 * capacity;
E[] newData = (E[]) new Object[newCapacity];
int j = front;
for (int i = 0; i < size; i++) {
newData[i] = theData[j];
j = (j + 1) % capacity;
}
front = 0;
rear = size - 1;
capacity = newCapacity;
theData = newData;
}
@Override
public boolean removeFirstOccurrence(Object o) {
var itr = iterator();
while (itr.hasNext()) {
if (itr.next().equals(o)) {
itr.remove();
return true;
}
}
return false;
}
@Override
public boolean removeLastOccurrence(Object o) {
var itr = descendingIterator();
while (itr.hasNext()) {
if (itr.next().equals(o)) {
itr.remove();
return true;
}
}
return false;
}
@Override
public Iterator<E> descendingIterator() {
return new DescendingItr();
}
/** Inner class to implement the Iterator&lt;E&gt; interface. */
private class Iter implements Iterator<E> {
// Data Fields
// Index of next element */
private int index;
// Count of elements accessed so far */
private int count = 0;
// Methods
// Constructor
/**
* Initializes the Iter object to reference the
* first queue element.
*/
public Iter() {
index = front;
}
/**
* Returns true if there are more elements in the queue to access.
* @return true if there are more elements in the queue to access.
*/
@Override
public boolean hasNext() {
return count < size;
}
/**
* Returns the next element in the queue.
* prendex references the next element to access.
* postindex and count are incremented.
* @return The element with subscript index
*/
@Override
public E next() {
if (!hasNext()) {
throw new NoSuchElementException();
}
E returnValue = theData[index];
index = (index + 1) % capacity;
count++;
return returnValue;
}
/**
* Remove the item accessed by the Iter objectd
*/
@Override
public void remove() {
ArrayDeque.this.removeAtIndex((index - 1 + capacity) % capacity);
}
}
/** Inner class to implement the Iterator&lt;E&gt; interface.
* This iterator goes from rear to front.
*/
private class DescendingItr implements Iterator<E> {
// Data Fields
// Index of next element */
private int index;
// Count of elements accessed so far */
private int count = 0;
// Methods
// Constructor
/**
* Initializes the Iter object to reference the
* first queue element.
*/
public DescendingItr() {
index = rear;
}
/**
* Returns true if there are more elements in the queue to access.
* @return true if there are more elements in the queue to access.
*/
@Override
public boolean hasNext() {
return count < size;
}
/**
* Returns the next element in the queue.
* prendex references the next element to access.
* postindex and count are incremented.
* @return The element with subscript index
*/
@Override
public E next() {
if (!hasNext()) {
throw new NoSuchElementException();
}
E returnValue = theData[index];
index = (index - 1 + capacity) % capacity;
count++;
return returnValue;
}
/**
* Remove the item accessed by the Iter object
*/
@Override
public void remove() {
ArrayDeque.this.removeAtIndex((index + 1) % capacity);
}
}
private void removeAtIndex(int index) {
if (index < rear) {
for (int i = index; i < rear; i++) {
theData[i] = theData[i+1];
}
} else {
for (int i = index; i < capacity; i++) {
theData[i] = theData[i+1];
}
theData[capacity-1] = theData[0];
for (int i = 0; i < rear; i++) {
theData[i] = theData[i+1];
}
}
rear--;
size--;
}
}