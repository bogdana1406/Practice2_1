package ua.nure.panchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    private static final int DEFAULT_CAPACITY = 10;
    private int cap,	    // total number of elements in the queue
                size,		// current number of elements
                front,  	// front index
                back;		// back index
    private Object[] values;

    public QueueImpl() {
        cap = DEFAULT_CAPACITY;
        values = new Object[DEFAULT_CAPACITY];
        back = -1;
        front = 0;
    }

    @Override
    public void enqueue(Object element) {
        if (isFull()) {
            doubleSize();
        }
        back++;
        values[back%cap] = element;
        size++;
    }

    @Override
    public Object dequeue() {
        Object head = top();
        values[front%cap] = null;
        front++;
        size--;
        return head;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            return values[front%cap];
        }
    }

    @Override
    public void clear() {
        for(int i = 0; i < cap; i++) {
            values[i] = null;
        }
        size = 0; back = -1; front = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isFull() {
        return size == cap;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("[]");
        } else {
            sb = new StringBuilder("[");
            for (int i = front; i < back; i++) {
                sb.append(values[i%cap] + ", ");
            }
            sb.append(values[back%cap]);
            sb.append("]");
        }
        return sb.toString();
    }

    private void doubleSize() {
        Object[] newArr = new Object[2*cap];
        for(int i = front; i <= back; i ++) {
            newArr[i-front] = values[i%cap];
        }
        values = newArr;
        front = 0;
        back = size - 1;
        cap *= 2;
    }

    @Override
    public Iterator<Object> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator
    {
        private int index;

        private boolean canBeRemoved = false;

        public QueueIterator()
        {
            index = front;
        }

        public boolean hasNext( )
        {
            return index <= back;
        }

        public Object next( )
        {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            canBeRemoved = true;
            return values[(index++)%cap];
        }

        public void remove( )
        {
            if (!canBeRemoved) {
                throw new IllegalStateException();
            }

            if (index - 1 == front) {
                QueueImpl.this.dequeue();
            } else {
                Object[] newArr = new Object[cap-1];
                for (int i = front; i < index - 1; i++) {
                    newArr[i] = values[i];
                }
                for (int i = index - 1; i < back; i++) {
                    newArr[i] = values[i + 1];
                }
                values = newArr;
                size--;
                cap--;
                back--;
            }
            canBeRemoved = false;
        }
    }
}
