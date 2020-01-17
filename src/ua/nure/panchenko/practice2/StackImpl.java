package ua.nure.panchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

    private Node top;
    int size;

    public StackImpl() {
        top = null;
    }

    private boolean isEmpty() {
        return top == null;
    }

    @Override
    public void push(Object element) {
        top = new Node(element, top);
        size++;
    }

    @Override
    public Object pop() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }
        Object data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public Object top() {
        if(isEmpty( )) {
            throw new IllegalStateException();
        }
        return top.data;
    }

    @Override
    public void clear() {
        size = 0;
        top = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if(isEmpty()) {
            return "[]";
        }
        Node tmp = top;
        Object[] arr = new Object[size];
        int i = 0;
        while(tmp != null) {
            arr[i] = tmp.data;
            tmp = tmp.next;
            i++;
        }
        StringBuffer sb = new StringBuffer("[");
        for (int j = arr.length - 1; j > 0; j--) {
            if (arr[j] != null) {
                sb.append(arr[j] + ", ");
            }
        }
        sb.append(arr[0] + "]");
        return sb.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new StackIterator();
    }

    private static class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this(data, null );
        }

        public Node(Object data, Node n) {
            this.data = data; next = n;
        }
    }

    private class StackIterator implements Iterator {

        private Node nextNode;
        private Object next;
        boolean canBeRemoved;

        public StackIterator() {
            nextNode = top;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object res = nextNode.data;
            nextNode = nextNode.next;
            canBeRemoved = true;
            this.next = res;
            return res;
        }

        @Override
        public void remove() {
            if (!canBeRemoved) {
                throw new IllegalStateException();
            }
            if( top.data.equals(next) ) {
                top = top.next;
                return;
            }

            Node cur  = top;
            Node prev = null;
            while(cur != null && !cur.data.equals(next) ) {
                prev = cur;
                cur = cur.next;
            }

            if(cur == null) {
                throw new IllegalStateException();
            }
            if (prev == null) {
                throw new NullPointerException();
            }
            prev.next = cur.next;
            canBeRemoved = false;
        }
    }
}
